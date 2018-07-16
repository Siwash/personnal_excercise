package com.erp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthorityService {

	String getMenus(HttpServletRequest request, HttpServletResponse response);
}
