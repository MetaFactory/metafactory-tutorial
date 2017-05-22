package org.metafactory.tutorial.example7.cdi.dao;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.metafactory.tutorial.example7.model.implementation.Phone;
import org.metafactory.tutorial.example7.model.implementation.Phone_;
import org.picketlink.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PhoneDaoBean - Created by MetaFactory: Automation of Software Development
 */
@Named
@Transactional(TxType.MANDATORY)
public class PhoneDaoBean extends tutorialExample7RootBean<Phone> implements Serializable
{
  private static final Logger LOG              = LoggerFactory.getLogger(PhoneDaoBean.class.getName());

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
    super.setPersistentClass(Phone.class);
  }

  /**
   * save - Generic save method
   * 
   * @param entity
   * @return Phone
   */
  public Phone save(final Phone entity)
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
   * @return Phone
   */
  public Phone update(final Phone entity)
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
  public void delete(final Phone entity)
  {
    super.delete(entity.getPhoneId());
  }

  /**
   * findPhoneByNumber -
   * 
   * @param number
   * @return Phone
   */
  public Phone findPhoneByNumber(final String number)
  {
    CriteriaBuilder cb = getEm().getCriteriaBuilder();
    CriteriaQuery<Phone> cqry = cb.createQuery(Phone.class);

    Root<Phone> fromPhone = cqry.from(Phone.class);

    cqry.where(cb.equal(fromPhone.get(Phone_.number), number));
    cqry.select(fromPhone);

    TypedQuery<Phone> q = getEm().createQuery(cqry);
    Phone result;
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

}
