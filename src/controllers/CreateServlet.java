package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbUtil;
import dto.Tasks;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //実行確認
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            //値セット
            Tasks tasks = new Tasks();

            String content = request.getParameter("content");
            tasks.setContent(content);

            //値更新
            EntityManager em = DbUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(tasks);
            em.getTransaction().commit();

            //ページ表示
            response.sendRedirect(request.getContextPath() + "/index");
        }
    }

}
