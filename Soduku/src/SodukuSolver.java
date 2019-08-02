public class SodukuSolver {

	private static int size = 9;
	private int [][] soduku;
	private static int empty = 0;
	
	public static int [][] soduku_Board = {
	{5,3,0,0,7,0,0,0,0},
	{6,0,0,1,9,5,0,0,0},
	{0,9,8,0,0,0,0,6,0},
	{8,0,0,0,6,0,0,0,3},
	{4,0,0,8,0,3,0,0,1},
	{7,0,0,0,2,0,0,0,6},
	{0,6,0,0,0,0,2,8,0},
	{0,0,0,4,1,9,0,0,5},
	{0,0,0,0,8,0,0,7,9}};
	
	public SodukuSolver() {
	}
	
	public void createBoard(int[][]soduku) {
		
		this.soduku = new int [size][size];
	
		for(int row = 0; row<size; row++) {
			
			for(int col=0; col<size; col++) {
				
				this.soduku[row][col] = soduku[row][col];
			}
		}
	}
	
	public boolean isInRow(int row, int number) {
		
		for(int i=0; i<size; i++) {
			
			if(soduku[row][i] == number) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isInCol(int col,int number) {
		
		for(int i=0; i<size; i++) {
			
			if(soduku[i][col] == number) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isInBox(int row, int col, int number) {
		
		int r = row - row % 3;
		int c = col - col % 3; 
		
		for(int i= r; i< r+3; i++) {			
			
			for(int j= c; j< c+3; j++) {
				
				if(soduku[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isOk(int row, int col, int number) {
		
		if(!isInRow(row,number) && !isInCol(col,number) && !isInBox(row,col,number)) {
			
			return true;
		}
		return false;
	}
	
	public boolean solve() {
		
		for(int row=0; row<size; row++) {
			
			for(int col=0; col<size; col++) {

				if(soduku[row][col] == empty) {
					
					for(int number=1; number<=9; number++) {
						
						if(isOk(row,col,number)) {
							
							soduku[row][col] = number;
							
							if(solve()) {
								return true;
							}else {
								soduku[row][col] = empty;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	public void display() {
		
		for(int row = 0; row<size; row++) {
			
			for(int col =0; col<size; col++) {
				System.out.print(soduku[row][col]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[]args) {
		
		SodukuSolver soduku = new SodukuSolver();
		
		soduku.createBoard(soduku_Board);
		System.out.println("Soduku board to be solved ");
		soduku.display();
		
		System.out.println();
		
		if(soduku.solve()) {
			System.out.println("Soduku board solved");
			soduku.display();
			
		}else {
			System.out.println("Try again tomorrow");
		}
	} 
}