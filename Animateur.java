package peche;
import java.util.ArrayList;
public class Animateur extends Personne {
	private ArrayList<Animal> animal;
	public Animateur(String nom){
		super(nom);
		animal = new ArrayList();
	}
	public void action(Stand s){
		if(Math.random()>0.5){
			if(Math.random()<0.8){
				Canard c = new Canard();
				animal.add(c);
				s.ajouterAnimal(c);
				System.out.println("L'animateur "+getNom()+" à ajouté "+c);
			}else{
				Lapin l = new Lapin();
				animal.add(l);
				s.ajouterAnimal(l);
				System.out.println("L'animateur "+getNom()+" à ajouté "+l);
			}
		}
	}
	@Override
	public String toString(){
		int com = 0;
		for(Animal a : animal){
			if(a!=null) 
				com++;
		}
		return getNom()+", animateur, nombre animaux crées : "+com;
	}
	public boolean getPervers(){
		int com = 0;
		for(Animal a : animal){
			if(a instanceof Lapin)
				com++;
		}
		if(com>=animal.size()/2){
			System.out.println("L'animateur "+getNom()+" est un pervers");
			return true;
		}else{
			System.out.println("L'animateur "+getNom()+" n'est pas un pervers");
			return false;
		}
	}
}
