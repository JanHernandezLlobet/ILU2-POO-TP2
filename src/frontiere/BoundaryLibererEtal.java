package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		Boolean venderReconnu = (controlLibererEtal.isVendeur(nomVendeur) != null);
		if(!venderReconnu) {
			System.out.println("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui!");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0].equals("true")) { // etaloccupe = donneesEtal[0]
				System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + ".");
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journ�e.");
			}
		}
		
		
	}

}
