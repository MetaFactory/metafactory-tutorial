package org.metafactory.tutorial.example6.model.implementation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Company - Created by MetaFactory: Automation of Software Development
 * 
 * @author - Merijn
 */
@Entity
@Table(name = "Company")
public class Company extends BaseModel implements Serializable
{
  private static final long serialVersionUID = 1;

  /** primary key */
  @Id
  @Column(name = "company_id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long              companyId;

  @Column(name = "name", length = 120, nullable = false)
  @NotNull
  @Size(max = 120)
  private String            name;

  @Column(name = "description", columnDefinition = "TEXT", nullable = true)
  private String            description;

  @JoinColumn(name = "phone_phone_id", referencedColumnName = "phone_id", nullable = true)
  @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  private Phone             phone;

  @JoinColumn(name = "email_email_id", referencedColumnName = "email_id", nullable = true)
  @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  private Email             email;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Set<Address>      addressSet       = new HashSet<Address>();

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
    if (name == null || name.trim().length() == 0)
    {
      this.name = null;
    }
    else
    {
      this.name = name;
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
   * constructor - Default constructor which loads defaults by using method loadDefaults
   */
  public Company()
  {
    this(true);
  }

  /**
   * constructor - Constructor with option to load defaults
   * 
   * @param loadDefaults
   */
  public Company(final boolean loadDefaults)
  {
    if (loadDefaults)
    {
      loadDefaults();
    }
  }

  /**
   * constructor - Constructor with primary key as parameter
   * 
   * @param companyId
   */
  public Company(final Long companyId)
  {
    this.companyId = companyId;
  }

  /**
   * getId -
   * 
   * @return Long
   */
  @Override
  public Long getId()
  {
    return getCompanyId();
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
    if (!(other instanceof Company)) return false;

    final Company company = (Company) other;
    if (this.companyId != null && company.getCompanyId() != null)
    {
      return equalsByPK(company);
    }
    else
    {
      return equalsByBK(company);
    }
  }

  /**
   * equalsByPK - Return true if primary keys are equal (and not null), otherwise false
   * 
   * @param company
   * @return boolean
   */
  public boolean equalsByPK(final Company company)
  {
    return this.getCompanyId().equals(company.getCompanyId());
  }

  /**
   * equalsByBK - Fields used as businesskey: 1) name.
   * 
   * @param company
   * @return boolean
   */
  public boolean equalsByBK(final Company company)
  {
    boolean result = true;
    // If all business keys are null, return false
    if (this.getName() == null)
    {
      result = false;
    }
    else
    {
      if (this.getName() != null && !this.getName().equals(company.getName()))
      {
        result = false;
      }
    }
    return result;
  }

  /**
   * hashCode - Fields used as businesskey: 1) name.
   * 
   * @return integer
   */
  public int hashCode()
  {
    int result;
    result = 14;

    if (name != null)
    {
      result = 29 * result + this.getName().hashCode();
    }

    return result;
  }

  /**
   * toString - toString based on businesskeys: 1) name.
   * 
   * @return String
   */
  public String toString()
  {
    StringBuilder result = new StringBuilder("Company: ");

    if (name != null)
    {
      result.append("name=" + name.toString());
    }
    else
    {
      result.append("name=null");
    }
    return result.toString();
  }

  /**
   * loadDefaults - load default values of some fields
   */
  public void loadDefaults()
  {

  }

}
