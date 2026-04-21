/**
    Rutten ges genom att route fylls med index för städerna i den ordning de besöks
    Det förutsätts att rutten börjar i staden med index 0 och route[0] ska sättas till 0.
    Sedan ska route[1] sättas till index för den stad som ligger närmast stad 0 osv.
    route har samma dimension som w och sista platsen i route: route[route.length-1] ska sättas
    till sista staden som besöks innan resan tillbaka till stad med index 0.
    minDistanceGreedy ska returnera längden på hela resan inklusive tillbaka till startstaden.
 **/

package nb38Tillstudenter;


import java.util.BitSet;

public class TravelingSalesMan {


    public static int minDistanceGreedy(int[][] w,int[] route){
        //använd helst et BitSet för att markera vilka du besökt
    }



}
