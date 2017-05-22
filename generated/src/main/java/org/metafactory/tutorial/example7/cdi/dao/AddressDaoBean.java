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
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.metafactory.tutorial.example7.model.implementation.Address;
import org.metafactory.tutorial.example7.model.implementation.AddressType;
import org.metafactory.tutorial.example7.model.implementation.Address_;
import org.picketlink.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AddressDaoBean - Created by MetaFactory: Automation of Software Development
 */
@Named
@Transactional(TxType.MANDATORY)
public class AddressDaoBean extends tutorialExample7RootBean<Address> implements Serializable
{
  private static final Logger LOG              = LoggerFactory.getLogger(AddressDaoBean.class.getName());

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
    super.setPersistentClass(Address.class);
  }

  /**
   * save - Generic save method
   * 
   * @param entity
   * @return Address
   */
  public Address save(final Address entity)
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
   * @return Address
   */
  public Address update(final Address entity)
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
  public void delete(final Address entity)
  {
    super.delete(entity.getAddressId());
  }

  /**
   * findAddressByFields -
   * 
   * @param streetName
   * @param zipCode
   * @param city
   * @param type
   * @return Address
   */
  public Address findAddressByFields(final String streetName, final String zipCode, final String city,
      final AddressType type)
  {
    CriteriaBuilder cb = getEm().getCriteriaBuilder();
    CriteriaQuery<Address> cq = cb.createQuery(Address.class);

    Root<Address> fromAddress = cq.from(Address.class);

    Predicate allCriteria = cb.conjunction();

    Expression<Boolean> equalStreetName = cb.equal(fromAddress.get(Address_.streetName), streetName);
    allCriteria = cb.and(allCriteria, equalStreetName);

    Expression<Boolean> equalZipCode = cb.equal(fromAddress.get(Address_.zipCode), zipCode);
    allCriteria = cb.and(allCriteria, equalZipCode);

    Expression<Boolean> equalCity = cb.equal(fromAddress.get(Address_.city), city);
    allCriteria = cb.and(allCriteria, equalCity);

    // join on AddressType

    Join<Address, AddressType> typeJoin = fromAddress.join(Address_.type);
    Expression<Boolean> equalType = cb.equal(typeJoin, type);
    allCriteria = cb.and(allCriteria, equalType);

    cq.select(fromAddress).where(allCriteria);

    TypedQuery<Address> q = getEm().createQuery(cq);

    Address result;
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
