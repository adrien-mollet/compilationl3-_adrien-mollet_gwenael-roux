package fg;
import nasm.*;
import util.graph.*;
import java.util.*;
import java.io.*;

public class Fg implements NasmVisitor <Void> {
    public Nasm nasm;
    public Graph graph;
    Map< NasmInst, Node> inst2Node;
    Map< Node, NasmInst> node2Inst;
    Map< String, NasmInst> label2Inst;

    public Fg(Nasm nasm){
        this.nasm = nasm;
        this.inst2Node = new HashMap< NasmInst, Node>();
        this.node2Inst = new HashMap< Node, NasmInst>();
        this.label2Inst = new HashMap< String, NasmInst>();
        this.graph = new Graph();

        for (NasmInst inst: nasm.listeInst){
            inst.accept(this);
        }

        EdgeHandler edgeHandler = new EdgeHandler();
    }

    public void affiche(String baseFileName){
        String fileName;
        PrintStream out = System.out;

        if (baseFileName != null){
            try {
                baseFileName = baseFileName;
                fileName = baseFileName + ".fg";
                out = new PrintStream(fileName);
            }

            catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        for(NasmInst nasmInst : nasm.listeInst){
            Node n = this.inst2Node.get(nasmInst);
            out.print(n + " : ( ");
            for(NodeList q=n.succ(); q!=null; q=q.tail) {
                out.print(q.head.toString());
                out.print(" ");
            }
            out.println(")\t" + nasmInst);
        }
    }

    public Void visit(NasmAdd inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);

        return null;
    }


    public Void visit(NasmCall inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmDiv inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmJe inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmJle inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmJne inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmMul inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmOr inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmCmp inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmInst inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmJge inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmJl inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmNot inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmPop inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmRet inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmXor inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmAnd inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmJg inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmJmp inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmMov inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmPush inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmSub inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmEmpty inst){
        if(inst.label != null){
            label2Inst.put(inst.label.toString(),inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst,node);
        node2Inst.put(node,inst);
        return null;
    }

    public Void visit(NasmAddress operand){return null;}
    public Void visit(NasmConstant operand){return null;}
    public Void visit(NasmLabel operand){return null;}
    public Void visit(NasmRegister operand){return null;}

    private class EdgeHandler implements NasmVisitor<Void> {

        private List<Node> graphNodes;

        public EdgeHandler() {
            this.graphNodes = Arrays.asList(graph.nodeArray());
            this.createEdges();
        }

        private void createEdges(){
            for (NasmInst inst: nasm.listeInst){
                inst.accept(this);
            }
        }

        @Override
        public Void visit(NasmAdd inst) {
            Node currentNode = inst2Node.get(inst);
            int index = graphNodes.indexOf(currentNode);
            if (index+1 < graphNodes.size()){
                Node destinationNode = graphNodes.get(index+1);
                graph.addEdge(currentNode,destinationNode);
            }
            return null;
        }

        @Override
        public Void visit(NasmCall inst) {
            return null;
        }

        @Override
        public Void visit(NasmDiv inst) {
            Node currentNode = inst2Node.get(inst);
            int index = graphNodes.indexOf(currentNode);
            if (index+1 < graphNodes.size()){
                Node destinationNode = graphNodes.get(index+1);
                graph.addEdge(currentNode,destinationNode);
            }
            return null;
        }

        @Override
        public Void visit(NasmJe inst) {
            return null;
        }

        @Override
        public Void visit(NasmJle inst) {
            return null;
        }

        @Override
        public Void visit(NasmJne inst) {
            return null;
        }

        @Override
        public Void visit(NasmMul inst) {
            Node currentNode = inst2Node.get(inst);
            int index = graphNodes.indexOf(currentNode);
            if (index+1 < graphNodes.size()){
                Node destinationNode = graphNodes.get(index+1);
                graph.addEdge(currentNode,destinationNode);
            }
            return null;
        }

        @Override
        public Void visit(NasmInst inst) {
            return null;
        }

        @Override
        public Void visit(NasmOr inst) {
            return null;
        }

        @Override
        public Void visit(NasmCmp inst) {
            return null;
        }

        @Override
        public Void visit(NasmJge inst) {
            return null;
        }

        @Override
        public Void visit(NasmJl inst) {
            return null;
        }

        @Override
        public Void visit(NasmNot inst) {
            return null;
        }

        @Override
        public Void visit(NasmPop inst) {
            Node currentNode = inst2Node.get(inst);
            int index = graphNodes.indexOf(currentNode);
            if (index+1 < graphNodes.size()){
                Node destinationNode = graphNodes.get(index+1);
                graph.addEdge(currentNode,destinationNode);
            }
            return null;
        }

        @Override
        public Void visit(NasmRet inst) {
            Node currentNode = inst2Node.get(inst);
            int index = graphNodes.indexOf(currentNode);
            if (index+1 < graphNodes.size()){
                Node destinationNode = graphNodes.get(index+1);
                graph.addEdge(currentNode,destinationNode);
            }
            return null;
        }

        @Override
        public Void visit(NasmXor inst) {
            return null;
        }

        @Override
        public Void visit(NasmAnd inst) {
            return null;
        }

        @Override
        public Void visit(NasmJg inst) {
            return null;
        }

        @Override
        public Void visit(NasmJmp inst) {
            return null;
        }

        @Override
        public Void visit(NasmMov inst) {
            Node currentNode = inst2Node.get(inst);
            int index = graphNodes.indexOf(currentNode);
            if (index+1 < graphNodes.size()){
                Node destinationNode = graphNodes.get(index+1);
                graph.addEdge(currentNode,destinationNode);
            }
            return null;
        }

        @Override
        public Void visit(NasmPush inst) {
            Node currentNode = inst2Node.get(inst);
            int index = graphNodes.indexOf(currentNode);
            if (index+1 < graphNodes.size()){
                Node destinationNode = graphNodes.get(index+1);
                graph.addEdge(currentNode,destinationNode);
            }
            return null;
        }

        @Override
        public Void visit(NasmSub inst) {
            Node currentNode = inst2Node.get(inst);
            int index = graphNodes.indexOf(currentNode);
            if (index+1 < graphNodes.size()){
                Node destinationNode = graphNodes.get(index+1);
                graph.addEdge(currentNode,destinationNode);
            }
            return null;
        }

        @Override
        public Void visit(NasmEmpty inst) {
            Node currentNode = inst2Node.get(inst);
            int index = graphNodes.indexOf(currentNode);
            if (index+1 < graphNodes.size()){
                Node destinationNode = graphNodes.get(index+1);
                graph.addEdge(currentNode,destinationNode);
            }
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
