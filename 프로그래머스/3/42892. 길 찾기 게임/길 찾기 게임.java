import java.util.*;

class Solution {
    static class Node {
        int num;
        int x, y;
        Node left, right;
        
        Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    static List<Integer> preOrderResult;
    static List<Integer> postOrderResult;
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        
        // 1. 노드 객체 생성
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        // 2. y값 기준 내림차순 정렬 (같으면 x값 오름차순)
        Arrays.sort(nodes, (a, b) -> {
            if(a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });
        
        // 3. 이진 트리 구성
        Node root = nodes[0]; // 첫 번째(가장 위) 노드가 루트
        for(int i = 1; i < n; i++) {
            insertNode(root, nodes[i]);
        }
        
        // 4. 순회
        preOrderResult = new ArrayList<>();
        postOrderResult = new ArrayList<>();
        
        preOrder(root);
        postOrder(root);
        
        // 5. 결과 반환
        int[][] answer = new int[2][n];
        for(int i = 0; i < n; i++) {
            answer[0][i] = preOrderResult.get(i);
            answer[1][i] = postOrderResult.get(i);
        }
        
        return answer;
    }
    
    // 노드를 이진 트리에 삽입 (BST 방식)
    private void insertNode(Node parent, Node child) {
        if(child.x < parent.x) { // 왼쪽
            if(parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else { // 오른쪽
            if(parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }
    
    // 전위 순회
    private void preOrder(Node node) {
        if(node == null) return;
        
        preOrderResult.add(node.num);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    // 후위 순회
    private void postOrder(Node node) {
        if(node == null) return;
        
        postOrder(node.left);
        postOrder(node.right);
        postOrderResult.add(node.num);
    }
}