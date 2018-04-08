package com.library.graph;

import java.util.*;

public class TestClass {

    /**
     * Issuer class struture, do no modify
     */
    private static class Issuer {
        String parentId;
        String id;

        Issuer(String parentId, String id) {
            this.parentId = parentId;
            this.id = id;
        }
    }

    static void createIssuerTree(List<Issuer> issuers) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (Issuer i : issuers) {
            List l = map.get(i.parentId);
            if (l == null) {
                l = new ArrayList();
                map.put(i.parentId, l);
            }
            l.add(i.id);
        }

        List<String> r = map.get("ROOT");
        System.out.println(r.get(0));
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Queue<String> temp;
        q1.add(r.get(0)); //Root

        do {
            StringBuilder sb = new StringBuilder();
            while (!q1.isEmpty()) {
                String s = q1.remove();
                List<String> children = map.get(s);
                if (children == null) continue;
                for (String id : children) {
                    sb.append(id).append(" ");
                    q1.add(id);
                }
            }
            System.out.println(sb.toString());
            temp = q1;
            q1 = q2;
            q2 = temp;
        } while (!q2.isEmpty());
    }

    //    https://www.hackerrank.com/challenges/gem-stones/problem
    static int gemstones(String[] arr) {
        HashSet<Character> s = new HashSet<>();
        HashMap<Character, Integer> m = new HashMap<>();
        int ret = 0;

        for (String str : arr) {
            s.clear();
            for (int i = 0; i < str.length(); i++) {
                char b = str.charAt(i);
                if (!s.contains(b)) {
                    s.add(b);
                    Integer in = m.get(b);
                    if (in == null) m.put(b, Integer.valueOf(1));
                    else {
                        Integer in1 = Integer.valueOf(in.intValue() + 1);
                        m.put(b, in1);
                        if (in1 == arr.length) ret++;
                    }
                }
            }
        }
        return ret;
    }

    public static void moveZeroes(int[] nums) {
        int z = 0;
        int nZ = 0;
        while (z < nums.length) {
            if (nums[z] == 0) break;
            z++;
        }

        while (z < nums.length) {
            nZ = z + 1;
            while (nZ < nums.length) {
                if (nums[nZ] != 0) break;
                nZ++;
            }

            if (nZ == nums.length) break;
            swap(nums, z, nZ);
            z++;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //----------------------------------------------------------
    //https://leetcode.com/problems/reverse-linked-list/description/
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode n = head.next;
        head.next = null;
        while (n != null) {
            ListNode nn = n.next;
            n.next = head;
            head = n;
            n = nn;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //----------------------------------------------------------

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Find LCA in Binary Search Tree (BST)
    public TreeNode lowestCommonAncestor_BST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor_BST(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor_BST(root.right, p, q);
        }
        return root;
    }

    //Finds LCA in a Binary Tree
    //UNTESTED. PLEASE TEST !!!
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pList = new ArrayList<TreeNode>();
        ArrayList<TreeNode> qList = new ArrayList<TreeNode>();

        boolean b1 = findPath(root, p, pList);
        boolean b2 = findPath(root, q, qList);
        if (!(b1 & b2)) {
            return null; //Atleast one of the nodes p or q is not found
        }
        int i;
        for (i = 0; i < pList.size() && i < qList.size(); i++) {
            if (pList.get(i) != qList.get(i)) break;
        }
        return pList.get(i - 1);
    }

    boolean findPath(TreeNode root, TreeNode n, ArrayList<TreeNode> list) {
        if (root == null) return false;

        list.add(root);
        if (root.val == n.val) return true;

        if (findPath(root.left, n, list)) return true;
        if (findPath(root.right, n, list)) return true;

        list.remove(list.size() - 1);
        return false;
    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int next = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                if (i != next) {
                    nums[next] = nums[i];
                }
                next++;
                prev = nums[i];
            }
        }
        return next;
    }

    //    https://leetcode.com/problems/valid-parentheses/description/
    public boolean isValid(String s) {
        byte[] b = new byte[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            byte b1 = (byte) s.charAt(i);
            if (top == -1 || complement(b[top]) != b1) {
                b[++top] = b1;
            } else {
                top--;
            }
        }
        return top == -1;
    }

    byte complement(byte b) {
        if (b == 0x28) return 0x29; //()
        if (b == 0x7B) return 0x7D; //{}
        if (b == 0x5B) return 0x5D; //[]
        return 0;
    }

