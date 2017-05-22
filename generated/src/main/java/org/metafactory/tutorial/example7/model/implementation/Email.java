package org.metafactory.tutorial.example7.model.implementation;

import java.io.Serializable;
import java.util.Date;

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
 * Email - Created by MetaFactory: Automation of Software Development
 */
@Entity
@Table(name = "Email")
public class Email extends BaseModel implements Serializable
{
  private static final long serialVersionUID = 1;

  /** primary key */
  @Id
  @Column(name = "email_id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long              emailId;

  /** Creation time of record */
  @Column(name = "created", nullable = false)
  @NotNull
  private Date              created;

  /** Username who created this record */
  @Column(name = "creator", nullable = false)
  @NotNull
  private String            creator;

  /** Modification time of record */
  @Column(name = "modified", nullable = false)
  @NotNull
  private Date              modified;

  /** Username who modified this record */
  @Column(name = "modifier", nullable = false)
  @NotNull
  private String            modifier;

  @Column(name = "emailAddress", length = 80, nullable = false)
  @NotNull
  @Size(max = 80)
  private String            emailAddress;

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
   * Getter for property emailId.
   * 
   * @return value of property emailId
   */
  public Long getEmailId()
  {
    return this.emailId;
  }

  /**
   * Setter for property emailId.
   * 
   * @param emailId new value of property emailId
   */
  public void setEmailId(final Long emailId)
  {
    this.emailId = emailId;
  }

  /**
   * Getter for property created.
   * 
   * @return value of property created
   */
  public Date getCreated()
  {
    return this.created;
  }

  /**
   * Setter for property created.
   * 
   * @param created new value of property created
   */
  public void setCreated(final Date created)
  {
    this.created = created;
  }

  /**
   * Getter for property creator.
   * 
   * @return value of property creator
   */
  public String getCreator()
  {
    return this.creator;
  }

  /**
   * Setter for property creator.
   * 
   * @param creator new value of property creator
   */
  public void setCreator(final String creator)
  {
    this.creator = creator;
  }

  /**
   * Getter for property modified.
   * 
   * @return value of property modified
   */
  public Date getModified()
  {
    return this.modified;
  }

  /**
   * Setter for property modified.
   * 
   * @param modified new value of property modified
   */
  public void setModified(final Date modified)
  {
    this.modified = modified;
  }

  /**
   * Getter for property modifier.
   * 
   * @return value of property modifier
   */
  public String getModifier()
  {
    return this.modifier;
  }

  /**
   * Setter for property modifier.
   * 
   * @param modifier new value of property modifier
   */
  public void setModifier(final String modifier)
  {
    this.modifier = modifier;
  }

  /**
   * Getter for property emailAddress.
   * 
   * @return value of property emailAddress
   */
  public String getEmailAddress()
  {
    return this.emailAddress;
  }

  /**
   * Setter for property emailAddress.
   * 
   * @param emailAddress new value of property emailAddress
   */
  public void setEmailAddress(final String emailAddress)
  {
    if (emailAddress == null || emailAddress.trim().length() == 0)
    {
      this.emailAddress = null;
    }
    else
    {
      this.emailAddress = emailAddress;
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
  public Email()
  {
    this(true);
  }

  /**
   * constructor - Constructor with option to load defaults
   * 
   * @param loadDefaults
   */
  public Email(final boolean loadDefaults)
  {
    if (loadDefaults)
    {
      loadDefaults();
    }
  }

  /**
   * constructor - Constructor with primary key as parameter
   * 
   * @param emailId
   */
  public Email(final Long emailId)
  {
    this.emailId = emailId;
  }

  /**
   * constructor -
   * 
   * @param emailAddress
   */
  public Email(final String emailAddress)
  {
    this.emailAddress = emailAddress;
  }

  /**
   * getId -
   * 
   * @return Long
   */
  @Override
  public Long getId()
  {
    return getEmailId();
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
    if (!(other instanceof Email)) return false;

    final Email email = (Email) other;
    if (this.emailId != null && email.getEmailId() != null)
    {
      return equalsByPK(email);
    }
    else
    {
      return equalsByBK(email);
    }
  }

  /**
   * equalsByPK - Return true if primary keys are equal (and not null), otherwise false
   * 
   * @param email
   * @return boolean
   */
  public boolean equalsByPK(final Email email)
  {
    return this.getEmailId().equals(email.getEmailId());
  }

  /**
   * equalsByBK - Fields used as businesskey: 1) emailAddress.
   * 
   * @param email
   * @return boolean
   */
  public boolean equalsByBK(final Email email)
  {
    boolean result = true;
    // If all business keys are null, return false
    if (this.getEmailAddress() == null)
    {
      result = false;
    }
    else
    {
      if (this.getEmailAddress() != null && !this.getEmailAddress().equals(email.getEmailAddress()))
      {
        result = false;
      }
    }
    return result;
  }

  /**
   * hashCode - Fields used as businesskey: 1) emailAddress.
   * 
   * @return integer
   */
  public int hashCode()
  {
    int result;
    result = 14;

    if (emailAddress != null)
    {
      result = 29 * result + this.getEmailAddress().hashCode();
    }

    return result;
  }

  /**
   * toString - toString based on businesskeys: 1) emailAddress.
   * 
   * @return String
   */
  public String toString()
  {
    StringBuilder result = new StringBuilder("Email: ");

    if (emailAddress != null)
    {
      result.append("emailAddress=" + emailAddress.toString());
    }
    else
    {
      result.append("emailAddress=null");
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
