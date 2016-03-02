<%@ page import="java.io.*,java.util.*,org.apache.commons.fileupload.*, org.apache.commons.fileupload.servlet.*, org.apache.commons.fileupload.disk.*,org.apache.commons.io.*" %>
<%@page pageEncoding="UTF-8"%>
<%@page contentType="text/html" import="java.util.Date.*" %>
<%@page contentType="text/html" import="java.text.SimpleDateFormat" %>
<%@page contentType="text/html" import="java.text.DateFormat" %>
<html>
    <head>
        <title>Upload File</title>
    </head>
    
    <body>
    <%
    	DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
       
        
         
            String FileName,path;
   
                        ServletFileUpload sfu = new ServletFileUpload();
                        boolean isMultipart = sfu.isMultipartContent(request);
                        if (isMultipart == true) {
                     int size = 9087549;
                            
                       String projectPath= getServletContext().getRealPath("/uploadfiles");
                     
                            System.out.println("projectPath="+projectPath);
                            String strDirectoy = projectPath;   
                            System.out.println("strDirectoy="+strDirectoy);
                            File tempPath = new File(strDirectoy);
                            DiskFileItemFactory factory = new DiskFileItemFactory(size, tempPath);
                            ServletFileUpload upload = new ServletFileUpload(factory);
              
                            upload.setSizeMax(size);
                            try {
                    
                                java.util.List fileItems = upload.parseRequest(request);
                   
                                Iterator iter = fileItems.iterator();
                                System.out.println("iter =" + iter);
                                FileItem item = (FileItem) iter.next();
                                if (item.getSize() <= (long) size) {
                                     FileName = item.getName();
            
                                    path = strDirectoy + "/";
            
                                    FileName = FilenameUtils.getName(FileName);
             
                                    String formato = FilenameUtils.getExtension(FileName);
                                   
           
                                    FileUtils fileUtils = new FileUtils();
                                    File UploadedFile = new File(path + FileName);
                                    File Path = new File(path);
                                    fileUtils.forceMkdir(Path);
                                 System.out.println("path=" + path);
                                    UploadedFile.createNewFile();
                                    if (UploadedFile.canWrite() == true) {
                                        item.write(UploadedFile);
                                        //System.out.println("item=" + item);
   
    
        System.out.println("upload file");
       
    %>

                   success fully uploaded


        <%
        } else {

        %>


        <% }} 
       else
       {%>
        <% }}
         catch (Exception exc)
         {
              exc.printStackTrace();

          }
         }
                            
        %>
        
         
        
       
    </body>
</html> 