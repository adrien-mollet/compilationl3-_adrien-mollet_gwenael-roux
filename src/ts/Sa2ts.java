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
        tableGlobale.affiche(System.out);
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
        if (node.tsItem.portee != this.tableGlobale){
            Ts tableLocale = tableGlobale.getTableLocale(node.tsItem.portee.toString());
            TsItemVar param = tableLocale.getVar(node.getNom());
            if (node.tsItem.isParam){
                if (param == null){
                    System.err.println("le parametre "+node.getNom()+" n'existe pas");
                }
                else {
                    node.tsItem = param;
                }
            } else {
                if (param == null){
                    System.err.println("la variable locale "+node.getNom()+" n'existe pas");
                }
                else {
                    node.tsItem = param;
                }
            }
        } else {
            TsItemVar varGlobale = this.tableGlobale.getVar(node.getNom());
            if(varGlobale == null){
                System.err.println("la variable globale "+node.getNom()+" n'existe pas");
            }
            else{
                node.tsItem = varGlobale;
            }
        }
        this.tableGlobale.addVar(node.getNom(),node.tsItem.getTaille());
        return null;
    }

    public Void visit(SaAppel node) {
        TsItemFct tsItemFct = this.tableGlobale.getFct(node.getNom());
        if(tsItemFct == null){
            System.err.println("la fonction "+node.getNom()+" n'existe pas");
        }
        else {
            node.tsItem = tsItemFct;
        }
        return null;
    }

    public Void visit(SaVarIndicee node) {
        TsItemVar tsItemVar = this.tableGlobale.getVar(node.getNom());
        if(tsItemVar == null){
            System.err.println("le tableau "+node.getNom()+" n'existe pas");
        }
        else {
            node.tsItem = tsItemVar;
        }
        return null;
    }
}
