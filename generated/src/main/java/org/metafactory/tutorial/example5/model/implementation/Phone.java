package org.metafactory.tutorial.example5.model.implementation;

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
import javax.validation.constraints.Size;

/**
 * Phone - Created by MetaFactory: Automation of Software Development
 */
@Entity
@Table(name = "Phone")
public class Phone extends BaseModel implements Serializable
{
  private static final long serialVersionUID = 1;

  /** primary key */
  @Id
  @Column(name = "phone_id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long              phoneId;

  @Column(name = "number", length = 20, nullable = false)
  @NotNull
  @Size(max = 20)
  private String            number;

  @Column(name = "description", columnDefinition = "TEXT", length = 250, nullable = true)
  @Size(max = 250)
  private String            description;

  @JoinColumn(name = "person_person_id", referencedColumnName = "person_id", nullable = true)
  @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  private Person            person;

  @JoinColumn(name = "company_company_id", referencedColumnName = "company_id", nullable = true)
  @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  private Company           company;

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
    if (number == null || number.trim().length() == 0)
    {
      this.number = null;
    }
    else
    {
      this.number = number;
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
   * constructor - Default constructor which loads defaults by using method loadDefaults
   */
  public Phone()
  {
    this(true);
  }

  /**
   * constructor - Constructor with option to load defaults
   * 
   * @param loadDefaults
   */
  public Phone(final boolean loadDefaults)
  {
    if (loadDefaults)
    {
      loadDefaults();
    }
  }

  /**
   * constructor - Constructor with primary key as parameter
   * 
   * @param phoneId
   */
  public Phone(final Long phoneId)
  {
    this.phoneId = phoneId;
  }

  /**
   * getId -
   * 
   * @return Long
   */
  @Override
  public Long getId()
  {
    return getPhoneId();
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
    if (!(other instanceof Phone)) return false;

    final Phone phone = (Phone) other;
    if (this.phoneId != null && phone.getPhoneId() != null)
    {
      return equalsByPK(phone);
    }
    else
    {
      return equalsByBK(phone);
    }
  }

  /**
   * equalsByPK - Return true if primary keys are equal (and not null), otherwise false
   * 
   * @param phone
   * @return boolean
   */
  public boolean equalsByPK(final Phone phone)
  {
    return this.getPhoneId().equals(phone.getPhoneId());
  }

  /**
   * equalsByBK - Fields used as businesskey: 1) number.
   * 
   * @param phone
   * @return boolean
   */
  public boolean equalsByBK(final Phone phone)
  {
    boolean result = true;
    // If all business keys are null, return false
    if (this.getNumber() == null)
    {
      result = false;
    }
    else
    {
      if (this.getNumber() != null && !this.getNumber().equals(phone.getNumber()))
      {
        result = false;
      }
    }
    return result;
  }

  /**
   * hashCode - Fields used as businesskey: 1) number.
   * 
   * @return integer
   */
  public int hashCode()
  {
    int result;
    result = 14;

    if (number != null)
    {
      result = 29 * result + this.getNumber().hashCode();
    }

    return result;
  }

  /**
   * toString - toString based on businesskeys: 1) number.
   * 
   * @return String
   */
  public String toString()
  {
    StringBuilder result = new StringBuilder("Phone: ");

    if (number != null)
    {
      result.append("number=" + number.toString());
    }
    else
    {
      result.append("number=null");
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
