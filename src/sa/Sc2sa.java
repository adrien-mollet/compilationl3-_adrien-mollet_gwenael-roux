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

    public void caseAPlusExp3(APlusExp3 node){
        SaExp op1, op2;
        node.getExp3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExp4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAdd(op1, op2);
    }
}