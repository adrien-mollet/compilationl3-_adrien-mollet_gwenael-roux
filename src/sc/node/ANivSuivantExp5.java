/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ANivSuivantExp5 extends PExp5
{
    private PExp6 _exp6_;

    public ANivSuivantExp5()
    {
        // Constructor
    }

    public ANivSuivantExp5(
        @SuppressWarnings("hiding") PExp6 _exp6_)
    {
        // Constructor
        setExp6(_exp6_);

    }

    @Override
    public Object clone()
    {
        return new ANivSuivantExp5(
            cloneNode(this._exp6_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANivSuivantExp5(this);
    }

    public PExp6 getExp6()
    {
        return this._exp6_;
    }

    public void setExp6(PExp6 node)
    {
        if(this._exp6_ != null)
        {
            this._exp6_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp6_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp6_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp6_ == child)
        {
            this._exp6_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp6_ == oldChild)
        {
            setExp6((PExp6) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
