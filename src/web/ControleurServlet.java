 package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ImetierCatalogue;
import metier.MetierImpl;
import metier.Produit;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/controleur")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ImetierCatalogue metier;
     
    @Override
    public void init() throws ServletException{
    	metier = new MetierImpl();
    }
    
    public ControleurServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mc = request.getParameter("motCle");
		ProduitModele mod = new ProduitModele();
		mod.setMotCle(mc);
		List<Produit> prods = metier.getProduitParMotCle(mc);
		mod.setProduits(prods);
		request.setAttribute("modele", mod);
		request.getRequestDispatcher("ProduitsView.jsp").forward(request,response);
	}

}
