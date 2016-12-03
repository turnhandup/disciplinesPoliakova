package main.java;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User {
	@Id
	private int id;
    @Column(name = "name")
	private String name;
    @Column(name = "surname")
	private String surname;
	private String role;
	@Column(name="Roles_idRoles")
	private int idRole;
	@Column(name="credits")
	private double credits;
	private ArrayList<String> disciplines;
	
	
	public User(int id, String name, String surname, int idRole, double credits){
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.idRole=idRole;
		this.credits=credits;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getSurname(){
		return surname;
	}
	public void setSurname(String surname){
		this.surname=surname;
	}
	public double getCredits(){
		return credits;
	}
	public void setCredits(double credits){
		this.credits=credits;
	}
	public ArrayList<String> getDisciplines(){
		return disciplines;
	}
	public void setDisciplines(ArrayList<String> disciplines){
		this.disciplines=disciplines;
	}
	public String getRole(){
		return role;
	}
	public void setRole(String role){
		this.role=role;
	}
	public int getIdRole(){
		return idRole;
	}
	public void setIdRole(int idRole){
		this.idRole=idRole;
	}
	
}
