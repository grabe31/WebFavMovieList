package controller;

import model.ListItem;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author Eric Grabe - egrabe
 * CIS175 - Fall 2023
 * Sep 25, 2023
 */
public class ListItemHelper {

	static EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("WebFavMovieList");
	
	public void insertItem(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListItem> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<ListItem> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
		}
	
	public void deleteItem(ListItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.title = :selectedTitle and li.director = :selectedDirector and li.year = :selectedYear", ListItem.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedDirector", toDelete.getDirector());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		ListItem result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}

	/**
	 * @param idToEdit
	 * @return
	 */
	public ListItem searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateItem(ListItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param Movie title
	 * @return
	 */
	public List<ListItem> searchForItemByTitle(String title) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.title = :selectedTitle", ListItem.class);
		typedQuery.setParameter("selectedTitle", title);
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * @param Movie Director
	 * @return
	 */
	public List<ListItem> searchForItemByDirector(String director) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.director = :selectedDirector", ListItem.class);
		typedQuery.setParameter("selectedDirector", director);
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	/**
	 * @param Movie year
	 * @return
	 */
	public List<ListItem> searchForItemByYear(String year) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.year = :selectedYear", ListItem.class);
		typedQuery.setParameter("selectedYear", year);
		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}