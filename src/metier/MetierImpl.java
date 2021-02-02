package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements ImetierCatalogue{

	@Override
	public List<Produit> getProduitParMotCle(String mc) {
		
		Connection conn = SingletonConnection.getConnection();//retourne une connection
		
		List<Produit> prods = new ArrayList<Produit>();
		
//		PreparedStatement ps;// sert a faire des requetes ici avec 'd' du prepared
		try {
			PreparedStatement ps = conn.prepareStatement("select * from PRODUITS where NOM_PRODUIT LIKE ?");
			ps.setString(1, "%"+mc+"%");//1 represente le nom_produit ensuite le critere de parametre 
										
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Produit p = new Produit();
				p.setIdProduit(rs.getLong("ID_PRODUIT"));
				p.setNomProduit(rs.getString("NOM_PRODUIT"));
				p.setPrix(rs.getDouble("PRIX"));
				prods.add(p);
				
				}
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
						
	}

	@Override
	public void addProduit(Produit p) {
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into PRODUITS (NOM_PRODUIT, PRIX) values(?,?)");
			ps.setString(1, p.getNomProduit());
			ps.setDouble(2, p.getPrix());
			int rs = ps.executeUpdate();
			
			System.out.println(" nombre de produit ajouter : "+rs);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

}
