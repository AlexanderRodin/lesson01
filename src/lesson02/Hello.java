package lesson02;

public class Hello {
    public static void main(String[] args) {
        int[] number = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] numberArray = new int[8];
        int[] numberArrayThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] randomArray = {1, 4, 7, 10, 13, 16, 19, 22};
        int sizeUserArrey = 5;
        int[] sumArr = {2, 1, 1, 2, 1};




        arrayOutput(fillingArreyNumbers(numberArray));
        System.out.println();
        arrayOutput(changeOfVariables(number));
        System.out.println();
        arrayOutput(arrayMultiplication(numberArrayThree));
        System.out.println();
        System.out.println("Минимальное значение массива: " + minArray(randomArray));
        System.out.println("Максимальное значение массива: " + maxArray(randomArray));
        System.out.println();
        integerArray(sizeUserArrey);
        System.out.println();
        System.out.println(arrayBalance(sumArr));





    }
    private static void arrayOutput(int[] arrey){
        for(int i=0;i<arrey.length;i++){
            System.out.print(arrey[i]+" ");
        }
    }
    private static int[] changeOfVariables (int[] num){
         int[] newArr = num;
         for(int i=0; i<num.length;i++){
            if(newArr[i]==0)num[i]=1;
            else num[i]=0;
        }
         return num;
    }
    private static int[] fillingArreyNumbers(int[] arr){
       int[] arrNumbers = {1, 4, 7, 10, 13, 16, 19, 22};
       for(int i=0;i<arr.length;i++){
            arr[i] = arrNumbers[i];
       }
       return arr;
    }
    private static int[] arrayMultiplication(int[] arr){
        int[] newArray = arr;
        for(int i = 0;i<arr.length;i++){
            if(newArray[i]<6)arr[i]*=2;
        }
        return arr;
    }
    private static int minArray(int[] arr){
        int min = arr[3];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min) min=arr[i];
        }
        return min;
    }
    private static int maxArray(int[] arr){
        int max = arr[3];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }
    private static int[][] integerArray(int sizeArray){
        int num = sizeArray;
        int[][] sqrArray = new int[sizeArray][sizeArray];
        for(int i = 0; i < sizeArray; i++) {
            for (int j = 0; j < sizeArray; j++) {
                if(i==j || j==(num-i-1))sqrArray[i][j]=1;
                    else sqrArray[i][j]=0;
                System.out.printf("%4d", sqrArray[i][j]);
            }
            System.out.println();
        }
        return sqrArray;
    }
    private static boolean arrayBalance(int[] arr){
        int leftSum = 0;
        for(int i = 0; i < arr.length; i++){
            leftSum += arr[i];
            int rightSum = 0;
            for (int j = 0; j < arr.length; j++){
                if(j>i)rightSum=rightSum+arr[j];
                else rightSum=0;
                //rightSum += (j > i)? arr[j] : 0;
            }
            if(leftSum == rightSum){
                return true;
            }
        }
        return false;

    }

}



