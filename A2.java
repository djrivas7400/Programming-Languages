/**
 * CSC 540-01 Assignment #2
 * 
 * On my honor, Danielle Rivas, this assignment is my own work.  
 * I, Danielle Rivas, will follow the instructor's rules and processes 
 * related to academic integrity as directed in the course syllabus.
 *
 */

// Students -- Add your import declarations here
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A2 {
	
	// Students -- Add your constants here
	private static String input = "";
	private static String nextToken = "";
	private static int NextID = 0;
	private static int i = 0;

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
			
			// Students -- Your code and methods calls go here
			while(sc.hasNextLine()){
				input += sc.nextLine();
			}
			//check string character by character
			getCharacter();
			printMessage();
			Prog();
			
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR - cannot open i?.txt \n");
		}
	}

	// Students -- Add your method declarations here
	public static void getCharacter(){
			//ignore white spaces, tabs, and next lines
		if(i>input.length()-1){
			nextToken = "";
		}else{
			if(input.charAt(i) == ' '){
				i++;
			}
			switch(input.charAt(i)){
				//check for the specified characters
				case 'f':
					nextToken = "f";
					NextID = FLOATDCL;
					i++;
					break;
				case 'i':
					nextToken = "i";
					NextID = INTDCL;
					i++;
					break;
				case 'p':
					nextToken = "p";
					NextID = PRINT;
					i++;
					break;
				case '=':
					nextToken = "=";
					NextID = ASSIGN;
					i++;
					break;
				case '+':
					nextToken = "+";
					NextID = PLUS;
					i++;
					break;
				case '-':
					nextToken = "-";
					NextID = MINUS;
					i++;
					break;
				default:
					//if digit go to numbers
					Boolean b = Character.isDigit(input.charAt(i));
					if(b){
						numbers();
						i++;
					}
					else{//output the character
						nextToken = Character.toString(input.charAt(i));
						NextID = ID;
						i++;
					}
			}
		}
	}
	public static void numbers(){
		String decimal = "";
		//get front of float or entire int
		while(i<input.length() && Character.isDigit(input.charAt(i))){
			decimal += input.charAt(i);
			i++;
		}
		//check if number is a float
		if(i< input.length() && input.charAt(i)=='.'){
			decimal +=".";
			i++;
			//if anything that is not a digit appears after the . it is an illegal character, end program
			if(!Character.isDigit(input.charAt(i))){
				nextToken = String.valueOf(decimal);
				NextID = FNUM;
				//System.out.println("Next token is: "+FNUM+", Next lexeme is "+decimal);
				System.exit(0);
				i = i-1;
			}else{//get back half of float
				while(i<input.length() && Character.isDigit(input.charAt(i))){
					decimal += input.charAt(i);
					i++;
				}
				nextToken = String.valueOf(decimal);
				NextID = FNUM;
				//System.out.println("Next token is: "+FNUM+", Next lexeme is "+decimal);
				 i --;
			}
		}else{//return integer number
			nextToken = String.valueOf(decimal);
			NextID = INUM;
			//System.out.println("Next token is: "+INUM+", Next lexeme is "+decimal);
			i--;
		}
	}

	public static void Prog(){
		System.out.println("Enter <Prog>");
		if(nextToken == "f" || nextToken == "i")
			Dcls();
		if(nextToken != "")
			Stmts();
		System.out.println("Exit <Prog>");
	}
	public static void Dcls(){
		System.out.println("Enter <Dcls>");
		//System.out.println("next token "+nextToken);
		if(nextToken =="f" || nextToken == "i"){
			//getCharacter();
			//System.out.println("next token "+nextToken);
			Dcl();
			if(nextToken =="f" || nextToken == "i")
				Dcls();
		}
		System.out.println("Exit <Dcls>");

	}
	public static void Dcl(){
		System.out.println("Enter <Dcl>");
		getCharacter();//FLOATDCL or INTDCL
		printMessage();

		getCharacter();//ID
		if(nextToken != "")
			printMessage();
		System.out.println("Exit <Dcl>");
	}
	public static void Stmts(){
		System.out.println("Enter <Stmts>");
		if(nextToken.matches("[a-z]+") && nextToken != "f" && nextToken != "i" ){
			Stmt();
			//getCharacter();
			//printMessage();
			//System.out.println(nextToken);
			if(nextToken.matches("[a-z]+") && nextToken != "f" && nextToken != "i" )
				Stmts();
		}
		System.out.println("Exit <Stmts>");
	}
	public static void Stmt(){
		System.out.println("Enter <Stmt>");
		if(nextToken == "p"){
			getCharacter();
			printMessage();
			getCharacter();

		}else{
			getCharacter();//Assign = 
			printMessage();
			getCharacter();
			printMessage();
			Val();//ID, INUM, FNUM
			//getCharacter();
			if(nextToken =="+" || nextToken =="-")
				Expr();
		}
		System.out.println("Leave <Stmt>");
		
	}
	public static void Expr(){
		System.out.println("Enter <Expr>");
		getCharacter();
		printMessage();
		Val();
		if(nextToken =="+" || nextToken == "-")
			Expr();
		System.out.println("Leave <Expr>");
	}
	public static void Val(){
		//System.out.println(nextToken);
		System.out.println("Enter <Val>");
		getCharacter();
		//System.out.println("Next token "+nextToken);
		if(nextToken !="")
			printMessage();
		System.out.println("Leave <Val>");
		
	}
	public static void printMessage(){
		System.out.println("Next token is: "+NextID+", Next lexeme is "+nextToken);
	}

}