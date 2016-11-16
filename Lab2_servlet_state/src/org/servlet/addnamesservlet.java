package org.servlet;

import org.domain.Person;
import org.domain.org.dao.PersonDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.PrivateKey;

/**
 * Created by tara on 11/12/16.
 */
@WebServlet(name = "addnamesservlet", urlPatterns = {"/addnamesservlet"})
public class addnamesservlet extends HttpServlet {

    private PersonDao personDao = new PersonDao();
    private HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = new Person();

        if(request.getParameter("key") != ""
                && request.getParameter("fname") != ""
                && request.getParameter("lname") != ""){

            person.setKey(Integer.parseInt(request.getParameter("key")));
            person.setFirstName(request.getParameter("fname"));
            person.setLastName(request.getParameter("lname"));
            personDao.addPerson(person);

            session = request.getSession(false);
            if(request.getSession() == null){
                session = request.getSession();
            }
            session.setAttribute("persondao", personDao);
            session.setAttribute("personlist", personDao.getAllPerson());

            System.out.println("New Person has been added "+person);
        }else{
            session = request.getSession();
            String errormsg = "Empty Fields!!";
            System.out.println(errormsg);
            session.setAttribute("error", errormsg);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
