package org.metafactory.tutorial.example7.cdi.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.metafactory.tutorial.example7.model.implementation.Relation;
import org.metafactory.tutorial.example7.model.implementation.RelationType;
import org.metafactory.tutorial.example7.model.implementation.Relation_;
import org.picketlink.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RelationDaoBean - Created by MetaFactory: Automation of Software Development
 */
@Named
@Transactional(TxType.MANDATORY)
public class RelationDaoBean extends tutorialExample7RootBean<Relation> implements Serializable
{
  private static final Logger LOG              = LoggerFactory.getLogger(RelationDaoBean.class.getName());

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
    super.setPersistentClass(Relation.class);
  }

  /**
   * save - Generic save method
   * 
   * @param entity
   * @return Relation
   */
  public Relation save(final Relation entity)
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
   * @return Relation
   */
  public Relation update(final Relation entity)
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
  public void delete(final Relation entity)
  {
    super.delete(entity.getRelationId());
  }

  /**
   * findRelationsByType -
   * 
   * @param type
   * @return List<Relation>
   */
  public List<Relation> findRelationsByType(final RelationType type)
  {
    CriteriaBuilder cb = getEm().getCriteriaBuilder();
    CriteriaQuery<Relation> cq = cb.createQuery(Relation.class);

    Root<Relation> fromRelation = cq.from(Relation.class);

    Expression<Boolean> equalType = cb.equal(fromRelation.get(Relation_.type), type);

    cq.select(fromRelation).where(equalType);

    TypedQuery<Relation> q = getEm().createQuery(cq);
    List<Relation> result = q.getResultList();

    return result;
  }

}
