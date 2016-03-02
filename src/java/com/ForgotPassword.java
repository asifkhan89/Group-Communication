/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import wsnew.FileTransfer_Service;


/**
 *
 * @author Rahul
 */
public class ForgotPassword extends HttpServlet {

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
        
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String email=request.getParameter("email");
        System.out.println("fname=>"+fname);
        System.out.println("lname=>"+lname);
        System.out.println("email=>"+email);
        String result=server.sendPasswordOnMail(fname,lname,email);
        
        if(result.equals(""))
        {
            request.setAttribute("msg", "Enter Email-ID is not Register or Name and Email-ID dus not match");
            RequestDispatcher rd=request.getRequestDispatcher("/forgotPass.jsp");
            rd.forward(request, response);
            
        }
        else
        {
            SendMailSSL sm=new SendMailSSL();
            sm.sendmail(email, result);
//            request.setAttribute("msg", "Password send on register Mail ID");
            request.setAttribute("msg", "Password send on register Mail ID "+email);

            RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
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
