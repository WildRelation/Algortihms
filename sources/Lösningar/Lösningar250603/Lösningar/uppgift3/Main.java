package uppgift3;

public class Main {

    static int nrCalls;

    public static void main(String[] args){

        int[][] m = new int[][] {   {4,3,8,7,2,7},
                                    {2,8,8,9,3,5},
                                    {1,4,1,9,4,2},
                                    {2,8,3,9,5,9},
                                    {9,9,8,3,1,7},
                                    {5,6,1,3,7,2},
                                    {9,2,2,5,6,3},
                                    {1,3,3,8,3,1},
                                    {8,4,6,8,2,5}};
        nrCalls = 0;
        System.out.println("Minsta summa: "+leastSum(m)+" calls: "+nrCalls);
        nrCalls=0;
        System.out.println("Minsta summa: "+leastSumDp(m)+" calls: "+nrCalls);
        nrCalls=0;
        System.out.println("Minsta summa: "+leastSum2(m)+" calls: "+nrCalls);

    }
    private static int leastSum(int[][] m) {
        return leastSum(m,0,0);
    }

    private static int leastSum(int[][] m, int row, int col) {
        nrCalls++;
        if(row>=m.length || col>=m[0].length) return Integer.MAX_VALUE;
        if(row==m.length-1 && col==m[0].length-1) return m[row][col];
        return m[row][col] + Integer.min(leastSum(m,row+1,col), leastSum(m,row,col+1));
    }
    private static int leastSumDp(int[][] m) {
        int[][] memo = new int[m.length][m[0].length];
        memo[m.length-1][m[0].length-1] = m[m.length-1][m[0].length-1];
        return leastSumDp(m, 0, 0, memo);
    }

    private static int leastSumDp(int[][] m, int row, int col, int[][] memo) {
        nrCalls++;
        if(row>=m.length || col>=m[0].length) return Integer.MAX_VALUE;
        if(memo[row][col]!=0) return memo[row][col];
        return memo[row][col] = m[row][col] + Integer.min(leastSumDp(m,row+1,col, memo), leastSumDp(m,row,col+1, memo));
    }
    //Nedan effektiviserar vi med att inte fortsätta om vi inte kan hitta en bättre lösning. Inte alls lika bra som dp i detta fall men
    //går naturligtvis att kombinera med dp.
    private static int leastSum2(int[][] m) {
        return leastSum2(m,0,0, Integer.MAX_VALUE, 0);
    }

    private static int leastSum2(int[][] m, int row, int col, int bestSofar, int sum) {
        nrCalls++;
        if(row>=m.length || col>=m[0].length || bestSofar<=sum) return Integer.MAX_VALUE/2;
        if(row==m.length-1 && col==m[0].length-1) return m[row][col];
        int sumDown = leastSum2(m,row+1,col, bestSofar, sum + m[row][col]);
        if(bestSofar > sumDown + sum) bestSofar = sumDown + sum;
        return m[row][col] + Integer.min(sumDown, leastSum2(m,row,col+1, bestSofar, sum + m[row][col]));
    }
}
