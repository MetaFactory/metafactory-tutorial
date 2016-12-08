package org.metafactory.tutorial.example6.model.implementation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * AddressType - Created by MetaFactory: Automation of Software Development
 * 
 * @author - Merijn
 */
@Entity
@Table(name = "AddressType")
public class AddressType extends BaseModel implements Serializable
{
  private static final long serialVersionUID = 1;

  /** primary key */
  @Id
  @Column(name = "addresstype_id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long              addressTypeId;

  /** Unique key */
  @Column(name = "key", nullable = false)
  @NotNull
  private String            key;

  /** Numeric value used for sorting */
  @Column(name = "qualifier", nullable = true)
  private Integer           qualifier;

  /**
   * Getter for property addressTypeId.
   * 
   * @return value of property addressTypeId
   */
  public Long getAddressTypeId()
  {
    return this.addressTypeId;
  }

  /**
   * Setter for property addressTypeId.
   * 
   * @param addressTypeId new value of property addressTypeId
   */
  public void setAddressTypeId(final Long addressTypeId)
  {
    this.addressTypeId = addressTypeId;
  }

  /**
   * Getter for property key.
   * 
   * @return value of property key
   */
  public String getKey()
  {
    return this.key;
  }

  /**
   * Setter for property key.
   * 
   * @param key new value of property key
   */
  public void setKey(final String key)
  {
    if (key == null || key.trim().length() == 0)
    {
      this.key = null;
    }
    else
    {
      this.key = key;
    }
  }

  /**
   * Getter for property qualifier.
   * 
   * @return value of property qualifier
   */
  public Integer getQualifier()
  {
    return this.qualifier;
  }

  /**
   * Setter for property qualifier.
   * 
   * @param qualifier new value of property qualifier
   */
  public void setQualifier(final Integer qualifier)
  {
    this.qualifier = qualifier;
  }

  /**
   * constructor - Default constructor which loads defaults by using method loadDefaults
   */
  public AddressType()
  {
    this(true);
  }

  /**
   * constructor - Constructor with option to load defaults
   * 
   * @param loadDefaults
   */
  public AddressType(final boolean loadDefaults)
  {
    if (loadDefaults)
    {
      loadDefaults();
    }
  }

  /**
   * constructor - Constructor with primary key as parameter
   * 
   * @param addressTypeId
   */
  public AddressType(final Long addressTypeId)
  {
    this.addressTypeId = addressTypeId;
  }

  /**
   * getId -
   * 
   * @return Long
   */
  @Override
  public Long getId()
  {
    return getAddressTypeId();
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
    if (!(other instanceof AddressType)) return false;

    final AddressType addressType = (AddressType) other;
    if (this.addressTypeId != null && addressType.getAddressTypeId() != null)
    {
      return equalsByPK(addressType);
    }
    else
    {
      return equalsByBK(addressType);
    }
  }

  /**
   * equalsByPK - Return true if primary keys are equal (and not null), otherwise false
   * 
   * @param addressType
   * @return boolean
   */
  public boolean equalsByPK(final AddressType addressType)
  {
    return this.getAddressTypeId().equals(addressType.getAddressTypeId());
  }

  /**
   * equalsByBK - Fields used as businesskey: 1) key.
   * 
   * @param addressType
   * @return boolean
   */
  public boolean equalsByBK(final AddressType addressType)
  {
    boolean result = true;
    // If all business keys are null, return false
    if (this.getKey() == null)
    {
      result = false;
    }
    else
    {
      if (this.getKey() != null && !this.getKey().equals(addressType.getKey()))
      {
        result = false;
      }
    }
    return result;
  }

  /**
   * hashCode - Fields used as businesskey: 1) key.
   * 
   * @return integer
   */
  public int hashCode()
  {
    int result;
    result = 14;

    if (key != null)
    {
      result = 29 * result + this.getKey().hashCode();
    }

    return result;
  }

  /**
   * toString - toString based on businesskeys: 1) key.
   * 
   * @return String
   */
  public String toString()
  {
    StringBuilder result = new StringBuilder("AddressType: ");

    if (key != null)
    {
      result.append("key=" + key.toString());
    }
    else
    {
      result.append("key=null");
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
