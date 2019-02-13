package com.maju.core.action;

import static com.maju.common.page.SimplePage.cpn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maju.common.page.Pagination;
import com.maju.common.web.CookieUtils;
import com.maju.core.bean.Order;
import com.maju.core.query.OrderQuery;
import com.maju.core.service.OrderService;

@Controller
public class OrderAct {

	@RequestMapping(value = "/order/v_list.html", method = RequestMethod.GET)
	public String list(Integer pageNo, HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		OrderQuery query = new OrderQuery();
		
		model.addAttribute("list",service.getOrderList(query));
		return "order/list";
	}
	@RequestMapping(value = "/order/v_page.html", method = RequestMethod.POST)
	public String page(Integer pageNo, HttpServletRequest request,HttpServletResponse response, ModelMap model) {
		OrderQuery query = new OrderQuery();
		query.setPage(cpn(pageNo));
		query.setPageSize(CookieUtils.getPageSize(request));
		Pagination pagination = service.getOrderListWithPage(query);
		model.addAttribute("pagination",pagination);
		model.addAttribute("pageNo",pagination.getPageNo());
		return "order/page";
	}
	@Autowired
	private OrderService service;
}