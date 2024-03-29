/* This file was generated by SableCC (http://www.sablecc.org/). */

package xslt.node;

import xslt.analysis.*;

@SuppressWarnings("nls")
public final class TXmlnsUrl extends Token
{
    public TXmlnsUrl()
    {
        super.setText("xmlns=\"http://www.w3.org/1999/xhtml\"");
    }

    public TXmlnsUrl(int line, int pos)
    {
        super.setText("xmlns=\"http://www.w3.org/1999/xhtml\"");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TXmlnsUrl(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTXmlnsUrl(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TXmlnsUrl text.");
    }
}
