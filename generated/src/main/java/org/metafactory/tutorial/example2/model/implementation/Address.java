package org.metafactory.tutorial.example2.model.implementation;

/**
 * Address - Created by MetaFactory: Automation of Software Development
 * 
 * @author - Merijn
 */
public class Address
{
  /** primary key */
  private Long        addressId;

  /** the streetName field */
  private String      streetName;

  /** the zipCode field */
  private String      zipCode;

  /** the city field */
  private String      city;

  /** the country field */
  private String      country;

  /** the description field */
  private String      description;

  private AddressType type;

  private Person      person;

  private Company     company;

  /**
   * Getter for property addressId.
   * 
   * @return value of property addressId
   */
  public Long getAddressId()
  {
    return this.addressId;
  }

  /**
   * Setter for property addressId.
   * 
   * @param addressId new value of property addressId
   */
  public void setAddressId(final Long addressId)
  {
    this.addressId = addressId;
  }

  /**
   * Getter for property streetName.
   * 
   * @return value of property streetName
   */
  public String getStreetName()
  {
    return this.streetName;
  }

  /**
   * Setter for property streetName.
   * 
   * @param streetName new value of property streetName
   */
  public void setStreetName(final String streetName)
  {
    this.streetName = streetName;
  }

  /**
   * Getter for property zipCode.
   * 
   * @return value of property zipCode
   */
  public String getZipCode()
  {
    return this.zipCode;
  }

  /**
   * Setter for property zipCode.
   * 
   * @param zipCode new value of property zipCode
   */
  public void setZipCode(final String zipCode)
  {
    this.zipCode = zipCode;
  }

  /**
   * Getter for property city.
   * 
   * @return value of property city
   */
  public String getCity()
  {
    return this.city;
  }

  /**
   * Setter for property city.
   * 
   * @param city new value of property city
   */
  public void setCity(final String city)
  {
    this.city = city;
  }

  /**
   * Getter for property country.
   * 
   * @return value of property country
   */
  public String getCountry()
  {
    return this.country;
  }

  /**
   * Setter for property country.
   * 
   * @param country new value of property country
   */
  public void setCountry(final String country)
  {
    this.country = country;
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
   * Getter for property type.
   * 
   * @return value of property type
   */
  public AddressType getType()
  {
    return this.type;
  }

  /**
   * Setter for property type.
   * 
   * @param type new value of property type
   */
  public void setType(final AddressType type)
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
  public Address()
  {
    super();
    // do nothing
  }

}
