package com.exam1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam1.pojo.Customer;
import com.exam1.service.ICustomerService;
import com.exam1.service.impl.CustomerServiceImpl;
import com.exam1.util.ServletUtil;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICustomerService iCustomerService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;

	public CustomerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		this.response = response;
		this.request.setCharacterEncoding("utf-8");
		String code = this.request.getParameter("code");
		switch (Integer.valueOf(code)) {
		case ServletUtil.CUSTOMER_LOGIN:
			login();
			break;

		default:
			break;
		}
	}

	//登录操作
	private void login() throws IOException, ServletException {
		String name = this.request.getParameter("name");
		Customer customer = iCustomerService.getCustomer(name);
		if (customer != null) {
			session = request.getSession();
			session.setAttribute("customer", customer);
			this.response.sendRedirect("index.jsp");
		}else{
			this.request.setAttribute("login_info", "您输入的用户名不存在，请重新输入！");
			this.request.getRequestDispatcher("login.jsp").forward(this.request, this.response);
		}
	}

	@Override
	public void init() throws ServletException {
		super.init();
		iCustomerService = new CustomerServiceImpl();
	}

}
