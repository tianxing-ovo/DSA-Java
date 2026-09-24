package systemdesign.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Category c1 = new Category(1, 0, 1, "一级分类1", 1);
        Category c2 = new Category(2, 0, 1, "一级分类2", 2);

        Category c3 = new Category(3, 1, 2, "二级分类1", 1);
        Category c4 = new Category(4, 1, 2, "二级分类2", 2);
        Category c5 = new Category(5, 1, 2, "二级分类3", 3);
        Category c6 = new Category(6, 2, 2, "二级分类4", 4);
        Category c7 = new Category(7, 2, 2, "二级分类5", 5);

        Category c8 = new Category(8, 3, 3, "三级分类1", 1);
        Category c9 = new Category(9, 3, 3, "三级分类2", 2);
        Category c10 = new Category(10, 4, 3, "三级分类3", 3);
        Category c11 = new Category(11, 4, 3, "三级分类4", 4);
        Category c12 = new Category(12, 5, 3, "三级分类5", 5);
        Category c13 = new Category(13, 5, 3, "三级分类6", 6);
        Category c14 = new Category(14, 5, 3, "三级分类7", 7);
        Category c15 = new Category(15, 6, 3, "三级分类8", 8);
        Category c16 = new Category(16, 6, 3, "三级分类9", 9);
        Category c17 = new Category(17, 7, 3, "三级分类10", 10);
        Category c18 = new Category(18, 7, 3, "三级分类11", 11);

        List<Category> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17,
                c18);
        list = listWithTree(list);
        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(list));
    }

    public static List<Category> listWithTree(List<Category> list) {
        return list.stream().filter(category -> category.getLevel() == 1)  //一级分类
                .peek(category -> category.setChildrenList(getChildrenList(category, list))) //递归设置子分类
                .sorted(Comparator.comparingInt(Category::getSort)) //升序
                .collect(Collectors.toList());
    }

    private static List<Category> getChildrenList(Category category, List<Category> list) {
        return list.stream().filter(c -> Objects.equals(c.getParentId(), category.getId())) //父分类id=当前分类id
                .peek(c -> c.setChildrenList(getChildrenList(c, list))) //递归设置子分类
                .sorted(Comparator.comparingInt(Category::getSort)) //升序
                .collect(Collectors.toList());
    }
}
