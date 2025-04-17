package practice;

import java.util.Collection;
import java.util.Scanner;

import example.jdbc.Department;
import example.jdbc.DepartmentDao;
import example.jdbc.JdbcDao;

public class StudentCrudExampleMain {
	
	private static void showAllStudents()
	{
		StudentJdbcDao<Student,Integer> dao=new studentDao();
		Collection<Student> studList=dao.getAll();
		for(Student std : studList)
			System.out.println(std);
		
	}
	private static void showOneStudent()
	{
		StudentJdbcDao<Student,Integer> dao=new studentDao();
		Student stud=dao.getOne(10);
		if(stud != null)
			System.out.println(stud);
		else
			System.out.println("Student WIth Given Roll NO does not Exist.");
	}
	private static void addStudent()
	{
		
			StudentJdbcDao<Student, Integer> dao=new studentDao();
			Student stud=new Student(50, "Samanta", "Pune");
			dao.add(stud);
					
		
	}
	
	

	public static void main(String[] args) {
		//showAllStudents();
		//showOneStudent();
		//addStudent();	
		Scanner sc= new Scanner(System.in);
		boolean exit=true;
		while(exit) {
			System.out.println("--------------Menu-----------"
					+ "\n1.SHOW ALL STUDENTS"
					+ "\n2.SHOW ONE STUDENT"
					+ "\n3. ADD STUDENT"
					+ "\n ENTER CHOICE ");
			int ch=sc.nextInt();
			switch (ch) {
			case 1: {
				System.out.println("Showing All Details of Students");
				showAllStudents();
				
				break;
			}case 2: {
				System.out.println("Showing  Details of One Student");
				
				showOneStudent();
				
				break;
			}case 3: {
				System.out.println("Student Has Been Added");
				addStudent();
				
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
			
		}

	}
	

}
