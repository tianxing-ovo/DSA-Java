package systemdesign.category;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private Integer id;
    private Integer parentId;
    private Integer level;
    private String name;
    private Integer sort;
    private List<Category> childrenList;

    public Category(Integer id, Integer parentId, Integer level, String name, Integer sort) {
        this.id = id;
        this.parentId = parentId;
        this.level = level;
        this.name = name;
        this.sort = sort;
    }
}
