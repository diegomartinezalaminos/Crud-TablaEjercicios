
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
  <body style="color:#fff">
      <div class="cuadro-error-create">
    <%
      Class.forName("com.mysql.jdbc.Driver");
      Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud-diego","root", "");
      Statement s = conexion.createStatement();
      //En los siguientes delete se borran todas las tablas que fueron creadas por el usuario que queremos borrar juto con si mismo
      //Esto se podria hacer mas limpio mediate un "triger update" y/o "ON CASCADE" 
      s.execute ("DELETE FROM usuario_has_tablaejercicio WHERE Usuario_CodUsuario=" + Integer.valueOf(request.getParameter("codigousuario")) + ";");
      s.execute ("DELETE FROM tablaejercicio WHERE CodTablaEjercicio NOT IN (SELECT TablaEjercicio_CodTablaEjercicio FROM usuario_has_tablaejercicio);");
      s.execute ("DELETE FROM Usuario WHERE CodUsuario=" + Integer.valueOf(request.getParameter("codigousuario")) + " AND CodUsuario <> 2;");
      out.println("El usuario se ha elimindado correctamente");
      s.close();
    %>	
      </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
  </body>
    <!--Bootstrap -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>