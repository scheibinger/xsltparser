/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class TNamespace extends Token
{
    public TNamespace(String text)
    {
        setText(text);
    }

    public TNamespace(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TNamespace(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNamespace(this);
    }
}
