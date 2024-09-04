import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class a0874WalkingRobot {
    private class Obstacles{
        HashMap<Integer, Set<Integer>> verticalObstacles = new HashMap<>();
        HashMap<Integer, Set<Integer>> horizontalObstacles = new HashMap<>();
        public Obstacles(int[][] obstacles)
        {
            for(int i = 0 ; i < obstacles.length; i++)
            {
                int x = obstacles[i][0];
                int y = obstacles[i][1];
                if(verticalObstacles.get(x)==null){
                    verticalObstacles.put(x,new HashSet<Integer>());
                }
                if(horizontalObstacles.get(y)==null)
                {
                    horizontalObstacles.put(y, new HashSet<Integer>());
                }
                horizontalObstacles.get(y).add(x);
                verticalObstacles.get(x).add(y);
            }
        }
        public boolean obstaclesInTheWay(int x, int y, int direction){
            if(direction==0 || direction == 2)
            {
                return verticalObstacles.get(x)!=null;
            }
            else return horizontalObstacles.get(y)!=null;
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        //let's fix obstacles
        Obstacles obstaclesHelper = new Obstacles(obstacles);

        //walk
        int positionX = 0;
        int positionY=0;
        int maxDistance = 0;
        int direction = 0;
        for(int i = 0 ; i < commands.length;i++)
        {
            int currCommand = commands[i];
            if(currCommand<0)
                direction=rotate(direction,currCommand);
            else{
                if(!obstaclesHelper.obstaclesInTheWay(positionX,positionY,direction))
                {
                    switch (direction){
                        case 0:positionY+=currCommand;break;
                        case 1:positionX+=currCommand;break;
                        case 2:positionY-=currCommand;break;
                        case 3:positionX-=currCommand;break;
                    }
                }
                else {
                    for (int j = 0; j < currCommand; j++) {
                        switch (direction) {
                            case 0:
                                if (!obstaclesHelper.verticalObstacles.get(positionX).contains(positionY + 1))
                                    positionY += 1;
                                break;
                            case 1:
                                if (!obstaclesHelper.horizontalObstacles.get(positionY).contains(positionX + 1))
                                    positionX += 1;
                                break;
                            case 2:
                                if (!obstaclesHelper.verticalObstacles.get(positionX).contains(positionY - 1))
                                    positionY -= 1;
                                break;
                            case 3:
                                if (!obstaclesHelper.horizontalObstacles.get(positionY).contains(positionX - 1))
                                    positionX -= 1;
                                break;
                        }
                    }
                }
                int currDistance = positionY*positionY + positionX*positionX;
                if(currDistance > maxDistance)
                    maxDistance= currDistance;
            }
        }
        return maxDistance;
    }
    public int rotate(int currentDirection, int rotation) {
        if(rotation == -2)
            return (currentDirection+3)%4;
        return  (currentDirection+1)%4;
    }



    public static void main(String[] args){
        a0874WalkingRobot rob = new a0874WalkingRobot();
        int dist = rob.robotSim(new int[]{6,-1,-1,6}, new int[][]{});
        System.out.println(dist);
    }
}
