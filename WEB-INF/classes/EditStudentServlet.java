import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import bean.StudentDTO;

@WebServlet("/showStudents")
public class EditStudentServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {
            String msg = "生徒全員の情報を表示します";
            //入力値（btn）を取得
            req.setCharacterEncoding("utf-8");
            String btn = req.getParameter("btn");
            //StudentDAOオブジェクトを生成
            StudentDAO3 sdao = new StudentDAO3();
            //押下ボタンによる分岐処理
            if(btn.equals("追加")) {
                int no = Integer.parseInt(req.getParameter("no"));
                String name = req.getParameter("name");
                int score = Integer.ParseInt(req.getParameter("score"));
                sdao.insert(no, name, score);
                　　　　　　
            }
}
