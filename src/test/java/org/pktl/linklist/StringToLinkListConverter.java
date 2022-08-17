package org.pktl.linklist;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.pktl.util.LinkListUtil;

public class StringToLinkListConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
        return LinkListUtil.stringToLinkList((String) o);
    }
}
