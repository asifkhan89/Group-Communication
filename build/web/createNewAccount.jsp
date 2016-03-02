<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Cloud Storage</title> 
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link href="tooplate_style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
         <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        
      <script language="Javascript" type="text/javascript">

function validateForm()
    {
       
        var dob = document.getElementById("datepicker").value;
       
        var now = new Date();
        var birthdate = dob.split("/");
        var born = new Date(birthdate[2], birthdate[0]-1, birthdate[1]);
        age=get_age(born,now);
        if (age<18)
        {
            alert("You need to be 18 years of age");
            return false;
        }
        submitFlag = true;
     if(document.getElementById("password").value.length<6){
        submitFlag=false;
        alert("Invalid length - 6 characters needed!");
    }
    return submitFlag;

    }

    function get_age(born, now) {
      var birthday = new Date(now.getFullYear(), born.getMonth(), born.getDate());
      if (now >= birthday) 
        return now.getFullYear() - born.getFullYear();
      else
        return now.getFullYear() - born.getFullYear() - 1;
    }




        function onlyAlphabets(e, t) {
            try {
                if (window.event) {
                    var charCode = window.event.keyCode;
                }
                else if (e) {
                    var charCode = e.which;
                }
                else { return true; }
                if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))
                    return true;
                else
                    return false;
            }
            catch (err) {
                alert(err.Description);
            }
        }

    </script>  
        
        
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
                                                <form  action="<%=request.getContextPath()%>/LoginForm"  onsubmit="return validateForm()" method="post">
                                                <table width="100%" border="0" cellpadding="4" cellspacing="0" bordercolordark="#FFFFFF" class="bodytext">                                                                                                                                                    
                                                    <%if(msg!=null){%>
                                                    <tr>
                                                        <td align="center"><b><%=msg%></b></td>
                                                    </tr> 
                                                    <%}%>
                                                    <tr>
                                                        <td align="center"><b>First Name</b></td>
                                                        <td align="center"><input type="text" name="fname" onkeypress="return onlyAlphabets(event,this);" placeholder="First Name" required></td>
                                                    </tr>                                                    
                                                    <tr>
                                                        <td align="center"><b>Last Name</b></td>
                                                        <td align="center"><input type="text" name="lname" onkeypress="return onlyAlphabets(event,this);" placeholder="Last Name" required></td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center"><b>Date of Birth</b></td>
                                                        <td align="center"><input type="text" name="dob" id="datepicker" placeholder="Calender" required></td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center"><b>Mobile No</b></td>
                                                        <td align="center"><input type="text" name="mobno" maxlength="10" placeholder="Mobile No" pattern="[1-9][0-9]{9}" required></td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center"><b>Gender</b></td>
                                                        <td align="center">
                                                            <input type="radio" name="gender" value="Male" required>Male&nbsp;&nbsp;
                                                            <input type="radio" name="gender" value="Female" required>Female
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center"><b>Select Group</b></td>
                                                        <td align="center">
                                                            <select name="groupid" id="groupid" required>
                                                                <option value="" selected >select </option>
                                                                <% ArrayList list=(ArrayList)request.getAttribute("list");
                                                                    if (list != null) {
                                                                        for (int i = 0; i < list.size(); i++) {%>
                                                                        <option value="<%=list.get(i)%>" > <%=list.get(++i)%> </option>
                                                                         
                                                                <%}}%>
                                                            </select>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center"><b>Email</b></td>
                                                        <td align="center"><input type="email" name="email" placeholder="Email" required></td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center"><b>Password</b></td>
                                                        <td align="center"><input type="password" name="password" id ="password" placeholder="Password" required></td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center">&nbsp;</td>
                                                        <td align="center">&nbsp;</td>
                                                    </tr>
                                                </table>
                                                    <input type="submit" name="Submit" value="Submit" />
                                                    <input type="reset" name="Reset" value="Clear" />
                                                    
                                                    <!--<input type="button" name="Back" value="Back" />-->
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
    <script>
  $(function(){
//alert("hello");
    $( "#datepicker" ).datepicker();
  });
  </script>
</html>
