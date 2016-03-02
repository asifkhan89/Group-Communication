package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <title>Cloud Storage</title> \n");
      out.write("        <meta name=\"keywords\" content=\"\" />\n");
      out.write("        <meta name=\"description\" content=\"\" />\n");
      out.write("        <link href=\"tooplate_style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body> \n");
      out.write("        <div id=\"tooplate_middle_wrapper1\">\n");
      out.write("            <div id=\"tooplate_middle_wrapper2\">\n");
      out.write("                <div id=\"tooplate_middle\">\n");
      out.write("                     <h1>Group Communication</h1>                  \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"tooplate_main\">\n");
      out.write("            <!--/****************/-->\n");
      out.write("            ");
 String msg = (String) request.getAttribute("msg");

            
      out.write("\n");
      out.write("\n");
      out.write("            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("                <tr>\n");
      out.write("                    <td align=\"left\" valign=\"top\">\n");
      out.write("                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td width=\"214\" align=\"left\" valign=\"top\">&nbsp;</td>\n");
      out.write("                                <td align=\"left\" valign=\"middle\" ></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <form action=\"");
      out.print(request.getContextPath());
      out.write("/LoginCheck\" method=\"post\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" height=\"1px\" valign=\"top\" bgcolor=\"#CCCCCC\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"center\" valign=\"top\" bgcolor=\"#e1e1e1\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td height=\"100\" align=\"center\" valign=\"middle\" bgcolor=\"#e1e1e1\"><table width=\"60%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td height=\"185\" align=\"left\" valign=\"top\" ><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td width=\"11%\">&nbsp;</td>\n");
      out.write("                                                <td width=\"78%\">&nbsp;</td>\n");
      out.write("                                                <td width=\"11%\">&nbsp;</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td><img src=\"images/logimg.png\" height=\"200\" width=\"200\" alt=\"business template\" /></td>\n");
      out.write("                                                <td align=\"center\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"4\" cellspacing=\"0\" bordercolordark=\"#FFFFFF\" class=\"bodytext\">\n");
      out.write("\n");
      out.write("                                                        ");
 if (msg != null) {
      out.write(" \n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <td colspan=\"2\" align=\"center\" valign=\"middle\" class=\"orange_text\">");
      out.print(msg);
      out.write("</td>\n");
      out.write("\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <td colspan=\"2\" align=\"center\" valign=\"middle\" class=\"orange_text\">User Login</td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <td width=\"29%\" align=\"left\" valign=\"top\" class=\"black_text\"><strong></strong><span class=\"blue\">Email</span></td>\n");
      out.write("                                                            <td width=\"71%\" align=\"left\" valign=\"top\">\n");
      out.write("                                                                <span class=\"normalText\">\n");
      out.write("                                                                    <input name=\"emailid\" type=\"email\" class=\"textfield\" size=\"25\" placeholder=\"Email\" required/>\n");
      out.write("                                                                </span></td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <td align=\"left\" valign=\"top\" class=\"black_text\"><strong></strong><span class=\"blue\">Password</span></td>\n");
      out.write("                                                            <td align=\"left\" valign=\"top\"><span class=\"normalText\">\n");
      out.write("                                                                    <input name=\"password\" type=\"password\" class=\"textfield\" size=\"26\" placeholder=\"Password\" required />\n");
      out.write("                                                                </span></td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        <tr>\n");
      out.write("                                                            <td align=\"left\" valign=\"top\" class=\"black_text\"><strong></strong></td>\n");
      out.write("                                                            <td align=\"left\" valign=\"top\">&nbsp;</td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        <tr align=\"center\" valign=\"top\">\n");
      out.write("                                                            <td colspan=\"2\" class=\"blue\">\n");
      out.write("                                                                <input name=\"Login\" type=\"submit\" class=\"check_btn\" id=\"Login\" value=\"Login\" />\n");
      out.write("                                                                &nbsp;\n");
      out.write("                                                                <input name=\"Cancel\" type=\"reset\" class=\"check_btn\" id=\"Cancel\" value=\"Clear\" />\n");
      out.write("                                                            </td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        <tr align=\"center\" valign=\"top\">\n");
      out.write("                                                            <td colspan=\"2\" class=\"blue\">&nbsp;</td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                        <tr align=\"center\" valign=\"top\">\n");
      out.write("                                                            <td><a href=\"");
      out.print(request.getContextPath());
      out.write("/CreateNewAccount\">Create New Account</a></td>\n");
      out.write("                                                            <td><a href=\"");
      out.print(request.getContextPath());
      out.write("/forgotPass.jsp\">Forgot Password</a></td>\n");
      out.write("                                                            <td><a href=\"");
      out.print(request.getContextPath());
      out.write("/createGroup.jsp\">Create New Group</a></td>\n");
      out.write("                                                        </tr>\n");
      out.write("                                                    </table></td>\n");
      out.write("                                                <td>&nbsp;</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                            <tr>\n");
      out.write("                                                <td>&nbsp;</td>\n");
      out.write("                                                <td>&nbsp;</td>\n");
      out.write("                                                <td>&nbsp;</td>\n");
      out.write("                                            </tr>\n");
      out.write("                                        </table></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" valign=\"top\" bgcolor=\"#e1e1e1\">&nbsp;</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" valign=\"top\" height=\"1px\" bgcolor=\"#e1e1e1\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td height=\"30\" align=\"center\" valign=\"middle\" class=\"white_text_normal\">&nbsp;</td>\n");
      out.write("                    </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        <!--/****************/-->\n");
      out.write("        <div class=\"cleaner\"></div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"cleaner\"></div>  \n");
      out.write("\n");
      out.write("    <div id=\"tooplate_footer_wrapper\">\n");
      out.write("        <div id=\"tooplate_footer\">   \n");
      out.write("            <!--Copyright © 2048 <a href=\"#\">Company Name</a> - Design: <a href=\"http://www.tooplate.com\">tooplate</a> -->  \n");
      out.write("        </div> <!-- end of tooplate_footer -->\n");
      out.write("    </div>    \n");
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
