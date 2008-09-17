/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class TCloseXsltTag extends Token
{
    public TCloseXsltTag(String text)
    {
        setText(text);
    }

    public TCloseXsltTag(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TCloseXsltTag(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCloseXsltTag(this);
    }
}
