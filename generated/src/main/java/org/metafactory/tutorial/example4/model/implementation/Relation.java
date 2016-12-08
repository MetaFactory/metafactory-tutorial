package org.metafactory.tutorial.example4.model.implementation;

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
   * constructor -
   * 
   * @param type
   * @param person
   */
  public Relation(final RelationType type, final Person person)
  {
    this.type = type;
    this.person = person;
  }

  /**
   * constructor -
   * 
   * @param type
   * @param company
   */
  public Relation(final RelationType type, final Company company)
  {
    this.type = type;
    this.company = company;
  }

  /**
   * equals - Fields used as businesskey: 1) person 2) type 3) company.
   * 
   * @param relation
   * @return boolean
   */
  public boolean equals(final Relation relation)
  {
    boolean result = true;
    // If all business keys are null, return false
    if (this.getPerson() == null && this.getType() == null && this.getCompany() == null)
    {
      result = false;
    }
    else
    {
      if (this.getPerson() != null && !this.getPerson().equals(relation.getPerson()))
      {
        result = false;
      }
      else if (this.getType() != null && !this.getType().equals(relation.getType()))
      {
        result = false;
      }
      else if (this.getCompany() != null && !this.getCompany().equals(relation.getCompany()))
      {
        result = false;
      }
    }
    return result;
  }

  /**
   * hashCode - Fields used as businesskey: 1) type 2) person 3) company.
   * 
   * @return integer
   */
  public int hashCode()
  {
    int result;
    result = 14;

    if (type != null)
    {
      result = 17 * result + type.hashCode();
    }
    if (person != null)
    {
      result = 17 * result + person.hashCode();
    }
    if (company != null)
    {
      result = 17 * result + company.hashCode();
    }

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
