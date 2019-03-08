package peche;
import java.util.ArrayList;
public class Stand {
	private ArrayList<Personne> personnes;
    private Animal[] round;
	private int indexFront, indexBack;
	public Stand(int taille){
		indexFront = 0;
		indexBack = taille/2;
		round = new Animal[taille];
		personnes = new ArrayList<>();
		if(Math.random()<=0.1) 
			this.ajouterAnimal(new LapinMagique());
	}
	public void avance(){ // avance la rotation d'un cran
        indexFront++;
        indexBack++;
		for(Personne p : personnes)
			p.action(this);
        if (indexBack == round.length)
            indexBack = 0;
        if (indexFront == round.length)
            indexFront = 0;
    }
	public void ajouterPersonne(Personne p){
		personnes.add(p);
	}
	public Animal getAnimal(int i){
		if(round[(indexFront + i)%round.length]==null)
			return null;
		else
			return round[(indexFront + i)%round.length];
	}
	public void ajouterAnimal(Animal a){
		for(int i:indexBack()){
			if (round[i]==null){
				round[i]=a;
				return;
			}		
		}
	}
	public int getTailleJeuVisible(){
		return round.length/2;
	}
	public Animal removeAnimal(int i){
		Lapin l;
		Canard c;
		if(round[(indexFront + i)%round.length]==null) 
			return null;
		else{
			Animal attrape = round[(indexFront + i)%round.length];
			if(attrape instanceof Lapin){
					l = new Lapin((Lapin)attrape);
					round[(indexFront + i)%round.length]=null;
					return l;
			}else if(attrape instanceof Canard){
					c = new Canard((Canard)attrape);
					round[(indexFront + i)%round.length]=null;
					return c;
			}
		}
		return null;
	}
	public int nbPervers(){
		int com = 0;
		for(Personne p : personnes){
			if(p instanceof Animateur && ((Animateur)p).getPervers()){
				com++;
			}
		}
		return com;
	}
	public void getVainqueur(){
		int maxpts = -1;
		Joueur vainq=null;
		for(Personne p : personnes){
			if(p instanceof Joueur && ((Joueur)p).compterLesPoints()>maxpts){
				maxpts = ((Joueur)p).compterLesPoints();
				vainq = (Joueur)p;
			}
		}
		if(vainq!=null)
			System.out.println("Le vainqueur est le joueur "+vainq);
	}
	@Override
	public String toString(){
		String s ="       => Arriere boutique =>\n";
		for(int i:indexBack()){
			if(round[i]==null)
				s+="  .";
			else
				s+=" "+round[i].getRepresentation();
		}
		s+="\n----------------------------------------\n";
		for(int i:indexFront()){
			if(round[i]==null)
				s+="  .";
			else
				s+=" "+round[i].getRepresentation();	
		}
		return s+"\n        <= Facade <= ";
	}
    private ArrayList<Integer> indexBack(){ // tous les indices de l'arrière boutique (là où les animateurs ajoutent des animaux)
        ArrayList<Integer> index = new ArrayList<Integer>();
        if(indexBack>indexFront){
            for (int i=indexFront-1; i>=0 ; i--)
                index.add(i);
            for (int i=round.length-1; i>= indexBack; i--)
                index.add(i);
        }else{
            for (int i=indexFront-1; i>= indexBack; i--)
                index.add(i);
        }
        return index;
    }
    private ArrayList<Integer> indexFront(){ // tous les indices de la facade (là où les joueurs pêchent)
        ArrayList<Integer> index = new ArrayList<Integer>();
        if(indexBack<indexFront){
            for (int i=indexFront; i< round.length; i++)
                index.add(i);
            for (int i=0; i< indexBack; i++)
                index.add(i);
        }else{
            for (int i=indexFront; i< indexBack; i++)
                index.add(i);
        }
        return index;
	}
}
