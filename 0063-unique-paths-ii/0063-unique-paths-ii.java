class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int [][] numInCell = new int[obstacleGrid.length][obstacleGrid[0].length];
        int ifNotRock = 1;
        //initialize 1st row and 1st column with 1(if not rock)
        for(int j = 0; j < obstacleGrid[0].length; ++j){
            if(obstacleGrid[0][j] == 1) ifNotRock = 0;
            numInCell[0][j] = ifNotRock;
        }
        ifNotRock = 1;
        for(int i = 0; i < obstacleGrid.length; ++i){
            if(obstacleGrid[i][0] == 1) ifNotRock = 0;
            else numInCell[i][0] = ifNotRock;
        }

        // fill array of possible ways to certain cell
        for(int i = 1; i < obstacleGrid.length; ++i){
            for(int j = 1; j < obstacleGrid[0].length; ++j){
                if(obstacleGrid[i][j] == 0) // 1 - obstacle
                {
                    numInCell[i][j] = numInCell[i - 1][j] + numInCell[i][j - 1];
                }
                else{
                    numInCell[i][j] = 0;
                }
            }
        }

        return numInCell[obstacleGrid.length - 1][obstacleGrid[0].length - 1]; 
    }
}