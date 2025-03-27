import ExamPractice.Question12;
import ExamPractice.Question13;
import ExamPractice.Question5;
import ExamPractice.Question8;

public class Main {
    public static void main(String[] args) {

        System.out.println("Question 5 tests:");
        Question5.subtractOption1(4);
        Question5.subtractOption2(4);
        System.out.println("-------------------");
        
        System.out.println("Question 12 tests:");
        char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        System.out.println(Question12.countVowels(a, 0));
        System.out.println("-------------------");

        System.out.println("Question 13 tests:");
        System.out.println("True palindrome results (expected answer is true)");
        char[] b = {'a', 'b', 'b', 'a'};
        char[] c = {'d', '4', 'y', '4', 'd'};
        System.out.println(Question13.findPalindromeRecursively(b, 0));
        System.out.println(Question13.findPalindromeRecursively(c, 0));
        System.out.println("False palindrome results (expected answer is false)");
        char[] d = {'a', 'b', 'b', 'u'};
        char[] f = {'d', '4', 'y', '2', 'd'};
        System.out.println(Question13.findPalindromeRecursively(d, 0));
        System.out.println(Question13.findPalindromeRecursively(f, 0));
    }
}