package org.metafactory.tutorial.example5.model.implementation;

import java.io.Serializable;

/**
 * RelationType - Created by MetaFactory: Automation of Software Development
 */
public enum RelationType implements Serializable {
  Private, Business;

  private static final long serialVersionUID = 1;

  /**
   * toString -
   * 
   * @return String
   */
  public String toString()
  {
    return this.name() + "(" + this.ordinal() + ")";
  }

}
