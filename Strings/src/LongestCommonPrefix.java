public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int lcpLen = strs[0].length();

        for(int i = 1; i < strs.length; i++){
            lcpLen = Math.min(lcpLen, strs[i].length());
            for(int j = 0; j < lcpLen; j++){
                if(strs[i].charAt(j) != strs[0].charAt(j)){
                    lcpLen = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, lcpLen);
    }

}
