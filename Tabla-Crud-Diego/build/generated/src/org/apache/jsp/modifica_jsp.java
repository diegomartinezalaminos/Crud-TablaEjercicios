package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class modifica_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" integrity=\"sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"estilos.css\">\n");
      out.write("        \n");
      out.write("        <title>Modifica-TablaEjercicio-diego</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 request.setCharacterEncoding("UTF-8");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <br><br>\n");
      out.write("            <div class=\"panel panel-redondeado\">\n");
      out.write("                <div class=\"panel-heading text-center panel-color\" style=\"padding-top: 25px;padding-bottom: 25px\">MODIFICACION TABLA DE EJERCICIOS</div>\n");
      out.write("                <br><br>\n");
      out.write("                <div style=\"padding-left: 20px;\">\n");
      out.write("                    <form method=\"get\" action=\"aplicamodificacion.jsp\" >\n");
      out.write("                        <div class=\"form-group\"> \n");
      out.write("                            <label style=\"padding-right: 10px;\">CÓDIGO: </label><input type=\"text\" size=\"3\" name=\"codigo\" value=\"");
      out.print( request.getParameter("codigo"));
      out.write("\" readonly>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label style=\"padding-right: 10px;\">Nombre: </label><input type=\"text\" size=\"20\" name=\"nombre\" value=\"");
      out.print( request.getParameter("nombre"));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label style=\"padding-right: 10px;\">Ejercicios: </label><input type=\"text\" size=\"40\" name=\"ejercicios\" value=\"");
      out.print( request.getParameter("ejercicios"));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\" >\n");
      out.write("                          <label style=\"padding-right: 10px;\">Dificultad: </label>  \n");
      out.write("                          <select>\n");
      out.write("                          <option value = \"-1\">Dificultad</option>\n");
      out.write("                          ");

                            try {
                              String Query = "select * from Dificultad";
                              Class.forName("com.mysql.jdbc.Driver");
                              Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud-diego", "root", "");
                              Statement stm = conexion.createStatement();
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
                              conexion.close();

                            } catch (Exception ex) {
                              ex.printStackTrace();
                              out.println("Error " + ex.getMessage());
                            }
                            
                          
      out.write("\n");
      out.write("                          </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label style=\"padding-right: 10px;\">Día: </label><input type=\"text\" name=\"dias\" size=\"20\" value=\"");
      out.print( request.getParameter("dias"));
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <hr>\n");
      out.write("                        <a href=\"acceso.jsp\" class=\"color-boton btn\"><span class=\"glyphicon glyphicon-remove\"></span>Cancelar</a>\n");
      out.write("                        <button type=\"submit\" class=\"color-boton btn\"><span class=\"glyphicon glyphicon-ok\"></span>Aceptar</button><br><br>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--bootstrap-->\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
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
