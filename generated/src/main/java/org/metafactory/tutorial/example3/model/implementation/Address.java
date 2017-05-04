package org.metafactory.tutorial.example3.model.implementation;

/**
 * Address - Created by MetaFactory: Automation of Software Development
 */
public class Address
{
  /** primary key */
  private Long        id;

  private String      streetName;

  private String      zipCode;

  private String      city;

  private String      country = "Nederland";

  private String      description;

  private AddressType type;

  private Person      person;

  private Company     company;

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
    if (streetName == null || streetName.trim().length() == 0)
    {
      this.streetName = null;
    }
    else
    {
      this.streetName = streetName;
    }
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
    if (zipCode == null || zipCode.trim().length() == 0)
    {
      this.zipCode = null;
    }
    else
    {
      this.zipCode = zipCode;
    }
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
    if (city == null || city.trim().length() == 0)
    {
      this.city = null;
    }
    else
    {
      this.city = city;
    }
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
    if (country == null || country.trim().length() == 0)
    {
      this.country = null;
    }
    else
    {
      this.country = country;
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
   * equals - Fields used as businesskey: 1) city 2) streetName 3) zipCode.
   * 
   * @param address
   * @return boolean
   */
  public boolean equals(final Address address)
  {
    boolean result = true;
    // If all business keys are null, return false
    if (this.getCity() == null && this.getStreetName() == null && this.getZipCode() == null)
    {
      result = false;
    }
    else
    {
      if (this.getCity() != null && !this.getCity().equals(address.getCity()))
      {
        result = false;
      }
      else if (this.getStreetName() != null && !this.getStreetName().equals(address.getStreetName()))
      {
        result = false;
      }
      else if (this.getZipCode() != null && !this.getZipCode().equals(address.getZipCode()))
      {
        result = false;
      }
    }
    return result;
  }

  /**
   * hashCode - Fields used as businesskey: 1) streetName 2) zipCode 3) city.
   * 
   * @return integer
   */
  public int hashCode()
  {
    int result;
    result = 14;

    if (streetName != null)
    {
      result = 29 * result + this.getStreetName().hashCode();
    }
    if (zipCode != null)
    {
      result = 29 * result + this.getZipCode().hashCode();
    }
    if (city != null)
    {
      result = 29 * result + this.getCity().hashCode();
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
    StringBuilder result = new StringBuilder("Address: ");

    result.append("streetName=" + streetName);
    result.append(", ");

    result.append("zipCode=" + zipCode);
    result.append(", ");

    result.append("city=" + city);
    result.append(", ");

    result.append("country=" + country);
    result.append(", ");

    result.append("description=" + description);

    return result.toString();
  }

}
