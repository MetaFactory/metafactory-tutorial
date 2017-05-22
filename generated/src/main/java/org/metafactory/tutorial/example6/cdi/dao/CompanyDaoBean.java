package org.metafactory.tutorial.example6.cdi.dao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.metafactory.tutorial.example6.model.implementation.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CompanyDaoBean - Created by MetaFactory: Automation of Software Development
 */
@Named
@Transactional(TxType.MANDATORY)
public class CompanyDaoBean extends tutorialExample6RootBean<Company> implements Serializable
{
  private static final Logger LOG              = LoggerFactory.getLogger(CompanyDaoBean.class.getName());

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
    super.setPersistentClass(Company.class);
  }

  /**
   * update - Update method
   * 
   * @param entity
   * @return Company
   */
  public Company update(final Company entity)
  {
    return super.merge(entity);
  }

  /**
   * delete - Delete method
   * 
   * @param entity
   */
  public void delete(final Company entity)
  {
    super.delete(entity.getCompanyId());
  }

}
