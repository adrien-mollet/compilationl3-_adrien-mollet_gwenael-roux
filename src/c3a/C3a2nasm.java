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
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {
        currentFct = inst.val;
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
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
        nasm.ajouteInst(new NasmDiv(null,op1,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        NasmOperand label = null;
        if (inst.label != null){
            label = inst.label.accept(this);
        }

        nasm.ajouteInst(new NasmCmp(label,inst.op1.accept(this),inst.op2.accept(this),""));
        nasm.ajouteInst(new NasmJne(label,inst.result.accept(this),""));
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
        NasmOperand label = inst.label.accept(this);
        NasmOperand operand = inst.op1.accept(this);
        nasm.ajouteInst(new NasmPush(label,operand,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstReturn inst) {
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
        nasm.ajouteInst(new NasmMov(label,reg_eax,operand,""));
        nasm.ajouteInst(new NasmCall(null,new NasmLabel("iprintLF"),""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aConstant oper) {
        return new NasmConstant(oper.val);
    }

    @Override
    public NasmOperand visit(C3aLabel oper) {
        return new NasmLabel(oper.toString());
    }

    @Override
    public NasmOperand visit(C3aTemp oper) {
        return new NasmRegister(oper.num);
    }

    @Override
    public NasmOperand visit(C3aVar oper) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {
        return null;
    }
}
