/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thorough.mybatis.persistence.model.dao;

import com.thorough.mybatis.persistence.model.entity.CommonEntity;

import java.util.List;

/**
 * DAO支持类实现
 */
public  interface TreeDao<P,T extends CommonEntity<P>> extends CrudDao<P,T> {

	/**
	 * 找到所有子节点
	 * @param entity
	 * @return
	 */
	public abstract List<T> findByParentIdsLike(T entity);

	/**
	 * 更新所有父节点字段
	 * @param entity
	 * @return
	 */
	public abstract int updateParentIds(T entity);

}