import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        boolean [][] result = new boolean[numCourses][numCourses];

        //default values
        for(int i = 0; i < numCourses; i++){
            result[i][i] = false;
        }

        for (int [] prerequisite: prerequisites){
            result[prerequisite[0]][prerequisite[1]] = true;
        }

        for (int i = 0; i < numCourses; i++){
            for(int row = 0; row < numCourses; row++){
                for(int col = 0; col < numCourses; col++){
                    result[row][col] = result[row][col] || (result[row][i] && result[i][col]);
                }
            }
        }

        List<Boolean> answer = new ArrayList<>();

        for (int[] query : queries) {
            answer.add(result[query[0]][query[1]]);
        }

        return answer;
    }
}
