
package peche;
public abstract class Personne {
	private String nom;
	public Personne(String nom){
		this.nom=nom;
	}
	public String getNom(){
		return nom;
	}
	public abstract void action(Stand s);
}
