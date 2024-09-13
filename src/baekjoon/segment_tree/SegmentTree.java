package baekjoon.segment_tree;

public class SegmentTree {
    public int[] arr;
    public int[] sumTree;
    public int[] minTree;
    public int[] maxTree;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.sumTree = new int[arr.length * 4];
        this.minTree = new int[arr.length * 4];
        this.maxTree = new int[arr.length * 4];
        this.init(0, arr.length - 1, 1);
    }

    public void init(int start, int end, int node) {
        if (start == end) {
            sumTree[node] = arr[start];
            minTree[node] = arr[start];
            maxTree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }

    public int initSum(int start, int end, int node) {
        if (start == end) return sumTree[node] = arr[start];
        int mid = (start + end) / 2;
        int left = initSum(start, mid, node * 2);
        int right = initSum(mid + 1, end, node * 2 + 1);
        return sumTree[node] = left + right;
    }

    public int initMin(int start, int end, int node) {
        if (start == end) return minTree[node] = arr[start];
        int mid = (start + end) / 2;
        int left = initSum(start, mid, node * 2);
        int right = initSum(mid + 1, end, node * 2 + 1);
        return minTree[node] = Math.min(left, right);
    }

    public int initMax(int start, int end, int node) {
        if (start == end) return maxTree[node] = arr[start];
        int mid = (start + end) / 2;
        int left = initSum(start, mid, node * 2);
        int right = initSum(mid + 1, end, node * 2 + 1);
        return maxTree[node] = Math.max(left, right);
    }

    public int sumQuery(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return sumTree[node];
        int mid = (start + end) / 2;
        int sumLeft = sumQuery(start, mid, node * 2, left, right);
        int sumRight = sumQuery(mid + 1, end, node * 2 + 1, left, right);
        return sumLeft + sumRight;
    }

    public int minQuery(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return Integer.MAX_VALUE;
        if (left <= start && end <= right) return minTree[node];
        int mid = (start + end) / 2;
        int minLeft = minQuery(start, mid, node * 2, left, right);
        int minRight = minQuery(mid + 1, end, node * 2 + 1, left, right);
        return Math.min(minLeft, minRight);
    }

    public int maxQuery(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return Integer.MIN_VALUE;
        if (left <= start && end <= right) return maxTree[node];
        int mid = (start + end) / 2;
        int maxLeft = maxQuery(start, mid, node * 2, left, right);
        int maxRight = maxQuery(mid + 1, end, node * 2 + 1, left, right);
        return Math.max(maxLeft, maxRight);
    }

    public void update(int start, int end, int node, int index, int value) {
        if (index < start || index > end) return;
        if (start == end) {
            sumTree[node] = value;
            minTree[node] = value;
            maxTree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, value);
        update(mid + 1, end, node * 2 + 1, index, value);
        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
    }
}
