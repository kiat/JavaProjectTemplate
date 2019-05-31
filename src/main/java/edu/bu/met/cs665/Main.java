package edu.bu.met.cs665;

import edu.bu.met.cs665.example1.Person;
import org.apache.log4j.Logger;

public class Main {

  private static Logger logger = Logger.getLogger(Main.class);


  /**
   * A main method to run examples.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    Main m = new Main();

    logger.info(m.doIt());


  }



  private String doIt() {
    Person student = new Person("John", "Doe");
    return student.getLastName() + ',' + student.getLastName();
  }

}
