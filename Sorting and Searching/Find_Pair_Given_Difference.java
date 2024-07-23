class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
       HashMap<Integer, Integer> tryio = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tryio.put(arr[i], tryio.getOrDefault(arr[i], 0) + 1);
        }

        if (x != 0) {
            for (int i = 0; i < n; i++) {
                int l = x + arr[i];
                if (tryio.containsKey(l)) {
                    return 1;
                }
            }
        } else {
            for (int i : tryio.values()) {
                if (i > 1) {
                    return 1;
                }
            }
        }

        return -1;
    }
}
