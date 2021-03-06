package Servlets;

import Models.GraphBundleModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Philipp
 */
@WebServlet(name = "GraphBundleServlet", urlPatterns = {"/GraphBundleServlet"})
public class GraphBundleServlet extends HttpServlet {

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
            throws ServletException, IOException 
    {
        GraphBundleModel graphBundleModelObj = new GraphBundleModel();
        try 
        {
            // Retrieve the attribute that holds all data which was retrieved by the Model from the Database.
            request.setAttribute("graphBundleAttribute", graphBundleModelObj.getJSONObjectList() ); // getUniqueCustomers
            request.setAttribute("fuck", graphBundleModelObj.getUniqueCustomers() );
        } 
        catch (SQLException ex) { Logger.getLogger(testServlet.class.getName()).log(Level.SEVERE, null, ex); }
        
        RequestDispatcher rd = request.getRequestDispatcher("/graphBundleJSP.jsp");
        rd.forward(request, response);
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
      
        // Not currently used.
        RequestDispatcher rd = request.getRequestDispatcher("/graphBundleJSP.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This is GraphBundleServlet.";
    }// </editor-fold>

}
