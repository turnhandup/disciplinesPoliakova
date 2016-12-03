package main.java;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface DisciplineDAO {
	   public ArrayList<Discipline> getAllDiscipline() throws SQLException;
	   public ArrayList<Discipline> getAllRecommendedDiscipline() throws SQLException, SAXException, IOException, ParserConfigurationException;
	   public Discipline getDiscipline(int id) throws SQLException;
	   public void updateDiscipline(Discipline discipline);
	   public void deleteDiscipline(Discipline discipline) throws SQLException;
}

