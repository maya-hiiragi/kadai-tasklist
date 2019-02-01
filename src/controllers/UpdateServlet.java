package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbUtil;
import dto.Tasks;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
            //値ゲット
            int id = Integer.valueOf(request.getParameter("id"));
            EntityManager em = DbUtil.getEntityManager();
            Tasks tasks = em.find(Tasks.class, id);

            //値セット
            String content = request.getParameter("content");
            tasks.setContent(content);

            Timestamp ts = new Timestamp(System.currentTimeMillis());
            tasks.setUpdated_at(ts);

            //値更新
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            //ページ移動
            response.sendRedirect(request.getContextPath() + "/show?id=" + id);
        }
    }

}
