<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <title>AplicaModificacion-TablaEjercicios-Diego</title>
    </head>
    <body style="color: #fff">
        <div class="cuadro-error-create">
        <%
          Class.forName("com.mysql.jdbc.Driver");
          Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud-diego", "root", "");
          Statement s = conexion.createStatement();
          request.setCharacterEncoding("UTF-8");

          String actualizacion = "UPDATE TablaEjercicio SET "
            + "NomTablaEjercicio='" + request.getParameter("nombre")
            + "', EjerciciosTablaEjercicio='" + request.getParameter("ejercicios")
            + "', DiasTablaEjercicio='" + request.getParameter("dias")
            + "', Dificultad_CodDificultad =" + Integer.valueOf(request.getParameter("intensidad"))
            + " WHERE CodTablaEjercicio=" + Integer.valueOf(request.getParameter("codigo")) + ";";
          
          s.execute(actualizacion);
          
          out.println("La Tabla de ejercicios se ha actualizado correctamente");

          conexion.close();
        %>
        <br>
        <a href="index.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-home"></span> Login</button></a>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>