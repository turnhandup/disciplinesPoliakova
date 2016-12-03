package main.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class JDBCDisciplineDAO extends ParseXML implements DisciplineDAO {
	 Connection connection = null;
	 
	    public Connection getConnection(){
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            if(connection == null)
	                connection = DriverManager.getConnection("jdbc:mysql://localhost/schedule?useSSL=false", "root", "1212kolya1212");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();  
	        }
	        return connection;
	    }
	    
	public ArrayList<Discipline> getAllDiscipline() throws SQLException {  
		if(connection==null)
					connection=getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM disciplines");
                ArrayList<Discipline> disciplines= new ArrayList<Discipline>();
                ParseXML pxml=new ParseXML();
                while(resultSet.next()){
                	disciplines.add(new Discipline(resultSet.getInt("idDisciplines"), resultSet.getString("name"), resultSet.getDouble("credits"),resultSet.getInt("isRecommended"),pxml.getTeacher(resultSet.getInt("idDisciplines")), pxml.getAnnotation(resultSet.getInt("idDisciplines"))));
                }
                resultSet.close();
                statement.close();
           
		return  disciplines;
	}

	public ArrayList<Discipline> getAllRecommendedDiscipline() throws SQLException {
		if(connection==null)
			connection=getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM disciplines");
        ArrayList<Discipline> disciplines= new ArrayList<Discipline>();
        ParseXML  pxml = new ParseXML();
        while(resultSet.next()){
        	if(resultSet.getInt("isRecommended")==1)
        	disciplines.add(new Discipline(resultSet.getInt("idDisciplines"), resultSet.getString("name"), resultSet.getDouble("credits"),resultSet.getInt("isRecommended"),pxml.getTeacher(resultSet.getInt("idDisciplines")), pxml.getAnnotation(resultSet.getInt("idDisciplines"))));	
        }
        resultSet.close();
        statement.close();
        return  disciplines;
		
	}
	public Discipline getDiscipline(int id) throws SQLException {
		if(connection==null)
			connection=getConnection();
		Statement statement = connection.createStatement();
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet resultSet = statement.executeQuery("SELECT * FROM disciplines where idDisciplines ="+"'"+id+"'");
		Discipline d = new Discipline(0,null ,0, 0,null,null);
		while(resultSet.next()){
			ParseXML pxml=new ParseXML();
		    d.setName(resultSet.getString("name"));
		    d.setCredits(resultSet.getDouble("credits"));
		    d.setIsRecommended(resultSet.getInt("isRecommended"));
		    d.setTeacher(pxml.getTeacher(resultSet.getInt("idDisciplines")));
		    d.setAnnotation(pxml.getAnnotation(resultSet.getInt("idDisciplines")));
		}
		return d;
	}

	public void updateDiscipline(Discipline discipline) {
		
		
	}


	public void deleteDiscipline(Discipline discipline) throws SQLException {
		if(connection==null)
			connection=getConnection();
		Statement statement = connection.createStatement();
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet resultSet = statement.executeQuery("SELECT *  FROM disciplines where idDisciplines ="+"'"+discipline.getId()+"'");
		if(resultSet.next())
		resultSet.deleteRow();
	
	}
	public void closeConnection(){
        try {
              if (connection != null) {
                  connection.close();
              }
            } catch (Exception e) { 
                //do nothing
            }
    }

}
