package com.capmi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capmi.RandomString.ExportExcel;
import com.capmi.RandomString.RandomString;

/**
 * 将生成的自定义优惠券导出到excel中
 * @author SIQIWU
 * @since 181205
 *
 */
public class GetCustomCouponExportServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RandomString rs = new RandomString();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			String cuscouponlength = req.getParameter("cuscouponlength");
			String cuscouponsum = req.getParameter("cuscouponsum");
			String cusfront = req.getParameter("cusfront");
			String[] insts = req.getParameterValues("inst");
			String notcontain = req.getParameter("notcontain");
			int cclen = Integer.parseInt(cuscouponlength);
			int ccs = Integer.parseInt(cuscouponsum);
			//判断复选框中的内容
			String a = "";
			 int ins=0;
			 if(insts.length==0){
				 resp.getWriter().write("please input coupon type;");
			 }else{
			 for(int i=0;i<insts.length;i++){
	        	ins = Integer.parseInt(insts[i]);
	        	a+= ins;
	        }
	        if(a.equals("12")){
	        	ins=6;
	        }else if(a.equals("23")){
	        	ins=5;
	        }else if(a.equals("13")){
	        	ins=4;
	        }else if(a.equals("123")){
	        	ins=7;
	        }}                     
			String[] counums = rs.getCusCharAndNumrnum(ccs,cclen,cusfront,ins,notcontain);
			
			String y = req.getParameter("y");
			ExportExcel ee = new ExportExcel();
			ee.createExcel(counums, y);
			resp.setCharacterEncoding("UTF-8");
	        resp.getWriter().write("请到指定路径中查看已导出文件");
	        System.out.println("得到的path是："+y);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
