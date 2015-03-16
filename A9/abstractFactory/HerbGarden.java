package abstractFactory;

public class HerbGarden extends Garden {
	  // this is a simple factory
	  // meaning contains factory methods
	  static HerbGarden instance = null;
	  private HerbGarden() {};
	  public Plant getShade() { return new Plant("Mint"); }
	  public Plant getCenter() { return new Plant("Rosemary"); }
	  public Plant getBorder() { return new Plant("Thyme"); }
	public static HerbGarden getInstance() {
		if(instance == null)
			instance = new HerbGarden();
		return instance;
	}
	}
