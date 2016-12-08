package org.metafactory.tutorial.example3.model.implementation;

/**
 * AddressType - Created by MetaFactory: Automation of Software Development
 * 
 * @author - Merijn
 */
public class AddressType
{
  /** primary key */
  private Long    id;

  /** Unique key */
  private String  key;

  /** Numeric value used for sorting */
  private Integer qualifier;

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
