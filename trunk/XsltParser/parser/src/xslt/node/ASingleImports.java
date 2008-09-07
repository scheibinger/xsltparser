/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class ASingleImports extends PImports
{
    private PImportElement _importElement_;

    public ASingleImports()
    {
        // Constructor
    }

    public ASingleImports(
        @SuppressWarnings("hiding") PImportElement _importElement_)
    {
        // Constructor
        setImportElement(_importElement_);

    }

    @Override
    public Object clone()
    {
        return new ASingleImports(
            cloneNode(this._importElement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASingleImports(this);
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
            + toString(this._importElement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
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
        if(this._importElement_ == oldChild)
        {
            setImportElement((PImportElement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}