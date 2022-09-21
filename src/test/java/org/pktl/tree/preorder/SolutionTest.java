package org.pktl.tree.preorder;

import cn.hutool.core.util.ArrayUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.converter.IntArrayConverter;
import org.pktl.converter.TreeNodeConverter;
import org.pktl.util.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "1 2 3 # # 4, 1 2 3 4",
            "1 2 3 # 5 4, 1 2 5 3 4"
    })
    void preorderTraversal(@ConvertWith(TreeNodeConverter.class) TreeNode node,
                           @ConvertWith(IntArrayConverter.class) int[] res) {
        int[] ints = new Solution().preorderTraversal(node);
        assertTrue(ArrayUtil.equals(ints, res));
    }
}