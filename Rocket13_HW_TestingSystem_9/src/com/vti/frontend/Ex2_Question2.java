package com.vti.frontend;

import com.vti.entity.CPU;

public class Ex2_Question2 {
	public static void main(String[] args) {
		CPU cpu2 = new CPU(10);
		CPU.Processor pro2 = cpu2.new Processor(4, "Intel");
		CPU.Ram ram2 = cpu2.new Ram(16, "Kingston");
		System.out.println("Khoi tao CPU");
		System.out.println("In thong tin Processor: ");
		System.out.println("Cache Processor: "+pro2.getCache());
		System.out.println("Clock Speed Ram: "+ram2.getClockSpeed());
	}
}
