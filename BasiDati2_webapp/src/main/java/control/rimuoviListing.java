package control;

import model.DBConnectionCRUD;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rimuoviListing")
public class rimuoviListing extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name= (String) request.getParameter("nameAir");

        System.out.println("RIMUOVI LISTING"+name);
        DBConnectionCRUD.deleteListing(name);


        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Success.jsp");
        dispatcher.forward(request, response);

    }

}