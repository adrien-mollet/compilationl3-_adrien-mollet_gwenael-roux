package ts;

import sa.*;

import java.util.ArrayList;
import java.util.List;

public class Sa2ts extends SaDepthFirstVisitor<Void> {

    private Ts tableGlobale;
    private List<Ts> tablesLocales;

    public Sa2ts(SaNode saNode) {
        tableGlobale = new Ts();
        tablesLocales = new ArrayList<>();
        saNode.accept(this);
    }

    public Ts getTableGlobale(){
        return tableGlobale;
    }

    public Void visit(SaDecTab node) {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public Void visit(SaDecFonc node) {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public Void visit(SaDecVar node) {
        defaultIn(node);

        defaultOut(node);
        return null;
    }

    public Void visit(SaVarSimple node) {
        defaultIn(node);
        if (node.tsItem.portee != this.tableGlobale){
            if (node.tsItem.isParam){

            } else {

            }
        }
        this.tableGlobale.addVar(node.getNom(),node.tsItem.getTaille());
        defaultOut(node);
        return null;
    }

    public Void visit(SaAppel node) {
        defaultIn(node);

        defaultOut(node);
        return null;
    }

    public Void visit(SaVarIndicee node) {
        defaultIn(node);

        defaultOut(node);
        return null;
    }
}
