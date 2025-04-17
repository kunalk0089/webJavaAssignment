package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.Department;
import example.jdbc.JdbcDao;
import example.jdbc.jdbcUtils;

public class studentDao implements StudentJdbcDao<Student,Integer>
{

	@Override
	public Collection<Student> getAll() {
		Collection<Student> allStudents= new ArrayList<Student>();
		try(
				
				Connection dbConnection= StudentUtils.buildConnection();
				Statement stmt= dbConnection.createStatement();
				ResultSet rs=stmt.executeQuery("select * from stud");
	
				){
			while(rs.next()) {
				int rollNo=rs.getInt(1);
				String name=rs.getString(2);
				String city=rs.getString(3);
				Student std=new Student(rollNo, name, city);
				allStudents.add(std);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return allStudents;
	}

	@Override
	public Student getOne(Integer rollNo) {
		Student foundStudent=null;
		String sqlQuery="select * from stud where rollNo =?";
		try(
				Connection dbConnection = StudentUtils.buildConnection();
				PreparedStatement pstmt= dbConnection.prepareStatement(sqlQuery);
				) {
			pstmt.setInt(1, rollNo);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				int RollNo=rs.getInt(1);
				String name=rs.getString(2);
				String city=rs.getString(3);
				foundStudent=new Student (RollNo,name,city);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return foundStudent;
	}

	@Override
	public void add(Student Stud) {
		String sqlQuery="insert into stud values(?,?,?)";
		try (
				Connection dbConnection = StudentUtils.buildConnection();
				PreparedStatement pstmt= dbConnection.prepareStatement(sqlQuery);
				){
			int rollNo=Stud.getRollNo();
			String name=Stud.getName();
			String city= Stud.getCity();
			
			
			pstmt.setInt(1, rollNo);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			
			int updateCount=pstmt.executeUpdate();
			System.out.println(updateCount +" Record Inserted");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void update(Student Stud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer rollNo) {
		// TODO Auto-generated method stub
		
	}
	

}
