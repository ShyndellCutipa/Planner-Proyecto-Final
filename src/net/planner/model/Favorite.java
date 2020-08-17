package net.planner.model;

public class Favorite {
	private int id_fav;
	private String category;
	private String name;
	private String reference;
	private String comment;
	
	public Favorite(int id_fav, String category, String name, String reference, String comment) {
		this.id_fav = id_fav;
		this.category = category;
		this.name = name;
		this.reference = reference;
		this.comment = comment;
	}

	public int getId_fav() {
		return id_fav;
	}

	public void setId_fav(int id_fav) {
		this.id_fav = id_fav;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
