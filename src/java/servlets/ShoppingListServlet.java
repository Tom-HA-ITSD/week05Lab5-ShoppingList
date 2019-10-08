package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doEverything(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doEverything(request, response);
    }
    
    protected void doEverything(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        
        String action = (String) request.getParameter("action");
        
        ArrayList<String> listItems = (ArrayList) session.getAttribute("listItems");
        
        if (listItems == null){
            listItems = new ArrayList<>();
        }
        
        if (action == null){
            action = "";
        }
        
        switch (action){
            case "logout":
                session.invalidate();
                response.sendRedirect("ShoppingList");
                return;
            case "register":
                String username = request.getParameter("username");
                session.setAttribute("username", username);
                break;
            case "add":
                String item = request.getParameter("newItem");
                listItems.add(item);
                session.setAttribute("listItems", listItems);
                break;
            case "delete":
                String deleteItem = request.getParameter("selectItem");
                listItems.remove(deleteItem);
                session.setAttribute("listItems", listItems);
                break;
        }
        
        if (session.getAttribute("username") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else{
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }
}
