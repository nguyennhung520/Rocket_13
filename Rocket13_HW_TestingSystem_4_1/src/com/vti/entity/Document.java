package com.vti.entity;

public abstract class Document {
	private int id;
	private String publisher;
	private int numRelease;
	public Document(int id, String publisher, int numRelease) {
		super();
		this.id = id;
		this.publisher = publisher;
		this.numRelease = numRelease;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", publisher=" + publisher + ", numRelease=" + numRelease + "]";
	}
	
	
}
