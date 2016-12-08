package org.metafactory.tutorial.example2.model.implementation;

/**
 * Phone - Created by MetaFactory: Automation of Software Development
 * 
 * @author - Merijn
 */
public class Phone
{
  /** primary key */
  private Long    phoneId;

  /** the number field */
  private String  number;

  /** the description field */
  private String  description;

  private Person  person;

  private Company company;

  /**
   * Getter for property phoneId.
   * 
   * @return value of property phoneId
   */
  public Long getPhoneId()
  {
    return this.phoneId;
  }

  /**
   * Setter for property phoneId.
   * 
   * @param phoneId new value of property phoneId
   */
  public void setPhoneId(final Long phoneId)
  {
    this.phoneId = phoneId;
  }

  /**
   * Getter for property number.
   * 
   * @return value of property number
   */
  public String getNumber()
  {
    return this.number;
  }

  /**
   * Setter for property number.
   * 
   * @param number new value of property number
   */
  public void setNumber(final String number)
  {
    this.number = number;
  }

  /**
   * Getter for property description.
   * 
   * @return value of property description
   */
  public String getDescription()
  {
    return this.description;
  }

  /**
   * Setter for property description.
   * 
   * @param description new value of property description
   */
  public void setDescription(final String description)
  {
    this.description = description;
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
  public Phone()
  {
    super();
    // do nothing
  }

}
