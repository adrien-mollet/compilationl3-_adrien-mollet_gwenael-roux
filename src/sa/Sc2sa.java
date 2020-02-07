package sa;

import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;

    public void caseAAffectationI(AAffectationI node){
        SaInstAffect op;
        node.getIaff().apply(this);
        op = (SaInstAffect) this.returnValue;
        this.returnValue = op;
    }

    public void caseAAppelExp6(AAppelExp6 node){
        SaExpAppel appel;
        node.getApp().apply(this);
        appel = (SaExpAppel) this.returnValue;
        this.returnValue = new SaExpAppel(appel.getVal());
    }

    public void caseAAppelI(AAppelI node){
        SaAppel appel;
        node.getIapp().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = appel;
    }

    public void caseABlocI(ABlocI node){
        SaInstBloc bloc;
        node.getIbloc().apply(this);
        bloc = (SaInstBloc) this.returnValue;
        this.returnValue = new SaInstBloc(bloc.getVal());
    }

    public void caseAConditionI(AConditionI node){
        SaInstSi si;
        node.getIsi().apply(this);
        si = (SaInstSi) this.returnValue;
        this.returnValue = si;
    }

    public void caseADf(ADf node){
        /*TId id = node.getId();
        SaLDec ldv;
        SaLDec ldvo;
        SaInstBloc ibloc;
        node.getId().apply(this);*/

    }



    public void caseANonVideLdf(ANonVideLdf node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseANonVideLdv(ANonVideLdv node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseANonVideLdvb(ANonVideLdvb node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseANonVideLdvo(ANonVideLdvo node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseANonVideLexp(ANonVideLexp node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseANonVideLexp2(ANonVideLexp2 node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseANonVideLi(ANonVideLi node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseANormalApp(ANormalApp node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseANormalIapp(ANormalIapp node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseAOuExp(AOuExp node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseAParenthesesExp6(AParenthesesExp6 node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseAPlusExp3(APlusExp3 node){
        SaExp op1, op2;
        node.getExp3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAdd(op1, op2);
    }

    public void caseAProgramme(AProgramme node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseARetourI(ARetourI node){
        SaInstRetour iret;
        node.getIret().apply(this);
        iret = (SaInstRetour) this.returnValue;
        this.returnValue = iret;
    }

    public void caseASimpleVar(ASimpleVar node){
        String id = node.getId().getText();
        this.returnValue = new SaVarSimple(id);
    }

    public void caseATableauDv(ATableauDv node){
        String id = node.getId().getText();
        int taille = Integer.parseInt(node.getNombre().getText());
        this.returnValue = new SaDecTab(id,taille);
    }

    public void caseATableauVar(ATableauVar node){
        TId id = node.getId();
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id.getText(),expr);
    }

    public void caseATantqueI(ATantqueI node){
        SaInstTantQue tantQue;
        node.getItq().apply(this);
        tantQue = (SaInstTantQue) this.returnValue;
        this.returnValue = tantQue;
    }

    public void caseAVarExp6(AVarExp6 node){
        SaVar var;
        node.getVar().apply(this);
        var = (SaVar) this.returnValue;
        this.returnValue = new SaExpVar(var);
    }

    public void caseAVariableDv(AVariableDv node){
        TId id = node.getId();
        this.returnValue = new SaDecVar(id.getText());
    }

    public void caseAVideLdf(AVideLdf node){
        node.apply(this);
        this.returnValue = null;
    }

    public void caseAVideLdv(AVideLdv node){
        node.apply(this);
        this.returnValue = null;
    }

    public void caseAVideLdvb(AVideLdvb node){
        node.apply(this);
        this.returnValue = null;
    }

    public void caseAVideLdvo(AVideLdvo node){
        node.apply(this);
        this.returnValue = null;
    }

    public void caseAVideLexp(AVideLexp node){
        node.apply(this);
        this.returnValue = null;
    }

    public void caseAVideLexp2(AVideLexp2 node){
        node.apply(this);
        this.returnValue = null;
    }

    public void caseAVideLi(AVideLi node){
        node.apply(this);
        this.returnValue = null;
    }




}