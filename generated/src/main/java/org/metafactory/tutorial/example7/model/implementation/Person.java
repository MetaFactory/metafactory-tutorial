package org.metafactory.tutorial.example7.model.implementation;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Person - Created by MetaFactory: Automation of Software Development
 */
@Entity
@Table(name = "Person")
public class Person extends BaseModel implements Serializable
{
  private static final long serialVersionUID = 1;

  /** primary key */
  @Id
  @Column(name = "person_id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long              personId;

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

  @Column(name = "firstName", length = 40, nullable = false)
  @NotNull
  @Size(max = 40)
  private String            firstName;

  @Column(name = "middleName", length = 10, nullable = true)
  @Size(max = 10)
  private String            middleName;

  @Column(name = "lastName", length = 60, nullable = false)
  @NotNull
  @Size(max = 60)
  private String            lastName;

  @Column(name = "birthDate", nullable = true)
  private Date              birthDate;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Set<Address>      addressSet       = new HashSet<Address>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Set<Phone>        phoneSet         = new HashSet<Phone>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private Set<Email>        emailSet         = new HashSet<Email>();

  /**
   * Getter for property personId.
   * 
   * @return value of property personId
   */
  public Long getPersonId()
  {
    return this.personId;
  }

  /**
   * Setter for property personId.
   * 
   * @param personId new value of property personId
   */
  public void setPersonId(final Long personId)
  {
    this.personId = personId;
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
   * Getter for property firstName.
   * 
   * @return value of property firstName
   */
  public String getFirstName()
  {
    return this.firstName;
  }

  /**
   * Setter for property firstName.
   * 
   * @param firstName new value of property firstName
   */
  public void setFirstName(final String firstName)
  {
    if (firstName == null || firstName.trim().length() == 0)
    {
      this.firstName = null;
    }
    else
    {
      this.firstName = firstName;
    }
  }

  /**
   * Getter for property middleName.
   * 
   * @return value of property middleName
   */
  public String getMiddleName()
  {
    return this.middleName;
  }

  /**
   * Setter for property middleName.
   * 
   * @param middleName new value of property middleName
   */
  public void setMiddleName(final String middleName)
  {
    if (middleName == null || middleName.trim().length() == 0)
    {
      this.middleName = null;
    }
    else
    {
      this.middleName = middleName;
    }
  }

  /**
   * Getter for property lastName.
   * 
   * @return value of property lastName
   */
  public String getLastName()
  {
    return this.lastName;
  }

  /**
   * Setter for property lastName.
   * 
   * @param lastName new value of property lastName
   */
  public void setLastName(final String lastName)
  {
    if (lastName == null || lastName.trim().length() == 0)
    {
      this.lastName = null;
    }
    else
    {
      this.lastName = lastName;
    }
  }

  /**
   * Getter for property birthDate.
   * 
   * @return value of property birthDate
   */
  public Date getBirthDate()
  {
    return this.birthDate;
  }

  /**
   * Setter for property birthDate.
   * 
   * @param birthDate new value of property birthDate
   */
  public void setBirthDate(final Date birthDate)
  {
    this.birthDate = birthDate;
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
   * Getter for property phoneSet.
   * 
   * @return value of property phoneSet
   */
  public Set<Phone> getPhoneSet()
  {
    return this.phoneSet;
  }

  /**
   * Setter for property phoneSet.
   * 
   * @param phoneSet new value of property phoneSet
   */
  public void setPhoneSet(final Set<Phone> phoneSet)
  {
    this.phoneSet = phoneSet;
  }

  /**
   * Getter for property emailSet.
   * 
   * @return value of property emailSet
   */
  public Set<Email> getEmailSet()
  {
    return this.emailSet;
  }

  /**
   * Setter for property emailSet.
   * 
   * @param emailSet new value of property emailSet
   */
  public void setEmailSet(final Set<Email> emailSet)
  {
    this.emailSet = emailSet;
  }

  /**
   * constructor - Default constructor which loads defaults by using method loadDefaults
   */
  public Person()
  {
    this(true);
  }

  /**
   * constructor - Constructor with option to load defaults
   * 
   * @param loadDefaults
   */
  public Person(final boolean loadDefaults)
  {
    if (loadDefaults)
    {
      loadDefaults();
    }
  }

  /**
   * constructor - Constructor with primary key as parameter
   * 
   * @param personId
   */
  public Person(final Long personId)
  {
    this.personId = personId;
  }

  /**
   * getId -
   * 
   * @return Long
   */
  @Override
  public Long getId()
  {
    return getPersonId();
  }

  /**
   * addToAddress -
   * 
   * @param address
   */
  public void addToAddress(final Address address)
  {
    address.setPerson(this);
    this.addressSet.add(address);
  }

  /**
   * addToPhone -
   * 
   * @param phone
   */
  public void addToPhone(final Phone phone)
  {
    phone.setPerson(this);
    this.phoneSet.add(phone);
  }

  /**
   * addToEmail -
   * 
   * @param email
   */
  public void addToEmail(final Email email)
  {
    email.setPerson(this);
    this.emailSet.add(email);
  }

  /**
   * deleteFromAddress -
   * 
   * @param address
   */
  public void deleteFromAddress(final Address address)
  {
    this.addressSet.remove(address);
    address.setPerson(null);
  }

  /**
   * deleteFromPhone -
   * 
   * @param phone
   */
  public void deleteFromPhone(final Phone phone)
  {
    this.phoneSet.remove(phone);
    phone.setPerson(null);
  }

  /**
   * deleteFromEmail -
   * 
   * @param email
   */
  public void deleteFromEmail(final Email email)
  {
    this.emailSet.remove(email);
    email.setPerson(null);
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
    if (!(other instanceof Person)) return false;

    final Person person = (Person) other;
    if (this.personId != null && person.getPersonId() != null)
    {
      return equalsByPK(person);
    }
    else
    {
      return equalsByBK(person);
    }
  }

  /**
   * equalsByPK - Return true if primary keys are equal (and not null), otherwise false
   * 
   * @param person
   * @return boolean
   */
  public boolean equalsByPK(final Person person)
  {
    return this.getPersonId().equals(person.getPersonId());
  }

  /**
   * equalsByBK - Fields used as businesskey: 1) lastName 2) firstName 3) middleName.
   * 
   * @param person
   * @return boolean
   */
  public boolean equalsByBK(final Person person)
  {
    boolean result = true;
    // If all business keys are null, return false
    if (this.getLastName() == null && this.getFirstName() == null && this.getMiddleName() == null)
    {
      result = false;
    }
    else
    {
      if (this.getLastName() != null && !this.getLastName().equals(person.getLastName()))
      {
        result = false;
      }
      else if (this.getFirstName() != null && !this.getFirstName().equals(person.getFirstName()))
      {
        result = false;
      }
      else if (this.getMiddleName() != null && !this.getMiddleName().equals(person.getMiddleName()))
      {
        result = false;
      }
    }
    return result;
  }

  /**
   * hashCode - Fields used as businesskey: 1) firstName 2) middleName 3) lastName.
   * 
   * @return integer
   */
  public int hashCode()
  {
    int result;
    result = 14;

    if (firstName != null)
    {
      result = 29 * result + this.getFirstName().hashCode();
    }
    if (middleName != null)
    {
      result = 29 * result + this.getMiddleName().hashCode();
    }
    if (lastName != null)
    {
      result = 29 * result + this.getLastName().hashCode();
    }

    return result;
  }

  /**
   * toString - toString based on businesskeys: 1) lastName 2) firstName 3) middleName.
   * 
   * @return String
   */
  public String toString()
  {
    StringBuilder result = new StringBuilder("Person: ");

    if (lastName != null)
    {
      result.append("lastName=" + lastName.toString());
    }
    else
    {
      result.append("lastName=null");
    }
    result.append(", ");

    if (firstName != null)
    {
      result.append("firstName=" + firstName.toString());
    }
    else
    {
      result.append("firstName=null");
    }
    result.append(", ");

    if (middleName != null)
    {
      result.append("middleName=" + middleName.toString());
    }
    else
    {
      result.append("middleName=null");
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
