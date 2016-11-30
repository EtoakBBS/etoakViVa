package com.etoak.bbs.web.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.etoak.bbs.data.dao.EtoakUserDao;
import com.etoak.bbs.web.base.BaseTest;


public class UserTest extends BaseTest{

	@Autowired
	private EtoakUserDao dao;

	@Test
	public void test() {
		
		dao.queryById(1);
	}

}
