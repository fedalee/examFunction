package com.jnuit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bean.Student;
import com.dao.StudentDao;
import com.exception.StudentNotFoundException;

public class StudentDaoTest {

	StudentDao studentDao = new StudentDao(); 
	
	@Test
	public void addTest() {
		
		Student student = new Student();
		student.setExamid("43423");
		student.setIdcard("54354");
		student.setName("lihuafeng");
		student.setLocation("harbin");
		student.setGrade(54.0);
		System.out.println(student.getExamid());
		studentDao.add(student);
	}
	
	@Test
	public void findTest(){
		
		Student student = studentDao.find("444");
		
		System.out.println(student.getExamid());
		System.out.println(student.getGrade());
		System.out.println(student.getIdcard());
		System.out.println(student.getLocation());
		System.out.println(student.getName());
		
	}
	
	@Test 
	public void deleteTest() throws StudentNotFoundException{
		studentDao.delete("lihuafeng");
	}

}
