package org.metafactory.tutorial.example6.model.implementation;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Address - Created by MetaFactory: Automation of Software Development
 */
@Entity
@Table(name = "Address")
public class Address extends BaseModel implements Serializable
{
  private static final long serialVersionUID = 1;

  /** primary key */
  @Id
  @Column(name = "address_id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long              addressId;

  @Column(name = "streetName", nullable = false)
  @NotNull
  private String            streetName;

  @Column(name = "zipCode", nullable = true)
  private String            zipCode;

  @Column(name = "city", nullable = false)
  @NotNull
  private String            city;

  @Column(name = "country", nullable = true)
  private String            country          = "Nederland";

  @Column(name = "description", columnDefinition = "TEXT", nullable = true)
  private String            description;

  @JoinColumn(name = "type_addresstype_id", referencedColumnName = "addresstype_id", nullable = false)
  @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  private AddressType       type;

  @JoinColumn(name = "person_person_id", referencedColumnName = "person_id", nullable = true)
  @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  private Person            person;

  @JoinColumn(name = "company_company_id", referencedColumnName = "company_id", nullable = true)
  @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  private Company           company;

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
   * constructor - Default constructor which loads defaults by using method loadDefaults
   */
  public Address()
  {
    this(true);
  }

  /**
   * constructor - Constructor with option to load defaults
   * 
   * @param loadDefaults
   */
  public Address(final boolean loadDefaults)
  {
    if (loadDefaults)
    {
      loadDefaults();
    }
  }

  /**
   * constructor - Constructor with primary key as parameter
   * 
   * @param addressId
   */
  public Address(final Long addressId)
  {
    this.addressId = addressId;
  }

  /**
   * getId -
   * 
   * @return Long
   */
  @Override
  public Long getId()
  {
    return getAddressId();
  }

  /**
   * equals -
   * 
   * @param other
   * @return boolean
   */
  public boolean equals(final Object other)
  {
    if (other == null) return false;
    if (this == other) return true;
    if (!(other instanceof Address)) return false;

    final Address address = (Address) other;
    if (this.addressId != null && address.getAddressId() != null)
    {
      return equalsByPK(address);
    }
    else
    {
      return equalsByBK(address);
    }
  }

  /**
   * equalsByPK - Return true if primary keys are equal (and not null), otherwise false
   * 
   * @param address
   * @return boolean
   */
  public boolean equalsByPK(final Address address)
  {
    return this.getAddressId().equals(address.getAddressId());
  }

  /**
   * equalsByBK - Fields used as businesskey: 1) city 2) streetName 3) zipCode.
   * 
   * @param address
   * @return boolean
   */
  public boolean equalsByBK(final Address address)
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
   * toString - toString based on businesskeys: 1) city 2) streetName 3) zipCode.
   * 
   * @return String
   */
  public String toString()
  {
    StringBuilder result = new StringBuilder("Address: ");

    if (city != null)
    {
      result.append("city=" + city.toString());
    }
    else
    {
      result.append("city=null");
    }
    result.append(", ");

    if (streetName != null)
    {
      result.append("streetName=" + streetName.toString());
    }
    else
    {
      result.append("streetName=null");
    }
    result.append(", ");

    if (zipCode != null)
    {
      result.append("zipCode=" + zipCode.toString());
    }
    else
    {
      result.append("zipCode=null");
    }
    return result.toString();
  }

  /**
   * loadDefaults - load default values of some fields
   */
  public void loadDefaults()
  {
    this.country = "Nederland";
  }

}
