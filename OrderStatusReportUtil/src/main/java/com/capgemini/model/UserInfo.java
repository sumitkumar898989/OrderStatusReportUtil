package com.capgemini.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class UserInfo {
	
	private int count;
    private ArrayList<String> emailList;
    public ArrayList<String> getEmailList() {
		return emailList;
	}
	public void setEmailList(ArrayList<String> emailList) {
		this.emailList = emailList;
	}
    public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
