package org.pktl.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.converter.TreeNodeConverter;

class TreeNodeUtilTest {

    @ParameterizedTest
    @CsvSource({
            "1 2 3 # # 4",
            "1 2 3 # 4 5",
            "1 2 3 # 4 5",
            "1 2 3 # 4 5 # # # 6",
            "1 2 3 # 5",
            "1 2 #",
            "1 # 3",
    })
    void createBinaryTree(@ConvertWith(TreeNodeConverter.class) TreeNode node) throws Exception {
        TreeNodeUtil.print(node);
    }
}