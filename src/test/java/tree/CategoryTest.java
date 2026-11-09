package tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 多级分类树测试
 *
 * @author tianxing
 */
class CategoryTest {

    @Test
    @DisplayName("构建多级分类树测试")
    void listWithTree() {
        List<Category> list = Arrays.asList(
                // 一级分类
                new Category(1, 0, "家用电器", 1),
                new Category(2, 0, "手机数码", 2),
                // 二级分类(归属于家用电器)
                new Category(3, 1, "大家电", 1),
                new Category(4, 1, "厨房小电", 2),
                new Category(5, 1, "生活电器", 3),
                // 二级分类(归属于手机数码)
                new Category(6, 2, "智能手机", 1),
                new Category(7, 2, "数码配件", 2),
                // 三级分类(大家电下)
                new Category(8, 3, "平板电视", 1),
                new Category(9, 3, "变频空调", 2),
                // 三级分类(厨房小电下)
                new Category(10, 4, "电饭煲", 1),
                new Category(11, 4, "空气炸锅", 2),
                // 三级分类(生活电器下)
                new Category(12, 5, "扫地机器人", 1),
                new Category(13, 5, "吸尘器", 2),
                new Category(14, 5, "空气净化器", 3),
                // 三级分类(智能手机下)
                new Category(15, 6, "拍照手机", 1),
                new Category(16, 6, "游戏手机", 2),
                // 三级分类(数码配件下)
                new Category(17, 7, "移动电源", 1),
                new Category(18, 7, "蓝牙耳机", 2)
        );
        List<Category> treeList = Category.listWithTree(list);
        printTree(treeList, "");
    }

    /**
     * 递归打印树状目录结构
     *
     * @param list   分类列表
     * @param prefix 前缀
     */
    private void printTree(List<Category> list, String prefix) {
        for (int i = 0; i < list.size(); i++) {
            Category category = list.get(i);
            boolean isLast = (i == list.size() - 1);
            System.out.println(prefix + (isLast ? "└── " : "├── ") + category.getName());
            printTree(category.getChildrenList(), prefix + (isLast ? "    " : "│   "));
        }
    }
}
