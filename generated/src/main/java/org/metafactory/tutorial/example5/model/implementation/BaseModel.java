package org.metafactory.tutorial.example5.model.implementation;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * BaseModel - Created by MetaFactory: Automation of Software Development
 */
@MappedSuperclass
public abstract class BaseModel
{
  /** version number to implement optimistic locking */
  @Version
  @Column(name = "version", nullable = false, columnDefinition = "integer DEFAULT 0")
  private Integer version;

  /**
   * Getter for property version.
   * 
   * @return value of property version
   */
  public Integer getVersion()
  {
    return this.version;
  }

  /**
   * Setter for property version.
   * 
   * @param version new value of property version
   */
  public void setVersion(final Integer version)
  {
    this.version = version;
  }

  /**
   * getId -
   * 
   * @return Long
   */
  public abstract Long getId();

}
