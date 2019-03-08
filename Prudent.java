package peche;

/**
 *
 * @author Serero
 */
public class Prudent extends Joueur{
	public Prudent(String nom){
		super(nom);
	}
	public void action(Stand s){
		if(Math.random()<txReussite){
			int randcase = (int)(Math.random()*s.getTailleJeuVisible()*2);
			Animal attrape = s.getAnimal(randcase);
			if(attrape != null && attrape.getPerdu()!=true){
				animal.add(s.removeAnimal(randcase));
				System.out.println("Le joueur "+getNom()+" a attrapé l'animal "+attrape.getRepresentation()+" qui est gagnant ? "+!attrape.getPerdu());
			}
		}
	}
}
