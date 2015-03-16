package abstractFactory;

public class VeggieGarden extends Garden {
	  static VeggieGarden instance = null;
	  private VeggieGarden() {};
	  public Plant getShade() { return new Plant("Broccoli"); }
	  public Plant getCenter() { return new Plant("Corn"); }
	  public Plant getBorder() { return new Plant("Peas"); }
	  public static VeggieGarden getInstance(){
		  if(instance == null)
			  instance = new VeggieGarden();
		  return instance;
	  }
	}
