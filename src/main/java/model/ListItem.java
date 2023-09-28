package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Eric Grabe - egrabe
 * CIS175 - Fall 2023
 * Sep 13, 2023
 */

@Entity
@Table(name= "Movies")
public class ListItem {

	@Id
	@GeneratedValue
	@Column(name= "ID")
	private int id;
	@Column(name= "Title")
	private String title;
	@Column(name= "Director")
	private String director;
	@Column(name= "Year")
	private String year;
	
	public ListItem() {
		super();
	}
	
	public ListItem(String title, String director, String year) {
		super();
		this.title = title;
		this.director = director;
		this.year = year;
	}
	
	public String returnItemDetails() {
		return this.title + ":" + this.director + this.year;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param name the name to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
}