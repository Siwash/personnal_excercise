package com.framework.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.erp.service.BossService;
import com.erp.service.DepartmentService;
import com.erp.service.PersonnelService;
import com.erp.service.ProductService;
import com.erp.service.SelfService;
import com.erp.service.StorehouseService;
import com.erp.service.purchaseService;


public class BaseController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3412511940987849417L;
	
	@Resource
	public StorehouseService storehouseService;
	@Resource
	public BossService bossService;
	@Resource
	public DepartmentService departmentService;
	@Resource
	public PersonnelService personnelService;
	@Resource
	public ProductService productService;
	@Resource
	public purchaseService purchaseService;
	@Resource
	public SelfService selfService;
	
	
	private static final int PageSize = 10;

	//
	public void writetoPage(HttpServletResponse response, String s) {
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(s);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getPagesize() {
		return PageSize;
	}

	/**
	 * <p>
	 * 时间属性的编辑器
	 * </p>
	 * 
	 * @author zlf
	 * @Date 2017年6月4日
	 * @param servletRequestDataBinder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder servletRequestDataBinder) {
		servletRequestDataBinder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
