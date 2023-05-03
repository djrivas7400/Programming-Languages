/**
 * CSC 540-01 Assignment #1
 * 
 * On my honor, Danielle Rivas, this assignment is my own work.  
 * I, Danielle Rivas, will follow the instructor's rules and processes 
 * related to academic integrity as directed in the course syllabus.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// Students -- Add your import declarations here

public class A1 {
	
	// Students -- Add your constants here
	private static String input = "";

	public static final int FLOATDCL = 0;
	public static final int INTDCL = 1;
	public static final int PRINT = 2;
	public static final int ID = 3;
	public static final int ASSIGN = 4;
	public static final int PLUS = 5;
	public static final int MINUS = 6;
	public static final int INUM = 7;
	public static final int FNUM = 8;
	public static void main(String[] args) {
		try {
			// Do NOT make any changes to the following TWO lines
			File file = new File(args[0]);		
			Scanner sc = new Scanner(file);		//*** Do not make any other Scanners ***//
			
			// *** NOTE ***
			// For this assignment, you are NOT allowed to use any member methods of 
			// class java.util.Scanner except hasNextLine and nextLine.  
			// For example, you CANNOT use any of hasNextInt, nextInt, hasNextFloat, nextFloat, 
			// hasNextDouble and nextDouble for this assignment.  
			
			// Students -- Your code and methods calls go here
			while(sc.hasNextLine()){
				input += sc.nextLine();
			}
			//check string character by character
			getCharacter();
			
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR - cannot open i?.txt \n");
		}
	}
	
	// Students -- Add your method declarations here
	public static void getCharacter(){
		for(int i=0;i<input.length();i++){
			//ignore white spaces, tabs, and next lines
			if(input.charAt(i) != ' ' && input.charAt(i) != '\t' && input.charAt(i) != '\n'){
				switch(input.charAt(i)){
					//check for the specified characters
					case 'f':
						System.out.println("Next token is: "+FLOATDCL+", Next lexeme is f");
						break;
					case 'i':
						System.out.println("Next token is: "+INTDCL+", Next lexeme is i");
						break;
					case 'p':
						System.out.println("Next token is: "+PRINT+", Next lexeme is p");
						break;
					case '=':
						System.out.println("Next token is: "+ASSIGN+", Next lexeme is =");
						break;
					case '+':
						System.out.println("Next token is: "+PLUS+", Next lexeme is +");
						break;
					case '-':
						System.out.println("Next token is: "+MINUS+", Next lexeme is -");
						break;
					default:
						//if digit go to numbers
						Boolean b = Character.isDigit(input.charAt(i));
						if(b)
							i = numbers(i);
						else//output the character
							System.out.println("Next token is: "+ID+", Next lexeme is "+input.charAt(i));
				}
			}
		}
	}
	public static int numbers(int i){
		String decimal = "";
		//get front of float or entire int
		while(i<input.length() && Character.isDigit(input.charAt(i))){
			decimal += input.charAt(i);
			i++;
		}
		//check if number is a float
		if(input.charAt(i)=='.'){
			decimal +=".";
			i++;
			//if anything that is not a digit appears after the . it is an illegal character, end program
			if(!Character.isDigit(input.charAt(i))){
				System.out.println("Next token is: "+FNUM+", Next lexeme is "+decimal);
				System.exit(0);
				return i-1;
			}else{//get back half of float
				while(i<input.length() && Character.isDigit(input.charAt(i))){
					decimal += input.charAt(i);
					i++;
				}
				System.out.println("Next token is: "+FNUM+", Next lexeme is "+decimal);
				return i-1;
			}
		}else{//return integer number
			System.out.println("Next token is: "+INUM+", Next lexeme is "+decimal);
			return i-1;
		}
	}

}