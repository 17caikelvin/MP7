
public class Board {
	public String[][] field;
	
	public Board(int dimension) {
		field = new String[dimension][dimension];
		for(int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				/*if (field[i][j] == "_") {
					System.out.print("X" + " ");
				}	else {
					System.out.print("O" + " ");
				}
				*/
				field[i][j] = "_ ";
			}
		}
	}
	
	public void printBoard() {
		for(int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				/*
				if (field[i][j].equals("O")) {
					System.out.print(" " + "_");
				}	else {
					System.out.print(" " + field[i][j]);
				}
				*/
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
