public class LC1119 {
    //Remove Vowels from a String
    //正则
    public String removeVowels(String S) {
        return S.replaceAll("[aeiou]", "");
    }
}
