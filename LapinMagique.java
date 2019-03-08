package peche;

/**
 *
 * @author Serero
 */
public class LapinMagique extends Animal {
	private static int cpt=1;
	public LapinMagique(){
		super(20,false,String.format("L%02d", cpt));
		cpt++;
	}
	public String getType(){
		return "Lapin";
	}
}
