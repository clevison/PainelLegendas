package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"viewport\"    content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\t<meta name=\"description\" content=\"\">\n");
      out.write("\t<meta name=\"author\"      content=\"Sergey Pozhilov (GetTemplate.com)\">\n");
      out.write("\t\n");
      out.write("\t<title>Equipes cadastradas</title>\n");
      out.write("\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/images/gt_favicon.png\">\n");
      out.write("\t<link rel=\"stylesheet\" media=\"screen\" href=\"http://fonts.googleapis.com/css?family=Open+Sans:300,400,700\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/css/bootstrap.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/css/font-awesome.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/css/bootstrap-theme.css\" media=\"screen\" >\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/css/main.css\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/css/mycss.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"home\" id=\"container\">\n");
      out.write("\n");
      out.write("\t<!-- Modal to create team -->\n");
      out.write("\t<div class=\"modal fade\" id=\"createTeamModal\" role=\"dialog\" tabindex=\"-1\">\n");
      out.write("\t\t<div class=\"modal-dialog modal-sm\">\n");
      out.write("\t\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\">Criar equipe</h4>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t\t<p><input type=\"text\" class=\"myInput\" placeholder=\"Nome da equipe\"></p>\n");
      out.write("\t\t\t\t\t\t<p><textarea class=\"myInput\" placeholder=\"Mensagem\" rows=\"5\"></textarea></p>\n");
      out.write("\t\t\t\t\t\t<br />\n");
      out.write("\t\t\t\t\t\t<p><input type=\"submit\" class=\"btn btn-success\" value=\"Enviar\"></p>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- /Modal to create team -->\n");
      out.write("\n");
      out.write("\t<!-- Modal to edit profile -->\n");
      out.write("\t<div class=\"modal fade\" id=\"editProfileModal\" role=\"dialog\" tabindex=\"-1\">\n");
      out.write("\t\t<div class=\"modal-dialog modal-sm\">\n");
      out.write("\t\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\">Editar perfil</h4>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t\t<p><input type=\"text\" class=\"myInput\" placeholder=\"Novo nome de usuário\" value=\"{nickname}\"></p>\n");
      out.write("\t\t\t\t\t\t<p><input type=\"email\" class=\"myInput\" placeholder=\"Novo e-mail\" value=\"{email}\"></p>\n");
      out.write("\t\t\t\t\t\t<p><input type=\"password\" class=\"myInput\" placeholder=\"Nova senha\" value=\"{senha}\"></p>\n");
      out.write("\t\t\t\t\t\t<br />\n");
      out.write("\t\t\t\t\t\t<p><input type=\"submit\" class=\"btn btn-success\" value=\"Salvar\"></p>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- /Modal to edit profile -->\n");
      out.write("\t\n");
      out.write("\t<!-- Modal to request entry -->\n");
      out.write("\t<div class=\"modal fade\" id=\"requestModal\" role=\"dialog\" tabindex=\"-1\">\n");
      out.write("\t\t<div class=\"modal-dialog modal-sm\">\n");
      out.write("\t\t\t<div class=\"modal-content\">\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\">Solicitar entrada</h4>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\n");
      out.write("\t\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t\t<p><textarea class=\"myInput\" placeholder=\"Mensagem\" rows=\"5\"></textarea></p>\n");
      out.write("\t\t\t\t\t\t<br />\n");
      out.write("\t\t\t\t\t\t<p><input type=\"submit\" class=\"btn btn-success\" value=\"Enviar\"></p>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- /Modal to request entry -->\n");
      out.write("\n");
      out.write("\t<!-- Fixed navbar -->\n");
      out.write("\t<div class=\"navbar navbar-inverse navbar-fixed-top\" >\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t\t<!-- Button for smallest screens -->\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\"><span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> </button>\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"index.jsp\"><img src=\"resources/images/logo.png\" alt=\"Progressus HTML5 template\"></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!-- <div class=\"navbar-collapse collapse\">\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav pull-right\">\n");
      out.write("\t\t\t\t\t<li><a class=\"btn\" data-toggle=\"modal\" data-target=\"#createTeamModal\">CRIAR EQUIPE</a></li>\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\">\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Olá, {nickname}<b class=\"caret\"></b></a>\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\" data-toggle=\"modal\" data-target=\"#editProfileModal\">Editar perfil</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"logout.jsp\">Sair</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>/.nav-collapse -->\n");
      out.write("\t\t</div>\n");
      out.write("\t</div> \n");
      out.write("\t<!-- /.navbar -->\n");
      out.write("\n");
      out.write("\t<!-- Main -->\n");
      out.write("\t<main id=\"main\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"portfolio\">\n");
      out.write("\t\t\t\t<div class=\"team\">\n");
      out.write("\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t<h1>Equipe</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<img class=\"image\" src=\"https://www.outsystems.com/PortalTheme/img/UserImage.png?24752\">\n");
      out.write("\t\t\t\t\t<a data-toggle=\"modal\" data-target=\"#requestModal\" class=\"button\">Solicitar entrada</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"team\">\n");
      out.write("\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t<h1>Equipe</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<img class=\"image\" src=\"https://www.outsystems.com/PortalTheme/img/UserImage.png?24752\">\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"button\">Acessar</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"team\">\n");
      out.write("\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t<h1>Equipe</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<img class=\"image\" src=\"https://www.outsystems.com/PortalTheme/img/UserImage.png?24752\">\n");
      out.write("\t\t\t\t\t<a data-toggle=\"modal\" data-target=\"#requestModal\" class=\"button\">Solicitar entrada</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"team\">\n");
      out.write("\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t<h1>Equipe</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<img class=\"image\" src=\"https://www.outsystems.com/PortalTheme/img/UserImage.png?24752\">\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"button\">Acessar</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"team\">\n");
      out.write("\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t<h1>Equipe</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<img class=\"image\" src=\"https://www.outsystems.com/PortalTheme/img/UserImage.png?24752\">\n");
      out.write("\t\t\t\t\t<a data-toggle=\"modal\" data-target=\"#requestModal\" class=\"button\">Solicitar entrada</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"team\">\n");
      out.write("\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t<h1>Equipe</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<img class=\"image\" src=\"https://www.outsystems.com/PortalTheme/img/UserImage.png?24752\">\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"button\">Acessar</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"team\">\n");
      out.write("\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t<h1>Equipe</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<img class=\"image\" src=\"https://www.outsystems.com/PortalTheme/img/UserImage.png?24752\">\n");
      out.write("\t\t\t\t\t<a data-toggle=\"modal\" data-target=\"#requestModal\" class=\"button\">Solicitar entrada</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"team\">\n");
      out.write("\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t<h1>Equipe</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<img class=\"image\" src=\"https://www.outsystems.com/PortalTheme/img/UserImage.png?24752\">\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"button\">Acessar</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"team\">\n");
      out.write("\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t<h1>Equipe</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<img class=\"image\" src=\"https://www.outsystems.com/PortalTheme/img/UserImage.png?24752\">\n");
      out.write("\t\t\t\t\t<a data-toggle=\"modal\" data-target=\"#requestModal\" class=\"button\">Solicitar entrada</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<div class=\"team\">\n");
      out.write("\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t<h1>Equipe</h1>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<img class=\"image\" src=\"https://www.outsystems.com/PortalTheme/img/UserImage.png?24752\">\n");
      out.write("\t\t\t\t\t<a href=\"#\" class=\"button\">Acessar</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</main>\n");
      out.write("\t<!-- /Main -->\n");
      out.write("\t\n");
      out.write("\t<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\n");
      out.write("\t<script src=\"http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/headroom.min.js\"></script>\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/jQuery.headroom.min.js\"></script>\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/template.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
