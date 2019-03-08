
package peche;
import java.util.ArrayList;
public class testAnimal {
	public static void main(String[] args){
		Stand stand = new Stand(20);
		for(int i=0; i<Integer.parseInt(args[0]);i++){
			if(i<Integer.parseInt(args[0])/2+2)
				stand.ajouterAnimal(new Canard());
			else
				stand.ajouterAnimal(new Lapin());
		}
		Animateur jeje = new Animateur("Gerard"); 
		Joueur keke = new Joueur("Keke"); 
		Joueur nana = new Joueur("Nana");
		Joueur dydy = new Prudent("Dydy");
		
		stand.ajouterPersonne(nana); 
		stand.ajouterPersonne(jeje); 
		stand.ajouterPersonne(keke); 
		stand.ajouterPersonne(dydy);
		stand.ajouterPersonne(new Animateur("Hubert"));
		for(int i=0;i<50;i++){
			System.out.println("\n-------------TOUR "+i+"-------------\n");
			System.out.println(stand+"\n");
			System.out.println(jeje+"\n"+keke+"\n"+nana+"\n"+dydy);
			stand.avance();
		}
		stand.nbPervers();
		stand.getVainqueur();
	}
}
