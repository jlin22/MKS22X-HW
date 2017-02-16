public class KnightBoard{
    private int[][]board;
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }
    public String toString(){
	String a = new String("");
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[r].length; c++){
	        a += board[r][c];
		if (c == board[r].length - 1){
		    a+= "\n";
		}
	    }
	}
	return a;
    }
    public void solve(){
         solveH(0,0,1);
    }
    public boolean solveH(int row, int col, int level){
	if (board.length * board[row].length < level){
	    return true;
	}	
	if (board[row][col] == 0){
	    board[row][col] = level;
	    if (board[row + 2][col + 1]==0){
		return solveH(row+2,col+1,level+1);
	    }
	    if (board[row + 2][col - 1]==0){
		return solveH(row+2,col-1,level+1);
	    }
	    if (board[row - 2][col + 1]==0){
		return solveH(row-2,col+1,level+1);
	    }
	    if (board[row - 2][col - 1]==0){
		return solveH(row-2,col-1,level+1);
	    }
	    if (board[row + 1][col + 2]==0){
		return solveH(row+1,col+2,level+1);
	    }
	    if (board[row + 1][col - 2]==0){
		return solveH(row+1,col-2,level+1);
	    }
	    if (board[row - 1][col + 2]==0){
		return solveH(row-1,col+2,level+1);
	    }
	    if (board[row - 1][col - 2]==0){
		return solveH(row-1,col-2,level+1);
	    }
	    

	    board[row][col] = 0;
	}
	return false;
    }
    public static void main(String[]a){
	KnightBoard x = new KnightBoard(6,6);
	x.solve();
	System.out.println(x.solveH(0,0,1));
	System.out.println(x.toString());
    }
}
