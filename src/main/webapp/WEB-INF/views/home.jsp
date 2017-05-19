<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <script type="application/javascript" src="<%=basePath%>/resources/js/jquery-1.8.0.min.js"></script>
      <script type="application/javascript">
          $.ajax({
              url : "http://172.24.62.89:8080/checkChromeForUpdate",
              dataType : "jsonp",
              jsonpCallback : 'jcb',
              success : function(data) {
                  console.log(data.fileName);
              },
              error : function(e) {
                  return false;
              }
          });
          function jcbFun(data) {
          }
      </script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>

</html>
