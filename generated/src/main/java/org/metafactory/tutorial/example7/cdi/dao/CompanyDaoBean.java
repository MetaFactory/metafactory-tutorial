package org.metafactory.tutorial.example7.cdi.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.metafactory.tutorial.example7.model.implementation.Company;
import org.metafactory.tutorial.example7.model.implementation.Company_;
import org.metafactory.tutorial.example7.model.implementation.Phone;
import org.picketlink.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CompanyDaoBean - Created by MetaFactory: Automation of Software Development
 * 
 * @author - Merijn
 */
@Named
@Transactional(TxType.MANDATORY)
public class CompanyDaoBean extends tutorialExample7RootBean<Company> implements Serializable
{
  private static final Logger LOG              = LoggerFactory.getLogger(CompanyDaoBean.class.getName());

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
    super.setPersistentClass(Company.class);
  }

  /**
   * save - Generic save method
   * 
   * @param entity
   * @return Company
   */
  public Company save(final Company entity)
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
   * @return Company
   */
  public Company update(final Company entity)
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
  public void delete(final Company entity)
  {
    super.delete(entity.getCompanyId());
  }

  /**
   * findCompanyByFields -
   * 
   * @param name
   * @param phone
   * @return Company
   */
  public Company findCompanyByFields(final String name, final Phone phone)
  {
    CriteriaBuilder cb = getEm().getCriteriaBuilder();
    CriteriaQuery<Company> cq = cb.createQuery(Company.class);

    Root<Company> fromCompany = cq.from(Company.class);

    Predicate allCriteria = cb.conjunction();

    Expression<Boolean> equalName = cb.equal(fromCompany.get(Company_.name), name);
    allCriteria = cb.and(allCriteria, equalName);

    // join on Phone

    Join<Company, Phone> phoneJoin = fromCompany.join(Company_.phone);
    Expression<Boolean> equalPhone = cb.equal(phoneJoin, phone);
    allCriteria = cb.and(allCriteria, equalPhone);

    cq.select(fromCompany).where(allCriteria);

    TypedQuery<Company> q = getEm().createQuery(cq);

    Company result;
    try
    {
      result = q.getSingleResult();
    }
    catch (NoResultException nre)
    {
      result = null;
    }

    return result;
  }

  /**
   * findCompaniesByFields -
   * 
   * @param name
   * @param phone
   * @return List<Company>
   */
  public List<Company> findCompaniesByFields(final String name, final Phone phone)
  {
    CriteriaBuilder cb = getEm().getCriteriaBuilder();
    CriteriaQuery<Company> cq = cb.createQuery(Company.class);

    Root<Company> fromCompany = cq.from(Company.class);

    Predicate allCriteria = cb.conjunction();

    Expression<Boolean> equalName = cb.equal(fromCompany.get(Company_.name), name);
    allCriteria = cb.and(allCriteria, equalName);

    // join on Phone

    Join<Company, Phone> phoneJoin = fromCompany.join(Company_.phone);
    Expression<Boolean> equalPhone = cb.equal(phoneJoin, phone);
    allCriteria = cb.and(allCriteria, equalPhone);

    cq.select(fromCompany).where(allCriteria);

    TypedQuery<Company> q = getEm().createQuery(cq);
    List<Company> result = q.getResultList();

    return result;
  }

}
