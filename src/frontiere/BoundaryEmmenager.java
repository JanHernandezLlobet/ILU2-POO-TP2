package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
			System.out.println("Au revoir voyageur " + nomVisiteur);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		
		StringBuilder question1 = new StringBuilder();
		StringBuilder question2 = new StringBuilder();
		StringBuilder question3 = new StringBuilder();
		
		question1.append("Bienvenue druide " + nomVisiteur + "\nQuelle est votre force ?");
		int force = Clavier.entrerEntier(question1.toString());
		
		question2.append("Quelle est la force de la potion la plus faible que vous produisez ?");
		int effetPotionMin = Clavier.entrerEntier(question2.toString());
		
		question3.append("Quelle est la force de la potion la plus forte que vous produisez ?");
		int effetPotionMax = Clavier.entrerEntier(question3.toString());
		
		this.controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		
		System.out.println("Bienvenue villageois " + nomVisiteur + "\nQuelle est votre force ?");
		int force = Clavier.entrerEntier(question.toString());
		
		this.controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
