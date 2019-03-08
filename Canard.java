/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peche;

/**
 *
 * @author Serero
 */
public class Canard extends Animal {
	private static int cpt=1;
	public Canard(){
		super((int)(Math.random()*3+1),false,String.format("c%02d", cpt));
		cpt++;
	}
	public Canard(Canard c){
		super(c);
	}
	@Override
	public String getType(){
		return "Canard";
	}
}
