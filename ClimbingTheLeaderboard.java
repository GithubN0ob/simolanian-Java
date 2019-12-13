class BadMethodPerformanceWise {

    // This is gonna time out brah. Abusing IntStreams isn't very performance efficient apparently :-/
    // Check the other class out
    
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        return IntStream.of(alice).map(i -> function(scores, i)).toArray();
    }
    
    static int function(int[] scores, int alice)  {
        return IntStream.of(scores).distinct().filter(i -> i>alice).toArray().length +1;
    }
}

class GoodMethodPerformanceWise {

    // This works
    // import java.util.*;
    // import java.util.stream.*;

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        
        scores = IntStream.of(scores).distinct().toArray();
        Arrays.sort(alice);
        int leng = scores.length;
        
        int current = scores.length-1;
        for (int i: alice) {
            
            try {
                while (scores[current] <= i) {
                    current--;
                }
            } catch (Exception e) {
                
            }
            lst.add(current+2);
        }
        int ii = IntStream.of(scores).max().getAsInt();
        
        // System.out.println(lst);
        
        return lst.stream().mapToInt(i -> i).toArray();
    }
    
    static int function(int[] scores, int alice)  {
        return IntStream.of(scores).distinct().filter(i -> i>alice).toArray().length +1;
    }
}
