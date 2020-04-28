class Solution {
    public int surfaceArea(int[][] grid) {
        int len = grid.length;
        int area = 0;
        for (int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                int high = grid[i][j];
                if(high>0){
                    area += high*4+2;
                    if(i>0){
                        area -= Math.min(high,grid[i-1][j])*2;
                    }
                    if(j>0){
                        area -= Math.min(high,grid[i][j-1])*2;
                    }
                }
            }
        }
        return area;
    }
}