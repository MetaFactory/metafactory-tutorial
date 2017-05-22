package org.metafactory.tutorial.example4.model.implementation;

/**
 * AddressType - Created by MetaFactory: Automation of Software Development
 */
public class AddressType
{
  /** primary key */
  private Long    addressTypeId;

  /** Unique key */
  private String  key;

  /** Numeric value used for sorting */
  private Integer qualifier;

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
   * equals - Fields used as businesskey: 1) key.
   * 
   * @param addressType
   * @return boolean
   */
  public boolean equals(final AddressType addressType)
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
   * toString -
   * 
   * @return String
   */
  public String toString()
  {
    StringBuilder result = new StringBuilder("AddressType: ");

    result.append("key=" + key);
    result.append(", ");

    result.append("qualifier=" + qualifier.toString());

    return result.toString();
  }

}
