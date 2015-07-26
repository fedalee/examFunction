package com.ui;

import java.util.Scanner;

import com.bean.Student;
import com.dao.StudentDao;
import com.exception.StudentNotFoundException;

public class Main {

	static StudentDao studentDao = new StudentDao();
	public static void main(String[] args) throws StudentNotFoundException {

		System.out.println("�û�����-----------");
		System.out.println("ѧ����Ϣ��ӣ������루a��");
		System.out.println("ѧ����Ϣɾ���������루b��");
		System.out.println("ѧ����Ϣ��ѯ�������루c��");
		
		
		Scanner in = new Scanner(System.in);
		
		String value = in.next();
		
		if(value.equals("a")){
			
			System.out.println("������ѧ�����ţ�");
			String examid = in.next();
			System.out.println("������ѧ��Id�ţ�");
			String idcard = in.next();
			System.out.println("������ѧ��ѧ����");
			String name = in.next();
			System.out.println("������ѧ����ַ��");
			String location = in.next();
			System.out.println("������ѧ���ɼ���");
			double grade = in.nextDouble();
			Student student = new Student();
			student.setExamid(examid);
			student.setGrade(grade);
			student.setIdcard(idcard);
			student.setLocation(location);
			student.setName(name);
			studentDao.add(student);
		}else if(value.equals("b")){
			System.out.println("������ѧ��������");
			String name = in.next();
			studentDao.delete(name);
		}else{
			System.out.println("������ѧ�����ţ�");
			String examid = in.next(); 
			studentDao.find(examid);
		}
	
	}

}
