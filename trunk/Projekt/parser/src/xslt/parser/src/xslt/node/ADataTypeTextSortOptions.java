/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class ADataTypeTextSortOptions extends PSortOptions
{
    private TDataType _dataType_;
    private TEqual _equal_;
    private PText _text_;

    public ADataTypeTextSortOptions()
    {
        // Constructor
    }

    public ADataTypeTextSortOptions(
        @SuppressWarnings("hiding") TDataType _dataType_,
        @SuppressWarnings("hiding") TEqual _equal_,
        @SuppressWarnings("hiding") PText _text_)
    {
        // Constructor
        setDataType(_dataType_);

        setEqual(_equal_);

        setText(_text_);

    }

    @Override
    public Object clone()
    {
        return new ADataTypeTextSortOptions(
            cloneNode(this._dataType_),
            cloneNode(this._equal_),
            cloneNode(this._text_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADataTypeTextSortOptions(this);
    }

    public TDataType getDataType()
    {
        return this._dataType_;
    }

    public void setDataType(TDataType node)
    {
        if(this._dataType_ != null)
        {
            this._dataType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dataType_ = node;
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
            + toString(this._dataType_)
            + toString(this._equal_)
            + toString(this._text_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._dataType_ == child)
        {
            this._dataType_ = null;
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
        if(this._dataType_ == oldChild)
        {
            setDataType((TDataType) newChild);
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
