package control;

import model.DBConnectionCRUD;
import model.Listing;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


import com.google.gson.Gson;
import model.Review;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet("/visualizza-servlet")
public class VisualizzaServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String azione=(String) request.getParameter("azione"); //fa capire quale query eseguire

        ArrayList<Listing> listing = new ArrayList<Listing>();

        if(azione.equals("byZona")){
            String criterio = (String) request.getParameter("criterio");//la funzione ajax il parametro di ricerca è zona
            listing = DBConnectionCRUD.retrieveByNeighbourhood(criterio);
        }
        if(azione.equals("byRev")){
            int min = Integer.parseInt(request.getParameter("min"));//la funzione ajax il parametro di ricerca è min
            int max = Integer.parseInt(request.getParameter("max"));//la funzione ajax il parametro di ricerca è max
            listing = DBConnectionCRUD.retrieveByNumbersOfReviews(min,max);
        }
        if(azione.equals("byPrice")){
            int min = Integer.parseInt(request.getParameter("min"));//la funzione ajax il parametro di ricerca è min
            int max = Integer.parseInt(request.getParameter("max"));//la funzione ajax il parametro di ricerca è max
            listing = DBConnectionCRUD.retrieveByPrice(min,max);
        }
        if(azione.equals("byRoom")){
            String room = (String) request.getParameter("room");//la funzione ajax il parametro di ricerca è room
            listing = DBConnectionCRUD.retrieveByRoomType(room);
        }
        if(azione.equals("byAll")){
            String zona = (String) request.getParameter("zona");
            int minR = Integer.parseInt(request.getParameter("minR"));
            int maxR = Integer.parseInt(request.getParameter("maxR"));
            int minP = Integer.parseInt(request.getParameter("minP"));
            int maxP = Integer.parseInt(request.getParameter("maxP"));
            String room = (String) request.getParameter("room");

            listing = DBConnectionCRUD.retrieveByAllFilters(zona, minR, maxR, minP, maxP, room);
        }

        Gson g= new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(g.toJson(listing));

    }

    public void destroy() {
    }
}