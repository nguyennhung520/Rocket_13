package com.vti.frontend;

import java.time.LocalDate;
import java.util.Random;

public class TestingSystem_2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Exercise 4: Random number
		//Question 1: in ngẫu nhiên 1 số nguyên 
		System.out.println("Question 1: In ra ngẫu nhiên 1 số nguyên");
		Random random = new Random();
		int n = random.nextInt();
		System.out.println("Số ngẫu nhiên: "+n);
		
		//Question 2: in ngẫu nhiên 1 số thực
		System.out.println("Question 2: In ra ngẫu nhiên 1 số thực");
		float f = random.nextFloat();
		System.out.println("Số ngẫu nhiên: "+f);
		
		//Question 3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên 1 bạn
		System.out.println("Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên 1 bạn");
		String[] nameArr = {"A","B","C","D"};
		int i = random.nextInt(nameArr.length);
		System.out.println("Tên ngẫu nhiên 1 bạn trong lớp: "+nameArr[i]);
		
		//Question 4: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995-->20-12-1995
		System.out.println("Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995-->20-12-1995");
		int minday = (int) LocalDate.of(1995, 07, 24).toEpochDay();
		int maxday = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		System.out.println("minday: "+minday);
		System.out.println("maxday: "+maxday);
		long randomInt = minday+random.nextInt(maxday - minday);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
		
		//Question 5: Lấy ngẫu nhiên 1 ngày trong khoảng 1 năm trở lại đây
		System.out.println("Lấy ngẫu nhiên 1 ngày trong khoảng 1 năm trở lại đây");
		int now = (int) LocalDate.now().toEpochDay();
		int randomDate = now - random.nextInt(365);
		LocalDate resultDate = LocalDate.ofEpochDay(randomDate);
		System.out.println("Ngày ngẫu nhiên là: "+resultDate);
		
		//Question 6: Lấy ngẫu nhiên 1 ngày trong quá khứ
		System.out.println("Lấy ngẫu nhiên 1 ngày trong quá khứ");
		int maxday1 = (int) LocalDate.now().toEpochDay();
		long randomDay1 = random.nextInt(maxday1);
		LocalDate resultDay1 = LocalDate.ofEpochDay(randomDay1);
		System.out.println("1 ngày ngẫu nhiên trong quá khứ: "+resultDay1);
		
		//Question 7: Lấy ngẫu nhiên 1 số có 3 chữ số
		System.out.println("Lấy ngẫu nhiên 1 số có 3 chữ số");
		int z = random.nextInt(999 - 100 + 1) + 100;
		System.out.println(z);
	}

}