//https://leetcode.com/problems/merge-intervals/description/

    /**
     * Definition for an interval.
     **/
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;

        Collections.sort(intervals, (i1, i2) -> i1.start < i2.start ? -1 : i1.start == i2.start ? 0 : 1);
        List<Interval> ret = new ArrayList<>();
        Interval m = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval ci = intervals.get(i);
            if (overlap(m, ci)) {
                m = merge(m, ci);
            } else {
                ret.add(m);
                m = ci;
            }
        }
        ret.add(m);
        return ret;
    }

    //Assumes i1 start time always less than i2, since interval set is sorted
    boolean overlap(Interval i1, Interval i2) {
        return i2.start <= i1.end;
    }

    Interval merge(Interval i1, Interval i2) {
        return new Interval(i1.start, Math.max(i1.end, i2.end));
    }

//    https://leetcode.com/problems/binary-tree-preorder-traversal/
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null) {
            ret.add(root.val);
            if (root.right != null) stack.addLast(root.right);
            if (root.left != null) stack.addLast(root.left);
            root = stack.pollLast();
        }
        return ret;
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        boolean done = false;
        while (!done) {
            if (root != null) {
                stack.addLast(root);
                root = root.left;
            } else {
                TreeNode n = stack.pollLast();
                if (n != null) {
                    ret.add(n.val);
                    root = n.right;
                } else {
                    done = true;
                }
            }
        }
        return ret;
    }

    //    https://leetcode.com/problems/binary-tree-postorder-traversal/description/
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> s = new LinkedList<>();
        boolean done = false;
        while (!done) {
            while (root != null) {
                if (root.right != null) s.push(root.right);
                s.push(root);
                root = root.left;
            }

            TreeNode n = s.pollFirst();
            if (n == null) {
                done = true;
            } else {
                if (n.right == null || n.right != s.peek()) {
                    ret.add(n.val);
                } else {
                    root = s.pollFirst();
                    s.push(n);
                }
            }
        }
        return ret;
    }

    //  https://leetcode.com/problems/binary-search-tree-iterator/description/
    public class BSTIterator {
        LinkedList<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return (stack.size() > 0);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode n = stack.pollFirst();
            int ret = -1;
            if (n != null) {
                ret = n.val;
                TreeNode root = n.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
            return ret;
        }
    }

    //https://leetcode.com/problems/excel-sheet-column-title/description/
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0, convert(n % 26));
            n /= 26;
        }
        return sb.toString();
    }

    char convert(int i) {
        return (char) (i + 65);
    }

    //  https://leetcode.com/problems/merge-k-sorted-lists/description/
    class Solution {
        ListNode head = null;
        ListNode tail = null;

        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> q = new PriorityQueue<>((q1, q2) -> (q1.val > q2.val) ? 1 : (q1.val == q2.val) ? 0 : -1);
            boolean done = false;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) q.add(lists[i]);
            }
            while (q.size() > 0) {
                ListNode l = q.remove();
                add(l);
                if (l.next != null) q.add(l.next);
            }
            return head;
        }

        void add(ListNode n) {
            if (head == null) {
                head = n;
                tail = n;
                return;
            }
            tail.next = n;
            tail = n;
        }
    }

    //    https://leetcode.com/problems/3sum/description/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //If next element (i+1) is same then skip

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // skip next element if same
                    while (left < right && nums[right] == nums[right - 1]) right--; //skip previous element is same
                    left++;
                    right--;
                } else if (sum > 0) { //Reduce the sum by decreasing right since the array is sorted
                    right--;
                } else left++;
            }
        }
        return res;
    }

    //    https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) return res;
        res.add("");
        String[] m = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            if (!Character.isDigit(c)) continue;
            int n = Character.getNumericValue(c);
            while (res.peek().length() == i) {
                String head = res.remove();
                for (char c1 : m[n].toCharArray()) {
                    res.add(head + String.valueOf(c1));
                }
            }
        }
        return res;
    }

    //    https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    //O(n) space and time complexity
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode n = q.remove();
                l.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            ret.add(l);
        }
        return ret;
    }

    public List<List<Integer>> levelOrder_fast(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelTraverse(root, 0, res);
        return res;
    }

    private void levelTraverse(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);
        levelTraverse(root.left, depth+1, res);
        levelTraverse(root.right, depth+1, res);
    }

    //    https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
    public int maxDepth_BinaryTree(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth_BinaryTree(root.left), maxDepth_BinaryTree(root.right)) + 1;
    }

    //  https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
//  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        return l.val == r.val && isMirror(l.right,r.left) && isMirror(l.left,r.right);
    }

