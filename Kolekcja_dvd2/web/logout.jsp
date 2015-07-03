<%
getServletContext().setAttribute("Login", null);
session.invalidate();
getServletContext().removeAttribute("upr");
response.sendRedirect("index.jsp");
%>