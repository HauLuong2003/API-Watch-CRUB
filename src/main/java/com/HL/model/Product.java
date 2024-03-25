package com.HL.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	private int id;
    private String name;
    private double price;
    private String description;
    private String image;
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Product(@JsonProperty("id") int id,@JsonProperty("name") String name, @JsonProperty("price") double price,@JsonProperty("description") String description,@JsonProperty("image") String image) {
		this.id= id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
	}
    public Product() {
    	
    }
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


    
}
