package main.java;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class ParseXML {
	DocumentBuilder builder;

	public ParseXML(){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	//creating XML-file
	public void createFile(int id, String teacher, String annotation){
		StringBuilder xmlStringBuilder = new StringBuilder();
		xmlStringBuilder.append("<?xml version='1.0'?>\n<dataset>\n");
		xmlStringBuilder.append("<teacher>"+teacher+"</teacher>\n");
		xmlStringBuilder.append("<annotation>"+annotation+"</annotation>\n");
		xmlStringBuilder.append("</dataset>\n");
		try{
			FileWriter writer = new FileWriter("src/main/xml_storage/"+id+"-info.xml", false);
			writer.write(xmlStringBuilder.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Teacher name getter
	public String getTeacher(int disciplineId) {
		File inputFile = new File("C:/Users/PANNA/Desktop/disciplinesPoliakova/src/main/xml_storage/"+disciplineId+"-info.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		if(doc==null){
			String notProvided= "Not provided";
			return notProvided;	
		}
		NodeList nodes = doc.getElementsByTagName("dataset");
		
		if (nodes.getLength()>0) {
			Node discipline = nodes.item(0);
			NodeList teacherList =  ((Element) discipline).getElementsByTagName("teacher");
			Node teacherFirst = teacherList.item(0);
			String teacherShow =teacherFirst.getTextContent();
			return teacherShow;
		}
		return null;
	}
	
	
	//Annotation getter
	public String getAnnotation(int disciplineId){
		File inputFile = new File("C:/Users/PANNA/Desktop/disciplinesPoliakova/src/main/xml_storage/"+disciplineId+"-info.xml");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		if(doc==null){
			String notProvided= "Not provided";
			return notProvided;	
		}
		else{
		NodeList nodes = doc.getElementsByTagName("dataset");
		if (nodes.getLength()>0) {
			Node discipline = nodes.item(0);
			NodeList annotationList =  ((Element) discipline).getElementsByTagName("annotation");
			Node annotationFirst = annotationList.item(0);
			String annotationShow = ((Element) annotationFirst).getTextContent();
			return annotationShow;
		}
		}
		return null;
	}

}
