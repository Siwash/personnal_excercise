package com.erp.service.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.erp.mapper.AuthorityMapper;
import com.erp.mapper.LeaveAskMapper;
import com.erp.mapper.WorkRecordListMapper;
import com.erp.model.Authority;
import com.erp.model.PageModel;
import com.google.gson.Gson;

import utils.ActiveMenu;
@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class AuthorityServiceImplTest {
	@Resource
	AuthorityMapper authorityMapper;
	@Resource
	WorkRecordListMapper wmapper;
	@Resource
	LeaveAskMapper LAM;
	@Test
	public void testGetMenus() {
		ActiveMenu activeMenu=new ActiveMenu();
		List<Authority> aList=authorityMapper.queryAllAuthority();
		List<Authority> aList2=activeMenu.getMenu(aList, authorityMapper.selectByPrimaryKey("01"));
		System.out.println(activeMenu.getRootNum(aList));
		System.out.println(aList);
	}
	@Test
	public void testSql() {
		List<Authority> list=authorityMapper.selectByDepartment("系统管理员");
		System.err.println(list);
	}
	
	@Test
	public void testSql2() {
		PageModel PM=new PageModel("20", LAM.getLeavePageDate(0, "001"));
		System.err.println(PageModel.getJson(PM));
	}
	@Test
	public void testSql3() {
		System.err.println(LAM.qureyAllLeaveAsk());
	}
}
