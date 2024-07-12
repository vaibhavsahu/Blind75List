import java.util.HashMap;
import java.util.LinkedList;

public class MinKnightMoves {

        public int minKnightMoves(int x, int y) {
            // the offsets in the eight directions
            int[][] offsets = {{1, 2}, {2, 1}, {2, -1}, {1, -2},
                    {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

            // data structures needed to move from the origin point
            var originQueue = new LinkedList<int []>();
            originQueue.addLast(new int[]{0, 0, 0});
            var originDistance = new HashMap<String, Integer>();
            originDistance.put("0,0", 0);

            // data structures needed to move from the target point
            var targetQueue = new LinkedList<int []>();
            targetQueue.addLast(new int[]{x, y, 0});
            var targetDistance = new HashMap<String, Integer>();
            targetDistance.put(x + "," + y, 0);

            while (true) {
                // check if we reach the circle of target
                var origin = originQueue.removeFirst();
                var originXY = origin[0] + "," + origin[1];
                if (targetDistance.containsKey(originXY)) {
                    return origin[2] + targetDistance.get(originXY);
                }

                // check if we reach the circle of origin
                var target = targetQueue.removeFirst();
                var targetXY = target[0] + "," + target[1];
                if (originDistance.containsKey(targetXY)) {
                    return target[2] + originDistance.get(targetXY);
                }

                for (var offset : offsets) {
                    // expand the circle of origin
                    var nextOrigin = new int[]{origin[0] + offset[0], origin[1] + offset[1]};
                    var nextOriginXY = nextOrigin[0] + "," + nextOrigin[1];
                    if (!originDistance.containsKey(nextOriginXY)) {
                        originQueue.addLast(new int[]{nextOrigin[0], nextOrigin[1], origin[2] + 1});
                        originDistance.put(nextOriginXY, origin[2] + 1);
                    }

                    // expand the circle of target
                    var nextTarget = new int[]{target[0] + offset[0], target[1] + offset[1]};
                    var nextTargetXY = nextTarget[0] + "," + nextTarget[1];
                    if (!targetDistance.containsKey(nextTargetXY)) {
                        targetQueue.addLast(new int[]{nextTarget[0], nextTarget[1], target[2] + 1});
                        targetDistance.put(nextTargetXY, target[2] + 1);
                    }
                }
            }
        }
    }

