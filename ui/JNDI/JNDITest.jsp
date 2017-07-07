<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*" %>
<%
  try
  {
   //初始化查找命名空间
   Context ctx = new InitialContext(); 
   //InitialContext ctx = new InitialContext();亦可 
   //找到DataSource,对名称进行定位java:comp/env是必须加的,后面跟你的DataSource名
   DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/test");
   //取出连接
   Connection conn = ds.getConnection();
System.out.println("connection pool connected !!");   
  } catch (NamingException e) {
   System.out.println(e.getMessage());
  } catch (SQLException e) {
   e.printStackTrace();
  }

%>