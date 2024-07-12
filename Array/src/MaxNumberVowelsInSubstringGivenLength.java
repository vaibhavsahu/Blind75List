import java.util.List;

public class MaxNumberVowelsInSubstringGivenLength {
    public int maxVowels(String s, int k) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

        int count = 0;

        for(int i = 0; i < k; i++) if(vowels.contains(s.charAt(i))) count++;

        int maxAns = count;

        for(int i = k; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))) count += 1;
            if(vowels.contains(s.charAt(i-k))) count -= 1;

            maxAns = Math.max(maxAns, count);
        }
        return maxAns;
    }
}
