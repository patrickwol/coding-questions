package org.pktl.converter;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.pktl.util.LinkListUtil;
import org.pktl.util.ListNode;

public class LinkListConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && ListNode.class.isAssignableFrom(targetType)) {
            return LinkListUtil.stringToLinkList((String) source);
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }
    }
}
