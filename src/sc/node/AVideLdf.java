/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AVideLdf extends PLdf
{
    private TVide _vide_;

    public AVideLdf()
    {
        // Constructor
    }

    public AVideLdf(
        @SuppressWarnings("hiding") TVide _vide_)
    {
        // Constructor
        setVide(_vide_);

    }

    @Override
    public Object clone()
    {
        return new AVideLdf(
            cloneNode(this._vide_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVideLdf(this);
    }

    public TVide getVide()
    {
        return this._vide_;
    }

    public void setVide(TVide node)
    {
        if(this._vide_ != null)
        {
            this._vide_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._vide_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._vide_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._vide_ == child)
        {
            this._vide_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._vide_ == oldChild)
        {
            setVide((TVide) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
