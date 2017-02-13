public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int col){
	if (col == board.length){
	    return true;
	}
	for (int row = 0; row < board.length; row++){
	    if (addQueen(row,col)){
		addQueen(row,col);
		if (solveH(col+1)){
		    return true;
		}
		removeQueen(row,col);
	    }
	}
	return false;
    }
    public int getSolutionCount(){
	return -1;
    }

    
	
    private boolean addQueen(int r, int c){
	if (board[r][c] != 0){
	    return false;
	}
	board[r][c] = 1;
	int d = 1;
	while (c + d < board.length){
	    board[r][c+d]--;
	    if (r - d >= 0){
		board[r-d][c+d]--;
	    }
	    if (r + d < board.length){
		board[r+d][c+d]--;
	    }
	    d++;
	}
	return true;
    }
    private boolean removeQueen(int r, int c){
	if (board[r][c] != 1){
	    return false;
	}
	board[r][c] = 0;
	int d = 1;
	while (c + d < board.length){
	    board[r][c+d]++;
	    if (r - d >= 0){
		board[r-d][c+d]++;
	    }
	    if (r + d < board.length){
		board[r+d][c+d]++;
	    }
	    d++;
	}
	return true;
    }
	    

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String a = "";
	for (int r = 0; r< board.length; r++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] == 1){
		    a += "Q";
		}
		else{
		    a+= "_";
		}		    
		if (c == board.length - 1){
		    a += "\n";
		}
	    }
	}
    	return a;
    }
    public static void main(String[]a){
	QueenBoard x = new QueenBoard(6);
	x.solve();
	System.out.println(x.toString());
	System.out.println(x.getSolutionCount());
	
    }
	
}
