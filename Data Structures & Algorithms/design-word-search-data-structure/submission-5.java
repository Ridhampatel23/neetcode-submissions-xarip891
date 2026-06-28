private class TrieNode{
    TrieNode[] children;
    boolean end;

    TrieNode(){
        children = new TrieNode[26];
        end = false;
    }
}


class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()){
            if (curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
       return dfs (word, 0, root);
    }

    public boolean dfs (String word, int index, TrieNode curr){
         if (index == word.length()) return curr.end;
       
            char c = word.charAt(index);
            if (c != '.'){
                if (curr.children[c - 'a'] == null) return false;

                return dfs (word, index + 1, curr.children[c - 'a']);
            }

            for (TrieNode child : curr.children){
                if (child != null && dfs(word, index + 1, child)) return true;
            }
        
        return false;
    }
}
