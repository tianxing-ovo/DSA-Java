package tree;

import lombok.Data;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 多级分类树
 *
 * @author tianxing
 */
@Data
public class Category {

    private final Integer id;
    private final Integer parentId;
    private final String name;
    private final Integer sort;
    private List<Category> childrenList = Collections.emptyList();

    /**
     * 将分类列表转换为多级分类树
     *
     * @param list 分类列表
     * @return 树形分类列表
     */
    public static List<Category> listWithTree(List<Category> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        // {key:parentId, value:直接子分类列表}
        Map<Integer, List<Category>> childrenMap = list.stream()
                .sorted(Comparator.comparingInt(Category::getSort))
                .collect(Collectors.groupingBy(Category::getParentId));
        // 设置子分类列表
        for (Category category : list) {
            List<Category> children = childrenMap.get(category.getId());
            if (children != null) {
                category.setChildrenList(children);
            }
        }
        // 返回根节点列表
        return childrenMap.get(0);
    }
}
