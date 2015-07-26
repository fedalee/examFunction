package com.ui;

import java.util.Scanner;

import com.bean.Student;
import com.dao.StudentDao;
import com.exception.StudentNotFoundException;

public class Main {

	static StudentDao studentDao = new StudentDao();
	public static void main(String[] args) throws StudentNotFoundException {

		System.out.println("用户操作-----------");
		System.out.println("学生信息添加，请输入（a）");
		System.out.println("学生信息删除，请输入（b）");
		System.out.println("学生信息查询，请输入（c）");
		
		
		Scanner in = new Scanner(System.in);
		
		String value = in.next();
		
		if(value.equals("a")){
			
			System.out.println("请输入学生考号：");
			String examid = in.next();
			System.out.println("请输入学生Id号：");
			String idcard = in.next();
			System.out.println("请输入学生学名：");
			String name = in.next();
			System.out.println("请输入学生地址：");
			String location = in.next();
			System.out.println("请输入学生成绩：");
			double grade = in.nextDouble();
			Student student = new Student();
			student.setExamid(examid);
			student.setGrade(grade);
			student.setIdcard(idcard);
			student.setLocation(location);
			student.setName(name);
			studentDao.add(student);
		}else if(value.equals("b")){
			System.out.println("请输入学生姓名：");
			String name = in.next();
			studentDao.delete(name);
		}else{
			System.out.println("请输入学生考号：");
			String examid = in.next(); 
			studentDao.find(examid);
		}
	
	}

}
