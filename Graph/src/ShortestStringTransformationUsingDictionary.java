import java.util.ArrayList;

/*
You are given a dictionary called words and two string arguments called start and stop.
        All given strings have equal length.
        Transform string start to string stop one character per step using words from the dictionary.
        For example, "abc" → "abd" is a valid transformation step because only one character is changed ("c" → "d"),
        but "abc" → "axy" is not a valid one because two characters are changed ("b" → "x" and "c" → "y").
        You need to find the shortest possible sequence of strings (two or more) such that:

        First string is start. Last string is stop.
        Every string (except the first one) differs from the previous one by exactly one character.
        Every string (except, possibly, first and last ones) are in the dictionary of words.
        Example One
        {
        "words": ["cat", "hat", "bad", "had"],
        "start": "bat",
        "stop": "had"
        }
        Output: ["bat", "bad", "had"] OR ["bat", "hat", "had"]
        In "bat", change "t" → "d" to get "bad".
        In "bad", change "b" → "h"to get "had".

        OR

        In "bat", change "b" → "h" to get "hat".
        In "hat", change "t" → "d" to get "had".

        Example Two
        {
        "words": [],
        "start": bbb,
        "stop": bbc
        }
        Output: ["bbb", "bbc"]
        In "bbb", the last character to "b" and get "bbc".

        Example Three
        {
        "words": [],
        "start": "zzzzzz",
        "stop": "zzzzzz"
        }
        Output: ["-1"]
        No sequence of strings exists that would satisfy all requirements.
        For example, ["zzzzzz", "zzzzzz"] does not satisfy requirement

        #3. In such situations, ["-1"] is the correct answer.

        Notes
        If two or more such sequences exist, return any.
        If no such sequence is there to be found, ["-1"] (a sequence of one string, "-1") is the correct answer.
*/
public class ShortestStringTransformationUsingDictionary {

    static ArrayList<String> string_transformation(ArrayList<String> words, String start, String stop) {

        return new ArrayList();
    }

}
