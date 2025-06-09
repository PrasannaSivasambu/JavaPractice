import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class WordPresenceInBoardArray {
    static class Pair {
        int row, col;
        char ele;
        Pair(int row, int col,char ele) {
            this.row = row;
            this.col = col;
            this.ele=ele;
        }

        @Override
        public boolean equals(Object obj) {
            if(this==obj) return true;
            if(!(obj instanceof Pair)) return false;
            Pair p=(Pair)obj;
            if(this.col==p.col && this.row==p.row && this.ele==p.ele){
                return true;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            return Objects.hash(this.row,this.col,this.ele);
        }
    }

    private static boolean search(char[][] board,String word){
            for(int i=0; i<board.length; i++){
                        for(int j=0; j<board[0].length; j++){
                            
                           if(backTrack(board,new StringBuilder(),new LinkedList<>(),word,i,j)){
                            return true;
                           }
                        }
                    }
     return   false;
    }
    private static boolean backTrack(char[][] board, StringBuilder s,Queue<Pair> queue ,String word,int x,int y){

        int[][] adjancencyDifference = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if(word.startsWith(Character.toString( board[x][y]))){
            s.append(board[x][y]);
            Pair pair=new Pair(x, y, board[x][y]);
            Set<String> visited= new HashSet<>();
            queue.add(pair);
            while(!queue.isEmpty()){
                Pair p=queue.poll();
                System.out.println();
                System.out.println(p.ele+" Check1");
                Set<Character> set= new HashSet<>();
                for(int[] adj : adjancencyDifference){
                
                    int newRow=p.row + adj[0];
                    int newCol=p.col + adj[1];
                    if(newRow>=0 && newCol>=0 & newRow<board.length && newCol<board[0].length && !visited.contains(Integer.toString(newRow)+Integer.toString(newCol))){    
                        if(word.contains(Character.toString( board[newRow][newCol]))){
                            System.out.println("SetCheck "+set+" " +set.contains(board[newRow][newCol])+" "+newRow+" "+newCol);
                            if(set.contains(board[newRow][newCol])){
                                System.out.println("Hello "+board[newRow][newCol]);
                                queue.add(new Pair(newRow, newCol, board[newRow][newCol]));
                                continue;
                            }
                            String st= new String(s.toString());
                           
                            if(word.startsWith( st+board[newRow][newCol])){
                                System.out.println("Check2 "+st+board[newRow][newCol]+" "+newRow+" "+newCol);
                                s.append(board[newRow][newCol]);
                                set.add(board[newRow][newCol]);
                                
                                queue.add(new Pair(newRow, newCol, board[newRow][newCol]));
                                System.out.println(s+" "+set);
                                if(word.equals(s.toString())) return true;
                               
                            }
                        }
                    }
                }
               
            visited.add(Integer.toString(p.row)+Integer.toString(p.col));
            }
            
            s.delete(0, s.length());
        }
         
        
       
        return false;
    }

    public static void main(String[] args) {
        
    
    char board[][]=new char[][]{{'A','B','C','D'},
                                  {'A','C','C','B'},
                                  {'B','D','E','A'}};
    String word="ABCA";

    System.out.println( search(board,word));
    }
    
}
