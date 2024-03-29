/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class AEncodingOutputOption extends POutputOption
{
    private TEncoding _encoding_;
    private TEqual _equal_;
    private PText _text_;

    public AEncodingOutputOption()
    {
        // Constructor
    }

    public AEncodingOutputOption(
        @SuppressWarnings("hiding") TEncoding _encoding_,
        @SuppressWarnings("hiding") TEqual _equal_,
        @SuppressWarnings("hiding") PText _text_)
    {
        // Constructor
        setEncoding(_encoding_);

        setEqual(_equal_);

        setText(_text_);

    }

    @Override
    public Object clone()
    {
        return new AEncodingOutputOption(
            cloneNode(this._encoding_),
            cloneNode(this._equal_),
            cloneNode(this._text_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEncodingOutputOption(this);
    }

    public TEncoding getEncoding()
    {
        return this._encoding_;
    }

    public void setEncoding(TEncoding node)
    {
        if(this._encoding_ != null)
        {
            this._encoding_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._encoding_ = node;
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
            + toString(this._encoding_)
            + toString(this._equal_)
            + toString(this._text_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._encoding_ == child)
        {
            this._encoding_ = null;
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
        if(this._encoding_ == oldChild)
        {
            setEncoding((TEncoding) newChild);
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
