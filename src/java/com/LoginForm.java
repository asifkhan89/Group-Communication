/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wsnew.FileTransfer_Service;
//import scs.SCS;
//import scs.SCS_Service;
//import ws.FileTransfer;
//import ws.FileTransfer_Service;

/**
 *
 * @author Rahul
 */
public class LoginForm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        FileTransfer_Service server = new FileTransfer_Service();
//        FileTransfer server = service.getFileTransferPort();
        
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String dob=request.getParameter("dob");
        String mobno=request.getParameter("mobno");
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String pass=request.getParameter("password");
        int groupid=Integer.parseInt(request.getParameter("groupid"));
        boolean result=server.createNewAccount(fname,lname,dob,mobno,gender,email,pass);   
               
        int uid=server.getUID(email,pass);
        
        server.registerKey(uid,fname,lname,email,groupid);
        
        if(result){
            request.setAttribute("msg", "Account Created Sucessfully");
            RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        else{
            

         ArrayList list = (ArrayList) server.groupDetails();
            request.setAttribute("list", list);
            request.setAttribute("msg", "Fail To Account Create Email ID Already Register or Technical Problem");
            RequestDispatcher rd=request.getRequestDispatcher("/createNewAccount.jsp");
            rd.forward(request, response);
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
