package org.pktl.tree.postorder;

import cn.hutool.core.util.ArrayUtil;
import org.junit.jupiter.api.Test;
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
            "1 2 # # 3, 3 2 1",
            "1 2, 2 1",
            "1 # 2, 2 1",
            "1 2 3 # # 4, 2 4 3 1",
            "1 2 3 # 4 5, 4 2 5 3 1",
            "2 # 3 # # # 1, 1 3 2"
    })
    void postorderTraversal(@ConvertWith(TreeNodeConverter.class) TreeNode node,
                            @ConvertWith(IntArrayConverter.class) int[] res) {
        int[] ints = new Solution().postorderTraversalStack(node);
        assertTrue(ArrayUtil.equals(ints, res));
    }
}