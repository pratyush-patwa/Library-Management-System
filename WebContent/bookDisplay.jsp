<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="source.Book" %>
<jsp:useBean id="ob" class="source.Book"/>

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
	height:100%;
	width:60%;
	background-color:white;
	}
	
</style>
</head>

<body>
<div id="up">
		<h1 align ="left">Books Details</h1>
		
		<button><a href="home.html">Home</a></button>
		<button><a href="BookForm.html">Add Books</a></button>
		<button><a href="IssueBook.jsp">Issue Book</a></button>
		<button><a href="ReturnBook.jsp">Return Book</a></button>
		<button><a href="index.html">Logout</a></button>
		
</div>
<hr>

<div id="down">

	<table border="1" width=100%>
	<tr><th>Book ID</th>
    	<th>Name</th>
    	<th>Program</th>
    	<th>Action</th>
    </tr>
<%
ArrayList<Book>list=ob.display();
Iterator <Book>itr=list.iterator();
while(itr.hasNext()){
	Book e=itr.next();	
%>

		<tr>
		<td><%= e.getId()%></td>
		<td><%= e.getName() %></td>
		<td><%= e.getProgram() %></td>
		<td><a href = "bookDelete.jsp?id=<%=e.getId() %>">DELETE</a></td>
 
		</tr>
	<% 
		}
	%>
	
	</table>
</div>
<hr>
</body>
