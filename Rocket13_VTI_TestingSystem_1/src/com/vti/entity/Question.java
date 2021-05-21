package com.vti.entity;

import java.time.LocalDate;

public class Question {
	public int id;
	public String content;
	public CategoryQuestion categoryQuestion;
	public TypeQuestion typeQ;
	public int creatorID;
	public LocalDate createDate;
}
