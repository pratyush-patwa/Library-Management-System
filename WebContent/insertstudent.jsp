<%@page import="source.Student" %>

<jsp:useBean id="ob" class="source.Student"/>
<jsp:setProperty name="ob" property="*"/>
<%
boolean a=ob.insert();
if(a){
	response.sendRedirect("studentdisplay.jsp");
	
}
%>