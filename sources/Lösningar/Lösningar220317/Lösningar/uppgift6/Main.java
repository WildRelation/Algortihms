package uppgift6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        System.out.println("Result: "+ packerGreedy(10, new int[] {2,4,1}));
        System.out.println("Result: "+ packerGreedy(20, new int[] {2,15,7,6,1}));
        System.out.println("Result: "+ packer(10, new int[] {2,4,1}));
        System.out.println("Result: "+ packer(20, new int[] {2,15,7,6,1}));
    }

    private static int packerGreedy(int boxSize, int[] merchandise) {
        Arrays.sort(merchandise);
        int used = 0, nrOfMerchandise = 0, index = merchandise.length-1;
        while(used<boxSize && index>=0){
            if(merchandise[index]+used<=boxSize) {
                used += merchandise[index];
                nrOfMerchandise++;
            }else
                index--;
        }
        if(index<0) return -1;
        return nrOfMerchandise;
    }

    private static int packer(int boxSize, int[] merchandise) {
        int[] memo = new int[boxSize+1];
        for(int merch: merchandise){
            if(merch<=boxSize) memo[merch]=1;
        }
        return packer(boxSize,merchandise,memo);
    }

    private static int packer(int boxSize, int[] merchandise, int[] memo) {
        if(memo[boxSize]!=0) return memo[boxSize];
        int bestResult = Integer.MAX_VALUE/2;
        for(int merch: merchandise){
            if(merch<boxSize) bestResult = Math.min(bestResult,1+packer(boxSize-merch,merchandise,memo));
        }
        return memo[boxSize]=bestResult;
    }
}
