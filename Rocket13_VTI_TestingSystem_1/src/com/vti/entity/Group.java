package com.vti.entity;

import java.time.LocalDate;

public class Group {
	public int id;
	public String name;
	public int	creatorid;
	public LocalDate createdate;
	public Account[] account;
}
