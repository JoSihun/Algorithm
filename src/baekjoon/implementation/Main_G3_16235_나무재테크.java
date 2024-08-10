package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Main_G3_16235_나무재테크 {
    static int N, M, K;
    static int[][] map, nutrients;
    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    static List<Tree> trees;
    static List<Tree> liveTrees;
    static List<Tree> deadTrees;

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    private static void spring() {
        Collections.sort(trees);
        liveTrees = new ArrayList<>();
        deadTrees = new ArrayList<>();
        for (Tree tree : trees) {
            if (map[tree.x][tree.y] < tree.age) {
                deadTrees.add(tree);
                continue;
            }
            map[tree.x][tree.y] -= tree.age++;
            liveTrees.add(tree);
        }
    }

    private static void summer() {
        for (Tree tree : deadTrees)
            map[tree.x][tree.y] += tree.age / 2;
    }

    private static void autumn() {
        trees = new ArrayList<>();
        for (Tree tree : liveTrees) {
            if (tree.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = tree.x + dx[i];
                    int ny = tree.y + dy[i];
                    if (0 <= nx && nx < N && 0 <= ny && ny < N)
                        trees.add(new Tree(nx, ny, 1));
                }
            }
        }
        trees.addAll(liveTrees);
    }

    private static void winter() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] += nutrients[i][j];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        nutrients = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nutrients[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        trees = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, z));
        }

        while (K-- > 0) {
            spring();
            summer();
            autumn();
            winter();
        }

        bw.write(Integer.toString(trees.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
