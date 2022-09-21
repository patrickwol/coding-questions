package org.pktl.tree.inorder;

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
            "1 2 # # 3, 2 3 1",
            "1 2, 2 1",
            "1 # 2, 1 2",
            "1 2 3 # # 4, 2 1 4 3",
            "1 2 3 # 5 4, 2 5 1 4 3"
    })
    void inorderTraversal(@ConvertWith(TreeNodeConverter.class) TreeNode node,
                          @ConvertWith(IntArrayConverter.class) int[] res) {
        int[] ints = new Solution().inorderTraversalStack(node);
        assertTrue(ArrayUtil.equals(ints, res));
    }
}