/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class TTilde extends Token
{
    public TTilde()
    {
        super.setText("~");
    }

    public TTilde(int line, int pos)
    {
        super.setText("~");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTilde(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTilde(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTilde text.");
    }
}
