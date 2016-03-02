<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Cloud Upload</title> 
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link href="tooplate_style.css" rel="stylesheet" type="text/css" />
        <script>
            showProductModel = function () {
                //for productname
                height = 200;
                width = 350;
                //var newWin = window.open('<%=request.getContextPath()%>
                var newWin = window.open('<%=request.getContextPath()%>/CategoryModel.jsp', 'newWin', 'left=' + (screen.width - width) / 2 + ',top=' + (screen.height - height) / 2 + ',height=' + height + ',width=' + width + ',toolbar=false,menubar=false');
            }
        </script>
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
                                        </tr>
                                        <tr>
                                            <td>
                                                &nbsp;
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="left">
                                                <table width="100%" border="0" cellpadding="4" cellspacing="0" bordercolordark="#FFFFFF" class="bodytext">
                                                    <% if (msg != null) {%> 
                                                    <tr>
                                                        <td colspan="2" align="center" valign="middle" class="orange_text"><%=msg%></td>
                                                    </tr>
                                                    <%}%>
                                                    <tr>
                                                    <form id="UploadForm" action="<%=request.getContextPath()%>/UploadFile" method="post">
                                                        Share file <input type="radio" name="share" value="true"/>&nbsp;&nbsp;
                                                        Don't Share <input type="radio" name="share" value="flase"/>&nbsp;&nbsp;<br>
                                                        <input name="fileField" type="text"  id="fileField" size="25"  readonly />

                                                        <input type="Button" name="uploadbtn" value="Choose File" id=upbtn onclick="showProductModel();"/>
                                                        <input type="submit" name="submit" value="Upload"/>
                                                    </form>
                                        </tr>                                                       
                                        <tr>
                                            <td align="left" valign="top" class="black_text"><strong></strong></td>
                                            <td align="left" valign="top">&nbsp;</td>
                                        </tr>
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
