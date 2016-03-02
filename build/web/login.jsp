<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Cloud Storage</title> 
        <meta name="keywords" content="" />
        <meta name="description" content="" />
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
            <% String msg = (String) request.getAttribute("msg");

            %>

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
                <form action="<%=request.getContextPath()%>/LoginCheck" method="post">
                    <tr>
                        <td align="left" height="1px" valign="top" bgcolor="#CCCCCC"></td>
                    </tr>
                    <tr>
                        <td align="center" valign="top" bgcolor="#e1e1e1"></td>
                    </tr>
                    <tr>
                        <td height="100" align="center" valign="middle" bgcolor="#e1e1e1"><table width="60%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td height="185" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                                <td width="11%">&nbsp;</td>
                                                <td width="78%">&nbsp;</td>
                                                <td width="11%">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td><img src="images/logimg.png" height="200" width="200" alt="business template" /></td>
                                                <td align="center" valign="top"><table width="100%" border="0" cellpadding="4" cellspacing="0" bordercolordark="#FFFFFF" class="bodytext">

                                                        <% if (msg != null) {%> 
                                                        <tr>
                                                            <td colspan="2" align="center" valign="middle" class="orange_text"><%=msg%></td>

                                                        </tr>
                                                        <%}%>

                                                        <tr>
                                                            <td colspan="2" align="center" valign="middle" class="orange_text">User Login</td>
                                                        </tr>
                                                        <tr>
                                                            <td width="29%" align="left" valign="top" class="black_text"><strong></strong><span class="blue">Email</span></td>
                                                            <td width="71%" align="left" valign="top">
                                                                <span class="normalText">
                                                                    <input name="emailid" type="email" class="textfield" size="25" placeholder="Email" required/>
                                                                </span></td>
                                                        </tr>
                                                        <tr>
                                                            <td align="left" valign="top" class="black_text"><strong></strong><span class="blue">Password</span></td>
                                                            <td align="left" valign="top"><span class="normalText">
                                                                    <input name="password" type="password" class="textfield" size="26" placeholder="Password" required />
                                                                </span></td>
                                                        </tr>
                                                        <tr>
                                                            <td align="left" valign="top" class="black_text"><strong></strong></td>
                                                            <td align="left" valign="top">&nbsp;</td>
                                                        </tr>
                                                        <tr align="center" valign="top">
                                                            <td colspan="2" class="blue">
                                                                <input name="Login" type="submit" class="check_btn" id="Login" value="Login" />
                                                                &nbsp;
                                                                <input name="Cancel" type="reset" class="check_btn" id="Cancel" value="Clear" />
                                                            </td>
                                                        </tr>
                                                        <tr align="center" valign="top">
                                                            <td colspan="2" class="blue">&nbsp;</td>
                                                        </tr>
                                                        <tr align="center" valign="top">
                                                            <td><a href="<%=request.getContextPath()%>/CreateNewAccount">Create New Account</a></td>
                                                            <td><a href="<%=request.getContextPath()%>/forgotPass.jsp">Forgot Password</a></td>
                                                            <td><a href="<%=request.getContextPath()%>/createGroup.jsp">Create New Group</a></td>
                                                        </tr>
                                                    </table></td>
                                                <td>&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                                <td>&nbsp;</td>
                                            </tr>
                                        </table></td>
                                </tr>
                            </table></td>
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
        </form>
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
