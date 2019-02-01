package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbUtil;
import dto.Tasks;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //値ゲット
        String _token = request.getSession().getId();
        EntityManager em = DbUtil.getEntityManager();
        Tasks tasks = em.find(Tasks.class, Integer.valueOf(request.getParameter("id")));

        //値セット
        request.setAttribute("_token", _token);
        request.setAttribute("tasks", tasks);

        //ページ表示
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/content/edit.jsp");
        rd.forward(request, response);
    }

}
