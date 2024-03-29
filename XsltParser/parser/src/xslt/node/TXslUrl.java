/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class TXslUrl extends Token
{
    public TXslUrl()
    {
        super.setText("xsl=\"http://www.w3.org/1999/XSL/Transform\"");
    }

    public TXslUrl(int line, int pos)
    {
        super.setText("xsl=\"http://www.w3.org/1999/XSL/Transform\"");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TXslUrl(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTXslUrl(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TXslUrl text.");
    }
}
