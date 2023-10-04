public class MaxIndexOflargestNumber {


    public static void main(String[] args) {


        int[] ar = {3,5,2,1,4,5,1,5,2,4};
        int index = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i =0;i<ar.length;i++){

            if(max<ar[i]){

                max=ar[i];
                index = i;
                count ++;
            }
        }

        System.out.println("maximum number is " +max);
        System.out.println("Index of the maximum number is " +index);
        System.out.println("Count = " +count);


    }
}
