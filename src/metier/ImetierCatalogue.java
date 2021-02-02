package metier;

import java.util.List;

public interface ImetierCatalogue {
	public List<Produit> getProduitParMotCle(String mc);
	public void addProduit(Produit p);
}
