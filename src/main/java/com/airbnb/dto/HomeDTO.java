package com.airbnb.dto;

public class HomeDTO {
	int id;
	String price;
	String name;
	String day;
	String view;
	String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public HomeDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public HomeDTO(int id, String price, String name, String day, String view, String image) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.day = day;
		this.view = view;
		this.image = image;
	}

	@Override
	public String toString() {
		return "HomeDTO [id=" + id + ", price=" + price + ", name=" + name + ", day=" + day + ", view=" + view + "]";
	}

	public HomeDTO(int id) {
		super();
		this.id = id;
	}

}
