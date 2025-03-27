package ExamPractice;

public class Question13 {
    public static boolean findPalindromeRecursively(char[] a, int start){
        if(a[start] != a[a.length - 1 - start]){
            return false;
        }
        if(start == Math.floor(start / 2)){
            return true;
        }
        return findPalindromeRecursively(a, start + 1);
    }
}
