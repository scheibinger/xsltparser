/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class ASingleTests extends PTests
{
    private PTestElement _testElement_;

    public ASingleTests()
    {
        // Constructor
    }

    public ASingleTests(
        @SuppressWarnings("hiding") PTestElement _testElement_)
    {
        // Constructor
        setTestElement(_testElement_);

    }

    @Override
    public Object clone()
    {
        return new ASingleTests(
            cloneNode(this._testElement_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASingleTests(this);
    }

    public PTestElement getTestElement()
    {
        return this._testElement_;
    }

    public void setTestElement(PTestElement node)
    {
        if(this._testElement_ != null)
        {
            this._testElement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._testElement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._testElement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._testElement_ == child)
        {
            this._testElement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._testElement_ == oldChild)
        {
            setTestElement((PTestElement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}