package String;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class FindInDictionary {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean bfs(char[][] grid , String word , int x , int y){
        int i = 1;
        int n = word.length();
        int rowSize = grid.length;
        int colSize = grid[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x , y));
        visited[x][y] = true;

        int[][] directions = {{1,0} , {0 ,1}};

        while (!q.isEmpty()){
            Node currentNode = q.poll();
            for(int[] dir : directions){
                int nextX = currentNode.x + dir[0];
                int nextY = currentNode.y + dir[1];
                if(nextX >= 0 && nextX < rowSize && nextY >= 0 && nextY < colSize && !visited[nextX][nextY] && word.charAt(i) == grid[nextX][nextY]){
                    if(i == n -1 ) return true;
                    i++;
                    Node nextNode = new Node(nextX , nextY);
                    q.add(nextNode);
                    visited[nextX][nextY] = true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'a', 'z', 'o', 'l'},
                {'n', 'x', 'h', 'o'},
                {'v', 'y', 'i', 'v'},
                {'o', 'r', 's', 'e'}
        };
        String[] dict =  {"van", "zoho", "love", "are", "is"};
        for(String s : dict){
            char ch = s.charAt(0);
            for(int i = 0 ; i < grid.length ; i++){
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == ch){
                        if(bfs(grid , s , i , j)){
                            System.out.println(s + " : Found");
                        }
                    }
                }
            }
        }

    }
}
