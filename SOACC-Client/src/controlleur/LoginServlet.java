package controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.LoginImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private LoginImpl loginImpl; 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.loginImpl = daoFactory.getLoginDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		if(loginImpl.login(username, password)) {
			session.setAttribute("user", username);
			this.getServletContext().getRequestDispatcher("/WEB-INF/EspaceGardes/VerifierInfo.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Username or password est incorrect");
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
