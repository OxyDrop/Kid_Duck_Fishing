package peche;
import java.util.ArrayList;
public class Joueur extends Personne {
	protected double txReussite;
	protected ArrayList<Animal> animal;
	public Joueur(String nom){
		super(nom);
		txReussite = Math.random();
		animal = new ArrayList();
	}
	public void action(Stand s){
		if(Math.random()<txReussite){
			int randcase = (int)(Math.random()*s.getTailleJeuVisible()*2);
			Animal attrape = s.removeAnimal(randcase);
			if(attrape !=null){
				animal.add(attrape);
				System.out.println("Le joueur "+getNom()+" a attrapé l'animal "+attrape.getRepresentation());
			}
		}
	}
	public int compterLesPoints(){
		int s = 0;
		for(Animal a : animal){
			if (a.getPerdu()==true)
				return 0;
			s+=a.getPts();
		}
		return s;
	}
	public String toString(){
		return getNom()+", joueur, nombre animaux attrapés : "+animal.size()+", total point : "+compterLesPoints();
	}
}
