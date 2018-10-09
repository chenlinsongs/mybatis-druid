package com.thorough.web.model;

import com.thorough.mybatis.dao.Image;
import com.thorough.mybatis.persistence.annotation.MyBatisDao;
import com.thorough.mybatis.persistence.model.dao.CommonDao;

@MyBatisDao
public interface WebDao extends CommonDao<String,Image> {

}
