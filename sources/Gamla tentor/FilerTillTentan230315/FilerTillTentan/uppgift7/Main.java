package uppgift7;

public class Main {

    public static void main(String[] args) {
        char[][] streetsEx1 = {
                {'o','s','o','o','o','o'},
                {'o','o','o','o','s','s'},
                {'o','o','h','o','o','o'},
                {'s','o','o','o','o','s'},
                {'o','o','o','s','o','o'}};
        char[][] streetsEx2 = {
                {'s','o','o','o','o','o'},
                {'o','s','s','o','s','o'},
                {'o','s','o','o','o','o'},
                {'o','h','o','o','o','s'}};
        char[][] streetsEx3 = {
                {'s','o','o','o','o','s'},
                {'o','o','o','o','o','o'},
                {'o','s','o','o','o','s'},
                {'o','o','o','o','o','o'},
                {'h','o','o','o','o','o'}};
        System.out.println("Kortaste vägen: " + shortestPath(streetsEx1));
        System.out.println("Kortaste vägen: " + shortestPath(streetsEx2));
        System.out.println("Kortaste vägen: " + shortestPath(streetsEx3));
    }

    private static int shortestPath(char[][] streets) {
    }

}
