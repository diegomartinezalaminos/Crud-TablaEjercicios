
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="estilos.css">
  </head>
  <body style="color: #fff;">
      <div class="cuadro-error-create">
    <%
      Class.forName("com.mysql.jdbc.Driver");
      Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud-diego","root", "");
      Statement s = conexion.createStatement();
      s.execute ("DELETE FROM usuario_has_tablaejercicio WHERE TablaEjercicio_CodTablaEjercicio=" + Integer.valueOf(request.getParameter("codigo")));
      s.execute ("DELETE FROM TablaEjercicio WHERE CodTablaEjercicio=" + Integer.valueOf(request.getParameter("codigo")));
      out.println("La tabla de ejercicios se ha eliminado");
      s.close();
    %>	
      </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
  </body>
</html>