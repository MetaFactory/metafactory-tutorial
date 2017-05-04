package org.metafactory.tutorial.example3.model.implementation;

/**
 * Email - Created by MetaFactory: Automation of Software Development
 */
public class Email
{
  /** primary key */
  private Long    id;

  private String  emailAddress;

  private String  description;

  private Person  person;

  private Company company;

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
    if (emailAddress == null || emailAddress.trim().length() == 0)
    {
      this.emailAddress = null;
    }
    else
    {
      this.emailAddress = emailAddress;
    }
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
    if (description == null || description.trim().length() == 0)
    {
      this.description = null;
    }
    else
    {
      this.description = description;
    }
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
   * equals - Fields used as businesskey: 1) emailAddress.
   * 
   * @param email
   * @return boolean
   */
  public boolean equals(final Email email)
  {
    boolean result = true;
    // If all business keys are null, return false
    if (this.getEmailAddress() == null)
    {
      result = false;
    }
    else
    {
      if (this.getEmailAddress() != null && !this.getEmailAddress().equals(email.getEmailAddress()))
      {
        result = false;
      }
    }
    return result;
  }

  /**
   * hashCode - Fields used as businesskey: 1) emailAddress.
   * 
   * @return integer
   */
  public int hashCode()
  {
    int result;
    result = 14;

    if (emailAddress != null)
    {
      result = 29 * result + this.getEmailAddress().hashCode();
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
    StringBuilder result = new StringBuilder("Email: ");

    result.append("emailAddress=" + emailAddress);
    result.append(", ");

    result.append("description=" + description);

    return result.toString();
  }

}
