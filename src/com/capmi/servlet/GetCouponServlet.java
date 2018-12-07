package com.capmi.servlet;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capmi.RandomString.RandomString;




public class GetCouponServlet extends HttpServlet{

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

      //      for(String eee:counums){
	        resp.getWriter().write("CouponNumber");
            for(int i=0;i<counums.length;i++){
                String htmlStr = "<table>" +
                        "<tr>"
                       /* + "<td>填写的编号：</td>"*/
                        + "<td>{0}</td></tr>" +                  
                    "</table>";
	        htmlStr = MessageFormat.format(htmlStr,counums[i]);
	        resp.setCharacterEncoding("UTF-8");//设置服务器端以UTF-8编码输出数据到客户端
	        resp.setContentType("text/html;charset=UTF-8");//设置客户端浏览器以UTF-8编码解析数据
	        resp.getWriter().write(htmlStr);//输出htmlStr里面的内容到客户端浏览器显示
            }
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	

}
