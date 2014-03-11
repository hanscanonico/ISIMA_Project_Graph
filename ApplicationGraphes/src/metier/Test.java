package metier;

import presentation.Fenetre;

public class Test {

	public static void main (String [] arg){
		Graphe g=new Graphe();
		Sommet a=new Sommet("A",1);
		Sommet b=new Sommet("B",2);
		Sommet c=new Sommet("C",3);
		Arrete ab=new Arrete(a, b);
		Arrete ac=new Arrete(a,c);
		Arrete bc=new Arrete(b,c);
		g.ajouterSommet(a);
		g.ajouterSommet(b);
		g.ajouterSommet(c);
		g.ajouterArrete(ab);
		g.ajouterArrete(ac);
		g.ajouterArrete(bc);
		Fenetre fen = new Fenetre(g);
		System.out.println(g);
	}
	
}
