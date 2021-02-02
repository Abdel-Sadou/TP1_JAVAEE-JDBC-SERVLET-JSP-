package test;

import java.util.List;

import metier.MetierImpl;
import metier.Produit;

public class Test {

	public static void main(String[] args) {
		MetierImpl metier = new MetierImpl();
//		
//		List<Produit> prods = metier.getProduitParMotCle("apple");
//		for (Produit produit : prods) {
//			System.out.println(produit.getNomProduit()+"-"+produit.getPrix()+"$");
//		}
		
		System.out.println("=--------------ajout d'un nouveau Produit ----------------");
		Produit ajoutProd = new Produit("Toshiba", 245);
		 metier.addProduit(ajoutProd);
		
		
	}

}
