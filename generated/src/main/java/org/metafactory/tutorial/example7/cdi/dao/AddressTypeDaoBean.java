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

import org.metafactory.tutorial.example7.model.implementation.AddressType;
import org.metafactory.tutorial.example7.model.implementation.AddressType_;
import org.picketlink.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AddressTypeDaoBean - Created by MetaFactory: Automation of Software Development
 * 
 * @author - Merijn
 */
@Named
@Transactional(TxType.MANDATORY)
public class AddressTypeDaoBean extends tutorialExample7RootBean<AddressType> implements Serializable
{
  private static final Logger LOG              = LoggerFactory.getLogger(AddressTypeDaoBean.class.getName());

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
    super.setPersistentClass(AddressType.class);
  }

  /**
   * save - Generic save method
   * 
   * @param entity
   * @return AddressType
   */
  public AddressType save(final AddressType entity)
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
   * @return AddressType
   */
  public AddressType update(final AddressType entity)
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
  public void delete(final AddressType entity)
  {
    super.delete(entity.getAddressTypeId());
  }

  /**
   * findAddressTypeByKey -
   * 
   * @param key
   * @return AddressType
   */
  public AddressType findAddressTypeByKey(final String key)
  {
    CriteriaBuilder cb = getEm().getCriteriaBuilder();
    CriteriaQuery<AddressType> cqry = cb.createQuery(AddressType.class);

    Root<AddressType> fromAddressType = cqry.from(AddressType.class);

    cqry.where(cb.equal(fromAddressType.get(AddressType_.key), key));
    cqry.select(fromAddressType);

    TypedQuery<AddressType> q = getEm().createQuery(cqry);
    AddressType result;
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
