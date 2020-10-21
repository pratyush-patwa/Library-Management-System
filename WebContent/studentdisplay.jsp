<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="source.Student" %>
<jsp:useBean id="ob" class="source.Student"/>
<head>
<style>
	body{
	 background-image: url("book.jpg");
	 background-color: #cccccc;
	 width:100%;
	 height:100%;
	}
	
	#up{
	padding:4%;
	height:10%;
	background-color:#FFE4C4;
	}
	
	#down{
	padding:5%;
	margin-top:5%;
	margin-left:15%;
	height:70%;
	width:60%;
	background-color:white;
	}
	
</style>
</head>

<body>
<div id="up">
		<h1 align ="left">Student Details</h1>
		
		<button><a href="home.html">Home</a></button>
		<button><a href="StudentForm.html">Add Student</a></button>
		<button><a href="index.html">Logout</a></button>
</div>
<hr>
<div id="down">
	
	
	<table border="1" width="100%">
	<tr><th>ID</th>
    	<th>Name</th>
    	<th>Program</th>
    	<th>Gender</th>
    	<th>Mobile</th>
    	<th>Action</th>
    </tr>
<%
ArrayList<Student>list=ob.display();
Iterator <Student>itr=list.iterator();
while(itr.hasNext()){
	Student e=itr.next();	
%>

		<tr>
		<td><%= e.getId()%></td>
		<td><%= e.getName() %></td>
		<td><%= e.getProgram() %></td>
		<td><%= e.getGender() %></td>
		<td><%= e.getMobile() %></td>
		<td><a href = "studentDelete.jsp?id=<%=e.getId() %>">DELETE</a></td>
 
		</tr>
	<% 
		}
	%>
	
	</table>
</div>
<hr>
</body>
