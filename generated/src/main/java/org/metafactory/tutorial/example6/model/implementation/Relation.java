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
 * Relation - Created by MetaFactory: Automation of Software Development
 */
@Entity
@Table(name = "Relation")
public class Relation extends BaseModel implements Serializable
{
  private static final long serialVersionUID = 1;

  /** primary key */
  @Id
  @Column(name = "relation_id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long              relationId;

  @Column(name = "type", nullable = false)
  @NotNull
  private RelationType      type;

  @JoinColumn(name = "person_person_id", referencedColumnName = "person_id", nullable = true)
  @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  private Person            person;

  @JoinColumn(name = "company_company_id", referencedColumnName = "company_id", nullable = true)
  @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  private Company           company;

  /**
   * Getter for property relationId.
   * 
   * @return value of property relationId
   */
  public Long getRelationId()
  {
    return this.relationId;
  }

  /**
   * Setter for property relationId.
   * 
   * @param relationId new value of property relationId
   */
  public void setRelationId(final Long relationId)
  {
    this.relationId = relationId;
  }

  /**
   * Getter for property type.
   * 
   * @return value of property type
   */
  public RelationType getType()
  {
    return this.type;
  }

  /**
   * Setter for property type.
   * 
   * @param type new value of property type
   */
  public void setType(final RelationType type)
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
  public Relation()
  {
    this(true);
  }

  /**
   * constructor - Constructor with option to load defaults
   * 
   * @param loadDefaults
   */
  public Relation(final boolean loadDefaults)
  {
    if (loadDefaults)
    {
      loadDefaults();
    }
  }

  /**
   * constructor - Constructor with primary key as parameter
   * 
   * @param relationId
   */
  public Relation(final Long relationId)
  {
    this.relationId = relationId;
  }

  /**
   * constructor -
   * 
   * @param type
   * @param person
   */
  public Relation(final RelationType type, final Person person)
  {
    this.type = type;
    this.person = person;
  }

  /**
   * constructor -
   * 
   * @param type
   * @param company
   */
  public Relation(final RelationType type, final Company company)
  {
    this.type = type;
    this.company = company;
  }

  /**
   * getId -
   * 
   * @return Long
   */
  @Override
  public Long getId()
  {
    return getRelationId();
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
    if (!(other instanceof Relation)) return false;

    final Relation relation = (Relation) other;
    if (this.relationId != null && relation.getRelationId() != null)
    {
      return equalsByPK(relation);
    }
    else
    {
      return equalsByBK(relation);
    }
  }

  /**
   * equalsByPK - Return true if primary keys are equal (and not null), otherwise false
   * 
   * @param relation
   * @return boolean
   */
  public boolean equalsByPK(final Relation relation)
  {
    return this.getRelationId().equals(relation.getRelationId());
  }

  /**
   * equalsByBK - Fields used as businesskey: 1) person 2) type 3) company.
   * 
   * @param relation
   * @return boolean
   */
  public boolean equalsByBK(final Relation relation)
  {
    boolean result = true;
    // If all business keys are null, return false
    if (this.getPerson() == null && this.getType() == null && this.getCompany() == null)
    {
      result = false;
    }
    else
    {
      if (this.getPerson() != null && !this.getPerson().equals(relation.getPerson()))
      {
        result = false;
      }
      else if (this.getType() != null && !this.getType().equals(relation.getType()))
      {
        result = false;
      }
      else if (this.getCompany() != null && !this.getCompany().equals(relation.getCompany()))
      {
        result = false;
      }
    }
    return result;
  }

  /**
   * hashCode - Fields used as businesskey: 1) type 2) person 3) company.
   * 
   * @return integer
   */
  public int hashCode()
  {
    int result;
    result = 14;

    if (type != null)
    {
      result = 17 * result + type.hashCode();
    }
    if (person != null)
    {
      result = 17 * result + person.hashCode();
    }
    if (company != null)
    {
      result = 17 * result + company.hashCode();
    }

    return result;
  }

  /**
   * toString - toString based on businesskeys: 1) person 2) type 3) company.
   * 
   * @return String
   */
  public String toString()
  {
    StringBuilder result = new StringBuilder("Relation: ");

    if (person != null)
    {
      result.append("person=" + person.toString());
    }
    else
    {
      result.append("person=null");
    }
    result.append(", ");
    if (type != null)
    {
      result.append("type=" + type.toString());
    }
    else
    {
      result.append("type=null");
    }
    result.append(", ");
    if (company != null)
    {
      result.append("company=" + company.toString());
    }
    else
    {
      result.append("company=null");
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
