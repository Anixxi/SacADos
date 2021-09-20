
public class Objet {

	private String nom;
	private Double poids;
	private Double valeur;


	public Objet() {
		nom = "";
		poids = 0.0;
		valeur = 0.0;
	}

	public Objet(String inom, Double ipoids, Double ivaleur) {
		nom = inom;
		poids = ipoids;
		valeur = ivaleur;
	
	}

	@Override
	public String toString() {
		return nom + " : " + "  " + poids + "  " + valeur ;
	}
}