package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise2;

public class Demo {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Exercise2 ex2 = new Exercise2();
		ex2.question1();
		ex2.question2();
		ex2.question3();
		ex2.question4();
		ex2.question5();
	}
}
