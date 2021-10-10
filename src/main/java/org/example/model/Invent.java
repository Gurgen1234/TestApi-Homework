package org.example.model;

import com.google.gson.annotations.SerializedName;

public class Invent{

	@SerializedName("sold")
	private int sold;

	@SerializedName("hhhhhhh")
	private int hhhhhhh;

	@SerializedName("string")
	private int string;

	@SerializedName("alive")
	private int alive;

	@SerializedName("pending")
	private int pending;

	@SerializedName("available")
	private int available;

	@SerializedName("on ground")
	private int onGround;

	@SerializedName("free")
	private int free;

	@SerializedName("Out of stock")
	private int outOfStock;

	public void setSold(int sold){
		this.sold = sold;
	}

	public int getSold(){
		return sold;
	}

	public void setHhhhhhh(int hhhhhhh){
		this.hhhhhhh = hhhhhhh;
	}

	public int getHhhhhhh(){
		return hhhhhhh;
	}

	public void setString(int string){
		this.string = string;
	}

	public int getString(){
		return string;
	}

	public void setAlive(int alive){
		this.alive = alive;
	}

	public int getAlive(){
		return alive;
	}


	public void setPending(int pending){
		this.pending = pending;
	}

	public int getPending(){
		return pending;
	}

	public void setAvailable(int available){
		this.available = available;
	}

	public int getAvailable(){
		return available;
	}

	public void setOnGround(int onGround){
		this.onGround = onGround;
	}

	public int getOnGround(){
		return onGround;
	}

	public void setFree(int free){
		this.free = free;
	}

	public int getFree(){
		return free;
	}

	public void setOutOfStock(int outOfStock){
		this.outOfStock = outOfStock;
	}

	public int getOutOfStock(){
		return outOfStock;
	}

	@Override
 	public String toString(){
		return 
			"Invent{" + 
			"sold = '" + sold + '\'' + 
			",hhhhhhh = '" + hhhhhhh + '\'' + 
			",string = '" + string + '\'' + 
			",alive = '" + alive + '\'' + 
			",null = '" + null + '\'' + 
			",pending = '" + pending + '\'' + 
			",available = '" + available + '\'' + 
			",on ground = '" + onGround + '\'' + 
			",free = '" + free + '\'' + 
			",out of stock = '" + outOfStock + '\'' + 
			"}";
		}
}