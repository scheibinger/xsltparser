/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class AOmitXmlDeclarationNoOutputOption extends POutputOption
{
    private TOmitXmlDeclaration _omitXmlDeclaration_;
    private TEqual _equal_;
    private TNo _no_;

    public AOmitXmlDeclarationNoOutputOption()
    {
        // Constructor
    }

    public AOmitXmlDeclarationNoOutputOption(
        @SuppressWarnings("hiding") TOmitXmlDeclaration _omitXmlDeclaration_,
        @SuppressWarnings("hiding") TEqual _equal_,
        @SuppressWarnings("hiding") TNo _no_)
    {
        // Constructor
        setOmitXmlDeclaration(_omitXmlDeclaration_);

        setEqual(_equal_);

        setNo(_no_);

    }

    @Override
    public Object clone()
    {
        return new AOmitXmlDeclarationNoOutputOption(
            cloneNode(this._omitXmlDeclaration_),
            cloneNode(this._equal_),
            cloneNode(this._no_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOmitXmlDeclarationNoOutputOption(this);
    }

    public TOmitXmlDeclaration getOmitXmlDeclaration()
    {
        return this._omitXmlDeclaration_;
    }

    public void setOmitXmlDeclaration(TOmitXmlDeclaration node)
    {
        if(this._omitXmlDeclaration_ != null)
        {
            this._omitXmlDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._omitXmlDeclaration_ = node;
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

    public TNo getNo()
    {
        return this._no_;
    }

    public void setNo(TNo node)
    {
        if(this._no_ != null)
        {
            this._no_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._no_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._omitXmlDeclaration_)
            + toString(this._equal_)
            + toString(this._no_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._omitXmlDeclaration_ == child)
        {
            this._omitXmlDeclaration_ = null;
            return;
        }

        if(this._equal_ == child)
        {
            this._equal_ = null;
            return;
        }

        if(this._no_ == child)
        {
            this._no_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._omitXmlDeclaration_ == oldChild)
        {
            setOmitXmlDeclaration((TOmitXmlDeclaration) newChild);
            return;
        }

        if(this._equal_ == oldChild)
        {
            setEqual((TEqual) newChild);
            return;
        }

        if(this._no_ == oldChild)
        {
            setNo((TNo) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}