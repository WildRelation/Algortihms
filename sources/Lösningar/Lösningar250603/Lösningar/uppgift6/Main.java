package uppgift6;

public class Main {

	public static void main(String[] args) {
		int X = Integer.MAX_VALUE;
		int[][] w = {	
						{	X, 2, X, X, X, 1, X, X},
						{	2, X, 2, 2, 4, X, X, X},
						{	X, 2, X, X, 3, X, X, 1},
						{	X, 2, X, X, 3, 1, X, X},
						{	X, 4, 3, 3, X, X, 7, X},
						{	1, X, X, 1, X, X, 5, X},
						{	X, X, X, X, 7, 5, X, 6},
						{	X, X, 1, X, X, X, 6, X}};
		int[][] w4 = {
				{	X, 2, X, X, X, 8, X, X},
				{	2, X, 2, 2, 4, X, X, X},
				{	X, 2, X, X, 3, X, X, 1},
				{	X, 2, X, X, 3, 1, X, X},
				{	X, 4, 3, 3, X, X, 7, X},
				{	8, X, X, 1, X, X, 5, X},
				{	X, X, X, X, 7, 5, X, 6},
				{	X, X, 1, X, X, X, 6, X}};
		int[][] w2 = {
				{	X, 3, 4, 5, 6},
				{	3, X, 6, 5, 6},
				{	4, 6, X, 3, 4},
				{	5, 5, 3, X, 2},
				{	6, 6, 4, 2, X}};
		int[][] w3 = {
				{X, 2, X, X, X, 1, X, X},
				{2, X, 2, 2, 4, X, X, X},
				{X, 2, X, X, 3, X, X, 1},
				{X, 2, X, X, 4, 1, X, X},
				{X, 4, 3, 4, X, X, 7, X},
				{1, X, X, 1, X, X, 5, X},
				{X, X, X, X, 7, 5, X, 6},
				{X, X, 1, X, X, X, 6, X}};
		int[][] w5 = {
				{	X, 1, 9, X},
				{	1, X, X, 9},
				{	9, X, X, 1},
				{	X, 9, 1, X}};
		int[][] w6 ={{X, 5, X, 3},
				{5, X, 2, 1},
				{X, 2, X, X},
				{3, 1, X, X}};

		System.out.println("Totalvikt: "+minSpanningTree(w));
	}

	public static int minSpanningTree(int[][] w){
		int d[] = new int[w.length];
		for(int i=1;i<d.length;i++) d[i]=Integer.MAX_VALUE;
		int p[] = new int [w.length];
		boolean[] taken = new boolean[w.length];

		for(int i= 0;i<d.length-1;i++){
			int u = next(d,taken);
			for(int v=0;v<w[u].length;v++)
				if(!taken[v] && d[v]>w[u][v]){
					d[v]=w[u][v];
					p[v] = u;
				}
		}
//		System.out.println("Node A var startnode "+d[0]);
//        for(int i=1; i<p.length;i++)
//            System.out.println("Nod "+(char)(i+'A')+" anslöts via "+(char)(p[i]+'A')+" med vikt:"+d[i]);
		int distance =0;
		for(int connectDistance:d)
			distance+=connectDistance;
		return distance;
	}
	static int next(int[] d, boolean[] taken){
		int minIndex=0, dMin=Integer.MAX_VALUE;
		for(int i=1;i<d.length;i++)
			if(d[i] < dMin && !taken[i]){
				minIndex = i;
				dMin = d[i];
			}
		taken[minIndex] = true;
		return minIndex;
	}
}
