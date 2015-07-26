package com.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlUtils {

	private static String filename = "src/exam.xml";
	
	public static Document getDocument() throws ParserConfigurationException, SAXException, IOException{
		
		//�õ�����ʵ��
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		//�õ��ĵ�������
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		return builder.parse(filename);
	}
	
	public static void write2Xml(Document document) throws FileNotFoundException, TransformerException{
		
		//�õ�ת��������
		TransformerFactory factory = TransformerFactory.newInstance();
		//�õ�ת����
		Transformer transformer = factory.newTransformer();
		//��documentд���ļ���ȥ
		transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(filename)));
	}
}
