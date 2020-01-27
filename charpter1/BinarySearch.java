package charpter1;

/**
 * 二分查找
 */
class BinarySearch{
    public static int binarySearch(int[] list,int x){
        int low = 0, high = list.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if (list[mid] > x){
                high = mid -1;
            }else if (list[mid] < x){
                low = mid + 1;
            }else {
                return mid;
            }
            
        }
        return -1;
        
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        int b = 3;
        System.out.print(binarySearch(a , b));
        

    }
}