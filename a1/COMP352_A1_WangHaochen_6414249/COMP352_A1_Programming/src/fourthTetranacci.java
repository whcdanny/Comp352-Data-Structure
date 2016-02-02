//Assignment 1
//Name: Wang Haochen
//ID: 6414249
//Date: 2014/9/26


import java.io.*;
import java.math.BigInteger;


public class fourthTetranacci {
	/**
	 * 
	 * @param k value to compute
	 * @return Tetranacci result using a recursion
	 */
	
	public static BigInteger fourthTetranacci(int k){
		BigInteger tetranacciNumber;
		if(k<3){
			tetranacciNumber=BigInteger.ZERO;
			}
		else if(k==3){
			tetranacciNumber=BigInteger.ONE;
			}
		else{
			tetranacciNumber = fourthTetranacci(k - 1).add(fourthTetranacci(k - 2)).add(fourthTetranacci(k - 3)).add(fourthTetranacci(k - 4));
			}
		System.out.println("Tetranacci value for n="+ k + " is:" + tetranacciNumber + ".");
		return tetranacciNumber;
	}
	
	
	public static void main(String[] args){
		PrintWriter writer = null;
		try{
			writer = new PrintWriter("out.txt");
			long start_time = System.nanoTime();
			long end_time = System.nanoTime();
			BigInteger end_value;
			//output to consule
			System.out.println("\nbinary Tetranacci:");
			//witer in text file
			writer.println("\nbinary Tetranacci:");
			
			int k=0;
			//Initialize timer
			while(k<=20){
				System.out.println("At k = " + k);
                writer.println("At k = " + k);
                //compute result
                end_value = fourthTetranacci(k);
                System.out.println(end_value);
                writer.println(end_value);
                end_time = end_time - start_time;
                System.out.println("Time since start: " + end_time+ " milliseconds");
                writer.println("Time since start: " + end_time+ " milliseconds");
                k+=5;
			}
			
			
		}catch (IOException e) {
            System.out.println("Problem writing to the file.");
        } finally {
            if (writer != null)
                writer.close();
        }
	}


}
