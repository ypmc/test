package net.cq.test;

import java.io.IOException;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
        int num = random.nextInt(100);
        System.out.println(num+1);
	}

	public String test() throws IOException{
		try
		{			
			return "";
		}catch(Exception e){
			throw new IOException();
		}
	}
}
