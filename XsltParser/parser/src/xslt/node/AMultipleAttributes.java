/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class AMultipleAttributes extends PAttributes
{
    private PAttributes _attributes_;
    private PAttributeElement _attributeElement_;

    public AMultipleAttributes()
    {
        // Constructor
    }

    public AMultipleAttributes(
        @SuppressWarnings("hiding") PAttributes _attributes_,
        @SuppressWarnings("hiding") PAttributeElement _attributeElement_)
    {
        // Constructor
        setAttributes(_attributes_);

        setAttributeElement(_attributeElement_);

    }

    @Override
    public Object clone()
    {
        return new AMultipleAttributes(
            cloneNode(this._attributes_),
            cloneNode(this._attributeElement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultipleAttributes(this);
    }

    public PAttributes getAttributes()
    {
        return this._attributes_;
    }

    public void setAttributes(PAttributes node)
    {
        if(this._attributes_ != null)
        {
            this._attributes_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._attributes_ = node;
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
            + toString(this._attributes_)
            + toString(this._attributeElement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._attributes_ == child)
        {
            this._attributes_ = null;
            return;
        }

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
        if(this._attributes_ == oldChild)
        {
            setAttributes((PAttributes) newChild);
            return;
        }

        if(this._attributeElement_ == oldChild)
        {
            setAttributeElement((PAttributeElement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
