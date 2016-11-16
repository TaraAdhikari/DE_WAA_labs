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

/**
 * Created by tara on 11/13/16.
 */
@WebServlet(name = "allnameservlet", urlPatterns = {"/allnameservlet"})
public class allnameservlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(request.getSession() == null){
            session = request.getSession();
        }

        if(session.getAttribute("persondao") != null){
            PersonDao personDao = (PersonDao) session.getAttribute("persondao");
            session.setAttribute("personlist", personDao.getAllPerson());
        }else{
            session.setAttribute("personlist", null);
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/allperson.jsp");
        requestDispatcher.forward(request, response);
    }
}
