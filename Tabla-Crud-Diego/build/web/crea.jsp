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
    <title>CreaTablaEjercicios-diego</title>
  </head>
  <body style="color:white;font-family: 'Luckiest Guy', cursive;">
    <%
      Class.forName("com.mysql.jdbc.Driver");
      Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud-diego","root", "");
      Statement s = conexion.createStatement();
      request.setCharacterEncoding("UTF-8");
      
      // Comprobamos si ya existe el codigo
      String compruebacodigo = "SELECT * FROM TablaEjercicio WHERE CodTablaEjercicio="
                                + Integer.valueOf(request.getParameter("codigo"));
      //ResultSet numerodificultad = s.executeQuery("SELECT CodDificultad FROM Dificultad WHERE TipoDificultad ='" + request.getParameter("dificultad") + "';");
      ResultSet codigotabla = s.executeQuery (compruebacodigo);
      codigotabla.last();
      %>
      <div class="cuadro-error-create">
      <%
      if (codigotabla.getRow() != 0) {
        out.println("Ha ocurrido un erro, no se ha podido crear la tabla, ya existe una tabla con ese código: "
                    + request.getParameter("codigo"));
      } else {
        String insercion = "INSERT INTO TablaEjercicio VALUES (" + Integer.valueOf(request.getParameter("codigo"))
                           + ", '" + request.getParameter("nombre")
                           + "','" + request.getParameter("ejercicios")
                           + "', " + Integer.valueOf(request.getParameter("intensidad"))
                           + ", '" + request.getParameter("dias") + "')";
        s.execute(insercion);
        
        
        conexion.close();
        
        //--------------------------------------------
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud-diego","root", "");
        Statement s2 = conexion2.createStatement();
        request.setCharacterEncoding("UTF-8");
      
        ResultSet codigousuarioforen = s2.executeQuery ("SELECT CodUsuario FROM usuario WHERE NomUsuario = '" + request.getParameter("usuarioconectado") + "'");
        codigousuarioforen.last();
        String insertforen = "INSERT INTO usuario_has_tablaejercicio VALUES (" + codigousuarioforen.getInt("CodUsuario") + ", " + Integer.valueOf(request.getParameter("codigo")) + ");";
        s2.execute(insertforen);
        out.println("La tabla de ejercicios se ha creado correctamente");
        conexion2.close();
        
      }
    %>
    <br><br>
    <a href="index.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-home"></span> Login</a>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>