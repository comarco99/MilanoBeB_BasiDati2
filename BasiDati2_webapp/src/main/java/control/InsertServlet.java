package control;

import model.DBConnectionCRUD;
import model.Listing;
import model.Review;
import org.json.JSONArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet("/insert-servlet")
public class InsertServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idAir"));
        String nome= request.getParameter("nome");
        String host= request.getParameter("nomeHost");
        String neigh = request.getParameter("quartiere");
        Double prezzo=Double.parseDouble(request.getParameter("prezzoAir"));
        String room= request.getParameter("room");
        Double lat = Double.parseDouble(request.getParameter("latitudine"));
        Double lon = Double.parseDouble(request.getParameter("longitudine"));
        ArrayList<Review> revs= new ArrayList<Review>();

        Listing nuovo = new Listing(id,nome,host,neigh,lat,lon,room,0,prezzo,revs);
        DBConnectionCRUD.insertListing(nuovo);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Success.jsp");
        dispatcher.forward(request, response);

    }

}