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
		
		//拿到工厂实例
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		//拿到文档解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		return builder.parse(filename);
	}
	
	public static void write2Xml(Document document) throws FileNotFoundException, TransformerException{
		
		//拿到转换器工厂
		TransformerFactory factory = TransformerFactory.newInstance();
		//拿到转换器
		Transformer transformer = factory.newTransformer();
		//将document写到文件中去
		transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(filename)));
	}
}
