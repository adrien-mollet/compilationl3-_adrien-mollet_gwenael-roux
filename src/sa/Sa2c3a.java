package sa;

import c3a.C3a;
import c3a.C3aOperand;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand> {

    private C3a c3a;

    private Sa2c3a(SaNode root){
        this.c3a = new C3a();
        root.accept(this);
    }



}
