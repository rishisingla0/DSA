class Solution {
    public void reverseString(char[] s) {
        int a = 0;
        int b = s.length-1;

        swap(s, a, b);
    }

    public void swap(char[] s, int a, int b) {
        if(b <= a) {
            return;
        }
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;

        swap(s, ++a, --b);
    }
}