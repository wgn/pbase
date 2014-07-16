package com.zhuani21.pbase.service;

import com.zhuani21.pbase.base.DaoSupport;
import com.zhuani21.pbase.domain.User;

public interface UserService extends DaoSupport<User> {

	/**
	 * 验证用户名与密码，如果正确就返回这个用户，否则返回null
	 * 
	 * @param loginName
	 * @param password 明文密码
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);

}
