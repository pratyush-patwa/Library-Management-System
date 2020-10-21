package source;
import java.sql.*;
import java.util.ArrayList;

public class Student{
	private String name=null;
	private String program=null;
	private String gender = null;
	private String mobile = null;
	private int id;
	//NAME
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//PROGRAM
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	
	//GENDER
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	//MOBILE
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public boolean insert() {
		boolean status=false;
		try{
			Class.forName("com.mysql.jdbc.Driver");		

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();

			String sql = "insert into students( name, program, gender, mobile) values('"+name+"','"+program+"','"+gender+"', '"+mobile+"')"; 
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
	
	
	
	public ArrayList<Student> display(){
		ArrayList<Student>list=new ArrayList<Student>();
		try{
			Class.forName("com.mysql.jdbc.Driver");		

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
			Statement stmt = con.createStatement();

			String sql = "select * from students";
			ResultSet rs= stmt.executeQuery(sql);  
			while(rs.next()){   
				Student ob=new Student();
			
				ob.setId(rs.getInt(1));
				
				ob.setName(rs.getString(2));
				ob.setProgram(rs.getString(3));
				ob.setGender(rs.getString(4));
				ob.setMobile(rs.getString(5));
				list.add(ob);
		
			
			}
			con.close();
		}
			catch(Exception e){
			e.printStackTrace();
			}
		return list;
		}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean delete(){
		boolean status=false;
				try{
					Class.forName("com.mysql.jdbc.Driver");		


					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
					Statement stmt = con.createStatement();
					String sql = "delete from students where id="+id;
					
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