package task2.Servlets;

import task2.Class.DBManager;
import task2.Class.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DetailsItemServlet", value = "/detail")
public class DetailsItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Item item = DBManager.getItem(id);

        if (item!=null){
            request.setAttribute("item", item);
            request.getRequestDispatcher("/task2_indexes/details.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/task2_indexes/404.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
