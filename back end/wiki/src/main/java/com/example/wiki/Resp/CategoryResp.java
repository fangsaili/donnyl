package com.example.wiki.Resp;




import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table ebook
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class CategoryResp {

    @Min(value = 1, message = "id不能小于1")
    private Long id;

    @NotNull(message = "父类不能为空")
    private Long parent;

    @NotNull(message = "名字不能为空")
    private String name;

    private Integer sort;

    @Override
    public String toString() {
        return "CategoryReq{" +
                "id=" + id +
                ", parent=" + parent +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}