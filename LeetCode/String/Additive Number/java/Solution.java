class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break; // leading zero in first number
            
            for (int j = i + 1; j < n; j++) {
                if (num.charAt(i) == '0' && j - i > 1) break; // leading zero in second number
                
                String num1 = num.substring(0, i);
                String num2 = num.substring(i, j);
                if (isValid(num1, num2, num.substring(j))) return true;
            }
        }
        
        return false;
    }
    
    private boolean isValid(String num1, String num2, String remaining) {
        while (!remaining.isEmpty()) {
            String sum = addStrings(num1, num2);
            if (!remaining.startsWith(sum)) return false;
            remaining = remaining.substring(sum.length());
            num1 = num2;
            num2 = sum;
        }
        return true;
    }
    
    private String addStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        
        return sb.reverse().toString();
    }
}
