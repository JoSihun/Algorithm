package SWEA2024B.Solution_No3_Pro_병사관리_LinkedList;

class UserSolutionCopy {
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

        public void add(int mID, int mTeam, int mScore) {
            Node newNode = new Node(mID, mTeam, mScore);
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

        public void delete(int mId) {
            Node temp = head;
            while (temp != null) {
                if (temp.id == mId) {
                    // check if size == 1
                    if (size == 1) {
                        head = null;
                        tail = null;
                    } else if (temp.prev == null) {
                        head = temp.next;
                        head.prev = null;
                    } else if (temp.next == null) {
                        tail = temp.prev;
                        tail.next = null;
                    } else {
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                    }
                    size--;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public Team[] team = new Team[6];

    public void init() {
        for (int i = 0; i <= 5; i++) {
            team[i] = new Team();
        }
    }

    public void hire(int mID, int mTeam, int mScore) {
        team[mTeam].add(mID, mTeam, mScore);
    }

    public void fire(int mID) {
        for (int i = 0; i <= 5; i++) {
            team[i].delete(mID);
        }
    }

    public void updateSoldier(int mID, int mScore) {
        for (int i = 0; i <= 5; i++) {
            Node temp = team[i].head;
            while (temp != null) {
                if (temp.id == mID) {
                    temp.score = mScore;
                    break;
                }
                temp = temp.next;
            }
        }
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
