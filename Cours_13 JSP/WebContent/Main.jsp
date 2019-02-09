<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>JSP Page</title>
	</head>
	<body>
	
    <%! 
       //String nom = "Ayoub"; 
    %>
	<%
	   /*
	   out.println("Bonjour " + nom);
	   Date date = new Date();
	   out.println("<br> on est le " + date.toString());
	   */
	   String nom = request.getParameter("txtNom");
	   out.println("Bonjour : " + nom);
	   
	%>
	   <form  action="Main.jsp" method="POST">
           Votre Nom: <input type="text" name="txtNom" /><br/>
           <input type="submit" value="envoyer">
       </form>
	</body>
</html>