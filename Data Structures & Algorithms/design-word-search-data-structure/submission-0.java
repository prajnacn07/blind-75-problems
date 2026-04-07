class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord  = false;
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(curr.children[i] == null){
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode root, int j){
        TrieNode curr = root;
        for(int i=j; i<word.length(); i++){
            int c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child : curr.children){
                    if(child != null && dfs(word, child, i+1)){
                        return true;
                    }
                }
                return false;
            } else{
                if(curr.children[c-'a'] == null){
                   return false; 
                }
                curr = curr.children[c-'a'];
            }
        }
        return curr.endOfWord;
    }
}
