package org.servlet;

import org.domain.org.dao.PersonDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "removenameservlet", urlPatterns = {"/removenameservlet"})
public class removenameservlet extends HttpServlet {
    PersonDao personDao;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if(request.getParameter("personkey") != "") {
            if (request.getSession() == null) {
                session = request.getSession();
            }
            if (session.getAttribute("persondao") != null) {
                personDao = (PersonDao) session.getAttribute("persondao");
                int key = Integer.parseInt(request.getParameter("personkey"));
                System.out.println(key);
                personDao.deletePerson(key);
                session.setAttribute("personlist", personDao.getAllPerson());
            } else {
                session.setAttribute("personlist", null);
            }
        }else{
            session = request.getSession();
            String errormsg = "Key is empty!";
            System.out.println(errormsg);
            session.setAttribute("errorremmsg", errormsg);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
