package c3a;

import nasm.*;
import ts.Ts;
import ts.TsItemFct;

public class C3a2nasm implements C3aVisitor<NasmOperand> {

    private C3a c3a;
    private Nasm nasm;
    private Ts tableGlobale;
    private TsItemFct currentFct;

    public C3a2nasm(C3a c3a, Ts table) {
        this.c3a = c3a;
        this.tableGlobale = table;
        this.nasm = new Nasm(tableGlobale);
        this.currentFct = null;
        nasm.ajouteInst(new NasmCall(null, new NasmLabel("main"), ""));

        NasmRegister ebx = nasm.newRegister();
        ebx.colorRegister(Nasm.REG_EBX);
        nasm.ajouteInst(new NasmMov(null, ebx, new NasmConstant(0), " valeur de retour du programme"));
        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(Nasm.REG_EAX);
        nasm.ajouteInst(new NasmMov(null, eax, new NasmConstant(1), ""));
        nasm.ajouteInst(new NasmInt(null, ""));

        for (C3aInst inst: c3a.listeInst){
            System.out.println(inst);
            inst.accept(this);
        }
    }

    public Nasm getNasm() {
        return nasm;
    }

    @Override
    public NasmOperand visit(C3aInstAdd inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        NasmInst inst1 = new NasmMov(label,dest,op1,"");
        nasm.ajouteInst(inst1);
        nasm.ajouteInst(new NasmAdd(null,dest,op2,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstCall inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }
        NasmOperand res = inst.result.accept(this);
        NasmRegister esp = nasm.newRegister();
        esp.colorRegister(Nasm.REG_ESP);
        nasm.ajouteInst(new NasmSub(label,esp,new NasmConstant(4),"allocation mémoire pour la valeur de retour"));
        nasm.ajouteInst(new NasmCall(null,new NasmLabel(inst.op1.val.identif),""));
        nasm.ajouteInst(new NasmPop(null, res,"récupération de la valeur de retour"));
        int nbarg = inst.op1.val.getNbArgs();
        if (nbarg !=0)
            nasm.ajouteInst(new NasmAdd(null,esp,new NasmConstant(nbarg*4),"désallocation des arguments"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {
        currentFct = inst.val;
        NasmOperand label = null;
        if (inst.val.identif != null){
            label = new NasmLabel(inst.val.identif);
        }
        NasmRegister reg_ebp = nasm.newRegister();
        NasmRegister reg_esp = nasm.newRegister();
        reg_ebp.colorRegister(Nasm.REG_EBP);
        reg_esp.colorRegister(Nasm.REG_ESP);
        nasm.ajouteInst(new NasmPush(label,reg_ebp,"sauvegarde la valeur de ebp"));
        nasm.ajouteInst(new NasmMov(null,reg_ebp,reg_esp,"nouvelle valeur de ebp"));
        int nb_var = currentFct.getTable().nbVar();
        nasm.ajouteInst(new NasmSub(null,reg_esp,new NasmConstant(nb_var*4),"allocation des variables locales"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInst inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfLess inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstMult inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        NasmInst inst1 = new NasmMov(label,dest,op1,"");
        nasm.ajouteInst(inst1);
        nasm.ajouteInst(new NasmMul(null,dest,op2,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstRead inst) {
        NasmOperand label = null;
        if(inst.label != null){
            label = inst.label.accept(this);
        }
        NasmOperand res = inst.result.accept(this);
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        nasm.ajouteInst(new NasmMov(label,reg_eax,new NasmLabel("sinput"),""));
        nasm.ajouteInst(new NasmCall(null,new NasmLabel("readline"),""));
        nasm.ajouteInst(new NasmCall(null,new NasmLabel("atoi"),""));
        nasm.ajouteInst(new NasmMov(null,res,reg_eax,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstSub inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        NasmInst inst1 = new NasmMov(label,dest,op1,"");
        nasm.ajouteInst(inst1);
        nasm.ajouteInst(new NasmSub(null,dest,op2,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstAffect inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }
        NasmOperand op = inst.op1.accept(this);
        NasmOperand res = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label,res,op,"Affect"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstDiv inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        NasmInst inst1 = new NasmMov(label,dest,op1,"");
        nasm.ajouteInst(inst1);
        nasm.ajouteInst(new NasmDiv(null,op2,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }
        NasmRegister reg_ebp = nasm.newRegister();
        NasmRegister reg_esp = nasm.newRegister();
        reg_ebp.colorRegister(Nasm.REG_EBP);
        reg_esp.colorRegister(Nasm.REG_ESP);
        int nb_var = currentFct.getTable().nbVar();
        nasm.ajouteInst(new NasmAdd(label,reg_esp,new NasmConstant(nb_var*4),"désallocation des variables locales"));
        nasm.ajouteInst(new NasmPop(null,reg_ebp,"restaure la valeur de ebp"));
        nasm.ajouteInst(new NasmRet(null,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {
        NasmOperand res = inst.result.accept(this);
        NasmRegister reg = nasm.newRegister();
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }

        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        nasm.ajouteInst(new NasmMov(label,reg,op1,"JumpIfEqual 1"));
        nasm.ajouteInst(new NasmCmp(null,reg,op2,"on passe par un registre temporaire"));
        nasm.ajouteInst(new NasmJe(null,res,"JumpIfEqual 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        NasmOperand res = inst.result.accept(this);
        NasmRegister reg = nasm.newRegister();
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }

        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        nasm.ajouteInst(new NasmMov(label,reg,op1,"JumpIfEqual 1"));
        nasm.ajouteInst(new NasmCmp(null,reg,op2,"on passe par un registre temporaire"));
        nasm.ajouteInst(new NasmJne(null,res,"JumpIfEqual 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJump inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }

        nasm.ajouteInst(new NasmJmp(label,inst.result.accept(this),""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstParam inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }
        NasmOperand operand = inst.op1.accept(this);
        nasm.ajouteInst(new NasmPush(label,operand,"Param"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstReturn inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }
        NasmOperand op = inst.op1.accept(this);
        NasmRegister ebp = nasm.newRegister();
        ebp.colorRegister(Nasm.REG_EBP);
        NasmAddress address = new NasmAddress(ebp,'+',new NasmConstant(2));
        nasm.ajouteInst(new NasmMov(label,address,op,"ecriture de la valeur de retour"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstWrite inst) {
        NasmOperand label = null;
        if(inst.label != null){
            label = inst.label.accept(this);
        }

        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        NasmOperand operand = inst.op1.accept(this);
        nasm.ajouteInst(new NasmMov(label,reg_eax,operand,"Write 1"));
        nasm.ajouteInst(new NasmCall(null,new NasmLabel("iprintLF"),"Write 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aConstant oper) {
        return new NasmConstant(oper.val);
    }

    @Override
    public NasmOperand visit(C3aLabel oper) { return new NasmLabel(oper.toString()); }

    @Override
    public NasmOperand visit(C3aTemp oper) {
        return new NasmRegister(oper.num);
    }

    @Override
    public NasmOperand visit(C3aVar oper) {
        NasmAddress address;

        if(oper.index == null){
            NasmRegister ebp = nasm.newRegister();
            ebp.colorRegister(Nasm.REG_EBP);
            NasmConstant n;
            if(oper.item.isParam){
                n = new NasmConstant((currentFct.getNbArgs() * 2) - oper.item.getAdresse());
                address = new NasmAddress(ebp, '+', n);
            }
            else {
                if (currentFct.getTable().getVar(oper.item.getIdentif())!=null){
                    n = new NasmConstant(oper.item.adresse+1);
                    address = new NasmAddress(ebp, '-', n);
                }
                else
                    return new NasmLabel(oper.item.getIdentif());
            }
        }
        else {
            NasmOperand op = oper.index.accept(this);
            address = new NasmAddress(new NasmLabel(oper.item.getIdentif()), '+', op);
        }

        return address;
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {
        return new NasmLabel(oper.val.identif);
    }
}
