package abstractFactory;

class DoMain {

	  public static void main (String[] args) {
	     Garden plot; // a factory
		  GardenMaker gfac; // a factory factory
		  
		  //Use static method to get singleton.
		  gfac = GardenMaker.getInstance();
		  //Following line throws an errors since it violates the singleton pattern:
		  //gfac = new GardenMaker();
		  
		  plot = gfac.getGarden("Flower");
		  System.out.println("\nnew garden factory... flowers"); 
		  System.out.println(" >> shade: " + plot.getShade().getName());
		  
		  plot = gfac.getGarden("Herb");	
		  System.out.println("\nnew garden factory... herbs");  
		  System.out.println(" >> shade: " + plot.getShade().getName());
		  System.out.println(" >> center: " + plot.getCenter().getName());
		  
		  plot = gfac.getGarden("default"); // default veggie
		  System.out.println("\nnew garden factory... vegetables"); 
		  System.out.println(" >> center: " + plot.getCenter().getName());

	  }
	}