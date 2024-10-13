class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // we have a string, t, which divides a string s if s can be formed by repeating t one or more times
        // objective: is to find the largest string, x, such that it divides both str1 and str2

        // if str1 + str2 == str2 + str1, str1 and str2 are made up of some common substring
        // the length of the GCD string would be the lenghts of str1 and str2

        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());

        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }

        return gcd(b, a % b);
    }
}