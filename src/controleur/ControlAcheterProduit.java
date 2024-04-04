package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public Gaulois[] rechercherVendeursItem(String item) {
		return village.rechercherVendeursProduit(item);
	}

	public int acheter(int quantite, Gaulois vendeur) {
		return (village.rechercherEtal(vendeur)).acheterProduit(quantite);
	}
	
}
