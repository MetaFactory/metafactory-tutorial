package org.metafactory.tutorial.example6.cdi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 * tutorialExample6RootBean - Created by MetaFactory: Automation of Software Development
 */
public abstract class tutorialExample6RootBean<T>
{
  private Class<T> persistentClass;

  private int      maxResults = 100;

  /**
   * Getter for property persistentClass.
   * 
   * @return value of property persistentClass
   */
  public Class<T> getPersistentClass()
  {
    return this.persistentClass;
  }

  /**
   * Setter for property persistentClass.
   * 
   * @param persistentClass new value of property persistentClass
   */
  public void setPersistentClass(final Class<T> persistentClass)
  {
    this.persistentClass = persistentClass;
  }

  /**
   * Getter for property maxResults.
   * 
   * @return value of property maxResults
   */
  public int getMaxResults()
  {
    return this.maxResults;
  }

  /**
   * Setter for property maxResults.
   * 
   * @param maxResults new value of property maxResults
   */
  public void setMaxResults(final int maxResults)
  {
    this.maxResults = maxResults;
  }

  /**
   * getEm -
   * 
   * @return EntityManager
   */
  public abstract EntityManager getEm();

  /**
   * get - Finds entity by using it's primary key (Long)
   * 
   * @param id
   * @return T
   */
  public T get(final Long id)
  {
    T entity;

    entity = (T) getEm().find(this.persistentClass, id);

    return entity;
  }

  /**
   * save - Generic save method
   * 
   * @param entity
   * @return T
   */
  public T save(final T entity)
  {
    getEm().persist(entity);
    return entity;
  }

  /**
   * delete - Generic delete method
   * 
   * @param id
   */
  public void delete(final Long id)
  {
    T ref = getEm().getReference(persistentClass, id);
    getEm().remove(ref);
  }

  /**
   * getAll - Generic finder
   * 
   * @return List<T>
   */
  public List<T> getAll()
  {
    CriteriaBuilder cb = getEm().getCriteriaBuilder();
    CriteriaQuery<T> cqry = cb.createQuery(persistentClass);

    Metamodel m = getEm().getMetamodel();
    EntityType<T> et_ = m.entity(persistentClass);

    Root<T> root = cqry.from(et_);

    cqry.select(root);

    TypedQuery<T> q = getEm().createQuery(cqry);
    q.setMaxResults(maxResults);
    List<T> result = q.getResultList();

    return result;
  }

  /**
   * merge -
   * 
   * @param entity
   * @return T
   */
  public T merge(final T entity)
  {
    return getEm().merge(entity);
  }

}
