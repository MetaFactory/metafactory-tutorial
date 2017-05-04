package org.metafactory.tutorial.example2.model.implementation;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Person - Created by MetaFactory: Automation of Software Development
 */
public class Person
{
  /** primary key */
  private Long         personId;

  private String       firstName;

  private String       middleName;

  private String       lastName;

  private Date         birthDate;

  private Set<Address> addressSet = new HashSet<Address>();

  private Set<Phone>   phoneSet   = new HashSet<Phone>();

  private Set<Email>   emailSet   = new HashSet<Email>();

  /**
   * Getter for property personId.
   * 
   * @return value of property personId
   */
  public Long getPersonId()
  {
    return this.personId;
  }

  /**
   * Setter for property personId.
   * 
   * @param personId new value of property personId
   */
  public void setPersonId(final Long personId)
  {
    this.personId = personId;
  }

  /**
   * Getter for property firstName.
   * 
   * @return value of property firstName
   */
  public String getFirstName()
  {
    return this.firstName;
  }

  /**
   * Setter for property firstName.
   * 
   * @param firstName new value of property firstName
   */
  public void setFirstName(final String firstName)
  {
    this.firstName = firstName;
  }

  /**
   * Getter for property middleName.
   * 
   * @return value of property middleName
   */
  public String getMiddleName()
  {
    return this.middleName;
  }

  /**
   * Setter for property middleName.
   * 
   * @param middleName new value of property middleName
   */
  public void setMiddleName(final String middleName)
  {
    this.middleName = middleName;
  }

  /**
   * Getter for property lastName.
   * 
   * @return value of property lastName
   */
  public String getLastName()
  {
    return this.lastName;
  }

  /**
   * Setter for property lastName.
   * 
   * @param lastName new value of property lastName
   */
  public void setLastName(final String lastName)
  {
    this.lastName = lastName;
  }

  /**
   * Getter for property birthDate.
   * 
   * @return value of property birthDate
   */
  public Date getBirthDate()
  {
    return this.birthDate;
  }

  /**
   * Setter for property birthDate.
   * 
   * @param birthDate new value of property birthDate
   */
  public void setBirthDate(final Date birthDate)
  {
    this.birthDate = birthDate;
  }

  /**
   * Getter for property addressSet.
   * 
   * @return value of property addressSet
   */
  public Set<Address> getAddressSet()
  {
    return this.addressSet;
  }

  /**
   * Setter for property addressSet.
   * 
   * @param addressSet new value of property addressSet
   */
  public void setAddressSet(final Set<Address> addressSet)
  {
    this.addressSet = addressSet;
  }

  /**
   * Getter for property phoneSet.
   * 
   * @return value of property phoneSet
   */
  public Set<Phone> getPhoneSet()
  {
    return this.phoneSet;
  }

  /**
   * Setter for property phoneSet.
   * 
   * @param phoneSet new value of property phoneSet
   */
  public void setPhoneSet(final Set<Phone> phoneSet)
  {
    this.phoneSet = phoneSet;
  }

  /**
   * Getter for property emailSet.
   * 
   * @return value of property emailSet
   */
  public Set<Email> getEmailSet()
  {
    return this.emailSet;
  }

  /**
   * Setter for property emailSet.
   * 
   * @param emailSet new value of property emailSet
   */
  public void setEmailSet(final Set<Email> emailSet)
  {
    this.emailSet = emailSet;
  }

  /**
   * addToAddress -
   * 
   * @param address
   */
  public void addToAddress(final Address address)
  {
    address.setPerson(this);
    this.addressSet.add(address);
  }

  /**
   * addToPhone -
   * 
   * @param phone
   */
  public void addToPhone(final Phone phone)
  {
    phone.setPerson(this);
    this.phoneSet.add(phone);
  }

  /**
   * addToEmail -
   * 
   * @param email
   */
  public void addToEmail(final Email email)
  {
    email.setPerson(this);
    this.emailSet.add(email);
  }

  /**
   * deleteFromAddress -
   * 
   * @param address
   */
  public void deleteFromAddress(final Address address)
  {
    this.addressSet.remove(address);
    address.setPerson(null);
  }

  /**
   * deleteFromPhone -
   * 
   * @param phone
   */
  public void deleteFromPhone(final Phone phone)
  {
    this.phoneSet.remove(phone);
    phone.setPerson(null);
  }

  /**
   * deleteFromEmail -
   * 
   * @param email
   */
  public void deleteFromEmail(final Email email)
  {
    this.emailSet.remove(email);
    email.setPerson(null);
  }

}
