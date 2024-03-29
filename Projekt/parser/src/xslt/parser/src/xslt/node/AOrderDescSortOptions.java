/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class AOrderDescSortOptions extends PSortOptions
{
    private TOrder _order_;
    private TEqual _equal_;
    private TDescending _descending_;

    public AOrderDescSortOptions()
    {
        // Constructor
    }

    public AOrderDescSortOptions(
        @SuppressWarnings("hiding") TOrder _order_,
        @SuppressWarnings("hiding") TEqual _equal_,
        @SuppressWarnings("hiding") TDescending _descending_)
    {
        // Constructor
        setOrder(_order_);

        setEqual(_equal_);

        setDescending(_descending_);

    }

    @Override
    public Object clone()
    {
        return new AOrderDescSortOptions(
            cloneNode(this._order_),
            cloneNode(this._equal_),
            cloneNode(this._descending_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOrderDescSortOptions(this);
    }

    public TOrder getOrder()
    {
        return this._order_;
    }

    public void setOrder(TOrder node)
    {
        if(this._order_ != null)
        {
            this._order_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._order_ = node;
    }

    public TEqual getEqual()
    {
        return this._equal_;
    }

    public void setEqual(TEqual node)
    {
        if(this._equal_ != null)
        {
            this._equal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._equal_ = node;
    }

    public TDescending getDescending()
    {
        return this._descending_;
    }

    public void setDescending(TDescending node)
    {
        if(this._descending_ != null)
        {
            this._descending_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._descending_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._order_)
            + toString(this._equal_)
            + toString(this._descending_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._order_ == child)
        {
            this._order_ = null;
            return;
        }

        if(this._equal_ == child)
        {
            this._equal_ = null;
            return;
        }

        if(this._descending_ == child)
        {
            this._descending_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._order_ == oldChild)
        {
            setOrder((TOrder) newChild);
            return;
        }

        if(this._equal_ == oldChild)
        {
            setEqual((TEqual) newChild);
            return;
        }

        if(this._descending_ == oldChild)
        {
            setDescending((TDescending) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
