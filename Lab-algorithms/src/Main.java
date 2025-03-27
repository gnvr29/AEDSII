import ExamPractice.Question12;
import ExamPractice.Question13;
import ExamPractice.Question2;
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
        System.out.println("-------------------");

        System.out.println("Question 2 tests:");
        System.out.println("Expected results: [1, 10] and [4, 12]");
        int[] g = {7, 5, 2, 4, 6, 10, 1, 9, 3};
        int[] h = {10, 11, 7, 5, 4, 12, 8, 6};
        int[] gAnswer = Question2.maxMin(g);
        int[] hAnswer = Question2.maxMin(h);
        System.out.println(gAnswer[0] + " " + gAnswer[1]);
        System.out.println(hAnswer[0] + " " + hAnswer[1]);
    }
}