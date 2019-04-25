// Louis Sze
public class Extras {
  // Extra programs that isn't used in the game black jack.

  /*
   * Byte - is a 8 bit integer, with a minimum value and maximum value of 127 Short - is a 16 bit
   * integer, with a minimum value of -32,768 and max 32,767 Int - is a 32 bit integer, with a
   * minimum -2e-31 and a max of 2e-31-1 Long - is a 64 bit integer, with a minimum value of -2e-63
   * and a max of 2e64-1 Float - is a single precision 32 bit IEEE754 Double - is a 64 bit IEEE754
   * Char - a single 16 bit unicode character, with a minimum value of '\u0000'(0) and a max value
   * of '\uffff' (65,535)
   */

  final int i = 10;
  // a final variable in java are variables that cannot be changed.
  int age = (int) 3.678;
  // Casting is taking an object of one particular type and turning it into another type.
  // Casting a double into an int , type casting.
  int spookyGhost = 1;
  // setting the spookyGhost variable to 1 with correct Camel Casing
  String strName = new String("This is a String");
  // String object wither lower camel case.
  // Arguments are inside Parenthesis
  int add = 1 + 2;
  int subtract = 1 - 2;
  int multiple = 1 * 2;
  int divide = 1 / 2;
  // i++ this adds 1 to i
  // j-- this minus 1 to j
  // += adds the variable and set it to equal to the variable

  /*
   * Inheritance is where a child class inherits its methods from parent class. The benefits of
   * inheritance is that you don't have to copy and rewrite new code. This makes it more easier to
   * read and no need to rewrite the same code over again.
   */

  // Fish is SuperClass
  // Shark and Whale is Sub Class
  public class fish {
    void breathe() {
      // fish actions that will be inherited by shark and whale
      System.out.println("Breathing");
    }

    void eats() {
      System.out.println("Eating");
    }
  }
  public class shark extends fish {
    // Shark extends fish fields and methods
    void eats() {
      // Shark eats method
      System.out.println("Eats fishes");
    }
  }
  public class whale extends fish {
    // Whale extends fish fields and method
    void eats() {
      // Whale eats method
      System.out.println("Eats Planktons");
      // polymorphism where the classes are extended and it overriding the fish class with shark and
      // whale eats.
      fish wiggle[] = new fish[2];
      wiggle[0] = new shark();
      wiggle[1] = new whale();
      for (int y = 0; y < 2; y++) {
        wiggle[y].eats();
      }

      /*
       * Polymorphism is the ability of an object to take on many forms. Most common use of
       * polymorphism is oop occurs when a parent class reference is used to refer to a child class
       * object
       */
    }
  }

  /*
   * add (int, int) add (int, int, int) overloading method where if three int is called it overloads
   * the two int method
   */
  // enhanced for loop where it saves the trouble and makes the parameters shorter
  public class EnhancedForLoop {
    public void enhanced() {
      int scores[] = {24, 35, 63, 74, 86};

      for (int i : scores) {
        System.out.println(i);
      }
    }
  }

  // exception handling
  int power(int n, int p) throws Exception {
    if (n < 0 || p < 0)
      throw new Exception("n or p should not be negative.");
    else if (n == 0 && p == 0)
      throw new Exception("n and p should not be zero.");
    return (int) Math.pow((double) n, (double) p);
  }

  class multiArray {
    int firstArray[][] = {{5, 4, 10, 32}, {6, 13, 34, 54}};
    int secondArray[][] = {{41, 52, 63, 74}, {15}, {4, 5, 6}};
    // this calls the array starting from 0 to how many arrays you have this is also called
    // multidimensional arrays, storing like a table
    // firstArray[0][1];
    // secondArray[3][1];
  }
  /*
   * Variable is a container which holds the value while the java program is executed Usually
   * assigned with a data type , three type of data types are local, instance, and static. Scope is
   * refers to the section of code where a variable can be accessed. The scope is a instance
   * variables is the entire class definition.
   */

}
