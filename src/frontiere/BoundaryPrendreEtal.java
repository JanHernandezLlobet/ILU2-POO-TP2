package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		Boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println("Je suis d�sol�e " + nomVendeur + " mais il faut �tre habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regader su je peux vous trouver un �tal.");
			Boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("D�sol�e " + nomVendeur + " je n'ai plus d'�tal qui ne soit d�l� occup�.");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait il me reste un �tal pour vous!");
		System.out.println("Il me faudrait quelques renseignemens :");
		
		StringBuilder question1 = new StringBuilder();
		question1.append("Quel produit souhaitez-vous vendre ?");
		String produit = Clavier.entrerChaine(question1.toString());
		
		StringBuilder question2 = new StringBuilder();
		question2.append("Combien souhaitez-vous en vendre ?");
		int nbProduit = Clavier.entrerEntier(question2.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n�" + numeroEtal);
		}
	
	}
}




