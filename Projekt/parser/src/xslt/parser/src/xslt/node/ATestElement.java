/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import java.util.*;
import xslt.analysis.*;

@SuppressWarnings("nls")
public final class ATestElement extends PTestElement
{
    private TXsltTag _xsltTag_;
    private TWhen _open_;
    private TTest _test_;
    private TEqual _equal_;
    private PText _text_;
    private TCloseTag _closeWhen_;
    private final LinkedList<PTemplateContent> _templateContent_ = new LinkedList<PTemplateContent>();
    private TCloseXsltTag _closeXsltTag_;
    private TWhen _close_;
    private TCloseTag _closeXslt_;

    public ATestElement()
    {
        // Constructor
    }

    public ATestElement(
        @SuppressWarnings("hiding") TXsltTag _xsltTag_,
        @SuppressWarnings("hiding") TWhen _open_,
        @SuppressWarnings("hiding") TTest _test_,
        @SuppressWarnings("hiding") TEqual _equal_,
        @SuppressWarnings("hiding") PText _text_,
        @SuppressWarnings("hiding") TCloseTag _closeWhen_,
        @SuppressWarnings("hiding") List<PTemplateContent> _templateContent_,
        @SuppressWarnings("hiding") TCloseXsltTag _closeXsltTag_,
        @SuppressWarnings("hiding") TWhen _close_,
        @SuppressWarnings("hiding") TCloseTag _closeXslt_)
    {
        // Constructor
        setXsltTag(_xsltTag_);

        setOpen(_open_);

        setTest(_test_);

        setEqual(_equal_);

        setText(_text_);

        setCloseWhen(_closeWhen_);

        setTemplateContent(_templateContent_);

        setCloseXsltTag(_closeXsltTag_);

        setClose(_close_);

        setCloseXslt(_closeXslt_);

    }

    @Override
    public Object clone()
    {
        return new ATestElement(
            cloneNode(this._xsltTag_),
            cloneNode(this._open_),
            cloneNode(this._test_),
            cloneNode(this._equal_),
            cloneNode(this._text_),
            cloneNode(this._closeWhen_),
            cloneList(this._templateContent_),
            cloneNode(this._closeXsltTag_),
            cloneNode(this._close_),
            cloneNode(this._closeXslt_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATestElement(this);
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

    public TWhen getOpen()
    {
        return this._open_;
    }

    public void setOpen(TWhen node)
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

    public TTest getTest()
    {
        return this._test_;
    }

    public void setTest(TTest node)
    {
        if(this._test_ != null)
        {
            this._test_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._test_ = node;
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

    public TCloseTag getCloseWhen()
    {
        return this._closeWhen_;
    }

    public void setCloseWhen(TCloseTag node)
    {
        if(this._closeWhen_ != null)
        {
            this._closeWhen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._closeWhen_ = node;
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

    public TWhen getClose()
    {
        return this._close_;
    }

    public void setClose(TWhen node)
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
            + toString(this._test_)
            + toString(this._equal_)
            + toString(this._text_)
            + toString(this._closeWhen_)
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

        if(this._test_ == child)
        {
            this._test_ = null;
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

        if(this._closeWhen_ == child)
        {
            this._closeWhen_ = null;
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
            setOpen((TWhen) newChild);
            return;
        }

        if(this._test_ == oldChild)
        {
            setTest((TTest) newChild);
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

        if(this._closeWhen_ == oldChild)
        {
            setCloseWhen((TCloseTag) newChild);
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
            setClose((TWhen) newChild);
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
