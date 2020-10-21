<%@page import="source.Book" %>
<jsp:useBean id="ob" class="source.Book"/>
 <jsp:setProperty name="ob" property="*"/>
<%	
boolean b=ob.delete();
if(b){
	response.sendRedirect("bookDisplay.jsp");
}
%>