public class CheckAllAsAppearsBeforeAllBs {
    public boolean checkString(String s) {
//https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
//        if (s.length() == 1) {
//            return true;
//        }
//
//        int aIndex = -1;
//        int bIndex = -1;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == 'b') {
//                bIndex = i;
//                break;
//            }
//        }
//
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (s.charAt(i) == 'a') {
//                aIndex = i;
//                break;
//            }
//        }
//
//        if (bIndex == -1 && aIndex > 1) {
//            return true;
//        }
//
//        return aIndex < bIndex;
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == 'b' && s.charAt(i+1) == 'a')
                return false;
        }
        return true;
    }
}
