class Solution {
    private int slotNum = 4;

    public int openLock(String[] deadends, String target) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<String> barriers = new HashSet<>(Arrays.asList(deadends));
        int n = 10_000;

        if (barriers.contains("0000")) {
            return -1;
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair<>("0000", 0));
        while (!queue.isEmpty()) {
            Pair<String, Integer> code = queue.poll();
            if (visited.contains(code.getKey())) {
                continue;
            }
            if (code.getKey().equals(target)) {
                return code.getValue();
            }
            visited.add(code.getKey());
            for (int i = 0; i < slotNum; ++i) {
                for (int dir: new int [] {-1, 1}) {
                    String oldCode =  code.getKey();
                    int num = oldCode.charAt(i) - '0';
                    int nextNum = (num + dir + 10) % 10;
                    String nextCode = oldCode.substring(0, i) +
                        String.valueOf(nextNum) +
                        oldCode.substring(i + 1);
                    if (barriers.contains(nextCode) || visited.contains(nextCode)) {
                        continue;
                    }
                    queue.offer(new Pair<>(nextCode, code.getValue() + 1));
                }
            }
        }

        return -1;
    }
}
