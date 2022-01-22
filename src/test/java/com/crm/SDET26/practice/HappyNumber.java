package com.crm.SDET26.practice;

public class HappyNumber {

//happy numbers- When a number is split into individual digit and squared then summed to return 1. 
	public static void main(String[] args) {
		int num = 3;
		
		while(num!=1 && num !=4)      
		{
			 num = checknum(num);
		}
		if(num == 1)
		{
			System.out.println("num is happy ");
		}else {
			System.out.println("num is sad ");
		}
		
	}
	
	public static int checknum(int number)
	{
		int sum = 0;
		int rem = 0;
		while(number > 0)
		{
			rem = number%10;
			sum = sum+(rem*rem);
			number = number/10;
		}
		return sum;
	}
}
