class TrieNode{
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode(){
        children = new HashMap<>();
        endOfWord = false;
    }

    public void addWords(String word){
        TrieNode curr = this;
        for(char c : word.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }
}
class Solution {
    private Set<String> res;
    private boolean[][] visit;
    int ROWS;
    int COLS;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words){
            root.addWords(word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];

        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                dfs(board, root, r, c, "");
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, TrieNode node, int r, int c, String word){
        if(r<0 || c<0 || r>=ROWS || c>=COLS || visit[r][c] || 
        !node.children.containsKey(board[r][c])){
            return;
        }

        visit[r][c] = true;

        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.endOfWord){
            res.add(word);
        }

        dfs(board, node, r + 1, c, word);
        dfs(board, node, r - 1, c, word);
        dfs(board, node, r, c + 1, word);
        dfs(board, node, r, c - 1, word);

        visit[r][c] = false;
        
    }
}
