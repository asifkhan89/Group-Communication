<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Business Website Template</title> 
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link href="tooplate_style.css" rel="stylesheet" type="text/css" />
    </head>
    <body> 
        <%String msg = (String) request.getAttribute("resmsg");%>
        <div id="tooplate_middle_wrapper1">
            <div id="tooplate_middle_wrapper2">
                <div id="tooplate_middle">
                     <h1>Group Communication</h1>  
                </div>
            </div>
        </div>
        <div>
            <table width="80%">
                <tr>
                    <td align="right">Welcome <%=session.getAttribute("uname")%><a href="<%=request.getContextPath()%>/Logout">&nbsp;Logout</a></td>
                </tr>
            </table>
        </div>
        <div id="tooplate_main">
            <!--/****************/-->
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="left" valign="top">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td width="214" align="left" valign="top">&nbsp;</td>
                                <td align="left" valign="middle" ></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td align="left" height="1px" valign="top" bgcolor="#CCCCCC"></td>
                </tr>
                <tr>
                    <td align="center" valign="top" bgcolor="#e1e1e1"></td>
                </tr>
                <tr>
                    <td height="100" align="center" valign="middle" bgcolor="#e1e1e1">
                        <table width="60%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td height="185" align="left" valign="top" >
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/Home">Home</a>
                                            </td>
                                            <td>
                                                <a href="<%=request.getContextPath()%>/uploadFile.jsp">Upload File</a>
                                            </td>
                                        </tr>
                                        <tr> 
                                            <td align="center" valign="top"><h3>Deleted File List</h3>
                                                <table width="100%" border="0" cellpadding="4" cellspacing="0" bordercolordark="#FFFFFF" class="bodytext">                                                                                                                                                    
                                                    <tr>
                                                        <td align="center"><b>File Name</b></td>
                                                        <td align="center"><b>Undo</b></td>
                                                    </tr>
                                                    <%ArrayList list=(ArrayList)request.getAttribute("filelist");
                                                    for(int i=0;i<list.size();i++){
                                                    %>
                                                    <tr>
                                                        <td align="center"><%=list.get(i)%></td>
                                                        <td align="center"><a href="<%=request.getContextPath()%>/Undo?fid=<%=list.get(++i)%>">Undo</a></td>
                                                    </tr>
                                                    <%++i;++i;}%>
                                                </table>
                                            </td>
                                            <td>&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td>
                                        </tr>
                                    </table>                                        
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td align="left" valign="top" bgcolor="#e1e1e1">&nbsp;</td>
                </tr>
                <tr>
                    <td align="left" valign="top" height="1px" bgcolor="#e1e1e1"></td>
                </tr>
                <tr>
                    <td height="30" align="center" valign="middle" class="white_text_normal">&nbsp;</td>
                </tr>
            </table>
            <!--/****************/-->
            <div class="cleaner"></div>
        </div>

        <div class="cleaner"></div>  

        <div id="tooplate_footer_wrapper">
            <div id="tooplate_footer">   
                <!--Copyright © 2048 <a href="#">Company Name</a> - Design: <a href="http://www.tooplate.com">tooplate</a> -->  
            </div> <!-- end of tooplate_footer -->
        </div>    
    </body>
</html>

