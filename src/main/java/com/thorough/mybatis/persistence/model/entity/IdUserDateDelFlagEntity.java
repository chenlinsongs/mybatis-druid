package com.thorough.mybatis.persistence.model.entity;

import com.thorough.mybatis.persistence.annotation.Column;
import java.util.Date;

public class IdUserDateDelFlagEntity<P> extends IdUserDateEntity<P> {
    private static final long serialVersionUID = 1L;

    @Column(name = "del_flag")
    protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）

    public IdUserDateDelFlagEntity(){
        super();
    }
    public IdUserDateDelFlagEntity(P id){
        super(id);
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public static String getFieldDelFlag() {
        return "delFlag";
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert(){
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate(){
        this.updateDate = new Date();
    }
}
