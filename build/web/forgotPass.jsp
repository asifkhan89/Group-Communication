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
        <div id="tooplate_middle_wrapper1">
            <div id="tooplate_middle_wrapper2">
                <div id="tooplate_middle">
                     <h1>Group Communication</h1> 
                </div>
            </div>
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
                                        <tr><%String msg = (String) request.getAttribute("msg");%>
                                            <td align="center" valign="top"><h3>Login Form</h3>
                                                <form action="<%=request.getContextPath()%>/ForgotPassword" method="post">
                                                <table width="100%" border="0" cellpadding="4" cellspacing="0" bordercolordark="#FFFFFF" class="bodytext">                                                                                                                                                    
                                                    <%if(msg!=null){%>
                                                    <tr>
                                                        <td align="center"><b><%=msg%></b></td>
                                                    </tr> 
                                                    <%}%>
                                                    <tr>
                                                        <td align="center"><b>Enter your First Name</b></td>
                                                        <td align="center"><input type="text" name="fname" placeholder="First Name" required></td>
                                                    </tr>                                                    
                                                    <tr>
                                                        <td align="center"><b>Enter your Last Name</b></td>
                                                        <td align="center"><input type="text" name="lname" placeholder="Last Name" required></td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center"><b>Enter Email ID</b></td>
                                                        <td align="center"><input type="email" name="email" placeholder="Email" required></td>
                                                    </tr>                                            
                                                    <tr>
                                                        <td align="center">&nbsp;</td>
                                                        <td align="center">&nbsp;</td>
                                                    </tr>
                                                </table>
                                                    <input type="submit" name="Submit" value="Submit">
                                                    <input type="reset" name="Reset" value="Clear">
                                                </form>
                                                    <a href="<%=request.getContextPath()%>/login.jsp"><button value="login.jsp">Back</button></a>
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

