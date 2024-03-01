package SWEA.PRO.PRACTICE3.No1삼국지게임;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class UserSolutionCopy {
    int N;
    int soldier[][];
    char monarch[][][];
    boolean[][] allyStatus;
    boolean[][] enemyStatus;
    Map<String, Integer> monarchX;
    Map<String, Integer> monarchY;

    void init(int N, int mSoldier[][], char mMonarch[][][]) {
        this.N = N;
        this.soldier = mSoldier;
        this.monarch = mMonarch;

        this.monarchX = new HashMap<>();
        this.monarchY = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String key = String.valueOf(mMonarch[i][j]);
                monarchX.put(key, i);
                monarchY.put(key, j);
            }
        }

        this.allyStatus = new boolean[N][N];
        this.enemyStatus = new boolean[N][N];
    }

    void destroy() {

    }

    int ally(char mMonarchA[], char mMonarchB[]) {
        if (Arrays.equals(mMonarchA, mMonarchB)) return -1;

        int xA = monarchX.get(String.valueOf(mMonarchA));
        int yA = monarchY.get(String.valueOf(mMonarchA));
        int xB = monarchX.get(String.valueOf(mMonarchB));
        int yB = monarchY.get(String.valueOf(mMonarchB));
        if (allyStatus[xA][yA] || allyStatus[xB][yB]) return -1;
        if (enemyStatus[xA][yA] || enemyStatus[xB][yB]) return -2;

        allyStatus[xA][yA] = true;
        allyStatus[xB][yB] = true;
        return 1;
    }

    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
        return -3;
    }

    int recruit(char mMonarch[], int mNum, int mOption) {
        int x = monarchX.get(String.valueOf(mMonarch));
        int y = monarchY.get(String.valueOf(mMonarch));
        if (mOption == 0) {
            soldier[x][y] += mNum;
            return soldier[x][y];
        } else if (mOption == 1) {
            soldier[x][y] -= mNum;
        }
        return -1;
    }
}