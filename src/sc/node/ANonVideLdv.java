/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ANonVideLdv extends PLdv
{
    private PDv _dv_;
    private PLdvb _ldvb_;

    public ANonVideLdv()
    {
        // Constructor
    }

    public ANonVideLdv(
        @SuppressWarnings("hiding") PDv _dv_,
        @SuppressWarnings("hiding") PLdvb _ldvb_)
    {
        // Constructor
        setDv(_dv_);

        setLdvb(_ldvb_);

    }

    @Override
    public Object clone()
    {
        return new ANonVideLdv(
            cloneNode(this._dv_),
            cloneNode(this._ldvb_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANonVideLdv(this);
    }

    public PDv getDv()
    {
        return this._dv_;
    }

    public void setDv(PDv node)
    {
        if(this._dv_ != null)
        {
            this._dv_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dv_ = node;
    }

    public PLdvb getLdvb()
    {
        return this._ldvb_;
    }

    public void setLdvb(PLdvb node)
    {
        if(this._ldvb_ != null)
        {
            this._ldvb_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ldvb_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._dv_)
            + toString(this._ldvb_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._dv_ == child)
        {
            this._dv_ = null;
            return;
        }

        if(this._ldvb_ == child)
        {
            this._ldvb_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._dv_ == oldChild)
        {
            setDv((PDv) newChild);
            return;
        }

        if(this._ldvb_ == oldChild)
        {
            setLdvb((PLdvb) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
