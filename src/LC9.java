import java.util.*;

public class LC9 {
    //Palindrome Number
    //Amazon
    //取余进行判断,那需要一个额外的存储列表
    //直接对半分进行判断,将减少的与增加的进行对比
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}
