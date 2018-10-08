package com.thorough.mybatis.persistence.model.entity;

import com.thorough.mybatis.persistence.annotation.Column;

public class IdUserDateDelFlagRemarksEntity<P> extends IdUserDateDelFlagEntity<P> {
    private static final long serialVersionUID = 1L;

    @Column(name = "remarks")
    protected String remarks;	// 备注

    public IdUserDateDelFlagRemarksEntity(){
        super();
    }

    public IdUserDateDelFlagRemarksEntity(P id){
        super(id);
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public static String getFieldFemarks() {
        return "remarks";
    }

}
