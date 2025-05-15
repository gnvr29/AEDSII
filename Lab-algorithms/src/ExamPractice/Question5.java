package ExamPractice;

public class Question5 {

    public static int SUBTRACTIONS = 0;

    public static void subtractOption1(int n) {
        SUBTRACTIONS = 0;
        int subtraido = 1000;

        int subtracoes = 3 * n + 2 * n * n;

        for (int i = 0; i < subtracoes; i++) {
            subtraido--;
            SUBTRACTIONS++;
        }
        System.out.println(SUBTRACTIONS + " subtraction were made with option 1");
    }

    public static void subtractOption2(int n) {
        SUBTRACTIONS = 0;
        int a = 1000, b = 1000, c = 1000, d = 1000, e = 1000;

        for(int i = 0; i < n; i++){
            a--;
            b--;
            c--;
            SUBTRACTIONS += 3;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                d--;
                e--;
                SUBTRACTIONS += 2;
            }
        }
        System.out.println(SUBTRACTIONS + " were made with option 2");
    }
}
