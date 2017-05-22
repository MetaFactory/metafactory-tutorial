package org.metafactory.tutorial.example6.cdi.dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.metafactory.tutorial.example6.model.implementation.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * EmailDaoBean - Created by MetaFactory: Automation of Software Development
 */
@Named
@Transactional(TxType.MANDATORY)
public class EmailDaoBean extends tutorialExample6RootBean<Email> implements Serializable
{
  private static final Logger LOG              = LoggerFactory.getLogger(EmailDaoBean.class.getName());

  private static final long   serialVersionUID = 1L;

  /** The Entity Manager */
  @Inject
  protected EntityManager     em;

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
   * setPersistentClass -
   */
  @PostConstruct
  public void setPersistentClass()
  {
    super.setPersistentClass(Email.class);
  }

  /**
   * update - Update method
   * 
   * @param entity
   * @return Email
   */
  public Email update(final Email entity)
  {
    return super.merge(entity);
  }

  /**
   * delete - Delete method
   * 
   * @param entity
   */
  public void delete(final Email entity)
  {
    super.delete(entity.getEmailId());
  }

}
