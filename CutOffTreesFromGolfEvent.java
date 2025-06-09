import java.util.*;

public class CutOffTreesFromGolfEvent{
    static class Pair {
        int row, col,ele;
        Pair(int row, int col,int ele) {
            this.row = row;
            this.col = col;
            this.ele=ele;
        }
    }
    public static int bfsTraversal(List<List<Integer>> forest){

        Set<Integer> visitedSet = new HashSet<>();
        Queue<Pair> queue= new LinkedList<>();
        
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        int numberOfAvailableTrees=0,numberOfCuttedTrees=0,rows=forest.size(),cols=forest.get(0).size();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ( forest.get(i).get(j)> 0) {
                    
                    numberOfAvailableTrees++;
                } 
            }
        }
        queue.add(new Pair(0, 0,forest.get(0).get(0)));

        while(!queue.isEmpty()){
            // System.out.println("Peeking "+queue.peek().ele);
            Pair ele=queue.poll();
            // System.out.println("Element "+ele.ele+" "+queue.size());
            int r = ele.row, c = ele.col ;
            if(visitedSet.contains(ele.ele)) continue;

            visitedSet.add(ele.ele);
            numberOfCuttedTrees++;
            for(int[] dir : directions){
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                    // System.out.println(r+" "+c+"     "+newRow+ " "+ newCol) ;
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && forest.get(newRow).get(newCol)>1) {
                    int element=forest.get(newRow).get(newCol); 
                    // System.out.println(element+" polo");
                    if(!visitedSet.contains(element)) {queue.add(new Pair(newRow, newCol, element));
                    // System.out.println("Seeing ");
                    forest.get(newRow).set(newCol,1);
                    }
                }
                 
            }
        //    if(queue.size()==20) break;
           
        }
        // System.out.println(queue.size());
        // System.err.println( numberOfAvailableTrees+" "+numberOfCuttedTrees);
        if(numberOfAvailableTrees==numberOfCuttedTrees) return numberOfCuttedTrees-1;

            return -1;
        
    }
    public static void main(String[] args) {
        List<List<Integer>> list=Arrays.asList(Arrays.asList(54581641,64080174,24346381,69107959),
                                                Arrays.asList(86374198,61363882,68783324,79706116),
                                                Arrays.asList(668150,92178815,89819108,94701471),
                                                Arrays.asList(83920491,22724204,46281641,47531096),
                                                Arrays.asList(89078499,18904913,25462145,60813308));

      System.out.println(  bfsTraversal(list)); 
    //     Queue<Integer> n=new LinkedList<>();
    //     n.add(1);
    //     n.add(2);
    //     n.add(3);

    //    int r= n.poll();
    //     System.out.println(n);
        System.out.println(list);
    }
}