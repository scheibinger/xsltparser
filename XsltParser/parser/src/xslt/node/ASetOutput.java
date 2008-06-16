/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class ASetOutput extends PSetOutput
{
    private TXsltTag _xsltTag_;
    private TOutput _output_;
    private POutputOptions _outputOptions_;
    private TCloseTagRange _closeTagRange_;

    public ASetOutput()
    {
        // Constructor
    }

    public ASetOutput(
        @SuppressWarnings("hiding") TXsltTag _xsltTag_,
        @SuppressWarnings("hiding") TOutput _output_,
        @SuppressWarnings("hiding") POutputOptions _outputOptions_,
        @SuppressWarnings("hiding") TCloseTagRange _closeTagRange_)
    {
        // Constructor
        setXsltTag(_xsltTag_);

        setOutput(_output_);

        setOutputOptions(_outputOptions_);

        setCloseTagRange(_closeTagRange_);

    }

    @Override
    public Object clone()
    {
        return new ASetOutput(
            cloneNode(this._xsltTag_),
            cloneNode(this._output_),
            cloneNode(this._outputOptions_),
            cloneNode(this._closeTagRange_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASetOutput(this);
    }

    public TXsltTag getXsltTag()
    {
        return this._xsltTag_;
    }

    public void setXsltTag(TXsltTag node)
    {
        if(this._xsltTag_ != null)
        {
            this._xsltTag_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._xsltTag_ = node;
    }

    public TOutput getOutput()
    {
        return this._output_;
    }

    public void setOutput(TOutput node)
    {
        if(this._output_ != null)
        {
            this._output_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._output_ = node;
    }

    public POutputOptions getOutputOptions()
    {
        return this._outputOptions_;
    }

    public void setOutputOptions(POutputOptions node)
    {
        if(this._outputOptions_ != null)
        {
            this._outputOptions_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._outputOptions_ = node;
    }

    public TCloseTagRange getCloseTagRange()
    {
        return this._closeTagRange_;
    }

    public void setCloseTagRange(TCloseTagRange node)
    {
        if(this._closeTagRange_ != null)
        {
            this._closeTagRange_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._closeTagRange_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._xsltTag_)
            + toString(this._output_)
            + toString(this._outputOptions_)
            + toString(this._closeTagRange_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._xsltTag_ == child)
        {
            this._xsltTag_ = null;
            return;
        }

        if(this._output_ == child)
        {
            this._output_ = null;
            return;
        }

        if(this._outputOptions_ == child)
        {
            this._outputOptions_ = null;
            return;
        }

        if(this._closeTagRange_ == child)
        {
            this._closeTagRange_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._xsltTag_ == oldChild)
        {
            setXsltTag((TXsltTag) newChild);
            return;
        }

        if(this._output_ == oldChild)
        {
            setOutput((TOutput) newChild);
            return;
        }

        if(this._outputOptions_ == oldChild)
        {
            setOutputOptions((POutputOptions) newChild);
            return;
        }

        if(this._closeTagRange_ == oldChild)
        {
            setCloseTagRange((TCloseTagRange) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}