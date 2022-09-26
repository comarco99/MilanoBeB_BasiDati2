package control;

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
import java.util.ArrayList;


@WebServlet("/modificaListing")
public class modificaListing extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idUpdate = Integer.parseInt(request.getParameter("idUpdate"));

        Listing current = DBConnectionCRUD.retrieveById(idUpdate);

        request.removeAttribute("update");
        request.setAttribute("update",current);

        //in current ci sono i vecchi dati del listing che vogliamo modificare
        //devo aprire una nuova pagine con un form precompilato di tutto e fare l'update con eventuali dati cambiati

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ModificaDati.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idAir"));
        String nome= request.getParameter("nome");
        String host= request.getParameter("nomeHost");
        String neigh = request.getParameter("quartiere");
        Double prezzo=Double.parseDouble(request.getParameter("prezzoAir"));
        String room= request.getParameter("room");
        Double lat = Double.parseDouble(request.getParameter("latitudine"));
        Double lon = Double.parseDouble(request.getParameter("longitudine"));

        DBConnectionCRUD.update(id,nome,host,neigh,lat,lon,room,prezzo);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Success.jsp");
        dispatcher.forward(request, response);


    }

}