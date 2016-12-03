<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="main.java.ParseXML, main.java.Discipline, java.util.ArrayList, main.java.JDBCDisciplineDAO, java.sql.DriverManager,java.sql.ResultSet,java.sql.Connection,java.sql.Statement" %>
<%@ page import="com.mysql.jdbc.Driver" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!---METADATA--->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale = 1.0">
	<meta name="description" content="Great resource which will help you to find your best sport team to play with" />
	<title>Disciplines.com</title> 
    
    <!---FONTS--->
	<link href='http://fonts.googleapis.com/css?family=Roboto:300,400' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Playfair+Display|Roboto+Condensed|Ubuntu+Condensed" rel="stylesheet">
    
    <!---CSS--->
     <link rel="stylesheet" href="./css/guestLogged.css">

    <!--JAVASCRIPT-->
    <script type="text/javascript" src="js/jquery.1.10.2.min.js"></script>
    <script type="text/javascript" src="js/guestLogged.js"></script>
    
    <!--BOOTSTRAP-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    <!--LESS-->
    <!-- LESS JavaScript ÐºÐ¾Ð¼Ð¿ÑÐ»ÑÑÐ¾Ñ -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/less.js/2.5.3/less.min.js"></script>
    
</head>
<body>
<section>
<div id="demo">
<h1>Disciplines table</h1>
 <h2>You are in a guest mode, to see more please log in</h2>
<button class="button1" id="allDiscipline" onclick="toggleTable();"> All</button>
<button class="button2" id="recommendedDiscipline" onclick="toggleTable2();" >Recommended</button>
<div class="table-responsive-vertical shadow-z-1">
<div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Name</th>
          <th>Credits</th>
          <th>Teacher</th>
          <th>Annotation</th>
          <th>Students</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content1">
<table id="1" cellpadding="0" cellspacing="0" border="0"    >
    <%
	JDBCDisciplineDAO d=new JDBCDisciplineDAO();
	ArrayList<Discipline> dcpl = d.getAllDiscipline();
	%>
  <tbody>
   
	<%        for(int i=0; i<dcpl.size(); i++){%>
               <tr>
                      <td>
                   	      <%= dcpl.get(i).getName() %>
                   	 </td>    
                   	 <td>
                   	     <%= dcpl.get(i).getCredits() %>
                   	 </td>
                   	 <td>
                   	 	<%= dcpl.get(i).getTeacher()%>
                   	 </td>
                   	 <td>
                   	 	<%= dcpl.get(i).getAnnotation() %>
                   	 </td>
                   	 <td></td>
              </tr>
            <%}%>
            
            </tbody>
</table>
</div>
<div class="tbl-content2">
<table id="2" style="display:none; cellpadding="0" cellspacing="0" border="0"">
    <%
   
	JDBCDisciplineDAO d2=new JDBCDisciplineDAO();
	
	ArrayList<Discipline> dcpl2 = d.getAllRecommendedDiscipline();
	%>
	
  <tbody>
	<%    
        for(int k=0; k<dcpl2.size(); k++){%>
                <tr>
                      <td>
                   	      <%= dcpl2.get(k).getName() %>
                   	 </td>
                           
                   	 <td>
                   	     <%= dcpl2.get(k).getCredits() %>
                   	 </td>
                   	  <td>
                   	 	<%= dcpl.get(k).getTeacher()%>
                   	 </td>
                   	 <td>
                   	 	<%= dcpl.get(k).getAnnotation()%>
                   	 </td>
                   	 <td></td>
                   	
                </tr>
            <%}%>

            </tbody>
</table>
</div>
</div>
</section>
</body>
</html>