package ExamPractice;

public class Question12 {

    public static int countVowels(char[] a, int start){
        if(start == a.length){
            return 0;
        } else if(a[start] == 'a' || a[start] == 'e'|| a[start] == 'i' || a[start] == 'o' || a[start] == 'u'){
            return 1 + countVowels(a, start + 1);
        } else {
            return 0 + countVowels(a, start + 1);
        }
    }
}
