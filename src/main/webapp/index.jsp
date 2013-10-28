<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.synerzip.training.UserService"%>
<%@page import="com.synerzip.training.User"%>
<%@page import="java.util.*"%>
<html>
<body>
 <h2>Users List</h2>
 <table>
  <tr>
   <td>ID</td>
   <td>Name</td>
   <td>Email</td>
  </tr>
  <%
      UserService us = new UserService();
      List<User> users = us.getUsers();
      for (User user : users)
      {
  %>
  <tr>
   <td><%=user.getId()%></td>
   <td><%=user.getName()%></td>
   <td><%=user.getEmail()%></td>
  </tr>
  <%
      }
  %>
 </table>
</body>
</html>
