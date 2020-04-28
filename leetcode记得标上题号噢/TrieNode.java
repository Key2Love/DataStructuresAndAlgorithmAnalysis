import sun.text.normalizer.Trie;

import java.util.Arrays;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(new Main().minimumLengthEncoding(words));
    }

    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Tire tire = new Tire();
        Arrays.sort(words, (s1, s2) -> (s2.length() - s1.length()));
        for (String st : words) {
            len += tire.insert(st);
        }
        return len;

    }
}

class TireNode {
    private TireNode[] children = new TireNode[26];

    public TireNode() {

    }

    public TireNode[] getChildren() {
        return children;
    }

    public void setChildren(TireNode[] children) {
        this.children = children;
    }
}

class Tire {
    public Tire() {
        root = new TireNode();
    }

    private TireNode root;

    public int insert(String word) {
        TireNode cur = root;
        boolean isNew = false;
        //倒着插入
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.getChildren()[c] == null) {
                isNew = true;
                cur.getChildren()[c] = new TireNode();
            }
            cur = cur.getChildren()[c];
        }
        return isNew ? word.length() + 1 : 0;
    }
}