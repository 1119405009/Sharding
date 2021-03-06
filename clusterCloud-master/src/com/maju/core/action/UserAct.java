package com.maju.core.action;

import static com.maju.common.page.SimplePage.cpn;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maju.common.page.Pagination;
import com.maju.common.web.CookieUtils;
import com.maju.common.web.session.SessionProvider;
import com.maju.core.bean.User;
import com.maju.core.query.UserQuery;
import com.maju.core.service.UserService;

@Controller
public class UserAct {

	@RequestMapping(value = "/user/v_list.html", method = RequestMethod.GET)
	public String list(Integer pageNo, HttpServletRequest request,HttpServletResponse response, ModelMap model) {
//		UserQuery query = new UserQuery();
		
//		model.addAttribute("list",service.getUserList(query));
//		
//		User user = new User();
//		user.setId(33);
//		user.setUsername("lance");
//		sessionProvider.setAttribute(request, response, "user_session", user);
		
//		Serializable attribute = sessionProvider.getAttribute(request, "user_session");
//		System.out.println(attribute);
		
		return "user/list";
	}
	@RequestMapping(value = "/user/v_page.html", method = RequestMethod.POST)
	public String page(Integer pageNo, HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		UserQuery query = new UserQuery();
		query.setPage(cpn(pageNo));
		query.setPageSize(CookieUtils.getPageSize(request));
		Pagination pagination = service.getUserListWithPage(query);
		model.addAttribute("pagination",pagination);
		model.addAttribute("pageNo",pagination.getPageNo());
		return "user/page";
	}
	@Autowired
	private UserService service;
//	@Autowired
//	private SessionProvider sessionProvider;
}