/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import AES.CryptoException;
import AES.CryptoUtils;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wsnew.FileTransfer_Service;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
//import scs.SCS;
//import scs.SCS_Service;

/**
 *
 * @author Rahul
 */
public class DownloadFile extends HttpServlet {

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
        String fid = (String) request.getParameter("fid");

        HttpSession sess = request.getSession(false);
        String uname = (String) sess.getAttribute("uname");
        String uid = (String) sess.getAttribute("uid");
        String emailid = (String) sess.getAttribute("emailid");

        System.out.println("uname--=>" + uname);
        System.out.println("uid--=>" + uid);
        System.out.println("emailid--=>" + emailid);

        FileTransfer_Service server = new FileTransfer_Service();

        ServletContext context = request.getServletContext();//get split receved folder path
        String ecfilepath = context.getRealPath("/enc");

        ServletContext context2 = request.getServletContext();//get split receved folder path
        String dcfilepath = context2.getRealPath("/dec");

        ArrayList list = (ArrayList) server.downloadFile(fid);
        String filename = (String) list.get(0);
        
        File inputFile =new File(ecfilepath+File.separator+filename);
        File outputFile=new File(dcfilepath+File.separator+filename);
        
        
        String key = server.getKey(uid, uname, emailid);
        // DownloadFile f=new DownloadFile();
        CryptoUtils aes = new CryptoUtils();
        try {
            aes.decrypt(key, inputFile, outputFile);
        } catch (CryptoException ex) {
            Logger.getLogger(DownloadFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        FileInputStream fis;
        byte[] fileBytes = null;
        ServletContext contextF = request.getServletContext();//get split receved folder path
        String mfolderpath = contextF.getRealPath("/dec");
        File file = new File(mfolderpath + File.separator + filename);
        fis = new FileInputStream(file);
        fileBytes = new byte[(int) file.length()];
        fis.read(fileBytes, 0, (int) file.length());
        fis.close();

        //String filename=(String) list.get(0);    
        String value = "attachment;filename=\"" + URLEncoder.encode(filename, "UTF-8") + '"';
        response.setHeader("Content-Disposition", value);
        response.getOutputStream().write(fileBytes);
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
