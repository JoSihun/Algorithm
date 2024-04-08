package PROGRAMMERS;

import java.util.HashMap;
import java.util.Map;

public class PGM_LV1_258712_가장많이받은선 {
    public static void main(String[] args) {

    }

    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> index = new HashMap<>();

        int n = friends.length;
        for (int i = 0; i < n; i++)
            index.put(friends[i], i);

        int[][] records = new int[n][n];
        for (String gift : gifts) {
            String[] friendName = gift.split(" ");
            int indexA = index.get(friendName[0]);
            int indexB = index.get(friendName[1]);
            records[indexA][indexB]++;
        }

        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                scores[i][0] += records[i][j];  // Give
                scores[i][1] += records[j][i];  // Take
            }
            scores[i][2] = scores[i][0] - scores[i][1]; // Give - Take
        }

        int answer = 0;
        for (int friendA = 0; friendA < n; friendA++) {
            int take = 0;
            for (int friendB = 0; friendB < n; friendB++) {
                if (friendA == friendB) continue;
                if (records[friendA][friendB] > records[friendB][friendA] ||
                        (records[friendA][friendB] == records[friendB][friendA] &&
                                scores[friendA][2] > scores[friendB][2])) {
                    take++;
                }
            }
            answer = Math.max(answer, take);
        }

        return answer;
    }
}
