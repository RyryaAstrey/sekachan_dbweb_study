import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import bean.StudentDTO;

@WebServlet("/showStudents")
public class ShowStudentsServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {
            //DAOオブジェクトを生成
            StudentDAO2 sdao = new StudentDAO2();
            //全件検索した結果をDTOオブジェクトとして取得
            StudentDTO sdto = sdao.select();
            //検索結果をリクエストスコープに格納
            req.setAttribute("sdto", sdto);
            //JSPにフォワード
            RequestDispatcher rd = req.getRequestDispatcher("/showstudents.jsp");
            rd.forward(req, res);
        }

        public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
                doPost(req, res);
            }
}
