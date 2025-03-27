package ExamPractice;

import java.util.Arrays;

public class Question2 {

    public static int[] maxMin(int[] a){
        int[] minMax = new int[2];
        int[] vet;

        // To make things easier, check if the array has even or odd length and add
        // one more duplicate number in case it's odd
        if(a.length % 2 == 0){
            vet = Arrays.copyOf(a, a.length);
        } else {
            vet = Arrays.copyOf(a, a.length + 1);
            vet[a.length] = vet[a.length - 1];
        }

        // Run through half of the array, comparing pairs in the positions i and vet.length - 1 - i
        for(int i = 0; i < vet.length/2; i++){
            if(vet[i] > vet[vet.length - 1 - i]){
                int temp = vet[vet.length - 1 - i];
                vet[vet.length - 1 - i] = vet[i];
                vet[i] = temp;
            }
        }
        //After this, we are sure that the minimum will be on the first half
        // and the maximum will be on the second half

        //Now we search for the minimum on the first half
        int min = vet[0];
        for(int j = 1; j < vet.length / 2; j++){
            if(vet[j] < min){
                min = vet[j];
            }
        }

        //Now we search for the maximum on the second half
        int max = vet[vet.length - 1];
        for(int k = vet.length - 2; k >= vet.length / 2; k--){
            if(vet[k] > max){
                max = vet[k];
            }
        }
        
        minMax[0] = min;
        minMax[1] = max;

        return minMax;
    }
}
