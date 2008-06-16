/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class ASingleInnerElements extends PInnerElements
{
    private PInnerElement _innerElement_;

    public ASingleInnerElements()
    {
        // Constructor
    }

    public ASingleInnerElements(
        @SuppressWarnings("hiding") PInnerElement _innerElement_)
    {
        // Constructor
        setInnerElement(_innerElement_);

    }

    @Override
    public Object clone()
    {
        return new ASingleInnerElements(
            cloneNode(this._innerElement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASingleInnerElements(this);
    }

    public PInnerElement getInnerElement()
    {
        return this._innerElement_;
    }

    public void setInnerElement(PInnerElement node)
    {
        if(this._innerElement_ != null)
        {
            this._innerElement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._innerElement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._innerElement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._innerElement_ == child)
        {
            this._innerElement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._innerElement_ == oldChild)
        {
            setInnerElement((PInnerElement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
