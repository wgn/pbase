package com.zhuani21.pbase.base;

import java.util.List;

public interface DaoSupport<T> {

	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	T getById(Long id);
	
	/**
	 * 根据id数组查询多个
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);


	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
}
