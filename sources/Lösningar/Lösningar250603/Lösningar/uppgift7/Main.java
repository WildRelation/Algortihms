package uppgift7;

import java.util.Arrays;



public class Main {

    static int calls;

    public static void main(String[] args) {
        int[][] m1 = new int[][] {  {4,3,8,7,2,7},
                                    {2,8,8,9,3,5},
                                    {1,4,1,9,4,2},
                                    {2,8,3,9,5,9},
                                    {9,9,8,3,1,7},
                                    {5,6,1,3,7,2},
                                    {9,2,2,5,6,3},
                                    {1,3,3,8,3,1},
                                    {8,4,6,8,2,5}};

        int[][] m2 = new int[][] {  {4,4,4,4,4,4},
                                    {4,4,4,1,4,4},
                                    {4,4,4,1,4,4},
                                    {4,1,1,1,1,4},
                                    {4,4,1,4,4,4},
                                    {4,4,4,4,4,4},
                                    {4,4,4,4,4,4}};

        int[][] m3 = new int[][] {  {4,4,4,4,4,4},
                                    {4,4,4,1,4,4},
                                    {4,4,4,1,4,4},
                                    {4,1,4,1,4,4},
                                    {4,1,1,1,1,4},
                                    {4,4,4,1,4,4},
                                    {4,4,4,4,4,4},
                                    {4,4,4,4,4,4}};

        int[][] m4 = new int[][] {  {4,4,4,4,4,4},
                                    {4,1,4,4,4,4},
                                    {4,1,4,4,4,4},
                                    {1,1,4,1,4,4},
                                    {4,1,1,1,4,4},
                                    {4,4,4,4,4,4},
                                    {4,4,4,4,4,4},
                                    {4,4,4,4,4,4}};

        int[][] m5 = new int[][] {  {4,4,4,4,4,4},
                                    {4,4,4,4,4,4},
                                    {4,1,1,1,4,4},
                                    {4,4,4,1,1,4},
                                    {4,1,1,1,4,4},
                                    {4,4,4,4,4,4},
                                    {4,4,4,4,4,4},
                                    {4,4,4,4,4,4}};
        calls=0;
        System.out.println("Resultat: "+ leastSumOf(8, m1)+": "+calls);
        calls=0;
        System.out.println("Resultat: "+ leastSumOf(7, m2)+": "+calls);
        calls=0;
        System.out.println("Resultat: "+ leastSumOf(8, m3)+": "+calls);
        calls=0;
        System.out.println("Resultat: "+ leastSumOf(8, m4)+": "+calls);
        calls=0;
        System.out.println("Resultat: "+ leastSumOf(8, m5)+": "+calls);

    }

    private static int leastSumOf(int size, int[][] m) {
        int leastSum = Integer.MAX_VALUE,sum;
        boolean[][] visited = new boolean[m.length][m[0].length];
        for(int i=0;i<m.length;i++)
            for(int j=0;j<m[0].length;j++){
                sum = leastSumOf(size, m,i,j,1,0,leastSum,visited);
                if(sum<leastSum) leastSum = sum;
            }
        return leastSum;
    }

    private static int leastSumOf(int size, int[][] m, int row, int col, int count, int sum, int leastSum, boolean[][] visited) {
        calls++;
        if(sum+m[row][col]>=leastSum) return Integer.MAX_VALUE;
        if(count == size){
            return sum+m[row][col];
        }
        visited[row][col]=true;
        int tmpSum=Integer.MAX_VALUE;
        for(int i=0;i<m.length;i++)
            for(int j=0;j<m[0].length;j++)
                if(hasNeighbour(i,j,visited) && !visited[i][j]){
                    tmpSum = leastSumOf(size, m,i,j,count+1,sum+m[row][col],leastSum,visited);
                    if(tmpSum<leastSum) leastSum = tmpSum;
                }
        visited[row][col]=false;
        return leastSum;
    }

    private static boolean hasNeighbour(int row, int col, boolean[][] visited) {
        if(0 < row && visited[row-1][col]) return true;
        if(0 < col && visited[row][col-1]) return true;
        if(row < visited.length-1 && visited[row+1][col]) return true;
        if(col < visited[0].length-1 && visited[row][col+1]) return true;
        return false;
    }


}
