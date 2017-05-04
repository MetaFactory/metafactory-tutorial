package org.metafactory.tutorial.example2.model.implementation;

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
    this.key = key;
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

}
