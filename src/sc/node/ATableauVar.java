/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ATableauVar extends PVar
{
    private TId _id_;
    private TCo _co_;
    private PExp _exp_;
    private TCf _cf_;

    public ATableauVar()
    {
        // Constructor
    }

    public ATableauVar(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TCo _co_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TCf _cf_)
    {
        // Constructor
        setId(_id_);

        setCo(_co_);

        setExp(_exp_);

        setCf(_cf_);

    }

    @Override
    public Object clone()
    {
        return new ATableauVar(
            cloneNode(this._id_),
            cloneNode(this._co_),
            cloneNode(this._exp_),
            cloneNode(this._cf_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATableauVar(this);
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

    public TCo getCo()
    {
        return this._co_;
    }

    public void setCo(TCo node)
    {
        if(this._co_ != null)
        {
            this._co_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._co_ = node;
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public TCf getCf()
    {
        return this._cf_;
    }

    public void setCf(TCf node)
    {
        if(this._cf_ != null)
        {
            this._cf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cf_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._id_)
            + toString(this._co_)
            + toString(this._exp_)
            + toString(this._cf_);
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

        if(this._co_ == child)
        {
            this._co_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._cf_ == child)
        {
            this._cf_ = null;
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

        if(this._co_ == oldChild)
        {
            setCo((TCo) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._cf_ == oldChild)
        {
            setCf((TCf) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
