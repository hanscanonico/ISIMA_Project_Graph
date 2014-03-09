package metier;

public class Sommet {
	private String nom;
	private int valeur;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Sommet(String nom,int val)
	{
		setNom(nom);
		setValeur(val);
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(getNom()).append("(");
		sb.append(getValeur()).append(")");
		return sb.toString();
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
