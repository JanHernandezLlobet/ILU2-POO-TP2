package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		
		// Verifier acheteur
		if(! controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			StringBuilder reponse1 = new StringBuilder();
			reponse1.append("Je suis désolée ");
			reponse1.append(nomAcheteur);
			reponse1.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(reponse1.toString());
			return;
		}
	
		// Chercher vendeur
		StringBuilder question1 = new StringBuilder();
		question1.append("Quel produit voulez-vous acheter ?");
		String item = Clavier.entrerChaine(question1.toString());
		Gaulois vendeurs[] = controlAcheterProduit.rechercherVendeursItem(item);
		
		StringBuilder question2 = new StringBuilder();
		if(vendeurs.length > 0) {

			question2.append("Chez quel commerçant voulez-vous acheter des fleurs ?\n");
			for(int i=0; i< (vendeurs.length); i++ ) {
				question2.append(i+1);
				question2.append(" - ");
				question2.append(vendeurs[i].getNom());
				question2.append("\n");
			}
		}
		else {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
			return;
		}
		
		int vendeurChoisis = Clavier.entrerEntier(question2.toString());
		Gaulois vendeur = vendeurs[vendeurChoisis-1];
		// Verifier vendeur
		if(! controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			StringBuilder reponse2 = new StringBuilder();
			reponse2.append("Je suis désolée, il faut que ");
			reponse2.append(vendeur.getNom());
			reponse2.append(" soit un habitant de notre village pour commercer ici.");
			System.out.println(reponse2.toString());
			return;
		}
				
		//Partie 2
		
		StringBuilder question3 = new StringBuilder();
		question3.append(nomAcheteur);
		question3.append(" se déplace jusqu'à l'étal du vendeur ");
		question3.append(vendeur);
		question3.append("\nBonjour ");
		question3.append(nomAcheteur);
		question3.append("\nCombien de fleurs voulez-vous acheter ?");
		int quantite = Clavier.entrerEntier(question3.toString());
		int quantiteApresAchat = controlAcheterProduit.acheter(quantite, vendeur);
		
		StringBuilder reponse3 = new StringBuilder();
		reponse3.append(nomAcheteur);
		
		if(quantiteApresAchat == quantite) {
			reponse3.append(" achète 5 fleurs à ");
			reponse3.append(vendeur.getNom());
			reponse3.append(".\n");
		}
		else if(quantiteApresAchat > 0) {
			reponse3.append(" veut acheter ");
			reponse3.append(quantite);
			reponse3.append(" fleurs, malheuresement ");
			reponse3.append(vendeur.getNom());
			reponse3.append(" n'en a plus que ");
			reponse3.append(quantiteApresAchat);
			reponse3.append(". ");
			reponse3.append(nomAcheteur);
			reponse3.append(" achète tout le stock de ");
			reponse3.append(vendeur.getNom());
			reponse3.append(".\n");
		}
		else {
			reponse3.append(" veut acheter ");
			reponse3.append(quantite);
			reponse3.append(" fleurs, malheuresement il n'y en a plus!\n");
		}
		System.out.println(reponse3.toString());
		return;
	}
}
