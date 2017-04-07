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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//根据action 字段内容来执行对应保存，更新，修改，删除逻辑
		String action = request.getParameter("action");
		if (action != null && action.equals("save")) {
			save(request, response);
		} else if (action != null && action.equals("list")) {
			list(request, response);
		} else if (action != null && action.equals("get")) {
			get(request, response);
		}else if (action != null && action.equals("update")) {
			update(request, response);
		}else if (action != null && action.equals("delete")) {
			delete(request, response);
		}
		else {

		}
	}
	protected void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //获取名称和地址
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		CollDao dao = new CollDaoImpl();
		CollectionBean bean = new CollectionBean();
		bean.setName(name);
		bean.setUrl(url);
		dao.save(bean);
		//保存完数据后查询列表
		list(request, response);
		
		
	}
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CollDao dao = new CollDaoImpl();
		List<CollectionBean> list = dao.list();
		//设置变量与值
		request.setAttribute("cl", list);
		request.getRequestDispatcher("/Collection.jsp").include(request,
				response);
	}
	protected void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id=request.getParameter("id");
		CollDao dao = new CollDaoImpl();
		CollectionBean bean = dao.get(Integer.valueOf(id));
		//设置变量和值
		request.setAttribute("CollectionBean", bean);
		request.getRequestDispatcher("/CollectionEidt.jsp").include(request,
				response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		CollDao dao = new CollDaoImpl();
		CollectionBean bean =new CollectionBean();
		bean.setId(Integer.valueOf(id));
		bean.setName(name);
		bean.setUrl(url);
		dao.update(bean);
		request.setAttribute("CollectionBean", bean);
		list(request, response);
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String[] ids=request.getParameterValues("ids");
		CollDao dao = new CollDaoImpl();
		dao.delete(ids);
		list(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
