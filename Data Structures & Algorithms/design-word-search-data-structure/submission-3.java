class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean end = false;
}


class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.end = true;
    }

    public boolean search(String word) {
       return dfs (word, 0, root);
    }

    public boolean dfs (String word, int index, TrieNode curr){
        for(int i = index; i < word.length(); i++){
            char c = word.charAt(i);
            if (c == '.'){
                for (TrieNode child : curr.children.values()) {
                    if (dfs(word, i + 1, child)) return true;
                }
                return false;
            } else {
                if (!curr.children.containsKey(c)) return false;
                curr = curr.children.get(c);
            }
        }
        return curr.end;
    }
}
