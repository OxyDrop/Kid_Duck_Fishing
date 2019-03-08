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
public class Lapin extends Animal {
	private static int cpt=1;
	public Lapin(){
		super(5,Math.random()<=0.3,String.format("L%02d", cpt));
		cpt++;
	}
	public Lapin(Lapin l){
		super(l);
	}
	@Override
	public String getType(){
		return "Lapin";
	}
}
