package game;
import java.util.Scanner;

public class TicTacToe 
{	
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
		
		// user input for placement
		System.out.println("Enter the cell for your placement (1-9): ");
		int pos = sc.nextInt();
		System.out.println(pos);
		
		placement(board,pos,"player");
		placement(board,pos,"cpu");
		print(board); // print game
		
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
		char symbol = 'X';
		
		if(user.equals("player"))
		{
			symbol = 'X';
		}
		else if(user.equals("cpu"))
		{
			symbol = 'O';
		}
		
		switch(pos)
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
}
