/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ANormalIapp extends PIapp
{
    private PApp _app_;
    private TDotcoma _dotcoma_;

    public ANormalIapp()
    {
        // Constructor
    }

    public ANormalIapp(
        @SuppressWarnings("hiding") PApp _app_,
        @SuppressWarnings("hiding") TDotcoma _dotcoma_)
    {
        // Constructor
        setApp(_app_);

        setDotcoma(_dotcoma_);

    }

    @Override
    public Object clone()
    {
        return new ANormalIapp(
            cloneNode(this._app_),
            cloneNode(this._dotcoma_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANormalIapp(this);
    }

    public PApp getApp()
    {
        return this._app_;
    }

    public void setApp(PApp node)
    {
        if(this._app_ != null)
        {
            this._app_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._app_ = node;
    }

    public TDotcoma getDotcoma()
    {
        return this._dotcoma_;
    }

    public void setDotcoma(TDotcoma node)
    {
        if(this._dotcoma_ != null)
        {
            this._dotcoma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dotcoma_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._app_)
            + toString(this._dotcoma_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._app_ == child)
        {
            this._app_ = null;
            return;
        }

        if(this._dotcoma_ == child)
        {
            this._dotcoma_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._app_ == oldChild)
        {
            setApp((PApp) newChild);
            return;
        }

        if(this._dotcoma_ == oldChild)
        {
            setDotcoma((TDotcoma) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
