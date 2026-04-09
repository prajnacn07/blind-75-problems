class Solution {

    private static final int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int numIslands(char[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int islandCount = 0;

        for(int r=0; r<ROW; r++){
            for(int c=0; c<COL; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';
        for(int[] dir : direction){
            dfs(grid, r+dir[0], c+dir[1]);
        }
    }
}
