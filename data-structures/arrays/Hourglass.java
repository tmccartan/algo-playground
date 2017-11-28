public class Hourglass {


  /*
    Finds the maximum number of hours in hourglass from a given 2D matrix
    1 1 1 0 0 0
    0 1 0 0 0 0
    1 1 1 0 0 0
    0 0 2 4 4 0
    0 0 0 2 0 0
    0 0 1 2 4 0

    A hour glass is given as
    1 1 1
      1
    1 1 1


   */

  private final void findMaxHours() {

    int arr[][] = new int[][]{
      {1, 1, 1, 0, 0, 0},
      {0, 1, 0, 0, 0, 0},
      {1, 1, 1, 0, 0, 0},
      {0, 0, 2, 4, 4, 0},
      {0, 0, 0, 2, 0, 0},
      {0, 0, 1, 2, 4, 0},
    };

    int maxGlass = Integer.MIN_VALUE;
    for(int i=0; i <4; i++) {
      for(int j=0; j<4; j++) {
        int sumTop = arr[i][j] + arr[i][j+1] + arr[i][j+2];
        int sumMiddle = arr[i+1][j+1];
        int sumBottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

        int count = sumTop + sumMiddle + sumBottom;
        if(count > maxGlass) {
          maxGlass = Math.max(count, maxGlass);
        }
      }
    }
    System.out.println(maxGlass);
  }
  public void doWork(){
    this.findMaxHours();
  }
  public static void main(String[] args) {
    Hourglass launcher = new Hourglass();
    launcher.doWork();
  }
}