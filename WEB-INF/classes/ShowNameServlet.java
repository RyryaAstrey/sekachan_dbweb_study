import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/showname")
public class ShowNameServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {
            final String URL = "jdbc:mysql://localhost/sampledb";
            final String USER = "root";
            final String PASS = "pass";
            String sql = "SELECT name FROM student WHERE no = 1";

            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;

            try{
                //①DBに接続
                con = DriverManager.getConnection(URL, USER, PASS);
                //②ステートメントを生成
                stmt = con.createStatement();
                //③SQLを実行
                rs = stmt.executeQuery(sql);
                //④検索結果の処理
                rs.next();
                String name = rs.getString("name");
                req.setAttribute("name", name);
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    //⑤リソースを解放
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                    if(con != null) con.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            //JSPにフォワード
            RequestDispatcher rd = req.getRequestDispatcher("/showname.jsp");
            rd.forward(req, res);
        }

        public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
                doPost(req, res);
            }
}
