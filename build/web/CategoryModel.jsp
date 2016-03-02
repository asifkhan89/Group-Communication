<%@ taglib uri="/WEB-INF/taglib280.tld" prefix="a" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>File Upload</title>


<script>

function uploadFile(filesPath, newValue)
{
   
var i=filesPath.lastIndexOf("\\");
var newText=filesPath.substring(i+1,filesPath.length);


window.opener.document.getElementById('fileField').value=newText;
window.close();
}

</script>

</head>


<a:AjaxUpload name="upload" action="UploadCategory.jsp" afterAction="uploadFile(document.upload.file.value,document.upload.file.value)">  
    
<body>
<table width="100%" border="1">
  <tr>
    <td colspan="2" align="right"><input type="file" name="file" /></td>
    <td width="11%"><input name="Submit" type="submit" id="Submit" value="Upload" /></td>
    <td width="34%">&nbsp;</td>
  </tr>
 </table>
</a:AjaxUpload> 
<table>
 <tr>
 <script>
//load();
</script>
 </tr>
  </table>
  </body>
</html>
