package uppgift7;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

public class Main {

    private static class Position{
        int row,col;
        public Position(int row,int col){
            this.row=row;
            this.col=col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static void main(String[] args){
        char[][] board = {  {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ','S',' ',' ','X','X','X',' ',' ',' ',' ','X','X',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','M','X',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ','X','X',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X','X','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};
        char[][] b2=    {   {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ','S',' ',' ','X','X','X',' ',' ',' ',' ','X','X',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','M','X',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ','X','X',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X','X','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};
        char[][] b3=    {   {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ','S',' ',' ','X','X','X',' ',' ',' ',' ',' ',' ',' ','X','X',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X','M',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ','X','X',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X','X','X'},
                            {'X',' ',' ',' ',' ',' ',' ','X','X',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
                            {'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}};//8
        char[][] b4 = { {'X','X','X','X','X'},
                        {'X','S',' ',' ','X'},
                        {'X',' ',' ','M','X'},
                        {'X',' ',' ',' ','X'},
                        {'X','X','X','X','X'}};//-1
        System.out.println(shortestRoute(board));
        System.out.println(shortestRoute(b2));
        System.out.println(shortestRoute(b3));
        System.out.println(shortestRoute(b4));
    }

    private static int shortestRoute(char[][] board) {
        Position startPosition=null, endPosition=null, currentPosition, nextPosition;
        int[][] nrOfMoves = new int[board.length][board[0].length];
        for(int[] row: nrOfMoves)
            Arrays.fill(row,-1);//-1 betyder ställen jag inte varit på än
        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'S'){
                    startPosition = new Position(i, j);
                    nrOfMoves[i][j] = 0;
                }
                if(board[i][j] == 'M') endPosition = new Position(i, j);
                if(board[i][j] == 'X') nrOfMoves[i][j] = -2;//-2 betyder vägg
            }
        }
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(startPosition);
        while (!queue.isEmpty()){
            currentPosition = queue.poll();
            for(int i=0;i<4;i++){
                nextPosition = getPosition(nrOfMoves,currentPosition,i);
                if(nextPosition!=null){
                    if(nextPosition.equals(endPosition)) return 1 + nrOfMoves[currentPosition.row][currentPosition.col];
                    queue.offer(nextPosition);
                    nrOfMoves[nextPosition.row][nextPosition.col] = 1 + nrOfMoves[currentPosition.row][currentPosition.col];
                }
            }
        }
        return -1;
    }

    private static Position getPosition(int[][] nrOfMoves, Position currentPosition, int direction) {//assumes X around boarder
        int newRow = currentPosition.row, newCol = currentPosition.col;
        switch(direction){
            case 0://up
                while(nrOfMoves[newRow-1][newCol]!=-2){
                    newRow--;
                }
                break;
            case 1://right
                while(nrOfMoves[newRow][newCol+1]!=-2){
                    newCol++;
                }
                break;
            case 2://down
                while(nrOfMoves[newRow+1][newCol]!=-2){
                    newRow++;
                }
                break;
            case 3://left
                while(nrOfMoves[newRow][newCol-1]!=-2){
                    newCol--;
                }
                break;
        }
        if(nrOfMoves[newRow][newCol]==-1) return new Position(newRow,newCol);
        return null;
    }
}
