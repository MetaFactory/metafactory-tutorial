package org.metafactory.tutorial.example1;

import java.util.List;
import java.util.Set;

/**
 * HelloWorldWithExpressions - Created by MetaFactory: Automation of Software Development
 */
public class HelloWorldWithExpressions
{
  /** Some String field */
  private String             field1   = "Value defined in pattern";

  /** Another field */
  public int                 field2   = 10;

  /** A constant field */
  public static final String CONSTANT = "value";

  /**
   * methode1 -
   * 
   * @param arg1
   * @param arg2
   * @return String
   */
  private String methode1(final String arg1, final int arg2)
  {
    return "Hello World";
  }

  /**
   * methode2 -
   * 
   * @param list
   * @return String
   */
  protected String methode2(final List<String> list)
  {
    return "Of course, generic types are supported";
  }

  /**
   * methode3 - Set your javadoc comment
   * 
   * @param list
   */
  protected void methode3(final Set<String> list)
  {
    // do something
  }

  /**
   * main -
   * 
   * @param args
   */
  public static void main(final String[] args)
  {
    System.out.println("Hello World");
  }

}
