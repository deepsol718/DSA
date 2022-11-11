public class TriesClass {
    TrieNode root ;
    int count = 0;

    TriesClass(){
        root = new TrieNode('\0');
    }

    public void add (String word){
        count++;
        add(word, root);
    }

    public void add(String word, TrieNode root){
        int i = word.charAt(0) - 'a';
        if (root.children[i] == null){
            root.children[i] = new TrieNode(word.charAt(0));
            root.children[i].childCount++;
//            System.out.print(word.charAt(0));
        }
//        else System.out.print(word.charAt(0));
        if (word.length() == 1){
            root.children[i].end = true;
//            System.out.print(root.children[i].c);
            return;
        }
        add(word.substring(1), root.children[i]);
    }

    public void print(){
        print(root,"");
    }

    public void print(TrieNode root, String word){
        if (root.end){
            System.out.print(word+" ");
        }

        for (int i = 0; i < 26; i++){
            if (root.children[i] != null){
                String temp = word + root.children[i].c;
                print(root.children[i],temp);
            }
        }
    }

    public boolean search(String word){
        return search(word,root);
    }

    public boolean search (String word, TrieNode root){
        int i = word.charAt(0) - 'a';
        if (root.children[i] == null) return false;
        if (word.length() == 1){
            return root.children[i].end;
        }

        boolean ans = search(word.substring(1),root.children[i]);

        return ans;
    }

    public boolean checksNext(TrieNode root){
        for (int i = 0; i < 26; i++) if (root.children[i] != null) return true;

        return false;
    }

}
