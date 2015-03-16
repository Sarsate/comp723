package abstractFactory;

class GardenMaker {
	  //Abstract Factory which returns one of three gardens
	  private Garden gd;
	  private static GardenMaker instance;
	  private GardenMaker(){};
	  public Garden getGarden(String gtype) {
	    gd = VeggieGarden.getInstance(); //default
	    if(gtype.equals("Flower")) gd = FlowerGarden.getInstance();
	    if(gtype.equals("Herb")) gd = HerbGarden.getInstance();
	    //The following lines throw an error, since they violate the singleton pattern.
	    /*
	     * gd = new VeggieGarden(); //default 
	     * if(gtype.equals("Flower")) gd = new FlowerGarden();
	     * if(gtype.equals("Herb")) gd = new HerbGarden();
	     * 
	     */
	    return gd;
	  }
	  public static GardenMaker getInstance()
	  {
		  if(instance == null)
			  instance = new GardenMaker();
		  return instance;
	  }
	}