//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
// adding up all the values along the path equals the given sum.

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int lCount = countUnivalSubtrees(root.left);
        int rCount = countUnivalSubtrees(root.right);
        if ((root.left != null && root.val == root.left.val && root.right != null && root.val == root.right.val) ||
                (root.left == null && root.val == root.right.val) ||
                (root.right == null && root.val == root.left.val)) return lCount + rCount + 1;
        else return lCount + rCount;
    }

    //    Given a binary tree, count the number of uni-value subtrees.
//    A Uni-value subtree means all nodes of the subtree have the same value.
    class countUnivalSubtrees {
        int c = 0;
        public int countUnivalSubtrees(TreeNode root) {
            f(root);
            return c;
        }
        boolean f(TreeNode n) {
            if (n == null) return true;
            if (n.left == null && n.right == null) {
                c++;
                return true;
            }
            if (n.left == null) {
                if (f(n.right) && n.val == n.right.val) {
                    c++;
                    return true;
                }
                return false;
            }
            if (n.right == null) {
                if (f(n.left) && n.val == n.left.val) {
                    c++;
                    return true;
                }
                return false;
            }

            boolean l = f(n.left);
            boolean r = f(n.right);
            if (n.val == n.left.val && n.val == n.right.val && l && r) {
                c++;
                return true;
            }
            return false;
        }
/*
Alternative implementation of function f above
        boolean f(TreeNode n) {
            if (n == null) return true;
            if (n.left == null && n.right == null) {
                c++;
                return true;
            }

            boolean l = f(n.left);
            boolean r = f(n.right);

            if (n.left != null && (!l || n.val != n.left.val)) return false;
            if (n.right != null && (!r || n.val != n.right.val)) return false;
            if (n.left != null && n.right != null && (n.val != n.left.val || n.val != n.right.val || !l || !r)) return false;
            c++;
            return true;
        }
        */
    }

    //    Given inorder and postorder traversal of a tree, construct the binary tree.
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return f(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode f(int[] in, int inS, int inE, int[] post, int postS, int postE) {
        if (postE < postS) return null;
        int v = post[postE];
        TreeNode root = new TreeNode(v);
        if (inS == inE) return root;

        int inRootIndex = indexOf(in, inS, inE, v);
        int inLeftEndIndex = inRootIndex - 1;
        int inRightStartIndex = inRootIndex + 1;
        int postLeftEndIndex = postS + inLeftEndIndex - inS;
        int postRightStartIndex = postLeftEndIndex + 1;
        root.left = f(in, inS, inLeftEndIndex, post, postS, postLeftEndIndex);
        root.right = f(in, inRightStartIndex, inE, post, postRightStartIndex, postE - 1);
        return root;
    }

    int indexOf(int[] a, int s, int e, int v) {
        for (int i = s; i <= e; i++) {
            if (a[i] == v) return i;
        }
        return -1;
    }

    //Build tree given preOrder and inOrder traversal
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return f1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    TreeNode f1(int[] pre, int preS, int preE, int[] in, int inS, int inE) {
        if (preE < preS) return null;
        int v = pre[preS];
        TreeNode root = new TreeNode(v);
        if (preS == preE) return root;

        int inRootIndex = indexOf(in, inS, inE, v);
        int inLeftEndIndex = inRootIndex - 1;
        int inRightStartIndex = inRootIndex + 1;
        int preLeftEndIndex = preS + 1 + inLeftEndIndex - inS;
        int preRightStartIndex = preLeftEndIndex + 1;
        root.left = f(pre, preS + 1, preLeftEndIndex, in, inS, inLeftEndIndex);
        root.right = f(pre, preRightStartIndex, preE, in, inRightStartIndex, inE);
        return root;
    }

//    int indexOf(int[] a, int s, int e, int v) {
//        for (int i = s; i <= e; i++) {
//            if (a[i] == v) return i;
//        }
//        return -1;
//    }

    public int minSubArrayLen(int n, int[] nums) {
        if (nums.length == 0) return 0;
        int s= 0;
        int e = 0;
        int rS = nums[s];
        while (e < nums.length) {
            if (rS == n) return e-s;
            if (rS < n) {
                if (e >= nums.length) return 0;
                rS+=nums[++e];
            }
            else {
                if (s==e) {
                    s++; e++;
                    rS = nums[s];
                }
                else {
                    rS -= nums[s++];
                }
            }
        }
        return 0;
    }

    //https://leetcode.com/problems/decode-ways/description/
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9')
                dp[i] = dp[i-1];
            if (i > 1) {
                if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) <= '6') {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }

    //https://leetcode.com/problems/same-tree/description/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //  https://leetcode.com/problems/validate-binary-search-tree/description/
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    //    https://leetcode.com/problems/binary-tree-paths/
    List<String> ret = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ret;
        f(root, String.valueOf(root.val));
        return ret;
    }

    void f(TreeNode n, String nodes) {
        if (n.left == null && n.right == null) {
            ret.add(nodes);
        }
        if (n.left != null) {
            f(n.left, nodes + "->" + n.left.val);
        }
        if (n.right != null) {
            f(n.right, nodes + "->" + n.right.val);
        }
    }

    //    https://leetcode.com/problems/diameter-of-binary-tree/description/
    int max_length = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return max_length;
    }

    int f(TreeNode root) {
        if (root == null) return 0;
        int leftLen = 0;
        int rightLen = 0;
        if (root.left != null) {
            leftLen = 1 + f(root.left);
        }
        if (root.right != null) {
            rightLen = 1 + f(root.right);
        }
        if (max_length < (leftLen + rightLen)) max_length = (leftLen + rightLen);
        return Math.max(leftLen, rightLen);
    }

    //https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
