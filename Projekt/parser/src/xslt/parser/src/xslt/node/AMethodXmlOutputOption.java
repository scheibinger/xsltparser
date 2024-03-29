/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class AMethodXmlOutputOption extends POutputOption
{
    private TMethod _method_;
    private TEqual _equal_;
    private TXml _xml_;

    public AMethodXmlOutputOption()
    {
        // Constructor
    }

    public AMethodXmlOutputOption(
        @SuppressWarnings("hiding") TMethod _method_,
        @SuppressWarnings("hiding") TEqual _equal_,
        @SuppressWarnings("hiding") TXml _xml_)
    {
        // Constructor
        setMethod(_method_);

        setEqual(_equal_);

        setXml(_xml_);

    }

    @Override
    public Object clone()
    {
        return new AMethodXmlOutputOption(
            cloneNode(this._method_),
            cloneNode(this._equal_),
            cloneNode(this._xml_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethodXmlOutputOption(this);
    }

    public TMethod getMethod()
    {
        return this._method_;
    }

    public void setMethod(TMethod node)
    {
        if(this._method_ != null)
        {
            this._method_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._method_ = node;
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

    public TXml getXml()
    {
        return this._xml_;
    }

    public void setXml(TXml node)
    {
        if(this._xml_ != null)
        {
            this._xml_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._xml_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._method_)
            + toString(this._equal_)
            + toString(this._xml_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._method_ == child)
        {
            this._method_ = null;
            return;
        }

        if(this._equal_ == child)
        {
            this._equal_ = null;
            return;
        }

        if(this._xml_ == child)
        {
            this._xml_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._method_ == oldChild)
        {
            setMethod((TMethod) newChild);
            return;
        }

        if(this._equal_ == oldChild)
        {
            setEqual((TEqual) newChild);
            return;
        }

        if(this._xml_ == oldChild)
        {
            setXml((TXml) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
