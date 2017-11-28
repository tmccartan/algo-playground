// Java program program to merge two
// sorted arrays with O(1) extra space.

import java.util.Arrays;

public class MergeSorted {

  public static int[] insertionSort (int[] nums1){

    int temp;

    for(int i = 1; i < nums1.length; i++){
      for(int j = i; j > 0; j--){
        if(nums1[j] < nums1[j-1]) {
          temp = nums1[j];
          nums1[j] = nums1[j-1];
          nums1[j-1] = temp;
        }
      }
    }
    return nums1;
  }

  public static void main (String[] args){


    int[] nums1 = new int[]{4,5,6,0,0,0};
    int[] nums2 = new int[]{1,2,3};
    int m = 3;
    int n = 3;


    for(int k = 0; k < n; k++){
      nums1[m + k] = nums2[k];
    }

    System.out.println(Arrays.toString(nums1));
    insertionSort(nums1);

    System.out.println(Arrays.toString(nums1));
  }
}