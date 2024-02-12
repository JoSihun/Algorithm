package SWEA2024B;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_No3_1230_암호문3_LinkedList {
    private static int N, M;
    private static int x, y;

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Custom Class that extends LinkedList
    // This class has add, insert, delete methods
    public static class CustomList {
        int size;
        Node head;
        Node tail;

        public CustomList() {
            this.size = 0;
            this.head = null;
            this.tail = null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        public void insert(int idx, int data) {
            if (idx < 0 || idx > size) {
                return;
            }
            if (idx == 0) {
                Node newNode = new Node(data);
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (idx == size) {
                Node newNode = new Node(data);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next.prev = newNode;
                temp.next = newNode;
                newNode.prev = temp;
            }
            size++;
        }

        public void delete(int idx, int count) {
            if (idx < 0 || idx >= size) {
                return;
            }
            if (idx == 0) {
                for (int i = 0; i < count; i++) {
                    head = head.next;
                    head.prev = null;
                }
            } else if (idx + count >= size) {
                Node temp = tail;
                for (int i = 0; i < count; i++) {
                    temp = temp.prev;
                }
                tail = temp;
                tail.next = null;
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                for (int i = 0; i < count; i++) {
                    temp.next = temp.next.next;
                    temp.next.prev = temp;
                }
            }
            size -= count;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            CustomList list = new CustomList();

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                char command = st.nextToken().charAt(0);
                switch (command) {
                    case 'I':
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++) {
                            list.insert(x + j, Integer.parseInt(st.nextToken()));
                        }
                        break;
                    case 'D':
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        list.delete(x, y);
                        break;
                    case 'A':
                        int y = Integer.parseInt(st.nextToken());
                        for (int j = 0; j < y; j++) {
                            list.add(Integer.parseInt(st.nextToken()));
                        }
                        break;
                }
            }

            sb.append("#").append(tc).append(" ");
            Node temp = list.head;
            for (int i = 0; i < 10; i++) {
                sb.append(temp.data).append(" ");
                temp = temp.next;
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
