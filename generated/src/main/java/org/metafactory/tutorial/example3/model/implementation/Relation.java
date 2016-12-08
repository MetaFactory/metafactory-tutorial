package org.metafactory.tutorial.example3.model.implementation;

/**
 * Relation - Created by MetaFactory: Automation of Software Development
 * 
 * @author - Merijn
 */
public class Relation
{
  /** primary key */
  private Long         id;

  private RelationType type;

  private Person       person;

  private Company      company;

  /**
   * Getter for property id.
   * 
   * @return value of property id
   */
  public Long getId()
  {
    return this.id;
  }

  /**
   * Setter for property id.
   * 
   * @param id new value of property id
   */
  public void setId(final Long id)
  {
    this.id = id;
  }

  /**
   * Getter for property type.
   * 
   * @return value of property type
   */
  public RelationType getType()
  {
    return this.type;
  }

  /**
   * Setter for property type.
   * 
   * @param type new value of property type
   */
  public void setType(final RelationType type)
  {
    this.type = type;
  }

  /**
   * Getter for property person.
   * 
   * @return value of property person
   */
  public Person getPerson()
  {
    return this.person;
  }

  /**
   * Setter for property person.
   * 
   * @param person new value of property person
   */
  public void setPerson(final Person person)
  {
    this.person = person;
  }

  /**
   * Getter for property company.
   * 
   * @return value of property company
   */
  public Company getCompany()
  {
    return this.company;
  }

  /**
   * Setter for property company.
   * 
   * @param company new value of property company
   */
  public void setCompany(final Company company)
  {
    this.company = company;
  }

  /**
   * equals - Fields used as businesskey:.
   * 
   * @param relation
   * @return boolean
   */
  public boolean equals(final Relation relation)
  {
    // FIXME: no businesskey fields defined
    return false;
  }

  /**
   * hashCode - FIXME define businesskeys in model
   * 
   * @return integer
   */
  public int hashCode()
  {
    int result;
    // FIXME: no businesskey fields defined
    result = super.hashCode();
    return result;
  }

  /**
   * toString -
   * 
   * @return String
   */
  public String toString()
  {
    StringBuilder result = new StringBuilder("Relation: ");

    return result.toString();
  }

}
