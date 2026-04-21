package uppgift4;

public class Main {

    public static void main(String[] args){

        int[][] maze = {{31,32,33,34,37,11,36},
                        {32,33,35,26,35,36,39},
                        {31,32,13,32,31,37,37},
                        {11,39,13,14,15,16,17},
                        {18,19,33,32,31,32,33},
                        {16,38,21,22,23,24,25}};
        System.out.println(existsPath(maze));
    }

    private static boolean existsPath(int[][] maze) {

    }
}
