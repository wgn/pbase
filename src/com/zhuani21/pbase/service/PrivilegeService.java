package com.zhuani21.pbase.service;

import java.util.List;

import com.zhuani21.pbase.base.DaoSupport;
import com.zhuani21.pbase.domain.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege> {

	/**
	 * 查询所有顶级的权限列表
	 * 
	 * @return
	 */
	List<Privilege> findTopList();

	/**
	 * 查询所有权限的URL的集合（不包含null值和重复的值）
	 * 
	 * @return
	 */
	List<String> getAllPrivilegeUrls();

}
