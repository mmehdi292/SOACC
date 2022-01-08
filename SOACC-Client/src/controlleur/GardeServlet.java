package controlleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GardeServiceStub;
import dao.GardeServiceStub.GetEtudiantParMatricule;
import dao.GardeServiceStub.GetEtudiantParMatriculeResponse;
import dao.GardeServiceStub.GetEtudiantParNom;
import dao.GardeServiceStub.GetEtudiantParNomEtPrenom;
import dao.GardeServiceStub.GetEtudiantParNomEtPrenomResponse;
import dao.GardeServiceStub.GetEtudiantParNomResponse;

/**
 * Servlet implementation class GardeServlet
 */
public class GardeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GardeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null)
			this.getServletContext().getRequestDispatcher("/WEB-INF/EspaceGardes/VerifierInfo.jsp").forward(request,
					response);
		else
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			RequestDispatcher afficher = request.getRequestDispatcher("/WEB-INF/EspaceGardes/AfficherDonnees.jsp");
			RequestDispatcher erreur = request.getRequestDispatcher("/WEB-INF/EspaceGardes/VerifierInfo.jsp");
			GardeServiceStub stub = new GardeServiceStub();

			if (!request.getParameter("matricule").equals("")) {
				String matricule = request.getParameter("matricule");
				GetEtudiantParMatricule req = new GetEtudiantParMatricule();
				req.setMatricule(matricule);
				GetEtudiantParMatriculeResponse res = stub.getEtudiantParMatricule(req);

				request.setAttribute("etudiant", res.get_return());
				request.setAttribute("type", "Matricule");
				afficher.forward(request, response);
			}

			if (request.getParameter("nom").equals("")) {
				request.setAttribute("error", "Verifier les condition de la recherche au haut");
				erreur.forward(request, response);
			} else {
				String nom = request.getParameter("nom");
				if (!(request.getParameter("prenom").equals(""))) {
					String prenom = request.getParameter("prenom");

					GetEtudiantParNomEtPrenom req = new GetEtudiantParNomEtPrenom();
					req.setNom(nom);
					req.setPrenom(prenom);
					GetEtudiantParNomEtPrenomResponse res = stub.getEtudiantParNomEtPrenom(req);

					request.setAttribute("etudiants", res.get_return());
				} else {

					GetEtudiantParNom req = new GetEtudiantParNom();
					req.setNom(nom);
					GetEtudiantParNomResponse res = stub.getEtudiantParNom(req);

					request.setAttribute("etudiants", res.get_return());
				}
				afficher.forward(request, response);
			}

		}
		else
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

	}

}
