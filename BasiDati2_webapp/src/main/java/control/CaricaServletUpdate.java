package control;

import model.DBConnectionCRUD;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet("/carica2-servlet")
public class CaricaServletUpdate extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.removeAttribute("listings");
        request.setAttribute("listings",DBConnectionCRUD.retrieveAllDocument());


        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/Recensioni.jsp");
        dispatcher.forward(request, response);

    }

}