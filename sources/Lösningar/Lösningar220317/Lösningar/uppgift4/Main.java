package uppgift4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] m = {   {2,	-1,	1,	2,	1,	3},
                        {4,	4,	-3,	5,	2,	2},
                        {1,	2,	-2,	3,	3,	1},
                        {5,	-4,	-3,	1,	4,	4},
                        {0,	2,	3,	2,	-5,	1}};
        System.out.println(highestSum(m));
    }

    private static int highestSum(int[][] m) {
        int[][] bestSumFrom = new int[m.length][m[0].length];
        for(int[] row:bestSumFrom)
            Arrays.fill(row,Integer.MIN_VALUE);
        return highestSum(m,0,0,bestSumFrom);
    }

    private static int highestSum(int[][] m, int row, int col,int[][] bestSumFrom) {
        if(bestSumFrom[row][col]!=Integer.MIN_VALUE) return bestSumFrom[row][col];
        if(row==m.length-1&&col==m[0].length-1) return bestSumFrom[row][col]=m[row][col];
        int sum = Integer.MIN_VALUE;
        if(row+1<m.length) sum = highestSum(m,row+1,col,bestSumFrom);
        if(col+1<m[0].length) sum = Math.max(sum,highestSum(m,row,col+1,bestSumFrom));
        if(col+2<m[0].length) sum = Math.max(sum,highestSum(m,row,col+2,bestSumFrom));
        return bestSumFrom[row][col]=sum+m[row][col];
    }
}
