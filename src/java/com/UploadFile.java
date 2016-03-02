/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import AES.CryptoUtils;
import com.SHA.GenHashhh;
import db.DBLayer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import wsnew.FileTransfer_Service;

/**
 *
 *
 */
public class UploadFile extends HttpServlet {

    String resmsg = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ffffpath = request.getParameter("fileField");
        String ffpath = getServletContext().getRealPath("/uploadfiles");
        System.out.println("ffpath:" + ffpath);
        String fpath = ffpath + File.separator + ffffpath;
        System.out.println("fpath:" + fpath);
        String share = request.getParameter("share");
        HttpSession sess = request.getSession(false);
        String uname = (String) sess.getAttribute("uname");
        String uid = (String) sess.getAttribute("uid");
        String emailid = (String) sess.getAttribute("emailid");

        System.out.println("uname--=>" + uname);
        System.out.println("uid--=>" + uid);
        System.out.println("emailid--=>" + emailid);

        FileTransfer_Service server1 = new FileTransfer_Service();

        String key = server1.getKey(uid, uname, emailid);

        System.out.println("Key-->" + key);

        ServletContext econtext = request.getServletContext();
        String efilepath = econtext.getRealPath("/enc");


        File filename = new File(fpath);
        /**
         * **********Encrypt file*************
         */
        //  UploadFile f=new UploadFile();
        encryptfile(fpath, efilepath, key);
        /**
         * ***********************
         */
        String fnamepath = efilepath + File.separator + filename.getName();

        System.out.println("file Path for Encypted:" + fnamepath);
        resmsg = filesend(fnamepath, fpath, uid, share, key);
        System.out.println("exicution end");
        request.setAttribute("resmsg", resmsg);
        RequestDispatcher rd = request.getRequestDispatcher("Home");
        rd.forward(request, response);
    }

    public String filesend(String filepath, String origpath, String uid, String share, String key) throws ServletException, IOException {
        String resmsg = null;
        boolean result = false;
        int s = 0;
        FileTransfer_Service server = new FileTransfer_Service();

        System.out.println("filepath in file send-->" + filepath);
        File file = new File(filepath);
        if (share.equals("true")) {
            s = 1;
        } else if (share.equals("flase")) {
            s = 0;
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fis);
            byte[] filebytes = new byte[(int) file.length()];
            inputStream.read(filebytes);
            System.out.println("file name using file.getName()-->" + file.getName() + " filebytes=" + filebytes);
            if (filebytes.length > 0) {
                int min = server.getMinMaxID();
                GenHashhh gh = new GenHashhh();
                String hash = gh.sha1(file);
                String filename = file.getName();
                String foldername = UUID.randomUUID().toString();
                int sharevalue = s;
                String sharedetails = server.checkHash(hash);//link                
                
                    long start = System.currentTimeMillis();
                    result = server.uploadtodb(file.getName(), uid, hash,
                            start, String.valueOf(filebytes.length), String.valueOf(filebytes.length),
                            s, Integer.parseInt(sharedetails));
                    if (result == true) {
                        resmsg = "File send successfully";
                    } else {
                        resmsg = "Problem occured while file sending";
                    }
                    long stop = System.currentTimeMillis();
                    double fileuploadtime = (double) (stop - start) / 1000;
                    System.out.println("File Upload Time ->" + fileuploadtime + " sec");
                    System.out.println("File Size -> " + filebytes.length + " bytes");
                    System.out.println("We Save -> " + filebytes.length + " bytes Size on Cloud");
                    System.out.println("Similar File Found on Cloud");
                
            } else {
                resmsg = "File size is zero can not upload file";
            }
            inputStream.close();
            System.out.println("File uploaded: " + origpath);

        } catch (IOException ex) {
            resmsg = "Problem occured while file sending";
            ex.printStackTrace();
            System.err.println(ex);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resmsg;
    }

    public void encryptfile(String ifilepath, String ofilepath, String key) {
        File ifile = new File(ifilepath);
        File ofile = new File(ofilepath + File.separator + ifile.getName());
        try {
            /**
             * *********************
             */
            String deletefile = ofilepath + File.separator;
            File f1 = new File(deletefile);
            if (f1.exists()) {
//            
            } else {
                f1.mkdirs();
            }
            /**
             * *********************
             */
            System.out.println("Start Encryption");
            CryptoUtils aes = new CryptoUtils();
            int ii = aes.encrypt(key, ifile, ofile);
            System.out.println("End Encryption:" + ii + "  :" + key);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteDir(File f) {
        if (f.exists()) {
            File[] listFiles = f.listFiles();
            for (int j = 0; j < listFiles.length; j++) {
                File ff = listFiles[j];
                System.out.println("Deleted Direcrory -->" + ff);
                ff.delete();
            }
            f.delete();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
