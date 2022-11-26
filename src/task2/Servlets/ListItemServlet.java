package task2.Servlets;

import task2.Class.DBManager;
import task2.Class.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListItemServlet", value = "/home")
public class ListItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Item> items = DBManager.getItemList();
        request.setAttribute("tovary", items);
        request.getRequestDispatcher("/task2_indexes/home.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
