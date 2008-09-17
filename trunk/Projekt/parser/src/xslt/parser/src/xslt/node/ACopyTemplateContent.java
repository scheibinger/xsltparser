/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import java.util.*;
import xslt.analysis.*;

@SuppressWarnings("nls")
public final class ACopyTemplateContent extends PTemplateContent
{
    private TXsltTag _xsltTag_;
    private TCopy _open_;
    private TCloseTag _closeCopy_;
    private final LinkedList<PTemplateContent> _templateContent_ = new LinkedList<PTemplateContent>();
    private TCloseXsltTag _closeXsltTag_;
    private TCopy _close_;
    private TCloseTag _closeXslt_;

    public ACopyTemplateContent()
    {
        // Constructor
    }

    public ACopyTemplateContent(
        @SuppressWarnings("hiding") TXsltTag _xsltTag_,
        @SuppressWarnings("hiding") TCopy _open_,
        @SuppressWarnings("hiding") TCloseTag _closeCopy_,
        @SuppressWarnings("hiding") List<PTemplateContent> _templateContent_,
        @SuppressWarnings("hiding") TCloseXsltTag _closeXsltTag_,
        @SuppressWarnings("hiding") TCopy _close_,
        @SuppressWarnings("hiding") TCloseTag _closeXslt_)
    {
        // Constructor
        setXsltTag(_xsltTag_);

        setOpen(_open_);

        setCloseCopy(_closeCopy_);

        setTemplateContent(_templateContent_);

        setCloseXsltTag(_closeXsltTag_);

        setClose(_close_);

        setCloseXslt(_closeXslt_);

    }

    @Override
    public Object clone()
    {
        return new ACopyTemplateContent(
            cloneNode(this._xsltTag_),
            cloneNode(this._open_),
            cloneNode(this._closeCopy_),
            cloneList(this._templateContent_),
            cloneNode(this._closeXsltTag_),
            cloneNode(this._close_),
            cloneNode(this._closeXslt_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACopyTemplateContent(this);
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

    public TCopy getOpen()
    {
        return this._open_;
    }

    public void setOpen(TCopy node)
    {
        if(this._open_ != null)
        {
            this._open_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._open_ = node;
    }

    public TCloseTag getCloseCopy()
    {
        return this._closeCopy_;
    }

    public void setCloseCopy(TCloseTag node)
    {
        if(this._closeCopy_ != null)
        {
            this._closeCopy_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._closeCopy_ = node;
    }

    public LinkedList<PTemplateContent> getTemplateContent()
    {
        return this._templateContent_;
    }

    public void setTemplateContent(List<PTemplateContent> list)
    {
        this._templateContent_.clear();
        this._templateContent_.addAll(list);
        for(PTemplateContent e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    public TCloseXsltTag getCloseXsltTag()
    {
        return this._closeXsltTag_;
    }

    public void setCloseXsltTag(TCloseXsltTag node)
    {
        if(this._closeXsltTag_ != null)
        {
            this._closeXsltTag_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._closeXsltTag_ = node;
    }

    public TCopy getClose()
    {
        return this._close_;
    }

    public void setClose(TCopy node)
    {
        if(this._close_ != null)
        {
            this._close_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._close_ = node;
    }

    public TCloseTag getCloseXslt()
    {
        return this._closeXslt_;
    }

    public void setCloseXslt(TCloseTag node)
    {
        if(this._closeXslt_ != null)
        {
            this._closeXslt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._closeXslt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._xsltTag_)
            + toString(this._open_)
            + toString(this._closeCopy_)
            + toString(this._templateContent_)
            + toString(this._closeXsltTag_)
            + toString(this._close_)
            + toString(this._closeXslt_);
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

        if(this._open_ == child)
        {
            this._open_ = null;
            return;
        }

        if(this._closeCopy_ == child)
        {
            this._closeCopy_ = null;
            return;
        }

        if(this._templateContent_.remove(child))
        {
            return;
        }

        if(this._closeXsltTag_ == child)
        {
            this._closeXsltTag_ = null;
            return;
        }

        if(this._close_ == child)
        {
            this._close_ = null;
            return;
        }

        if(this._closeXslt_ == child)
        {
            this._closeXslt_ = null;
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

        if(this._open_ == oldChild)
        {
            setOpen((TCopy) newChild);
            return;
        }

        if(this._closeCopy_ == oldChild)
        {
            setCloseCopy((TCloseTag) newChild);
            return;
        }

        for(ListIterator<PTemplateContent> i = this._templateContent_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PTemplateContent) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._closeXsltTag_ == oldChild)
        {
            setCloseXsltTag((TCloseXsltTag) newChild);
            return;
        }

        if(this._close_ == oldChild)
        {
            setClose((TCopy) newChild);
            return;
        }

        if(this._closeXslt_ == oldChild)
        {
            setCloseXslt((TCloseTag) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
