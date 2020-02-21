package ts;

import sa.*;

public class Sa2ts extends SaDepthFirstVisitor<Void> {

    private Ts tableGlobale;
    private Ts tableCourante;

    public Sa2ts(SaNode saNode) {
        tableGlobale = new Ts();
        tableCourante = this.tableGlobale;
        saNode.accept(this);
    }

    public Ts getTableGlobale(){
        return tableGlobale;
    }

    public Void visit(SaDecTab node) {
        if(tableGlobale.getVar(node.getNom()) == null){
            tableGlobale.addVar(node.getNom(),node.getTaille());
        } else {
            System.err.println("Le tableau "+node.getNom()+" existe déjà !");
        }
        return null;
    }

    public Void visit(SaDecFonc node) {
        if (tableCourante.getFct(node.getNom()) == null){
            this.tableCourante = new Ts();

            SaLDec params = node.getParametres();
            int tailleParam = 0;
            if (params != null){
                tailleParam = params.length();
                for (int i = 0; i< tailleParam ; ++i){
                    SaDec parametre = params.getTete();
                    tableCourante.addParam(parametre.getNom());
                    params = params.getQueue();
                }
            }

            SaLDec vars = node.getVariable();
            if (vars != null){
                vars.accept(this);
            }

            //node.getCorps().accept(this);

            this.tableGlobale.addFct(node.getNom(),tailleParam,this.tableCourante,node);
        } else {
            System.err.println("La fonction "+node.getNom()+" existe déjà !");
        }
        return null;
    }

    public Void visit(SaDecVar node) {
        if(tableCourante.getVar(node.getNom()) == null){
            if (node.tsItem.isParam){
                tableCourante.addParam(node.getNom());
            } else {
                tableCourante.addVar(node.getNom(),1);
            }
        } else {
            System.err.println("La variable/le paramètre "+node.getNom()+" existe déjà !");
        }
        /*if (node.tsItem.portee != tableGlobale){
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
        }*/
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
