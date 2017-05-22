package org.metafactory.tutorial.example7.cdi.dao;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.metafactory.tutorial.example7.model.implementation.Person;
import org.picketlink.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PersonDaoBean - Created by MetaFactory: Automation of Software Development
 */
@Named
@Transactional(TxType.MANDATORY)
public class PersonDaoBean extends tutorialExample7RootBean<Person> implements Serializable
{
  private static final Logger LOG              = LoggerFactory.getLogger(PersonDaoBean.class.getName());

  private static final long   serialVersionUID = 1L;

  /** The Entity Manager */
  @Inject
  protected EntityManager     em;

  @Inject
  private Identity            identity;

  /**
   * Getter for property em.
   * 
   * @return value of property em
   */
  public EntityManager getEm()
  {
    return this.em;
  }

  /**
   * Getter for property identity.
   * 
   * @return value of property identity
   */
  public Identity getIdentity()
  {
    return this.identity;
  }

  /**
   * Setter for property identity.
   * 
   * @param identity new value of property identity
   */
  public void setIdentity(final Identity identity)
  {
    this.identity = identity;
  }

  /**
   * setPersistentClass -
   */
  @PostConstruct
  public void setPersistentClass()
  {
    super.setPersistentClass(Person.class);
  }

  /**
   * save - Generic save method
   * 
   * @param entity
   * @return Person
   */
  public Person save(final Person entity)
  {
    Date created = new Date();
    String creator = identity.getAccount().getId();
    entity.setCreated(created);
    entity.setCreator(creator);
    entity.setModified(created);
    entity.setModifier(creator);

    return super.save(entity);
  }

  /**
   * update - Update method
   * 
   * @param entity
   * @return Person
   */
  public Person update(final Person entity)
  {
    Date modified = new Date();
    String modifier = identity.getAccount().getId();
    entity.setModified(modified);
    entity.setModifier(modifier);

    return super.merge(entity);
  }

  /**
   * delete - Delete method
   * 
   * @param entity
   */
  public void delete(final Person entity)
  {
    super.delete(entity.getPersonId());
  }

}
