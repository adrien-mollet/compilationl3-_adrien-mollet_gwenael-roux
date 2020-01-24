/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import sc.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgramme(AProgramme node);
    void caseASimpleVar(ASimpleVar node);
    void caseATableauVar(ATableauVar node);
    void caseANonVideLdvo(ANonVideLdvo node);
    void caseAVideLdvo(AVideLdvo node);
    void caseANonVideLdv(ANonVideLdv node);
    void caseAVideLdv(AVideLdv node);
    void caseANonVideLdvb(ANonVideLdvb node);
    void caseAVideLdvb(AVideLdvb node);
    void caseAVariableDv(AVariableDv node);
    void caseATableauDv(ATableauDv node);
    void caseANonVideLdf(ANonVideLdf node);
    void caseAVideLdf(AVideLdf node);
    void caseADf(ADf node);
    void caseAIbloc(AIbloc node);
    void caseANonVideLi(ANonVideLi node);
    void caseAVideLi(AVideLi node);
    void caseAAffectationI(AAffectationI node);
    void caseAConditionI(AConditionI node);
    void caseAIsinonI(AIsinonI node);
    void caseATantqueI(ATantqueI node);
    void caseAAppelI(AAppelI node);
    void caseABlocI(ABlocI node);
    void caseARetourI(ARetourI node);
    void caseAIaff(AIaff node);
    void caseAIsi(AIsi node);
    void caseAIsinon(AIsinon node);
    void caseAItq(AItq node);
    void caseANormalIapp(ANormalIapp node);
    void caseAEcrireIapp(AEcrireIapp node);
    void caseANormalApp(ANormalApp node);
    void caseALireApp(ALireApp node);
    void caseANonVideLexp(ANonVideLexp node);
    void caseAVideLexp(AVideLexp node);
    void caseANonVideLexp2(ANonVideLexp2 node);
    void caseAVideLexp2(AVideLexp2 node);
    void caseAIret(AIret node);
    void caseAOuExp(AOuExp node);
    void caseANivSuivantExp(ANivSuivantExp node);
    void caseAEtExp1(AEtExp1 node);
    void caseANivSuivantExp1(ANivSuivantExp1 node);
    void caseAEgalExp2(AEgalExp2 node);
    void caseAInfExp2(AInfExp2 node);
    void caseANivSuivantExp2(ANivSuivantExp2 node);
    void caseAPlusExp3(APlusExp3 node);
    void caseAMoinsExp3(AMoinsExp3 node);
    void caseANivSuivantExp3(ANivSuivantExp3 node);
    void caseAMultExp4(AMultExp4 node);
    void caseADivExp4(ADivExp4 node);
    void caseANivSuivantExp4(ANivSuivantExp4 node);
    void caseANonExp5(ANonExp5 node);
    void caseANivSuivantExp5(ANivSuivantExp5 node);
    void caseAParenthesesExp6(AParenthesesExp6 node);
    void caseAAppelExp6(AAppelExp6 node);
    void caseAVarExp6(AVarExp6 node);
    void caseANombreExp6(ANombreExp6 node);

    void caseTNombre(TNombre node);
    void caseTId(TId node);
    void caseTDotcoma(TDotcoma node);
    void caseTComa(TComa node);
    void caseTEgal(TEgal node);
    void caseTInf(TInf node);
    void caseTPlus(TPlus node);
    void caseTMoins(TMoins node);
    void caseTMult(TMult node);
    void caseTDiv(TDiv node);
    void caseTPo(TPo node);
    void caseTPf(TPf node);
    void caseTCo(TCo node);
    void caseTCf(TCf node);
    void caseTAo(TAo node);
    void caseTAf(TAf node);
    void caseTSi(TSi node);
    void caseTAlors(TAlors node);
    void caseTEntier(TEntier node);
    void caseTSinon(TSinon node);
    void caseTTantque(TTantque node);
    void caseTFaire(TFaire node);
    void caseTRetour(TRetour node);
    void caseTEt(TEt node);
    void caseTOu(TOu node);
    void caseTNon(TNon node);
    void caseTLire(TLire node);
    void caseTEcrire(TEcrire node);
    void caseTEspaces(TEspaces node);
    void caseTCommentaire(TCommentaire node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
