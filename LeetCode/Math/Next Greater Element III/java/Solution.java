class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int i = digits.length - 2;

        
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }


        if (i < 0) return -1;

        
        int j = digits.length - 1;
        while (j >= 0 && digits[j] <= digits[i]) {
            j--;
        }

        
        swap(digits, i, j);

       
        reverse(digits, i + 1, digits.length - 1);

       
        long result = Long.parseLong(new String(digits));
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
}
