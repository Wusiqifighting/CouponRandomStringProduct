package com.capmi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capmi.RandomString.ExportExcel;
import com.capmi.RandomString.RandomString;


public class GetCouponExportServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RandomString rs = new RandomString();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    req.setCharacterEncoding("UTF-8");
	        String couponlength = req.getParameter("couponlength");
	        String couponsum = req.getParameter("couponsum");
	        String front = req.getParameter("front");
	        int coulen = Integer.parseInt(couponlength);
	        int cousum = Integer.parseInt(couponsum);
	        String[] counums = rs.getCharAndNumrnum(cousum,coulen,front);
	        String x = req.getParameter("x");
	        ExportExcel ee = new ExportExcel();
	        System.out.println("得到的path是："+x);
					ee.createExcel(counums,x);
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
	        resp.getWriter().write("请到指定路径中查看已导出文件        "+x);
	        System.out.println("得到的path是："+x);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);	
	}

}
