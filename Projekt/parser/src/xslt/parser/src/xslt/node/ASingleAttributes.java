/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class ASingleAttributes extends PAttributes
{
    private PAttributeElement _attributeElement_;

    public ASingleAttributes()
    {
        // Constructor
    }

    public ASingleAttributes(
        @SuppressWarnings("hiding") PAttributeElement _attributeElement_)
    {
        // Constructor
        setAttributeElement(_attributeElement_);

    }

    @Override
    public Object clone()
    {
        return new ASingleAttributes(
            cloneNode(this._attributeElement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASingleAttributes(this);
    }

    public PAttributeElement getAttributeElement()
    {
        return this._attributeElement_;
    }

    public void setAttributeElement(PAttributeElement node)
    {
        if(this._attributeElement_ != null)
        {
            this._attributeElement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._attributeElement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._attributeElement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._attributeElement_ == child)
        {
            this._attributeElement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._attributeElement_ == oldChild)
        {
            setAttributeElement((PAttributeElement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}