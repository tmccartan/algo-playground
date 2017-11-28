import java.util.Arrays;

public class QuickSort {

  public void quickSort(int[] arr) {

    //Start with low = 0  and high at the end of the array
    quickSort(arr,0, arr.length-1);
  }

  private final void quickSort(int[] arr, int low, int high){

    if(low < high){
      //pi is the partiion
      int pivot = partition(arr, low, high);
      System.out.println("pivot = " + pivot);

      //Sort to the left
      quickSort(arr, low, pivot-1);
      //Sort to the right
      quickSort(arr, pivot+1, high);
    }
  }

  private final int partition(int[] arr, int low, int high)
  {
    int pivot = arr[high];
    int i = (low -1);
    for(int j = low; j< high; j++){
      if(arr[j]<=pivot){
        i++;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i]= temp;
      }
    }
    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;

    return i+1;

  }
  public static void main (String[] args){

    int[] nums1 = new int[]{4,5,6,1,2,3};

    System.out.println(Arrays.toString(nums1));

    QuickSort qs = new QuickSort();

    qs.quickSort(nums1);

    System.out.println(Arrays.toString(nums1));
  }
}