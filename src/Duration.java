import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class Duration {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        List<Integer> exercises = new ArrayList<>();
        int ans = getExercisesCombinationsCount(exercises, 12);
    }

    private static int  getExercisesCombinationsCount(List<Integer> exercises, int duration){
        int ans = 0;
        sort(exercises);
        List<Integer> dp = new ArrayList<>(duration+1);
        dp.set(0, 1);

        for(int j=0;j<=duration;j++){
            if(j % exercises.get(0) == 0)
                dp.set(j,1);
            else
                dp.set(j,0);
        }

        for(int i=1;i<exercises.size();i++){
            for(int j=exercises.get(i);j<=duration;j++){
                if(j % exercises.get(i) == 0){
                    int result = dp.get(j) + dp.get(j-exercises.get(i));
                    dp.set(j,result);
                }
            }
        }
        return ans;
    }
}
