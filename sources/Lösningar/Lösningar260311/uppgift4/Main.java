package uppgift4;

import java.util.Arrays;

public class Main {

    static int nrCalls;
    public static void main(String[] args){
        for(int i=0;i<=10;i++){
            System.out.println(nrOfCombinationsA(i)+":"+ nrOfCombinationsB(i));
        }
        for(int i=0;i<60;i+=10){
            nrCalls=0;
            System.out.println("length: "+i+": "+ nrOfCombinationsA(i)+" calls: "+nrCalls);
            nrCalls=0;
            System.out.println("length: "+i+": "+ nrOfCombinationsB(i)+" calls: "+nrCalls);
        }
    }

    private static int nrOfCombinationsA(int length) {
        nrCalls++;
        if(length == 1) return 0;
        if(length == 0 || length==2 || length==3) return 1;
        int nrOfCombinations=0;
        nrOfCombinations+= nrOfCombinationsA(length-4);
        nrOfCombinations+= nrOfCombinationsA(length-3);
        nrOfCombinations+= nrOfCombinationsA(length-2);
        return nrOfCombinations;
    }

    private static int nrOfCombinationsB(int length) {
        if(length == 0 || length==2 || length==3) return 1;
        if(length == 1) return 0;
        int[] memo = new int[length+1];
        Arrays.fill(memo,-1);
        memo[1]=0;
        memo[0]=memo[2]=memo[3]=1;
        return nrOfCombinationsB(length,memo);
    }

    private static int nrOfCombinationsB(int length, int[] memo) {
        nrCalls++;
        if(memo[length] != -1) return memo[length];
        int nrOfCombinations=0;
        nrOfCombinations+= nrOfCombinationsB(length-4,memo);
        nrOfCombinations+= nrOfCombinationsB(length-3,memo);
        nrOfCombinations+= nrOfCombinationsB(length-2,memo);
        return memo[length]=nrOfCombinations;
    }

}
