import java.util.*;

public class LC208 {
    //Implement Trie (Prefix Tree)
    //root是一个TrieNode,每一个TrieNode下面有26个bucket槽,对word进行 chars 的遍历,每一层进入一个bucket,判断是否存在char
    //如果存在就进入下一层,如果不存在则创建; 查询是否存在的时候,同上按照层进行遍历,最后出去的时候在最后一层;
    //如果终止的时候是全部都有的,那有可能是prefix,因此要判断是否是完整的word
    public class Trie {
        class TrieNode {
            public boolean isWord;
            public TrieNode[] children = new TrieNode[26];
        }

        private TrieNode root;
        TrieNode curr;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) cur.children[index] = new TrieNode();
                cur = cur.children[index];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            if (startsWith(word)) return curr.isWord;
            else return false;
        }

        public boolean startsWith(String prefix) {
            curr = root;
            for (char c : prefix.toCharArray()) {
                if (curr.children[c - 'a'] == null) return false;
                else curr = curr.children[c - 'a'];
            }
            return true;
        }
    }
}
