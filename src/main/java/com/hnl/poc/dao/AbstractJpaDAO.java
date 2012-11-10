/**
 * 
 */
package com.hnl.poc.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * @author ughn13
 *
 */
public abstract class AbstractJpaDAO< T extends Serializable >  {
	   
	   private Class< T > clazz;
	   
	   @PersistenceContext
	   EntityManager entityManager;
	   
	   public void setClazz( final Class< T > clazzToSet ){
	      this.clazz = clazzToSet;
	   }
	   
	   public T findOne( final Long id ){
	      return this.entityManager.find( this.clazz, id );
	   }
	   public List< T > findAll(){
	      return this.entityManager.createQuery( "from " + this.clazz.getName() )
	       .getResultList();
	   }
	   
	   public void save( final T entity ){
	      this.entityManager.persist( entity );
	   }
	   
	   public void update( final T entity ){
	      this.entityManager.merge( entity );
	   }
	   
	   public void delete( final T entity ){
	      this.entityManager.remove( entity );
	   }
	  
}
