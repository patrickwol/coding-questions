package org.pktl.converter;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.pktl.util.TreeNode;
import org.pktl.util.TreeNodeUtil;

public class TreeNodeConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && TreeNode.class.isAssignableFrom(targetType)) {
            return TreeNodeUtil.convertStringToTree((String) source);
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }
    }
}
