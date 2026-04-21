package uppgift6;

public class Main {
    public static void main(String[] args){
        char[][] maze = {   {'*','*','*','*','*','*','*','*','*'},
                            {'*',' ',' ',' ','*',' ',' ','M','*'},
                            {'*',' ','*',' ','*','2',' ',' ','*'},
                            {'*',' ','*',' ','6','7','1','2','*'},
                            {'*',' ','*',' ',' ','*','*',' ','*'},
                            {'*',' ','*',' ',' ','5',' ',' ','*'},
                            {'*','S','8','7',' ',' ','2',' ','*'},
                            {'*','*','*','*','*','*','*','*','*'}};//25
        System.out.println(shortestTime(maze));
    }

    private static int shortestTime(char[][] maze) {
    }

}
