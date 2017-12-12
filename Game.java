import java.util.Scanner;
import java.lang.*;
public class Game {
	public static void main (String[] args) {
		Board answerBoard = new Board(8);
		Board playerBoard = new Board(8);
		Player player_one = new Player();
		while (player_one.setShips <= 2) {
			generateShip(answerBoard, player_one.setShips + 1);
			player_one.setShips++;
		}
		while (player_one.torpedos > 0 && player_one.hits < 5) {
			playerBoard.printBoard();
			player_one.hits = userFire(answerBoard, playerBoard, player_one.hits, player_one.torpedos);
			player_one.torpedos--;
		}
		finale(player_one.hits, player_one.torpedos);
	}
	
	public static void generateShip(Board b, int size) {
		if (Math.random() < 0.5) {
			int x = (int) (Math.random() * 7);
			int y = (int)(Math.random() * 5);
			for (int i = 0; i < size; i++) {
				b.field[x][y+i] = "O ";
			}
		}	else {
			int x = (int) (Math.random() * 5);
			int y = (int)(Math.random() * 7);
			for (int i = 0; i < size; i++) {
				b.field[x+i][y] = "O ";
			}
		}
	}
	
	public static int userFire(Board ansBoard, Board playerBoard, int hits, int torps) { 
		Scanner input = new Scanner(System.in);
		int x, y;
		System.out.println(" You have " + torps + " torpedos remaining.");
		System.out.println("Which row would you like to fire in? : ");
		x = input.nextInt();
		while (x > 8 || x < 1) {
			System.out.println("Enter a valid number (1-8)");
			x = input.nextInt();
		}
		System.out.println("Which column would you like to fire in? : ");
		y = input.nextInt();
		while (y > 8 || y < 1) {
			System.out.println("Enter a valid number (1-8)");
			y = input.nextInt();
		}
		if(ansBoard.field[x-1][y-1].equals("O ")) {
			hits++;
			System.out.println("----------- Success! -----------");
			playerBoard.field[x-1][y-1] = "O ";
		}	else {
			System.out.println("----------- Miss :( -----------");
			playerBoard.field[x-1][y-1] = "X ";
		}
		return hits;
	}
	
	public static void finale(int hits, int torps) {
		if (hits < 5) {
			System.out.println("Sorry, you didn't sink all the ships!");
		}	else if (torps < 1) {
			System.out.println("You have used all your torpedoes.");
		}	else {
			if (hits >= 5) {
				System.out.println("You beat the game!");
			}
		}
	}
}
