package uppgift7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {
    private static class Position{
        private int row, column;
        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public Position newPosition(int type){//tar inte hänsyn till brädets begränsningar
            if(type==0){//upp-höger
                return new Position(row-2,column+1);
            }else if(type==1){//höger-upp
                return new Position(row-1,column+2);
            }else if(type==2){//höger-ned
                return new Position(row+1,column+2);
            }else if(type==3){//ned-höger
                return new Position(row+2,column+1);
            }else if(type==4){//ned-vänster
                return new Position(row+2,column-1);
            }else if(type==5){//vänster-ned
                return new Position(row+1,column-2);
            }else if(type==6){//vänster-upp
                return new Position(row-1,column-2);
            }else if(type==7){//upp-vänster
                return new Position(row-2,column-1);
            }
            return null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && column == position.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

    }

    public static void main(String[] args){
        char[][] board0 = { {   'g','g','h','g','g','h','g','g','g','h','g','h','h','g','g','g','g','h','g','g','g','h','g','h','h','h','g','h','h','g','g','h','g','g','g'},
                            {   's','g','h','g','g','g','g','h','h','h','g','g','h','g','h','h','h','h','g','g','h','g','g','h','h','g','g','h','g','g','g','h','g','h','g'},
                            {   'g','h','g','g','g','g','h','g','h','h','g','g','g','g','g','g','g','g','g','h','g','h','h','g','g','h','h','g','h','h','g','h','h','h','m'}};

        char[][] board = {  {'g','g','h','g','g','h','g','g'},
                            {'g','h','h','h','g','h','g','g'},
                            {'g','g','s','g','h','h','g','g'},
                            {'g','h','h','h','h','g','h','g'},
                            {'g','g','g','g','g','g','g','g'},
                            {'h','g','h','g','h','h','h','g'},
                            {'g','h','h','h','h','m','h','g'}};
        char[][] board2 = {//behåll denna
                {'g','g','h','g','g','h','g','g'},
                {'g','h','h','h','g','h','g','g'},
                {'g','g','s','g','h','h','g','g'},
                {'g','h','h','h','h','g','h','g'},
                {'g','g','g','g','g','g','g','g'},
                {'h','g','h','h','h','h','h','g'},
                {'g','h','h','h','h','m','h','g'}};
        char[][] board3 = {
                {'g','g','h','g','g','h','g','g'},
                {'g','h','h','h','g','h','g','g'},
                {'g','g','s','g','h','h','g','g'},
                {'g','h','h','h','h','g','h','g'},
                {'g','g','g','g','h','g','h','g'},
                {'h','g','h','h','h','h','h','h'},
                {'g','h','h','h','h','m','h','g'}};
        System.out.println(shortestPath(board0));
    }

    private static int shortestPath(char[][] board) {
        Position endPosition=null, startPosition=null, currentPosition, newPosition;
        int[][] nrOfMoves = new int[board.length][board[0].length];
        for(int[] row: nrOfMoves)
            Arrays.fill(row,-1);//-1 betyder ställen jag inte varit på än
        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 's') startPosition = new Position(i, j);
                if(board[i][j] == 'm') endPosition = new Position(i, j);
                if(board[i][j] == 'h') nrOfMoves[i][j] = -2;//-2 betyder ställen jag inte kan gå till
            }
        }
        Queue<Position> queue = new LinkedList<>();
        queue.offer(startPosition);
        nrOfMoves[startPosition.row][startPosition.column]=0;
        while (!queue.isEmpty()){
            print(nrOfMoves);
            System.out.println("***");
            currentPosition=queue.poll();
            if(currentPosition.equals(endPosition))
                return nrOfMoves[currentPosition.row][currentPosition.column];
            for(int i=0;i<8;i++){
                newPosition = currentPosition.newPosition(i);
                if(withinBounds(newPosition,board) && nrOfMoves[newPosition.row][newPosition.column] == -1){
                    nrOfMoves[newPosition.row][newPosition.column] = nrOfMoves[currentPosition.row][currentPosition.column]+1;
                    queue.offer(newPosition);
                }
            }
        }
        return -1;
    }

    private static boolean withinBounds(Position position, char[][] board) {
        return position.row>=0 && position.row<board.length && position.column>=0 && position.column<board[0].length;
    }

    private static void print(int[][] v){
        for(int[] r:v)
            System.out.println(Arrays.toString(r));
    }

}
