package org.metafactory.tutorial.example2.model.implementation;

/**
 * Email - Created by MetaFactory: Automation of Software Development
 */
public class Email
{
  /** primary key */
  private Long    emailId;

  private String  emailAddress;

  private String  description;

  private Person  person;

  private Company company;

  /**
   * Getter for property emailId.
   * 
   * @return value of property emailId
   */
  public Long getEmailId()
  {
    return this.emailId;
  }

  /**
   * Setter for property emailId.
   * 
   * @param emailId new value of property emailId
   */
  public void setEmailId(final Long emailId)
  {
    this.emailId = emailId;
  }

  /**
   * Getter for property emailAddress.
   * 
   * @return value of property emailAddress
   */
  public String getEmailAddress()
  {
    return this.emailAddress;
  }

  /**
   * Setter for property emailAddress.
   * 
   * @param emailAddress new value of property emailAddress
   */
  public void setEmailAddress(final String emailAddress)
  {
    this.emailAddress = emailAddress;
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

}
