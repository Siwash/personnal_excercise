package company.items.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import company.items.service.ZtreeService;

@Controller
@RequestMapping("indexController")
public class IndexController {
	@Resource
	ZtreeService zs;
	@RequestMapping(value="getTree.ajax",produces="text/html; charset=utf-8")
	public @ResponseBody String getTree() {
		String json=zs.queryAllByJson();
		return json;
	}
	@RequestMapping(value="updataZtree.ajax",produces="text/html; charset=utf-8")
	public @ResponseBody String updataZtree(String id,String pid) {
		String result=zs.updataPidById(id,pid);
		return result;
	}
	@RequestMapping(value="updataCheck.ajax",produces="text/html; charset=utf-8")
	public @ResponseBody String updataCheck(HttpServletRequest request) {
		String nodes= request.getParameter("nodes");
		String result=zs.updataCheckById(nodes);
		return result;
	}
}
