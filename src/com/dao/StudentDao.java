package com.dao;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.bean.Student;
import com.exception.StudentNotFoundException;
import com.util.XmlUtils;

public class StudentDao {

	public void add(Student s){
		
		try {
			//得到代理文档
			Document document = XmlUtils.getDocument();
			
			//创建出学生标签
			Element student_tag = document.createElement("student");
			
			//给学生添加属性
			student_tag.setAttribute("idcard", s.getIdcard());
			student_tag.setAttribute("examid", s.getExamid());
			
			//创建出name标签
			Element name_tag = document.createElement("name");
			name_tag.setTextContent(s.getName());
			
			//创建出location标签
			Element location_tag = document.createElement("location");
			location_tag.setTextContent(s.getLocation());
			
			//创建出grade标签
			Element grade_tag = document.createElement("grade");
			grade_tag.setTextContent(s.getGrade()+"");
			
			//添加student的子节点
			student_tag.appendChild(name_tag);
			student_tag.appendChild(location_tag);
			student_tag.appendChild(grade_tag);
			
			//将学生标签挂到文档上
			document.getElementsByTagName("exam").item(0).appendChild(student_tag);
			
			try {
				//更新内存
				XmlUtils.write2Xml(document);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Student find(String examid){
		Student s = new Student();
		try {
			//得到代理文档
			Document document = XmlUtils.getDocument();
			
			NodeList list = document.getElementsByTagName("student");
			for(int index = 0 ; index < list.getLength();index ++){
				//拿到第index个student标签
				Element student_tag = (Element) list.item(index);
				if(student_tag.getAttribute("examid").equals(examid)){
					String idcard = student_tag.getAttribute("idcard");
					String name = student_tag.getChildNodes().item(1).getTextContent();
					String location = student_tag.getChildNodes().item(3).getTextContent();
					String grade = student_tag.getChildNodes().item(5).getTextContent();
					s.setExamid(examid);
					Double grade_double = Double.parseDouble(grade);

					s.setGrade(grade_double);
					s.setIdcard(idcard);
					s.setLocation(location);
					s.setName(name);
					return s;
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(String name) throws StudentNotFoundException{
		
		try {
			//得到代理文档
			Document document = XmlUtils.getDocument();
			
			//拿到name标签
			NodeList nameList = document.getElementsByTagName("name");
			
			for(int i = 0 ; i < nameList.getLength() ; i++){
				Element name_tag = (Element) nameList.item(i);
				String nameText = nameList.item(i).getTextContent();
				if(nameText.equals(name)){
					//得到它的父节点
					Element student_tag = (Element) name_tag.getParentNode();
					/**
					 * <student idcard="111" examid="222">
							<name>张三</name>
							<location>沈阳</location>
							<grade>89</grade>
						</student>
					 * 
					 */
					Element exam_tag = (Element) student_tag.getParentNode();
					exam_tag.removeChild(student_tag);
					try {
						//更新内存
						XmlUtils.write2Xml(document);
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return ;
				}
			}
			new StudentNotFoundException(name + "不存在");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
