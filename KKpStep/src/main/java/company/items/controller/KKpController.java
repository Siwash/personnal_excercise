package company.items.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import company.items.service.PeopleService;

@Controller
@RequestMapping("/kkpagerController")
public class KKpController {
		@Resource
		PeopleService peopleService;
		@RequestMapping(value="/showPage.ajax",produces="text/html; charset=utf-8")
		public @ResponseBody String showPage(String n,HttpSession session) {
			String m=(String) session.getAttribute("PageData");
			if (m==null) {
				m="10";
			}
			System.err.println(n+"::"+m);
			String json=peopleService.getPageJson(n,m);
			System.out.println(json);
			return json;
		}
		
		@RequestMapping(value="/addp.do")
		public String addpeople(String number,HttpSession session) {
			int m=number==null? 0:Integer.parseInt(number);
			String addlist=peopleService.addPeopleData(m);			
			System.out.println(number+addlist);
			session.setAttribute("totalData","");
			return "index";
		}
		@RequestMapping(value="/init.do")
		public String pagetatol(Model model,String total,String PageData,HttpSession session,String Method) {
			
			
			int totalData=peopleService.queryAllData(); 
			
			if (Method.equals("PD")) {
				PageData=(String) (PageData==null? "10":PageData);
				int pd=Integer.parseInt(PageData);
				int y=totalData%pd;
				y=y>0? totalData/pd+1:totalData/pd;
				total=Integer.toString(y);
			}else if (Method.equals("TP")) {
				total=(String) (total==null? "7":total);
				int TP=Integer.parseInt(total);
				int x=totalData%TP;
				x=x>0? totalData/TP+1:totalData/TP;
				PageData=Integer.toString(x);
			}
			
			session.setAttribute("PageData", PageData);
			session.setAttribute("totalPage",total );
			session.setAttribute("totalData", totalData);
			System.err.println(PageData+"---"+total);
			return "index";
		}
		
}
