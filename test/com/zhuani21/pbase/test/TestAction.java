package com.zhuani21.pbase.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 3835012252725516187L;
	@Resource
	private TestService testService;

	public String execute() throws Exception {
		System.out.println("-------> TestAction.execute()");
		System.out.println("-------> testService = " + testService);
		testService.saveTwoUsers();
		return "success";
	}

}
