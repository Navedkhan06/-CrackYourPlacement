
class Solution {

    // Define the Segment Tree Node
    public class SegmentTreeNode {
        public SegmentTreeNode left;
        public SegmentTreeNode right;
        public int start;
        public int end;
        public int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }

    // Build the Segment Tree
    public SegmentTreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end);

        if (start == end) {
            return node;
        }

        int mid = start + (end - start) / 2;
        node.left = buildTree(start, mid);
        node.right = buildTree(mid + 1, end);

        return node;
    }

    // Update the Segment Tree
    public void update(SegmentTreeNode node, int index) {
        if (node == null) {
            return;
        }
        if (node.start == index && node.end == index) {
            node.sum += 1;
            return;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if (index <= mid) {
            update(node.left, index);
        } else {
            update(node.right, index);
        }
        node.sum = (node.left != null ? node.left.sum : 0) + (node.right != null ? node.right.sum : 0);
    }

    // Query the Segment Tree
    public int sumRange(SegmentTreeNode root, int start, int end) {
        if (root == null || start > end) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            return sumRange(root.left, start, end);
        } else if (start > mid) {
            return sumRange(root.right, start, end);
        }
        return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
    }

    // Main function to count smaller elements
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int[] counts = new int[nums.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find the range of the values in nums
        for (int el : nums) {
            min = Math.min(min, el);
            max = Math.max(max, el);
        }

        // Build the Segment Tree
        SegmentTreeNode root = buildTree(min, max);

        // Traverse nums in reverse to count smaller elements
        for (int i = nums.length - 1; i >= 0; i--) {
            update(root, nums[i]);
            counts[i] = sumRange(root, min, nums[i] - 1);
        }

        // Convert counts array to List<Integer>
        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }
        return result;
    }
}
