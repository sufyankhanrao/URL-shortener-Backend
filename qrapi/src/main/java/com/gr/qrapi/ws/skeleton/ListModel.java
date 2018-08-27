package com.gr.qrapi.ws.skeleton;


public class ListModel {
	String label;
	int data;
	
	public ListModel() {
	}
	
	public ListModel(String label, Integer data) {
		super();
		this.label = label;
		this.data = data;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	
}
