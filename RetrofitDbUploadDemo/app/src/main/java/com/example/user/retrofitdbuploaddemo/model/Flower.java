package com.example.user.retrofitdbuploaddemo.model;

import com.google.gson.annotations.SerializedName;

public class Flower{

	@SerializedName("instructions")
	private String instructions;

	@SerializedName("productId")
	private int productId;

	@SerializedName("price")
	private double price;

	@SerializedName("name")
	private String name;

	@SerializedName("photo")
	private String photo;

	@SerializedName("category")
	private String category;

	public void setInstructions(String instructions){
		this.instructions = instructions;
	}

	public String getInstructions(){
		return instructions;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductId(){
		return productId;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPhoto(String photo){
		this.photo = photo;
	}

	public String getPhoto(){
		return photo;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return 
			"Flower{" + 
			"instructions = '" + instructions + '\'' + 
			",productId = '" + productId + '\'' + 
			",price = '" + price + '\'' + 
			",name = '" + name + '\'' + 
			",photo = '" + photo + '\'' + 
			",category = '" + category + '\'' + 
			"}";
		}
}