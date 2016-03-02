package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CategoryModel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/taglib280.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_a_AjaxUpload_name_afterAction_action;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_a_AjaxUpload_name_afterAction_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_a_AjaxUpload_name_afterAction_action.release();
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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title>File Upload</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("function uploadFile(filesPath, newValue)\r\n");
      out.write("{\r\n");
      out.write("   \r\n");
      out.write("var i=filesPath.lastIndexOf(\"\\\\\");\r\n");
      out.write("var newText=filesPath.substring(i+1,filesPath.length);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("window.opener.document.getElementById('fileField').value=newText;\r\n");
      out.write("window.close();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_a_AjaxUpload_0(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("<table>\r\n");
      out.write(" <tr>\r\n");
      out.write(" <script>\r\n");
      out.write("//load();\r\n");
      out.write("</script>\r\n");
      out.write(" </tr>\r\n");
      out.write("  </table>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_a_AjaxUpload_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  a:AjaxUpload
    com.cj.ajax.AjaxUploadTag _jspx_th_a_AjaxUpload_0 = (com.cj.ajax.AjaxUploadTag) _jspx_tagPool_a_AjaxUpload_name_afterAction_action.get(com.cj.ajax.AjaxUploadTag.class);
    _jspx_th_a_AjaxUpload_0.setPageContext(_jspx_page_context);
    _jspx_th_a_AjaxUpload_0.setParent(null);
    _jspx_th_a_AjaxUpload_0.setName("upload");
    _jspx_th_a_AjaxUpload_0.setAction("UploadCategory.jsp");
    _jspx_th_a_AjaxUpload_0.setAfterAction("uploadFile(document.upload.file.value,document.upload.file.value)");
    int _jspx_eval_a_AjaxUpload_0 = _jspx_th_a_AjaxUpload_0.doStartTag();
    if (_jspx_eval_a_AjaxUpload_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_a_AjaxUpload_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_a_AjaxUpload_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_a_AjaxUpload_0.doInitBody();
      }
      do {
        out.write("  \r\n");
        out.write("    \r\n");
        out.write("<body>\r\n");
        out.write("<table width=\"100%\" border=\"1\">\r\n");
        out.write("  <tr>\r\n");
        out.write("    <td colspan=\"2\" align=\"right\"><input type=\"file\" name=\"file\" /></td>\r\n");
        out.write("    <td width=\"11%\"><input name=\"Submit\" type=\"submit\" id=\"Submit\" value=\"Upload\" /></td>\r\n");
        out.write("    <td width=\"34%\">&nbsp;</td>\r\n");
        out.write("  </tr>\r\n");
        out.write(" </table>\r\n");
        int evalDoAfterBody = _jspx_th_a_AjaxUpload_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_a_AjaxUpload_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_a_AjaxUpload_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_a_AjaxUpload_name_afterAction_action.reuse(_jspx_th_a_AjaxUpload_0);
      return true;
    }
    _jspx_tagPool_a_AjaxUpload_name_afterAction_action.reuse(_jspx_th_a_AjaxUpload_0);
    return false;
  }
}
