package djsync;

import java.util.*;

public class HelloWorld {
  private Timer t = new Timer();

  public HelloWorld(){



  }
  public native void displayHelloWorld();

  static{
    System.loadLibrary("hello");
  }

  public static void main(String[] args){
    new HelloWorld().displayHelloWorld();
  }

}