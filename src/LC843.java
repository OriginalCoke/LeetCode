import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC843 {
    //Guess the Word
    //Google
    //循环体的判断条件是10次内猜中,全中(位置和值)guess返回6,因此i<10,x<6的时候就需要循环判断;
    //每次都去更新数组,只留下匹配的位置的字符串,使得母集越来越小;
    //Random().nextInt(n)的使用, list.toArray(int length)的使用;
    //交互题目,新颖,需要改进做法
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guess);
            List<String> tempList = new ArrayList<>();
            for (String w : wordlist)
                if (match(guess, w) == x)
                    tempList.add(w);
            wordlist = tempList.toArray(new String[tempList.size()]);
        }
    }

    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) == b.charAt(i)) matches++;
        return matches;
    }
}
