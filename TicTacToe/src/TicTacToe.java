import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();


	public static void main(String[] args) {
		
		//Creating Game board 
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};

		
		printGameBoard(gameBoard);
		
		
		
		
		//This will loop the code
		while(true) {
			
			//Allow user input and will keep asking
			Scanner scan = new Scanner(System.in);
			// Will let user choose placement of x and y
			System.out.println("Enter your placement (1-9):");
			int playerPos = scan.nextInt();
			
			while(playerPosition.contains(playerPos) || cpuPosition.contains(playerPosition)) {
				System.out.println("psoition taken! Enter a correct position");
				playerPos = scan.nextInt();
			}
			
			//Creating player 1 and 2
			placePiece(gameBoard, playerPos,  "player" );
			
			String result = checkWinner();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			//This will place the cpus choice in a random position 
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			while(playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)) {
				cpuPos = scan.nextInt(9) + 1;
			}
			placePiece(gameBoard, cpuPos, "cpu");
			
			printGameBoard(gameBoard);
			
			checkWinner();
			
			
			
		}
		
			
	}
	//Printing out the gameboard using a for loop
	public static void printGameBoard(char[] [] gameBoard) {
		for(char[] row: gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void placePiece(char [][] gameBoard, int pos, String user) {
		
		//if the user is a player then the symbol is x and computer is O
		
		char symbol = ' ';
		
		if(user.equals("player")) {
			symbol= 'X';
			playerPosition.add(pos);
		}else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPosition.add(pos);
		}
		
		//Will change the input to an X 
		switch(pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		}
	}
	
	//This will let us check who the winners in the game are 
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(bottomRow);
		winning.add(leftCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		
		for (List l : winning) {
			if(playerPosition.containsAll(l)) {
				return "Congratulations you won!";
			}else if(cpuPosition.contains(l)) {
				return "CPU wins! Sorry :(";
			}else if(playerPosition.size() + cpuPosition.size() ==9) {
				return "Tie";
			}
		}
		
		
		
		return "";
	}
}

