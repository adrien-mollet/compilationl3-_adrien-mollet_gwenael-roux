package ig;

import fg.*;
import nasm.*;
import util.graph.*;
import util.intset.*;
import java.io.*;

public class Ig {
	public Graph graph;
	public FgSolution fgs;
	public int regNb;
	public Nasm nasm;
	public Node int2Node[];


	public Ig(FgSolution fgs){
		this.fgs = fgs;
		this.graph = new Graph();
		this.nasm = fgs.nasm;
		this.regNb = this.nasm.getTempCounter();
		this.int2Node = new Node[regNb];
		this.construction();
	}

	public void construction() {
		constructNodes();
		constructEdges();
	}

	public int[] getPrecoloredTemporaries() {
		int[] precolored = new int[nasm.getTempCounter()];

		for (NasmInst inst : nasm.listeInst){
			getPrecoloration(inst.source, precolored);
			getPrecoloration(inst.destination, precolored);
		}

		return precolored;
	}

	private void getPrecoloration(NasmOperand operand, int[] precolored) {
		if (operand == null){
			return;
		} else if (operand.isGeneralRegister()){
			NasmRegister register = (NasmRegister) operand;
			precolored[register.val] = register.color;
		} else if (operand instanceof NasmAddress) {
			NasmAddress address = (NasmAddress) operand;
			if (address.base.isGeneralRegister()){
				NasmRegister registerBase = (NasmRegister) address.base;
				precolored[registerBase.val] = registerBase.color;
			}
			if (address.offset!= null && address.offset.isGeneralRegister()){
				NasmRegister registerOffset = (NasmRegister) address.offset;
				precolored[registerOffset.val] = registerOffset.color;
			}
		}
	}

	public void allocateRegisters() {
		ColorGraph cg = new ColorGraph(graph, 4, getPrecoloredTemporaries());
		cg.coloration();

		for (NasmInst inst : nasm.listeInst){
			allocateRegister(inst.source, cg.couleur);
			allocateRegister(inst.destination, cg.couleur);
		}
	}

	public void allocateRegister(NasmOperand operand, int[] couleurs){
		if (operand == null){
			return;
		} else if (operand.isGeneralRegister()){
			NasmRegister register = (NasmRegister) operand;
			if (register.color == Nasm.REG_UNK){
				register.colorRegister(couleurs[register.val]);
			}
		} else if (operand instanceof NasmAddress) {
			NasmAddress address = (NasmAddress) operand;
			if (address.base.isGeneralRegister()){
				NasmRegister registerBase = (NasmRegister) address.base;
				if (registerBase.color == Nasm.REG_UNK){
					registerBase.colorRegister(couleurs[registerBase.val]);
				}
			}
			if (address.offset!= null && address.offset.isGeneralRegister()){
				NasmRegister registerOffset = (NasmRegister) address.offset;
				if (registerOffset.color == Nasm.REG_UNK){
					registerOffset.colorRegister(couleurs[registerOffset.val]);
				}
			}
		}
	}

	private void constructNodes(){
		for (int i = 0; i < regNb; ++i){
			int2Node[i] = graph.newNode();
		}
	}

	private void constructEdges(){
		for (NasmInst inst : nasm.listeInst){
			IntSet in = fgs.in.get(inst);
			constructEdgesFromIntSet(in);

			IntSet out = fgs.out.get(inst);
			constructEdgesFromIntSet(out);
		}
	}

	private void constructEdgesFromIntSet(IntSet intSet) {
		for (int r1 = 0; r1 < regNb; ++r1) {
			for (int r2 = 0; r2 < regNb; ++r2){
				if (r1 != r2){
					if (intSet.isMember(r1) && intSet.isMember(r2)){
						graph.addEdge(int2Node[r1], int2Node[r2]);
					}
				}
			}
		}
	}


	public void affiche(String baseFileName){
		String fileName;
		PrintStream out = System.out;

		if (baseFileName != null){
			try {
				baseFileName = baseFileName;
				fileName = baseFileName + ".ig";
				out = new PrintStream(fileName);
			}

			catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}

		for(int i = 0; i < regNb; i++){
			Node n = this.int2Node[i];
			out.print(n + " : ( ");
			for(NodeList q=n.succ(); q!=null; q=q.tail) {
				out.print(q.head.toString());
				out.print(" ");
			}
			out.println(")");
		}
	}
}
	    
    

    
    
