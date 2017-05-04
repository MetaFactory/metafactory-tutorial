package org.metafactory.tutorial.example2.model.implementation;

import java.util.HashSet;
import java.util.Set;

/**
 * Company - Created by MetaFactory: Automation of Software Development
 */
public class Company
{
  /** primary key */
  private Long         companyId;

  private String       name;

  private String       description;

  private Phone        phone;

  private Email        email;

  private Set<Address> addressSet = new HashSet<Address>();

  /**
   * Getter for property companyId.
   * 
   * @return value of property companyId
   */
  public Long getCompanyId()
  {
    return this.companyId;
  }

  /**
   * Setter for property companyId.
   * 
   * @param companyId new value of property companyId
   */
  public void setCompanyId(final Long companyId)
  {
    this.companyId = companyId;
  }

  /**
   * Getter for property name.
   * 
   * @return value of property name
   */
  public String getName()
  {
    return this.name;
  }

  /**
   * Setter for property name.
   * 
   * @param name new value of property name
   */
  public void setName(final String name)
  {
    this.name = name;
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
   * Getter for property phone.
   * 
   * @return value of property phone
   */
  public Phone getPhone()
  {
    return this.phone;
  }

  /**
   * Setter for property phone.
   * 
   * @param phone new value of property phone
   */
  public void setPhone(final Phone phone)
  {
    this.phone = phone;
  }

  /**
   * Getter for property email.
   * 
   * @return value of property email
   */
  public Email getEmail()
  {
    return this.email;
  }

  /**
   * Setter for property email.
   * 
   * @param email new value of property email
   */
  public void setEmail(final Email email)
  {
    this.email = email;
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
   * addToAddress -
   * 
   * @param address
   */
  public void addToAddress(final Address address)
  {
    address.setCompany(this);
    this.addressSet.add(address);
  }

  /**
   * deleteFromAddress -
   * 
   * @param address
   */
  public void deleteFromAddress(final Address address)
  {
    this.addressSet.remove(address);
    address.setCompany(null);
  }

}
