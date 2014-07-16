package com.zhuani21.pbase.test;

import java.util.Properties;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.PortableServer.POA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhuani21.pbase.domain.User;

@Service
public class TestService {

	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void saveTwoUsers() {
		Session session = sessionFactory.getCurrentSession();

		session.save(new User());
		// int a = 1 / 0; // 这行会抛异常
		session.save(new User());
	}
}
