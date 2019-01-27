package controllers;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //値ゲット
        EntityManager em = DbUtil.getEntityManager();
        List<Tasks> tasks = em.createNamedQuery("tasksAll", Tasks.class).getResultList();
        em.close();

        //値セット
        request.setAttribute("tasks", tasks);

        //ページ表示
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/content/index.jsp");
        rd.forward(request, response);
    }

}
