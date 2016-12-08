package org.metafactory.tutorial.example2.model.implementation;

/**
 * Relation - Created by MetaFactory: Automation of Software Development
 * 
 * @author - Merijn
 */
public class Relation
{
  /** primary key */
  private Long         relationId;

  private RelationType type;

  private Person       person;

  private Company      company;

  /**
   * Getter for property relationId.
   * 
   * @return value of property relationId
   */
  public Long getRelationId()
  {
    return this.relationId;
  }

  /**
   * Setter for property relationId.
   * 
   * @param relationId new value of property relationId
   */
  public void setRelationId(final Long relationId)
  {
    this.relationId = relationId;
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
   * constructor - Default constructor which loads defaults by using method loadDefaults
   */
  public Relation()
  {
    super();
    // do nothing
  }

}
