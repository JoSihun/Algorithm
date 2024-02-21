package SWEA.PRO.LECTURE2024.Solution_No3_Pro_병사관리_LinkedList;

class UserSolution {
    public static class Node {
        int id;
        int team;
        int score;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int mID, int mTeam, int mScore) {
            this.id = mID;
            this.team = mTeam;
            this.score = mScore;
            this.prev = null;
            this.next = null;
        }
    }

    public static class Team {
        int size;
        Node head;
        Node tail;

        public Team() {
            this.size = 0;
            this.head = null;
            this.tail = null;
        }

        public void add(Node newNode) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }
    }

    public Team[] team = new Team[6];
    public Node[] soldier = new Node[100001];

    public void init() {
        for (int i = 0; i <= 5; i++) {
            team[i] = new Team();
        }
        for (int i = 0; i < 100001; i++) {
            soldier[i] = new Node();
        }
    }

    public void hire(int mID, int mTeam, int mScore) {
        soldier[mID] = new Node(mID, mTeam, mScore);
        team[mTeam].add(soldier[mID]);
    }

    public void fire(int mID) {
        if (team[soldier[mID].team].size == 1) {
            team[soldier[mID].team].head = null;
            team[soldier[mID].team].tail = null;
            team[soldier[mID].team].size--;
        } else if (soldier[mID].prev == null) {
            team[soldier[mID].team].head = soldier[mID].next;
            team[soldier[mID].team].head.prev = null;
            team[soldier[mID].team].size--;
        } else if (soldier[mID].next == null) {
            team[soldier[mID].team].tail = soldier[mID].prev;
            team[soldier[mID].team].tail.next = null;
            team[soldier[mID].team].size--;
        } else {
            soldier[mID].prev.next = soldier[mID].next;
            soldier[mID].next.prev = soldier[mID].prev;
            team[soldier[mID].team].size--;
        }
    }

    public void updateSoldier(int mID, int mScore) {
        soldier[mID].score = mScore;
    }

    public void updateTeam(int mTeam, int mChangeScore) {
        Node temp = team[mTeam].head;
        while (temp != null) {
            if (temp.score + mChangeScore < 1) {
                temp.score = 1;
            } else if (temp.score + mChangeScore > 5) {
                temp.score = 5;
            } else {
                temp.score += mChangeScore;
            }
            temp = temp.next;
        }
    }

    public int bestSoldier(int mTeam) {
        Node maxNode = team[mTeam].head;
        Node temp = team[mTeam].head;
        while (temp != null) {
            if (maxNode.score < temp.score) {
                maxNode = temp;
            } else if (maxNode.score == temp.score) {
                if (maxNode.id < temp.id) {
                    maxNode = temp;
                }
            }
            temp = temp.next;
        }
        return maxNode.id;
    }
}
