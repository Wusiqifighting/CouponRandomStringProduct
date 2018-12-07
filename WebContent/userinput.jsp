<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>优惠券配置信息</title>
<style>
    body{ text-align:center} 
    #divcss5{margin:0 auto; solid #000;width:300px;height:100px} 
 
</style>
<script>
var x;
</script>

</head>
<body>


<p>请输入需要配置的优惠券配置信息</p>
<p>(这里默认是大写数字和数字的组合,且字母中不包含I,O,L，如需自定义优惠券，请到下方自定义优惠券配置)</p>

<div  id="divcss5">
<form  method="post" action="${pageContext.request.contextPath}/GetCouponExportServlet">
优惠券的长度：<input type="number" name="couponlength" required><br>
优惠券的个数：<input type="number" name="couponsum" required><br>
指定优惠券前缀：<input type="text" name="front"><br>
<input type="submit" value="submit" onclick="action='${pageContext.request.contextPath}/GetCouponServlet'">
<input id="x" type="submit" name="x" value="exportvalue" onclick="ck()" >
 <script>
        var ck = function(){
            x = prompt ("输入路径: ", "D://CouponNumber.xls");/*第一个变量为提示语，第二个变量为默认初始值*/
            document.getElementById("x").value=x; 
        }
    </script>
</form>
</div>
<br>
<br>
<br>

<div>
<p>自定义优惠券配置</p>
</div>
<div>
<form action="${pageContext.request.contextPath}/GetCustomCouponServlet" method="post" name="myform">
自定义优惠券的长度：<input type="number" name="cuscouponlength" required><br>
自定义优惠券的个数：<input type="number" name="cuscouponsum" required><br>
自定义指定优惠券前缀：<input type="text" name="cusfront"><br>
自定义优惠券组合类型：
<input type="checkbox" name="inst" value="1" id="ck1">大写字母
<input type="checkbox" name="inst" value="2" id="ck2">小写字母
<input type="checkbox" name="inst" value="3" id="ck3">数字
<br>
优惠券中不包含的数字或字母（多个请以逗号隔开）：<input type="text" name="notcontain"><br>
<%-- <input type="submit" value="submit" onclick="action='${pageContext.request.contextPath}/GetCustomCouponServlet'"> --%>
<input id="z" type="submit" name="z" value="submit" onclick="csubmit(this.form)">
<input id="y" type="submit" name="y" value="exportvalue" onclick="exportex(this.form)" >
</form>

 <script>
        var exportex = function(form){
        	var ck1v = document.getElementById("ck1").checked;
        	var ck2v = document.getElementById("ck2").checked;
        	var ck3v = document.getElementById("ck3").checked;
        	if(ck1v==false&&ck2v==false&&ck3v==false){
         	   alert("请输入优惠券类型！");
         	   return false;
            }
            y = prompt ("输入路径: ", "D://CouponNumber.xls");/*第一个变量为提示语，第二个变量为默认初始值*/
            document.getElementById("y").value=y; 
          //  document.myform.submit();
     		   return true; 
        }
        var csubmit = function(form){
        	var ck1v = document.getElementById("ck1").checked;
        	var ck2v = document.getElementById("ck2").checked;
        	var ck3v = document.getElementById("ck3").checked;
        	if(ck1v==false&&ck2v==false&&ck3v==false){
         	   alert("请输入优惠券类型！");
         	   return false;
            }else{
            //    document.myform.submit();
     		    return true;
            }
        }
        

    </script>

</div>
</body>
</html>