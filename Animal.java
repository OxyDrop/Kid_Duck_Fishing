
package peche;
public abstract class Animal {
	private int pts;
	private boolean perdu;
	private String representation;
	public Animal(int pts, boolean perdu, String representation){
		this.perdu=perdu;
		this.pts=pts;
		this.representation=representation;
	}
	public Animal(Animal a){
		this(a.pts,a.perdu,a.representation);
	}
	@Override
	public String toString(){
		return "Points : "+pts+" perdant : "+perdu+" nom : "+representation;
	}
	public String getRepresentation(){
		return representation;
	}
	public boolean getPerdu(){
		return perdu;
	}
	public int getPts(){
		return pts;
	}
	
	public abstract String getType();
	
}
