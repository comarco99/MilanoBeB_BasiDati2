package control;

import com.google.gson.Gson;
import model.DBConnectionCRUD;
import model.Listing;
import model.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet("/near-duomo")
public class NearDuomo extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ArrayList<Listing> listing = DBConnectionCRUD.retrieveNearDuomo((String)request.getParameter("place"));

        Gson g= new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(g.toJson(listing));

    }

    public void destroy() {
    }
}