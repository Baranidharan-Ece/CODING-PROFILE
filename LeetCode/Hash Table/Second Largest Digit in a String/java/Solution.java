// class Solution {
//     public int secondHighest(String s) {
//         String d = "";
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if (Character.isDigit(ch)) {
//                 d += ch;
//             }
//         }
//         int a = Integer.parseInt(d);
//         int b = a;
//         int max = 0;
//         int res = 0;
//         while (b > 0) {
//             int t = b % 10;
//             if (t > max) {
//                 max = t;
//             }
//             if (max > t && max != t) {
//                 res = t;
//             }
//             b /= 10;
//         }
//         if (max > 1) {
//             return res;
//         }

//         return -1;
//     }
// }


class Solution {
    public int secondHighest(String s) {
        int max = -1;
        int res = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';

                if (digit > max) {
                    res = max;
                    max = digit;
                } 
                else if (digit < max && digit > res) {
                    res = digit;
                }
            }
        }

        return res;
    }
}