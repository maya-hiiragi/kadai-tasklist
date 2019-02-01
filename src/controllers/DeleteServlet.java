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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
            //データゲット
            int id = Integer.valueOf(request.getParameter("id"));
            EntityManager em = DbUtil.getEntityManager();
            Tasks tasks = em.find(Tasks.class, id);

            //データ削除
            em.getTransaction().begin();
            em.remove(tasks);
            em.getTransaction().commit();
            em.close();

            //ページ移動
            response.sendRedirect(request.getContextPath() + "/index");
        }

    }

}
