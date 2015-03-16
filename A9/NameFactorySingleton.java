import java.io.*;

// factory method pattern

class NameFactorySingleton {
  //returns an instance of LastFirst or FirstFirst
  //depending on whether a comma is found
  static NameFactorySingleton instance = null;
  public static NameFactorySingleton getNameFactoryInstance() {
	  if(instance == null)
		  instance = new NameFactorySingleton();
	  return instance;
  }
  private NameFactorySingleton() {};
  public Name getName(String entry) {
    int cm = entry.indexOf(","); //comma determines name order
    if (cm >0)
      return new LastFirst(entry); //return one class
    else 
		return new FirstFirst(entry);
  }
}

//==============================================================

class Name {
  //a simple class to take a string apart into two names
  protected String last; //store last name here
  protected String first; //store first name here
  
  public String getFirst() {
    return first; //return first name
  }
  
  public String getLast() {
    return last; //return last name
  }
  
}

class LastFirst extends Name { //split last, first
  public LastFirst(String s) {
    int cm = s.indexOf(","); //find comma
    if (cm > 0) {
      //left is last name
      last = s.substring(0, cm).trim();
      //right is first name
      first = s.substring(cm + 1).trim();
	 } else {
      last = s; // put all in last name
      first = ""; // if no comma
    }
  }
}

class FirstFirst extends Name { //split first last
  public FirstFirst(String s) {
    int i = s.lastIndexOf(" "); //find sep space
    if (i > 0) {
      //left is first name
      first = s.substring(0, i).trim();
      //right is last name
      last =s.substring(i+1).trim();
    } else {
      first = ""; // put all in last name
      last = s; // if no space
    }
  }
}

//================================================================


class DoMain {

public static void main (String[] args) throws IOException {

  //Must use static method to get singleton.
  NameFactorySingleton nfactory = NameFactorySingleton.getNameFactoryInstance();
  //The following commented line should throw an error, since the constructor is private.
  //NameFactorySingleton nfactory2 = new NameFactorySingleton();
  Name n;
  String line;

  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
  
  while (true) {        
    line = in.readLine();
    if (line.equals("/")) break;
	 
    //send the text to the factory and get a class back
    n = nfactory.getName(line);
	 
    //compute the first and last names
    //using the returned class   
	 System.out.println(
	   "F:" + n.getFirst() + "  L:" + n.getLast());
  }
}
}
