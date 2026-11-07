import java.util.*;

class Solution {
    private Map<String, Integer> steps = new HashMap<>();
    private List<List<String>> results = new ArrayList<>();
    private String beginWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return results;
        }

        this.beginWord = beginWord;
        dict.remove(beginWord);
        steps.put(beginWord, 0);

        // Phase 1: BFS to map each word to its shortest distance from beginWord
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        boolean found = false;

        while (!queue.isEmpty() && !found) {
            String curr = queue.poll();
            int currStep = steps.get(curr);
            char[] chars = curr.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue;
                    chars[i] = c;
                    String nextWord = new String(chars);

                    if (dict.contains(nextWord)) {
                        steps.put(nextWord, currStep + 1);
                        dict.remove(nextWord);
                        queue.offer(nextWord);

                        if (nextWord.equals(endWord)) {
                            found = true;
                            break;
                        }
                    }
                }
                chars[i] = original;
                if (found) break;
            }
        }

        // Phase 2: Reverse DFS from endWord back to beginWord
        if (steps.containsKey(endWord)) {
            LinkedList<String> path = new LinkedList<>();
            path.addFirst(endWord);
            backtrack(endWord, path);
        }

        return results;
    }

    private void backtrack(String word, LinkedList<String> path) {
        if (word.equals(beginWord)) {
            results.add(new ArrayList<>(path));
            return;
        }

        int currStep = steps.get(word);
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                chars[i] = c;
                String prevWord = new String(chars);

                if (steps.getOrDefault(prevWord, -1) == currStep - 1) {
                    path.addFirst(prevWord);
                    backtrack(prevWord, path);
                    path.removeFirst();
                }
            }
            chars[i] = original;
        }
    }
}
