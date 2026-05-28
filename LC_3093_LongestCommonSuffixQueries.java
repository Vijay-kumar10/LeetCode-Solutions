public class LC_3093_LongestCommonSuffixQueries {

     public int[] stringIndices(String[] words, String[] query) {
        Trie trie = new Trie();
        
        //default case
        int index = -1;
        int smallest = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            trie.insert(words[i],i);
            if(words[i].length() < smallest){
                smallest = words[i].length();
                index = i;
            }
        }
        int ans[] = new int[query.length];
        for(int i=0;i<query.length;i++){
            int idx = trie.prefix(query[i]);
            if(idx == -1){
                ans[i] = index;
            }else{
                ans[i] = idx;
            }
        }
        return ans;
        
    }

    class TrieNode {
        int len;
        int idx;
        TrieNode[] children;

        public TrieNode() {
            idx = -1;
            len = Integer.MAX_VALUE;
            children = new TrieNode[26];
        }
    }
    
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        void insert (String s,int idx){
            TrieNode node = root;
            int n = s.length();
            for(int i=n-1;i>=0;i--){
                int ch = s.charAt(i)-'a';

                if(node.children[ch] == null){
                    node.children[ch] = new TrieNode();
                }

                node = node.children[ch];

                if(n < node.len){
                    node.len = n;
                    node.idx = idx; 
                }
            }
        }

        int prefix(String query){
            TrieNode node = root;
            int ans  = -1;
            int n = query.length();
            for(int i=n-1;i>=0;i--){
                int ch = query.charAt(i)-'a';
                if(node.children[ch]==null){
                    break;
                }
                node = node.children[ch];
                ans = node.idx;
            }
            return ans;
        }
    }
}
