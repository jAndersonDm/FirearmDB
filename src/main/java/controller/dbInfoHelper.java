/**
 * @author ${Josiah Anderson} - janderson78@dmacc.edu
 * CIS175 - Fall 2021
 * ${2/17/2022}
 */
package controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.gunInfo;

public class dbInfoHelper {

static EntityManagerFactory entManF = Persistence.createEntityManagerFactory("FirearmDB");
	
	public void enterInfo(gunInfo info) {
		EntityManager entM = entManF.createEntityManager();
		entM.getTransaction().begin();
		entM.persist(info);
		entM.getTransaction().commit();
		entM.close();
		
	}
	
	public void deleteInfo(gunInfo delete) {
		
		EntityManager entM = entManF.createEntityManager();
		entM.getTransaction().begin();
		TypedQuery<gunInfo>typedQuery = entM.createQuery("select info from gunInfo info where info.ammo = :selectAmmo", gunInfo.class);
		typedQuery.setParameter("selectAmmo", delete.getAmmo());
		typedQuery.setMaxResults(1);
		gunInfo res = typedQuery.getSingleResult();
		
		entM.remove(res);
		entM.getTransaction().commit();
		entM.close();
	}
	
	public List<gunInfo> showInfo(){
		EntityManager entM = entManF.createEntityManager();
		@SuppressWarnings("unchecked")
		List<gunInfo> items = entM.createQuery("SELECT i FROM gunInfo i").getResultList();
		return items;
	}
	

	public void editInfo(gunInfo edit) {
		
		EntityManager entM = entManF.createEntityManager();
		entM.getTransaction().begin();
		entM.merge(edit);
		entM.getTransaction().commit();
		entM.close();
	}

	
	public gunInfo searchId(int edit) {
		// Search id of guns
		EntityManager entM = entManF.createEntityManager();
		entM.getTransaction().begin();
		gunInfo found = entM.find(gunInfo.class, edit);
		entM.close();
		return found;
	}

	
	public void cleaner() {
		entManF.close();
	}
}
