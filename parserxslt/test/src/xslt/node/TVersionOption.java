/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class TVersionOption extends Token
{
    public TVersionOption()
    {
        super.setText("\"1.0\"");
    }

    public TVersionOption(int line, int pos)
    {
        super.setText("\"1.0\"");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TVersionOption(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTVersionOption(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TVersionOption text.");
    }
}