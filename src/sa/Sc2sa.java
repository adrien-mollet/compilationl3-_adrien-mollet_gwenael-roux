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

    public void caseADivExp4(ADivExp4 node){

    }

    public void caseAEcrireIapp(AEcrireIapp node){

    }

    public void caseAEgalExp2(AEgalExp2 node){

    }

    public void caseAEtExp1(AEtExp1 node){

    }

    public void caseAIaff(AIaff node){

    }

    public void caseAIbloc(AIbloc node){

    }

    public void caseAInfExp2(AInfExp2 node){

    }

    public void caseAIret(AIret node){

    }

    public void caseAIsi(AIsi node){

    }

    public void caseAIsinon(AIsinon node){

    }

    public void caseAIsinonI(AIsinonI node){

    }

    public void caseAItq(AItq node){
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        SaInst ibloc;
        node.getIbloc().apply(this);
        ibloc = (SaInst) this.returnValue;
        this.returnValue = new SaInstTantQue(expr,ibloc);
    }

    public void caseALireApp(ALireApp node){
       this.returnValue = new SaExpLire();
    }

    public void caseAMoinsExp3(AMoinsExp3 node){
        SaExp exp3;
        node.getExp3().apply(this);
        exp3 = (SaExp) this.returnValue;

        SaExp exp4;
        node.getExp4().apply(this);
        exp4 = (SaExp) this.returnValue;

        this.returnValue = new SaExpSub(exp3,exp4);
    }

    public void caseAMultExp4(AMultExp4 node){
        SaExp exp4;
        node.getExp4().apply(this);
        exp4 = (SaExp) this.returnValue;

        SaExp exp5;
        node.getExp5().apply(this);
        exp5 = (SaExp) this.returnValue;

        this.returnValue = new SaExpMult(exp4,exp5);
    }

    public void caseANivSuivantExp(ANivSuivantExp node){
        SaExp expr;
        node.getExp1().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = expr;
    }

    public void caseANivSuivantExp1(ANivSuivantExp1 node){
        SaExp expr;
        node.getExp2().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = expr;
    }

    public void caseANivSuivantExp2(ANivSuivantExp2 node){
        SaExp expr;
        node.getExp3().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = expr;
    }

    public void caseANivSuivantExp3(ANivSuivantExp3 node){
        SaExp expr;
        node.getExp4().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = expr;
    }

    public void caseANivSuivantExp4(ANivSuivantExp4 node){
        SaExp expr;
        node.getExp5().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = expr;
    }

    public void caseANivSuivantExp5(ANivSuivantExp5 node){
        SaExp expr;
        node.getExp6().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = expr;
    }

    public void caseANombreExp6(ANombreExp6 node){
        TNombre nombre = node.getNombre();
        this.returnValue = new SaExpInt(Integer.parseInt(nombre.getText()));
    }

    public void caseANonExp5(ANonExp5 node){
        SaExp expr;
        node.getExp5().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = new SaExpNot(expr);
    }

    public void caseANonVideLdf(ANonVideLdf node){
        SaDec fonc;
        node.getDf().apply(this);
        fonc = (SaDec) this.returnValue;
        SaLDec ldf;
        node.getLdf().apply(this);
        ldf = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(fonc,ldf);
    }

    public void caseANonVideLdv(ANonVideLdv node){
        SaDec var;
        node.getDv().apply(this);
        var = (SaDec) this.returnValue;
        SaLDec lvar;
        node.getLdvb().apply(this);
        lvar = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(var,lvar);
    }

    public void caseANonVideLdvb(ANonVideLdvb node){
        SaDec var;
        node.getDv().apply(this);
        var = (SaDec) this.returnValue;
        SaLDec lvar;
        node.getLdvb().apply(this);
        lvar = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(var,lvar);
    }

    public void caseANonVideLdvo(ANonVideLdvo node){
        SaLDec ldv;
        node.getLdv().apply(this);
        ldv = (SaLDec) this.returnValue;
        this.returnValue = ldv;
    }

    public void caseANonVideLexp(ANonVideLexp node){
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        SaLExp lexpr2;
        node.getLexp2().apply(this);
        lexpr2 = (SaLExp) this.returnValue;
        this.returnValue = new SaLExp(expr,lexpr2);
    }

    public void caseANonVideLexp2(ANonVideLexp2 node){
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        SaLExp lexpr2;
        node.getLexp2().apply(this);
        lexpr2 = (SaLExp) this.returnValue;
        this.returnValue = new SaLExp(expr,lexpr2);
    }

    public void caseANonVideLi(ANonVideLi node){
        SaInst inst;
        node.getI().apply(this);
        inst = (SaInst) this.returnValue;
        SaLInst li;
        node.getLi().apply(this);
        li = (SaLInst) this.returnValue;
        this.returnValue = new SaLInst(inst,li);
    }

    public void caseANormalApp(ANormalApp node){
        TId id = node.getId();
        SaLExp lexpr;
        node.getLexp().apply(this);
        lexpr = (SaLExp) this.returnValue;
        this.returnValue = new SaAppel(id.getText(),lexpr);
    }

    public void caseANormalIapp(ANormalIapp node){
        SaAppel appel;
        node.getApp().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue  = appel;
    }

    public void caseAOuExp(AOuExp node){
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = expr;
    }

    public void caseAParenthesesExp6(AParenthesesExp6 node){
        SaExp expr;
        node.getExp().apply(this);
        expr = (SaExp) this.returnValue;
        this.returnValue = expr;
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
        SaLDec fonctions;
        node.getLdf().apply(this);
        fonctions = (SaLDec) this.returnValue;
        SaLDec variables;
        node.getLdvo().apply(this);
        variables = (SaLDec) this.returnValue;
        this.returnValue = new SaProg(variables,fonctions);
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
        this.returnValue = null;
    }

    public void caseAVideLdv(AVideLdv node){
        this.returnValue = null;
    }

    public void caseAVideLdvb(AVideLdvb node){
        this.returnValue = null;
    }

    public void caseAVideLdvo(AVideLdvo node){
        this.returnValue = null;
    }

    public void caseAVideLexp(AVideLexp node){
        this.returnValue = null;
    }

    public void caseAVideLexp2(AVideLexp2 node){
        this.returnValue = null;
    }

    public void caseAVideLi(AVideLi node){
        this.returnValue = null;
    }




}