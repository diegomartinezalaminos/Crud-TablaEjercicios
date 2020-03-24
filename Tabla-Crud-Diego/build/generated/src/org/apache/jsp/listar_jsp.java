package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class listar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    \n");
      out.write("    <!-- Bootstrap -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" integrity=\"sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r\" crossorigin=\"anonymous\">\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    <title>Crud-Diego-Listar</title>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("      <div class=\"container\" >\n");
      out.write("          <br><br>\t\t\t\n");
      out.write("          <div class=\"panel panel-primary\">\n");
      out.write("              <div class=\"panel-heading text-center\"><h2>TABLA EJERCICIOS</h2></div>\n");
      out.write("              ");

                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud-diego", "root", "");
                Statement s = conexion.createStatement();
                ResultSet listado = s.executeQuery("SELECT CodTablaEjercicio, NomTablaEjercicio, EjerciciosTablaEjercicio, TipoDificultad, DiasTablaEjercicio FROM TablaEjercicio INNER JOIN Dificultad ON Dificultad_CodDificultad = CodDificultad WHERE CodTablaEjercicio IN (SELECT TablaEjercicio_CodTablaEjercicio FROM usuario_has_tablaejercicio WHERE Usuario_CodUsuario = (SELECT CodUsuario FROM usuario WHERE NomUsuario = '" + request.getParameter("usuarioiniciado") + "'));");
              
      out.write("\n");
      out.write("\n");
      out.write("              <table class=\"table table-striped\">\n");
      out.write("                  <tr><th>CODIGO</th><th>NOMBRE</th><th>EJERCICIOS</th><th>INTENSIDAD</th><th>DIA</th></tr>\n");
      out.write("                  <form method=\"get\" action=\"crea.jsp\">\n");
      out.write("                      <tr><td><input type=\"text\" name=\"codigo\" size=\"2\"></td>\n");
      out.write("                          <td><input type=\"text\" name=\"nombre\" size=\"20\"></td>\n");
      out.write("                          <td><input type=\"text\" name=\"ejercicios\" size=\"50\"></td>\n");
      out.write("                          <td>    \n");
      out.write("                      <select class=\"form-control\" style=\"width: 200px;\">\n");
      out.write("                          <option value = \"-1\">Dificultad</option>\n");
      out.write("                          ");

                            try {
                              String Query = "select * from Dificultad";
                              Class.forName("com.mysql.jdbc.Driver");
                              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud-diego", "root", "");
                              Statement stm = conn.createStatement();
                              ResultSet rs = stm.executeQuery(Query);
                              while (rs.next()) {

                          
      out.write("\n");
      out.write("                          <option name=\"intensidad\" value=\"");
      out.print(rs.getInt("CodDificultad"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("TipoDificultad"));
      out.write("</option>\n");
      out.write("                          ");


                              }

                            } catch (Exception ex) {
                              ex.printStackTrace();
                              out.println("Error " + ex.getMessage());
                            }


                          
      out.write("\n");
      out.write("                      </select>\n");
      out.write("                          </td>\n");
      out.write("                          <td><input type=\"text\" name=\"dia\" size=\"20\"></td>\n");
      out.write("                          <td><button type=\"submit\" value=\"Añadir\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-plus\"></span> Añadir</button></td><td></td></tr>           \n");
      out.write("                  </form>\n");
      out.write("                  ");

                    while (listado.next()) {
                      out.println("<tr><td>");
                      out.println(listado.getString("CodTablaEjercicio") + "</td>");
                      out.println("<td>" + listado.getString("NomTablaEjercicio") + "</td>");
                      out.println("<td>" + listado.getString("EjerciciosTablaEjercicio") + "</td>");
                      out.println("<td>" + listado.getString("TipoDificultad") + "</td>");
                      out.println("<td>" + listado.getString("DiasTablaEjercicio") + "</td>");
                  
      out.write("\n");
      out.write("                  <td>\n");
      out.write("                      <form method=\"get\" action=\"modifica.jsp\">\n");
      out.write("                          <input type=\"hidden\" name=\"codigo\" value=\"");
      out.print(listado.getString("CodTablaEjercicio"));
      out.write("\">\n");
      out.write("                          <input type=\"hidden\" name=\"nombre\" value=\"");
      out.print(listado.getString("NomTablaEjercicio"));
      out.write("\">\n");
      out.write("                          <input type=\"hidden\" name=\"ejercicios\" value=\"");
      out.print(listado.getString("EjerciciosTablaEjercicio"));
      out.write("\">\n");
      out.write("                          <input type=\"hidden\" name=\"dificultad\" value=\"");
      out.print(listado.getString("TipoDificultad"));
      out.write("\">\n");
      out.write("                          <input type=\"hidden\" name=\"dias\" value=\"");
      out.print(listado.getString("DiasTablaEjercicio"));
      out.write("\">\n");
      out.write("                          <button type=\"submit\"  class=\"btn btn-info\" hrf=\"modifica.jsp?usuariooline=");
      out.print(request.getParameter("usuarioiniciado"));
      out.write("\"><span class=\"glyphicon glyphicon-pencil\"></span> Modificar</button>\n");
      out.write("                      </form>\n");
      out.write("                  </td>\n");
      out.write("                  <td>\n");
      out.write("                      <form method=\"get\" action=\"borra.jsp\">\n");
      out.write("                          <input type=\"hidden\" name=\"codigo\" value=\"");
      out.print(listado.getString("CodTablaEjercicio"));
      out.write("\"/>\n");
      out.write("                          <button type=\"submit\" class=\"btn btn-danger\"><span class=\"glyphicon glyphicon-remove\"></span> Eliminar</button>\n");
      out.write("                      </form>\n");
      out.write("                  </td></tr>\n");
      out.write("                  ");

                    } // while   
                    conexion.close();
                  
      out.write("\n");
      out.write("\n");
      out.write("              </table>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <!--Bootstrap -->\n");
      out.write("      <script src=\"js/jquery.min.js\"></script>\n");
      out.write("      <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
