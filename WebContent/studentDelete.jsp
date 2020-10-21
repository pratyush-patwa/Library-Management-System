
<%@page import="source.Student" %>
<jsp:useBean id="ob" class="source.Student"/>
<jsp:setProperty name="ob" property="*"/>
<%	
boolean b=ob.delete();
if(b){
	response.sendRedirect("studentdisplay.jsp");
}
%>