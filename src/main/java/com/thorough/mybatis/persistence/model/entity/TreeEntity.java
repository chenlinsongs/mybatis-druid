package com.thorough.mybatis.persistence.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.thorough.mybatis.utils.ReflectionsUtil;
import com.thorough.mybatis.persistence.annotation.Column;


public abstract class TreeEntity<P,T extends TreeEntity> extends IdUserDateDelFlagRemarksNameEntity<P>{

    protected T parent;	// 父级编号

    @Column(name = "parent_id")
    protected String parentId;

    @Column(name = "parent_ids")
    protected String parentIds; // 所有父级编号

    @Column(name = "sort")
    protected Integer sort;		// 排序

    public TreeEntity(P id) {
        super(id);
        this.sort = 30;
    }

    /**
     * 父对象，只能通过子类实现，父类实现mybatis无法读取
     * @return
     */
    @JsonBackReference
    public abstract T getParent();

    /**
     * 父对象，只能通过子类实现，父类实现mybatis无法读取
     * @return
     */
    public abstract void setParent(T parent);

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
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

    public P getParentId() {
        P id = null;
        if (parent != null){

            id = (P) ReflectionsUtil.getFieldValue(parent, "id");
        }
        return id != null ? id : (P) "0";
    }

    public static String getFieldParentIds(){
        return "parentIds";
    }

    public static String getFieldSort(){
        return "sort";
    }
}
