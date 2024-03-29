/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class ADoctypeSystemOutputOption extends POutputOption
{
    private TDoctypeSystem _doctypeSystem_;
    private TEqual _equal_;
    private PText _text_;

    public ADoctypeSystemOutputOption()
    {
        // Constructor
    }

    public ADoctypeSystemOutputOption(
        @SuppressWarnings("hiding") TDoctypeSystem _doctypeSystem_,
        @SuppressWarnings("hiding") TEqual _equal_,
        @SuppressWarnings("hiding") PText _text_)
    {
        // Constructor
        setDoctypeSystem(_doctypeSystem_);

        setEqual(_equal_);

        setText(_text_);

    }

    @Override
    public Object clone()
    {
        return new ADoctypeSystemOutputOption(
            cloneNode(this._doctypeSystem_),
            cloneNode(this._equal_),
            cloneNode(this._text_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADoctypeSystemOutputOption(this);
    }

    public TDoctypeSystem getDoctypeSystem()
    {
        return this._doctypeSystem_;
    }

    public void setDoctypeSystem(TDoctypeSystem node)
    {
        if(this._doctypeSystem_ != null)
        {
            this._doctypeSystem_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._doctypeSystem_ = node;
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

    public PText getText()
    {
        return this._text_;
    }

    public void setText(PText node)
    {
        if(this._text_ != null)
        {
            this._text_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._text_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._doctypeSystem_)
            + toString(this._equal_)
            + toString(this._text_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._doctypeSystem_ == child)
        {
            this._doctypeSystem_ = null;
            return;
        }

        if(this._equal_ == child)
        {
            this._equal_ = null;
            return;
        }

        if(this._text_ == child)
        {
            this._text_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._doctypeSystem_ == oldChild)
        {
            setDoctypeSystem((TDoctypeSystem) newChild);
            return;
        }

        if(this._equal_ == oldChild)
        {
            setEqual((TEqual) newChild);
            return;
        }

        if(this._text_ == oldChild)
        {
            setText((PText) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
