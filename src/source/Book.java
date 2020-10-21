package source;
import java.sql.*;
import java.util.ArrayList;

public class Book{
	private String id= null;
	private String name=null;
	private String program =null;
	
	
	//ISBN
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	
	//NAME
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Program
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	
	
	public boolean insert() {
		boolean status=false;
		try{
			Class.forName("com.mysql.jdbc.Driver");		

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();

			String sql = "insert into book(id, name, program) values('"+id+"','"+name+"','"+program+"')"; 
			int i = stmt.executeUpdate(sql);
			if(i>0){
			
			status=true;
			}
			con.close();

			}
			catch(Exception e){
			e.printStackTrace();
			}
		return status;
	}
	
	
	
	public ArrayList<Book> display(){
		ArrayList<Book>list=new ArrayList<Book>();
		try{
			Class.forName("com.mysql.jdbc.Driver");		

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();

			String sql = "select * from book";
			ResultSet rs= stmt.executeQuery(sql);  
			while(rs.next()){   
				Book ob=new Book();
				ob.setId(rs.getString(1));
				
				ob.setName(rs.getString(2));
				ob.setProgram(rs.getString(3));	
				list.add(ob);
			}
			con.close();
		}
			catch(Exception e){
			e.printStackTrace();
			}
		return list;
		}
	
	public boolean delete(){
		boolean status=false;
				try{
					Class.forName("com.mysql.jdbc.Driver");		
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");

					Statement stmt = con.createStatement();

					String sql = "delete from book where id= "+id;
					
					int i = stmt.executeUpdate(sql);
					
					if(i>0){
					 status=true;
					}
					con.close();	
					}
					catch(Exception e){
					e.printStackTrace();

					}
				return status;
					
	}
}