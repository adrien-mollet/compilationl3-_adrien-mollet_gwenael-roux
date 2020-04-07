package fg;
import util.graph.*;
import nasm.*;
import util.intset.*;

import java.awt.*;
import java.io.*;
import java.util.*;

public class FgSolution{
	int iterNum = 0;
	public Nasm nasm;
	Fg fg;
	public Map< NasmInst, IntSet> use;
	public Map< NasmInst, IntSet> def;
	public Map< NasmInst, IntSet> in;
	public Map< NasmInst, IntSet> out;

	public FgSolution(Nasm nasm, Fg fg){
		this.nasm = nasm;
		this.fg = fg;
		this.use = new HashMap< NasmInst, IntSet>();
		this.def = new HashMap< NasmInst, IntSet>();
		this.in =  new HashMap< NasmInst, IntSet>();
		this.out = new HashMap< NasmInst, IntSet>();
		new UseAndDefHandler();
		new InAndOutHandler();
	}

	public void affiche(String baseFileName){
		String fileName;
		PrintStream out = System.out;

		if (baseFileName != null){
			try {
				baseFileName = baseFileName;
				fileName = baseFileName + ".fgs";
				out = new PrintStream(fileName);
			}

			catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}

		out.println("iter num = " + iterNum);
		for(NasmInst nasmInst : this.nasm.listeInst){
			out.println("use = "+ this.use.get(nasmInst) + " def = "+ this.def.get(nasmInst) + "\tin = " + this.in.get(nasmInst) + "\t \tout = " + this.out.get(nasmInst) + "\t \t" + nasmInst);
		}
	}

	private void addRegister(NasmInst inst){
		addDestSource(inst.source, inst);
		addDestSource(inst.destination, inst);

		if (inst.source instanceof NasmAddress){
			NasmAddress src = (NasmAddress) inst.source;
			addDestSource(src.base, inst);
			addDestSource(src.offset, inst);
		}
		if (inst.destination instanceof NasmAddress){
			NasmAddress dest = (NasmAddress) inst.destination;
			addDestSource(dest.base, inst);
			addDestSource(dest.offset, inst);
		}

	}

	private void addDestSource(NasmOperand operand, NasmInst inst){
		if (operand != null && operand.isGeneralRegister() && operand instanceof NasmRegister){
			NasmRegister dest = (NasmRegister) operand;
			if (dest.color != Nasm.REG_EBP && dest.color != Nasm.REG_ESP){
				if(inst.destDef){
					def.get(inst).add(dest.val);
				}
				if (inst.destUse){
					use.get(inst).add(dest.val);
				}
			}
		}
	}

	private class UseAndDefHandler implements NasmVisitor<Void>{

		public UseAndDefHandler(){
			for (NasmInst inst : nasm.listeInst) {
				inst.accept(this);
			}
		}

		@Override
		public Void visit(NasmAdd inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmCall inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmDiv inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmJe inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmJle inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmJne inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmMul inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmOr inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmCmp inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmInst inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmJge inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmJl inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmNot inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmPop inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmRet inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmXor inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmAnd inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmJg inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmJmp inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmMov inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmPush inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmSub inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmEmpty inst) {
			def.put(inst,new IntSet(fg.inst2Node.size()));
			use.put(inst,new IntSet(fg.inst2Node.size()));
			addRegister(inst);
			in.put(inst,new IntSet(fg.inst2Node.size()));
			out.put(inst,new IntSet(fg.inst2Node.size()));
			return null;
		}

		@Override
		public Void visit(NasmAddress operand) {
			return null;
		}

		@Override
		public Void visit(NasmConstant operand) {
			return null;
		}

		@Override
		public Void visit(NasmLabel operand) {
			return null;
		}

		@Override
		public Void visit(NasmRegister operand) {
			return null;
		}
	}

	private class InAndOutHandler implements NasmVisitor<Void>{
		private boolean ok;
		public InAndOutHandler(){
			ok = true;
			while (ok){
				ok = false;
				for (NasmInst inst : nasm.listeInst) {
					inst.accept(this);
				}
				++iterNum;
			}
		}


		private void iterInAndOut(NasmInst inst){
			IntSet inPrim = in.get(inst);
			IntSet outPrim = out.get(inst).copy();

			IntSet outCopy = out.get(inst).copy();
			IntSet useCopy = use.get(inst).copy();
			IntSet inResult = useCopy.union(outCopy.minus(def.get(inst)));
			in.put(inst,inResult);

			IntSet outResult = new IntSet(fg.inst2Node.size());
			for(NodeList nl=fg.inst2Node.get(inst).succ(); nl!=null; nl=nl.tail){
				outResult.union(in.get(fg.node2Inst.get(nl.head)));
			}
			out.put(inst,outResult);

			this.ok = this.ok || (!inPrim.equal(inResult)) || (!outPrim.equal(outResult));
		}

		@Override
		public Void visit(NasmAdd inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmCall inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmDiv inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmJe inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmJle inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmJne inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmMul inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmOr inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmCmp inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmInst inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmJge inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmJl inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmNot inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmPop inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmRet inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmXor inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmAnd inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmJg inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmJmp inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmMov inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmPush inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmSub inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmEmpty inst) {
			iterInAndOut(inst);
			return null;
		}

		@Override
		public Void visit(NasmAddress operand) {
			return null;
		}

		@Override
		public Void visit(NasmConstant operand) {
			return null;
		}

		@Override
		public Void visit(NasmLabel operand) {
			return null;
		}

		@Override
		public Void visit(NasmRegister operand) {
			return null;
		}
	}
}

    
