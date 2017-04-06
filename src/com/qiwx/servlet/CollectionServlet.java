package com.qiwx.servlet;

import java.awt.image.BandCombineOp;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qiwx.bean.CollectionBean;
import com.qiwx.dao.CollDao;
import com.qiwx.dao.impl.CollDaoImpl;
import com.qiwx.util.DBUtils;

/**
 * Servlet implementation class CollectionServlet
 */
@WebServlet("/CollectionServlet")
public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CollectionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String url = request.getParameter("url");
		CollDao dao = new CollDaoImpl();
		CollectionBean bean = new CollectionBean();
		bean.setName(name);
		bean.setUrl(url);
		dao.save(bean);
		//保存成功后查询数据库记录
		List list = dao.list();
		//将list设置变量
		request.setAttribute("cl", list);
		request.getRequestDispatcher("/Collection.jsp").include(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
