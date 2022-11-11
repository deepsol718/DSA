public class TrieNode {
    char c;
    boolean end = false;
    TrieNode[] children ;
    int childCount = 0;

    TrieNode(char c){
        this.c = c;
        children =  new TrieNode[26];
    }
}
