package com.thorough.mybatis.dao;


import com.thorough.mybatis.persistence.annotation.MyBatisDao;
import com.thorough.mybatis.persistence.model.dao.CommonDao;

@MyBatisDao
public interface ImageDao extends CommonDao<String,Image> {

}