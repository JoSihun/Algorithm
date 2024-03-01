package SWEA.PRO.PRACTICE3.No1삼국지게임;

import java.util.*;

class UserSolution {
    int N;
    int soldier[][];
    char monarch[][][];

    boolean [][][][] allyStatus;
    boolean [][][][] enemyStatus;

    String[][] monarchName;
    Map<String, Integer> monarchX;
    Map<String, Integer> monarchY;
    Map<String, List<String>> allyMonarch;

    boolean isNext(String monarchA, String monarchB) {
        int xA = monarchX.get(monarchA);
        int yA = monarchY.get(monarchA);
        int xB = monarchX.get(monarchB);
        int yB = monarchY.get(monarchB);
        return Math.abs(xA - xB) <= 1 && Math.abs(yA - yB) <= 1;
    }

    boolean isExists(String monarchA, String monarchB) {
        for (String key: allyMonarch.get(monarchA)) {
            if (isNext(key, monarchB)) {
                return true;
            }
        }
        return false;
    }

    void changeEnemyStatus(String monarchA, String monarchB) {
        int xA = monarchX.get(monarchA);
        int yA = monarchY.get(monarchA);
        int xB = monarchX.get(monarchB);
        int yB = monarchY.get(monarchB);
        enemyStatus[xA][yA][xB][yB] = true;
        enemyStatus[xB][yB][xA][yA] = true;
    }

    void init(int N, int mSoldier[][], char mMonarch[][][]) {
        this.N = N;
        this.soldier = mSoldier;
        this.monarch = mMonarch;

        this.monarchName = new String[N][N];
        this.allyStatus = new boolean[N][N][N][N];
        this.enemyStatus = new boolean[N][N][N][N];

        this.monarchX = new HashMap<>();
        this.monarchY = new HashMap<>();
        this.allyMonarch = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String key = String.valueOf(mMonarch[i][j]);
                allyMonarch.put(key, new ArrayList<>());
                monarchName[i][j] = key;
                monarchX.put(key, i);
                monarchY.put(key, j);
                System.out.println(monarchName[i][j]);
            }
        }
    }

    void destroy() {

    }

    int ally(char mMonarchA[], char mMonarchB[]) {
        if (Arrays.equals(mMonarchA, mMonarchB)) return -1;

        System.out.println(monarchX.keySet());
        System.out.println("mMonarchA: " + String.valueOf(mMonarchA));
        System.out.println("mMonarchB: " + String.valueOf(mMonarchB));
        System.out.println(monarchY.get(String.valueOf(mMonarchA)));
        int xA = monarchX.get(String.valueOf(mMonarchA));
        int yA = monarchY.get(String.valueOf(mMonarchA));
        int xB = monarchX.get(String.valueOf(mMonarchB));
        int yB = monarchY.get(String.valueOf(mMonarchB));

        if (allyStatus[xA][yA][xB][yB] || allyStatus[xB][yB][xA][yA]) return -1;
        if (enemyStatus[xA][yA][xB][yB] || enemyStatus[xB][yB][xA][yA]) return -2;
        List<String> allyA = allyMonarch.get(String.valueOf(mMonarchA));
        List<String> allyB = allyMonarch.get(String.valueOf(mMonarchB));
        allyA.add(String.valueOf(mMonarchB));
        allyB.add(String.valueOf(mMonarchA));
        allyMonarch.put(String.valueOf(mMonarchA), allyA);
        allyMonarch.put(String.valueOf(mMonarchB), allyB);
        allyStatus[xA][yA][xB][yB] = true;
        allyStatus[xB][yB][xA][yA] = true;
        return 1;
    }

    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
        int xA = monarchX.get(String.valueOf(mMonarchA));
        int yA = monarchY.get(String.valueOf(mMonarchA));
        int xB = monarchX.get(String.valueOf(mMonarchB));
        int yB = monarchY.get(String.valueOf(mMonarchB));
        if (allyStatus[xA][yA][xB][yB] || allyStatus[xB][yB][xA][yA]) return -1;

        // 군주 mMonarchA 의 영토 또는 동맹 영토가 군주 mMonarchB 의 영토와 인접하지 않다면 -2을 반환하고, 전투는 일어나지 않는다.
        if (!isNext(String.valueOf(mMonarchA), String.valueOf(mMonarchB))) return -2;
        else if (!isExists(String.valueOf(mMonarchA), String.valueOf(mMonarchB))) return -2;

        // 전투가 발생하면 군주 mMonarchA 의 동맹과 군주 mMonarchB 의 동맹은 서로 적대관계가 된다.
        List<String> allyA = allyMonarch.get(String.valueOf(mMonarchA));
        List<String> allyB = allyMonarch.get(String.valueOf(mMonarchB));
        for (String key1: allyA) {
            for (String key2: allyB) {
                changeEnemyStatus(key1, key2);
            }
        }

        // 전투가 발생하면 군주 mMonarchB 의 영토에 인접한 군주 mMonarchA 를 포함한 모든 동맹들은 보유한 병사의 절반을 보내 함께 공격한다.
        // 군주 mMonarchB 의 영토에 인접한 군주 mMonarchB 의 모든 동맹들도 보유한 병사의 절반을 mMonarchB 의 영토로 보내 방어를 돕는다.
        // 보내는 병사 계산시 소수점은 버린다.
        // 공격하는 병사의 수가 0명이라도 전투가 발생한 것이다.


        return -3;
    }

    int recruit(char mMonarch[], int mNum, int mOption) {
        int x = monarchX.get(String.valueOf(mMonarch));
        int y = monarchY.get(String.valueOf(mMonarch));
        if (mOption == 0) {
            soldier[x][y] += mNum;
            return soldier[x][y];
        } else if (mOption == 1) {
            int sum = 0;
            List<String> ally = allyMonarch.get(String.valueOf(mMonarch));
            for (String key : ally) {
                int xx = monarchX.get(key);
                int yy = monarchY.get(key);
                soldier[xx][yy] += mNum;
                sum += soldier[xx][yy];
            }
            return sum;
        }
        return -1;
    }
}