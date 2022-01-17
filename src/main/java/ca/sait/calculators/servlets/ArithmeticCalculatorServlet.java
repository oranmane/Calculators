package ca.sait.calculators.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Calculate two integer values
 * @author Seungjin Moon
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

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
        
        String message = String.format("---");
        request.setAttribute("message", message);
         getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
         
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

        String firstInput = request.getParameter("first");
        String secondInput = request.getParameter("second");
        String message = "";
        
        if (firstInput != null & secondInput != null) {
            try{
                int first = Integer.parseInt(firstInput);
                int second = Integer.parseInt(secondInput);
                String calcNum = "";
                
                if (request.getParameter("addition") != null) {
                    calcNum = Integer.toString(first + second);
                } else if (request.getParameter("subtraction") != null) {
                    calcNum = Integer.toString(first - second);
                } else if (request.getParameter("multiplication") != null) {
                    calcNum = Integer.toString(first * second);
                } else if (request.getParameter("division") != null) {
                    calcNum = Double.toString((first * 1.0) / second);
                }
                
                message = String.format("%s", calcNum);

                request.setAttribute("firstInput", firstInput);
                request.setAttribute("secondInput", secondInput);                
                request.setAttribute("message", message);
                
            } catch (NumberFormatException ex) {
                // Input exists but is not a number.
                message = "invalid";

                request.setAttribute("message", message);
            } 
        } else {
            // Input is missing
            message = "invalid";

            request.setAttribute("message", message);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }
    
}