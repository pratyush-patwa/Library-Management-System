<%@page import="source.Book" %>
<jsp:useBean id="ob" class="source.Book"/>
<jsp:setProperty name="ob" property="*"/>
<%
boolean a=ob.insert();
if(a){
	response.sendRedirect("bookDisplay.jsp");
}
%>