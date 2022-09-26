package control;

import com.google.gson.Gson;
import model.DBConnectionCRUD;
import model.Listing;
import model.Review;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/visualizza-reviews")
public class VisualizzaReviews extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        ArrayList<Review> revs= new ArrayList<Review>();


        int id = Integer.parseInt(request.getParameter("id"));//la funzione ajax il parametro di ricerca è idair
        //non funziona con id
        revs = DBConnectionCRUD.retrieveReviews(id);



     /*   Gson g= new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(g.toJson(revs));*/

        request.removeAttribute("cercaReviews");
        request.setAttribute("cercaReviews", revs);


        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/RecensioniView.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void destroy() {
    }
}