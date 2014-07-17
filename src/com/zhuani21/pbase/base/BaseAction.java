package com.zhuani21.pbase.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhuani21.pbase.service.DepartmentService;
import com.zhuani21.pbase.service.PrivilegeService;
import com.zhuani21.pbase.service.RoleService;
import com.zhuani21.pbase.service.UserService;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private static final long serialVersionUID = -6754763091004471626L;
	// ===================== 声明Service ====================
	@Resource
	protected RoleService roleService;
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;

	// ===================== 对ModelDriven的支持 ====================

	protected T model;

	@SuppressWarnings("unchecked")
	public BaseAction() {
		System.out.println("----------> BaseAction.BaseAction()");
		try {
			// 通过反射获取T的真是类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

}