//    Incomplete, Node ordering not vertical
    int maxWidth = Integer.MIN_VALUE;
    List<List<Integer>> ret_v = new ArrayList<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return ret_v;
        traverse(root, 0);
        for (int i = 0; i < maxWidth; i++) {
            ret_v.add(i, new ArrayList<>());
        }
        v(root, maxWidth);
        return ret_v;
    }

    void traverse(TreeNode root, int i) {
        if (maxWidth < i) maxWidth = i;
        if (root.left != null) traverse(root.left, i + 1);
        if (root.right != null) traverse(root.right, i - 1);
    }

    void v(TreeNode root, int c) {
        if (c < ret.size()) {
            ret_v.get(c).add(root.val);
        }
        else {
            ret_v.add(c, new ArrayList<>());
            ret_v.get(c).add(root.val);
        }
        if (root.left != null) {
            v(root.left, c - 1);
        }
        if (root.right != null) {
            v(root.right, c + 1);
        }
    }

    //    https://leetcode.com/problems/maximum-subarray/description/
    public int maxSubArray(int[] nums) {
        if (nums == null) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + ((dp[i - 1] > 0)? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //    https://leetcode.com/problems/subsets/
    List<List<Integer>> out = new ArrayList<>();
    List<Integer> a = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for (int m = 0; m <= nums.length; m++) {
            f(nums, 0, m);
        }
        return out;
    }

    void f(int[] nums, int s, int m) {
        if (m == 0) {
            out.add(new ArrayList<>(a));
            return;
        }
        for (int i = s; i <= nums.length - m; i++) {
            a.add(nums[i]);
            f(nums, i+1, m-1);
            a.remove(a.size() - 1);
        }
    }

    //    https://leetcode.com/problems/implement-trie-prefix-tree/description/
    class Trie {

        class Node {
            boolean isWord;
            HashMap<Character, Node> children;
        }

        final Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node n = root;
            for (char c : word.toCharArray()) {
                if (n.children == null) {
                    n.children = new HashMap<>();
                }
                if (!n.children.containsKey(c)) {
                    n.children.put(c, new Node());
                }
                n = n.children.get(c);
            }
            n.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node n = root;
            for (char c : word.toCharArray()) {
                if (n.children == null || !n.children.containsKey(c)) return false;
                n = n.children.get(c);
            }
            return n.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node n = root;
            for (char c : prefix.toCharArray()) {
                if (n.children == null || !n.children.containsKey(c)) return false;
                n = n.children.get(c);
            }
            return true;
        }
    }

    //    https://leetcode.com/problems/map-sum-pairs/description/
    class MapSum {
        class Node {
            int val = 0;
            HashMap<Character, Node> children;
        }

        final Node root;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node n = root;
            for (char c : key.toCharArray()) {
                if (n.children == null) {
                    n.children = new HashMap<>();
                }
                if (!n.children.containsKey(c)) {
                    n.children.put(c, new Node());
                }
                n = n.children.get(c);
            }
            n.val = val;
        }

        public int sum(String prefix) {
            Node n = root;
            for (char c : prefix.toCharArray()) {
                if (n.children == null || !n.children.containsKey(c)) return 0;
                n = n.children.get(c);
            }

            return findSum(n);
        }

        int findSum(Node root) {
            if  (root.children == null) {
                return root.val;
            }

            int sum = root.val;
            for(Node n : root.children.values()) {
                sum +=findSum(n);
            }
            return sum;
        }
    }

}

