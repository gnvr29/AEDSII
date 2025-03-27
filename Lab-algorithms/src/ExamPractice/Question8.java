package ExamPractice;

public class Question8 {

    public static void recursivePrint(int[] a, int length){
        if(length == 1){
            System.out.println(a[0]);
        }
        else{
            System.out.println(a[length-1]);
            recursivePrint(a, length-1);
        }
    }
}
