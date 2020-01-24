/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ADf extends PDf
{
    private TId _id_;
    private TPo _po_;
    private PLdv _ldv_;
    private TPf _pf_;
    private PLdvo _ldvo_;
    private PIbloc _ibloc_;

    public ADf()
    {
        // Constructor
    }

    public ADf(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TPo _po_,
        @SuppressWarnings("hiding") PLdv _ldv_,
        @SuppressWarnings("hiding") TPf _pf_,
        @SuppressWarnings("hiding") PLdvo _ldvo_,
        @SuppressWarnings("hiding") PIbloc _ibloc_)
    {
        // Constructor
        setId(_id_);

        setPo(_po_);

        setLdv(_ldv_);

        setPf(_pf_);

        setLdvo(_ldvo_);

        setIbloc(_ibloc_);

    }

    @Override
    public Object clone()
    {
        return new ADf(
            cloneNode(this._id_),
            cloneNode(this._po_),
            cloneNode(this._ldv_),
            cloneNode(this._pf_),
            cloneNode(this._ldvo_),
            cloneNode(this._ibloc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADf(this);
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    public TPo getPo()
    {
        return this._po_;
    }

    public void setPo(TPo node)
    {
        if(this._po_ != null)
        {
            this._po_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._po_ = node;
    }

    public PLdv getLdv()
    {
        return this._ldv_;
    }

    public void setLdv(PLdv node)
    {
        if(this._ldv_ != null)
        {
            this._ldv_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ldv_ = node;
    }

    public TPf getPf()
    {
        return this._pf_;
    }

    public void setPf(TPf node)
    {
        if(this._pf_ != null)
        {
            this._pf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pf_ = node;
    }

    public PLdvo getLdvo()
    {
        return this._ldvo_;
    }

    public void setLdvo(PLdvo node)
    {
        if(this._ldvo_ != null)
        {
            this._ldvo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ldvo_ = node;
    }

    public PIbloc getIbloc()
    {
        return this._ibloc_;
    }

    public void setIbloc(PIbloc node)
    {
        if(this._ibloc_ != null)
        {
            this._ibloc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ibloc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._id_)
            + toString(this._po_)
            + toString(this._ldv_)
            + toString(this._pf_)
            + toString(this._ldvo_)
            + toString(this._ibloc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._po_ == child)
        {
            this._po_ = null;
            return;
        }

        if(this._ldv_ == child)
        {
            this._ldv_ = null;
            return;
        }

        if(this._pf_ == child)
        {
            this._pf_ = null;
            return;
        }

        if(this._ldvo_ == child)
        {
            this._ldvo_ = null;
            return;
        }

        if(this._ibloc_ == child)
        {
            this._ibloc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(this._po_ == oldChild)
        {
            setPo((TPo) newChild);
            return;
        }

        if(this._ldv_ == oldChild)
        {
            setLdv((PLdv) newChild);
            return;
        }

        if(this._pf_ == oldChild)
        {
            setPf((TPf) newChild);
            return;
        }

        if(this._ldvo_ == oldChild)
        {
            setLdvo((PLdvo) newChild);
            return;
        }

        if(this._ibloc_ == oldChild)
        {
            setIbloc((PIbloc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
