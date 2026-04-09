class Solution {
    private static final int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;

        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        for(int r=0; r<row; r++){
            dfs(r, 0, pac, heights);
            dfs(r, col-1, atl, heights);
        }

        for(int c=0; c<col; c++){
            dfs(0, c, pac, heights);
            dfs(row-1, c, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][]ocean, int[][]heights){
        ocean[r][c] = true;
        for(int[] dir : direction){
            int nr = r+dir[0];
            int nc = c+dir[1];

            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && 
            !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
