package SWEA.PRO.LECTURE2024.Solution_No3_Pro_병사관리_LinkedList;

class UserSolutionAnswer {
    public static class Node {
        int id;
        int score;
        Node next;

        Node() {
        }

        Node(int id, int score) {
            this.id = id;
            this.score = score;
            this.next = null;
        }

        Node(int id, int score, Node next) {
            this.id = id;
            this.score = score;
            this.next = next;
        }
    }

    public static class Team {
        Node[] head = new Node[6];
        Node[] tail = new Node[6];
    }

    public int size = 0;
    public int[] num = new int[100055];      // num[i] := ID 가 i 인 사람의 team 번호
    public int[] score = new int[100055];  // score[i] := ID 가 i 인 사람의 최신 버전
    public Node[] node = new Node[200055];

    public Node createNode(int id, Node next) {
        Node ret = node[size++];
        ret.id = id;
        ret.next = next;
        ret.score = ++score[id];
        return ret;
    }


    public Team[] team = new Team[6];

    public void init() {
        size = 0;
        for (int i = 0; i < 200055; i++) {
            if (node[i] == null) node[i] = new Node();
        }
        for (int i = 1; i <= 5; i++) {
            team[i] = new Team();
            for (int j = 1; j <= 5; j++) {
                team[i].tail[j] = team[i].head[j] = createNode(0, null);
            }
        }

        for (int i = 0; i <= 100000; i++) {
            score[i] = 0;
            num[i] = 0;
        }
    }

    public void hire(int mID, int mTeam, int mScore) {  // O(1)
        Node newNode = createNode(mID, null);
        team[mTeam].tail[mScore].next = newNode;
        team[mTeam].tail[mScore] = newNode;
        num[mID] = mTeam;
    }

    public void fire(int mID) {  // O(1)
        score[mID] = -1;
    }

    public void updateSoldier(int mID, int mScore) {  // O(1)
        hire(mID, num[mID], mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore) {  // O(1)
        if (mChangeScore < 0) {
            for (int j = 1; j <= 5; j++) {
                int k = j + mChangeScore;
                k = k < 1 ? 1 : (k > 5 ? 5 : k);
                if (j == k) continue;

                if (team[mTeam].head[j].next == null) continue;
                team[mTeam].tail[k].next = team[mTeam].head[j].next;
                team[mTeam].tail[k] = team[mTeam].tail[j];
                team[mTeam].head[j].next = null;
                team[mTeam].tail[j] = team[mTeam].head[j];
            }
        }
        if (mChangeScore > 0) {
            for (int j = 5; j >= 1; j--) {
                int k = j + mChangeScore;
                k = k < 1 ? 1 : (k > 5 ? 5 : k);
                if (j == k) continue;

                if (team[mTeam].head[j].next == null) continue;
                team[mTeam].tail[k].next = team[mTeam].head[j].next;
                team[mTeam].tail[k] = team[mTeam].tail[j];
                team[mTeam].head[j].next = null;
                team[mTeam].tail[j] = team[mTeam].head[j];
            }
        }
    }

    public int bestSoldier(int mTeam) {  // O(N)
        for (int j = 5; j >= 1; j--) {
            Node node = team[mTeam].head[j].next;
            if (node == null) continue;

            int ans = 0;
            while (node != null) {
                if (node.score == score[node.id]) {
                    ans = ans < node.id ? node.id : ans;
                }
                node = node.next;
            }
            if (ans != 0) return ans;
        }
        return 0;
    }
}