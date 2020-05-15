/**
 * Created by lideqing@xiaomi.com on 20-2-17
 */
public class TwoZeroEight {
    public static class Trie {
        private TrieNode head;

        private static class TrieNode {

            private TrieNode[] next;
            private boolean isWord;

            public TrieNode() {
                isWord = false;
                next = new TrieNode[26];
            }

            public TrieNode getTrieNode(char s) {
                return next[s - 'a'];
            }

            public TrieNode setTrieNode(char s) {
                return next[s - 'a'] = new TrieNode();
            }

            public void setWordFlag(boolean isWord) {
                this.isWord = isWord;
            }

            public boolean getWordFlag() {
                return isWord;
            }

        }

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            head = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode tem = head;
            for (char s : word.toCharArray()) {
                TrieNode node = tem.getTrieNode(s);
                tem = (node == null ? tem.setTrieNode(s) : node);
            }
            tem.setWordFlag(true);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode tem = head;
            for (char s : word.toCharArray()) {
                TrieNode next = tem.getTrieNode(s);
                if (next != null) {
                    tem = next;
                } else {
                    return false;
                }
            }
            return tem.getWordFlag();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode tem = head;
            for (char s : prefix.toCharArray()) {
                TrieNode next = tem.getTrieNode(s);
                if (next != null) {
                    tem = next;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
