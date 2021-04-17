package game;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe 
{	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		// Creating the Board using a 2d array of characters
		char [][] board = {{' ','|' , ' ' , '|' , ' '}  ,
						   { '-','+' , '-' , '+' , '-'} ,
						   {' ','|' , ' ' , '|' , ' '}  , 
						   { '-','+' , '-' , '+' , '-'} , 
						   {' ','|' , ' ' , '|' , ' '} };
	
		print(board); // print game
		
		while(true)
		{
			System.out.println("Enter the cell for your placement (1-9): ");
			int playerPos = sc.nextInt(); // user input for placement
			System.out.println(playerPos);
			// in case the player position entered is already taken by player or cpu
						while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos))
						{
							System.out.println("Position occupied. Re enter postion:");
						    playerPos = sc.nextInt(); // user input for placement
						}
			
			placement(board,playerPos,"player"); // user's turn fulfilled  
			String result = checkWinner(); // check if there is a winner after user's turns
			
			Random r = new Random();  	// cpu input for placement
			int cpuPos = r.nextInt(9)+1;
			// in case the cpu position generated is already taken by player or cpu
						while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos))
						{
							 cpuPos = r.nextInt(9); // cpu input for placement
						}
							
			placement(board,cpuPos,"cpu");  // pc's turn fulfilled							
			print(board); // print game
			result = checkWinner(); // check if there is a winner after cpu turns
			
			if(result.length()>0)
			{
				System.out.println(result);
				break;
			}
		}
	}

	public static void print(char[][] board) 
	{
		// printing the game board
		for(char [] row : board)
		{
			for(char c: row)
			{
				System.out.print(c);
			}
			System.out.println();
		}		
	}

	public static void placement(char[][] board, int pos, String user)
	{
		char symbol = 'X'; // by default char = X
		
		if(user.equals("player")) // to determine whether the placement is for User or Cpu.
		{
			symbol = 'X';
			playerPositions.add(pos); // add the pos number to player ArrayList
		}
		else if(user.equals("cpu"))
		{
			symbol = 'O';
			cpuPositions.add(pos); // add the pos number to cpu ArrayList
		}
		
		switch(pos) // to set the symbol at the given position 
		{
			case 1: 
				board[0][0] = symbol;
				break;
			case 2: 
				board[0][2] = symbol;
				break;
			case 3: 
				board[0][4] = symbol;
				break;
			case 4: 
				board[2][0] = symbol;
				break;
			case 5: 
				board[2][2] = symbol;
				break;
			case 6: 
				board[2][4] = symbol;
				break;
			case 7: 
				board[4][0] = symbol;
				break;
			case 8: 
				board[4][2] = symbol;
				break;
			case 9: 
				board[4][4] = symbol;
				 break;
		}
		
	}

	public static String checkWinner()
	{
		List topRow = Arrays.asList(1,2,3); // using lists to store winning positions to check later
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List rightCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List leftCol = Arrays.asList(3,6,9);
		List diagonal1 = Arrays.asList(1,5,9);
		List diagonal2 = Arrays.asList(3,5,7);
		
		List<List> winning = new ArrayList<List>(); // a new list of lists
		winning.add(topRow); // adding all the winning position lists to this new list
		winning.add(midRow);
		winning.add(botRow);
		winning.add(rightCol);
		winning.add(midCol);
		winning.add(leftCol);
		winning.add(diagonal1);
		winning.add(diagonal1);
		
		for(List l : winning) //for each list insdie the winning list
		{
			//if the ArrayList of Player has all of the elements of any one l i.e. list(sequence) of winning in it
			if(playerPositions.containsAll(l))			
			{
				return "Congrats you won !!";
			}			
			//if the ArrayList of cpu has all of the elements of any one l i.e. list(sequence) of winning in it
			else if(cpuPositions.containsAll(l))
			{
				return "Cpu won, better luck next time.";
			}
			// if the board is full i.e. total size = player+cpu
			else if(playerPositions.size()+cpuPositions.size() == 9)
			{
				return "It's a Tie !";
			}
		}
		
		return "";
		}

}
