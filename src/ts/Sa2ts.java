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
        if(!tableGlobale.variables.containsKey(node.getNom())){
            tableGlobale.addVar(node.getNom(),node.getTaille());
        }
        defaultOut(node);
        return null;
    }

    public Void visit(SaDecFonc node) {
        defaultIn(node);
        if(!tableGlobale.fonctions.containsKey(node.getNom())){
            tableGlobale.addFct(node.getNom(),node.tsItem.nbArgs,node.tsItem.getTable(),node.tsItem.saDecFonc);
            node.accept(this);
        }
        defaultOut(node);
        return null;
    }

    public Void visit(SaDecVar node) {
        defaultIn(node);
        if (node.tsItem.portee != tableGlobale){
            Ts tableLocale = tableGlobale.getTableLocale(node.tsItem.portee.toString());
            if(!tableLocale.variables.containsKey(node.getNom())){
                if (node.tsItem.isParam){
                    tableLocale.addParam(node.getNom());
                } else {
                    tableLocale.addVar(node.getNom(),1);
                }
            }
        } else {
            if(!tableGlobale.variables.containsKey(node.getNom())){
                tableGlobale.addVar(node.getNom(),1);
            }
        }
        defaultOut(node);
        return null;
    }

    public Void visit(SaVarSimple node) {
        defaultIn(node);
        if (node.tsItem.portee != this.tableGlobale){
            Ts tableLocale = tableGlobale.getTableLocale(node.tsItem.portee.toString());
            if(tableLocale.variables.containsKey(node.getNom())){
                if (node.tsItem.isParam){
                    System.out.println("param");
                } else {
                    System.out.println("locale");
                }
            }
        } else {
            if(tableGlobale.variables.containsKey(node.getNom())){
                System.out.println("globale");
            }
        }
        this.tableGlobale.addVar(node.getNom(),node.tsItem.getTaille());
        defaultOut(node);
        return null;
    }

    public Void visit(SaAppel node) {
        defaultIn(node);
        if(!this.tableGlobale.fonctions.containsKey(node.getNom())){
            System.out.println("pas ok");
        }
        else {
            System.out.println("ok");
        }
        defaultOut(node);
        return null;
    }

    public Void visit(SaVarIndicee node) {
        defaultIn(node);
        if(!this.tableGlobale.variables.containsKey(node.getNom())){
            System.out.println("pas ok");
        }
        else {
            System.out.println("ok");
        }
        defaultOut(node);
        return null;
    }
}
