public class FaultySensor {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int n = sensor1.length;
//https://leetcode.com/problems/faulty-sensor/
        for(int i = 0; i < n-1; i++){
            if(sensor1[i] != sensor2[i]){
                if(i == n-1){
                    return -1;
                } else if(sensor1[i] == sensor2[i+1] && sensor1[i+1] == sensor2[i]){
                    continue;
                } else if(sensor1[i] == sensor2[i+1]){
                    return 1;
                } else if(sensor1[i+1] == sensor2[i]){
                    return 2;
                }
            }
        }
        return -1;
    }
}
