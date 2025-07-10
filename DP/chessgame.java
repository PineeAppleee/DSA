package dp;

public class chessgame {
    public static void main(String[] args) {
    int board [][] = new int[8][8];
        System.out.println(chessgame(3,3,board,0));
    }
    static int chessgame(int row,int col,int board[][],int pos){
        if(row<0||col<0||row>board.length-1||col>board[0].length-1) return 0;
        if(row==0&&col==0) return 1;
        int left = 1+chessgame(row,col-1,board,pos);
        int right = 1+chessgame(row,col+1,board,pos);
        int up = 1+chessgame(row-1,col,board,pos);
        int downword = 1+chessgame(row+1,col,board,pos);
        return left+right+up+downword;
    }
}
