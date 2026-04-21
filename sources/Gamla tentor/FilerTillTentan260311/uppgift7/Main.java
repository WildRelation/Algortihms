package uppgift7;

public class Main {
    public static void main(String[] args){
        char[][] board = { {   'g','g','h','g','g','h','g','g','g','h','g','h','h','g','g','g','g','h','g','g','g','h','g','h','h','h','g','h','h','g','g','h','g','g','g'},
                            {   's','g','h','g','g','g','g','h','h','h','g','g','h','g','h','h','h','h','g','g','h','g','g','h','h','g','g','h','g','g','g','h','g','h','g'},
                            {   'g','h','g','g','g','g','h','g','h','h','g','g','g','g','g','g','g','g','g','h','g','h','h','g','g','h','h','g','h','h','g','h','h','h','m'}};
        System.out.println(shortestPath(board));
    }

    private static int shortestPath(char[][] board) {
    }
    
}
