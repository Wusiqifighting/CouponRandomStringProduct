package com.capmi.servlet;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capmi.RandomString.ExportExcel;
import com.capmi.RandomString.RandomString;

public class GetCustomCouponServlet extends HttpServlet{

	/**
	 * 实现自定义优惠券配置
	 * @author SIQIWU
	 * @since 20181203
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RandomString rs = new RandomString();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("跳转到servlet了");
		 String y = req.getParameter("y");
		 String z = req.getParameter("z");
		 System.out.println("z:"+z+"y:"+y);
		 
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
		 System.out.println("insts数组："+insts);
		 if(insts==null){
			 resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html;charset=UTF-8");
			 resp.getWriter().write("请先输入优惠券的类型呦！！！");
			 return;
		 }
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
        }                     
		String[] counums = rs.getCusCharAndNumrnum(ccs,cclen,cusfront,ins,notcontain);

		  
/*		 String y = req.getParameter("y");
		 String z = req.getParameter("z");
		 System.out.println("z:"+z+"y:"+y);*/
		
		  if(z!=null&&!z.equals("")){
	      resp.getWriter().write("CouponNumber");
          for(int i=0;i<counums.length;i++){
              String htmlStr = "<table>" +
                      "<tr>"
          /*            + "<td>填写的编号：</td>"*/
                      + "<td>{0}</td></tr>" +                  
                  "</table>";
              
	        htmlStr = MessageFormat.format(htmlStr,counums[i]);
	        resp.setCharacterEncoding("UTF-8");//设置服务器端以UTF-8编码输出数据到客户端
	        resp.setContentType("text/html;charset=UTF-8");//设置客户端浏览器以UTF-8编码解析数据
	        resp.getWriter().write(htmlStr);//输出htmlStr里面的内容到客户端浏览器显示	        
          }}else if(y!=null&&!y.equals("")){
			ExportExcel ee = new ExportExcel();
			ee.createExcel(counums, y);
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
	        resp.getWriter().write("请到指定路径中查看已导出文件      "+y);
	        System.out.println("得到的path是："+y);}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);	
    }

}
