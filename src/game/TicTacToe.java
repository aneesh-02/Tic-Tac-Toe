package game;

public class TicTacToe 
{	
	public static void main(String[] args) 
	{
		// Creating the Board using a 2d array of characters
		
		char [][] board = {{' ','|' , ' ' , '|' , ' '}  ,
						   { '-','+' , '-' , '+' , '-'} ,
						   {' ','|' , ' ' , '|' , ' '}  , 
						   { '-','+' , '-' , '+' , '-'} , 
						   {' ','|' , ' ' , '|' , ' '} };
		
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

}
