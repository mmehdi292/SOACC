package controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.GestionEtudiantsDao;

/**
 * Servlet implementation class GestionEtudiantServlet
 */
public class GestionEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestionEtudiantsDao gestionEtudiantsDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEtudiantServlet() {
        super();
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.gestionEtudiantsDao = daoFactory.getEtudiantsDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//tous les étudiants inscrit dans une année universitaire
		request.setAttribute("etudiants", gestionEtudiantsDao.lister());
        this.getServletContext().getRequestDispatcher("/WEB-INF/GestionEtudiants/ConsulterEtudiant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
