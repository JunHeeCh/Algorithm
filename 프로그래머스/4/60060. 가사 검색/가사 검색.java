import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0; // ★ 배열 대신 정수 하나만
    }
    
    // 길이별로 Trie 뿌리를 따로 관리
    Map<Integer, TrieNode> prefixRoots = new HashMap<>();
    Map<Integer, TrieNode> suffixRoots = new HashMap<>();
    
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        for (String w : words) {
            int len = w.length();
            insert(prefixRoots, len, w);
            insert(suffixRoots, len, new StringBuilder(w).reverse().toString());
        }
        
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int len = q.length();
            
            if (q.charAt(0) == '?') {
                String rev = new StringBuilder(q).reverse().toString();
                int qIdx = rev.indexOf('?');
                String fixedPart = (qIdx == -1) ? rev : rev.substring(0, qIdx);
                answer[i] = search(suffixRoots, len, fixedPart);
            } else {
                int qIdx = q.indexOf('?');
                String fixedPart = (qIdx == -1) ? q : q.substring(0, qIdx);
                answer[i] = search(prefixRoots, len, fixedPart);
            }
        }
        
        return answer;
    }
    
    private void insert(Map<Integer, TrieNode> roots, int len, String word) {
        TrieNode cur = roots.computeIfAbsent(len, k -> new TrieNode());
        cur.count++;
        
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
            cur.count++;
        }
    }
    
    private int search(Map<Integer, TrieNode> roots, int len, String fixedPart) {
        TrieNode cur = roots.get(len);
        if (cur == null) return 0; // 그 길이를 가진 단어 자체가 없음
        
        for (char c : fixedPart.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return 0;
            }
            cur = cur.children[idx];
        }
        return cur.count;
    }
}