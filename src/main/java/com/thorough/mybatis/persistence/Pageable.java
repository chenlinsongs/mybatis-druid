package com.thorough.mybatis.persistence;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlTransient;

public interface Pageable<T> {

    @JsonIgnore
    @XmlTransient
    public Page<T> getPage();


    public Page<T> setPage(Page<T> page);
}
