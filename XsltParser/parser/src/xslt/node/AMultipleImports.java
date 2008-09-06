/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class AMultipleImports extends PImports
{
    private PImports _imports_;
    private PImportElement _importElement_;

    public AMultipleImports()
    {
        // Constructor
    }

    public AMultipleImports(
        @SuppressWarnings("hiding") PImports _imports_,
        @SuppressWarnings("hiding") PImportElement _importElement_)
    {
        // Constructor
        setImports(_imports_);

        setImportElement(_importElement_);

    }

    @Override
    public Object clone()
    {
        return new AMultipleImports(
            cloneNode(this._imports_),
            cloneNode(this._importElement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultipleImports(this);
    }

    public PImports getImports()
    {
        return this._imports_;
    }

    public void setImports(PImports node)
    {
        if(this._imports_ != null)
        {
            this._imports_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._imports_ = node;
    }

    public PImportElement getImportElement()
    {
        return this._importElement_;
    }

    public void setImportElement(PImportElement node)
    {
        if(this._importElement_ != null)
        {
            this._importElement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._importElement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._imports_)
            + toString(this._importElement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._imports_ == child)
        {
            this._imports_ = null;
            return;
        }

        if(this._importElement_ == child)
        {
            this._importElement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._imports_ == oldChild)
        {
            setImports((PImports) newChild);
            return;
        }

        if(this._importElement_ == oldChild)
        {
            setImportElement((PImportElement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}