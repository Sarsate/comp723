package abstractFactory;

public class FlowerGarden extends Garden {
	  static FlowerGarden instance = null;
	  private FlowerGarden() {};
	  public Plant getShade() { return new Plant("Impatiens"); }
	  public Plant getCenter() { return new Plant("Zinnia"); }
	  public Plant getBorder() { return new Plant("Phlox"); }
	  public static Garden getInstance() {
		  if(instance == null)
			  instance = new FlowerGarden();
		  return instance;
	  }
	}