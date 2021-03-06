package rpf.quickSort;

public class QuickSort {


	public static void  compare2(int[] arrays,int left,int right) {
		int _left=left;
		int _right=right;
		
		System.out.println(left+"--"+right);
		if(left<=right) {
			int temp=arrays[left];
		
		while (left!=right) {
			while(right>left&&arrays[right]>=temp)
				right--;
				arrays[left]=arrays[right];
			while(right>left&&arrays[left]<=temp)
				left++;
				arrays[right]=arrays[left];
			
		}
		arrays[right]=temp;
		
		compare2(arrays, _left, left-1);
		compare2(arrays, right+1, _right);
		}
	}
	 public static void quickSort(int arr[],int _left,int _right){
	        int left = _left;
	        int right = _right;
	        int temp = 0;
	        if(left <= right){   //待排序的元素至少有两个的情况
	            temp = arr[left];  //待排序的第一个元素作为基准元素
	            while(left != right){   //从左右两边交替扫描，直到left = right

	                while(right > left && arr[right] >= temp)  
	                     right --;        //从右往左扫描，找到第一个比基准元素小的元素
	                  arr[left] = arr[right];  //找到这种元素arr[right]后与arr[left]交换

	                while(left < right && arr[left] <= temp)
	                     left ++;         //从左往右扫描，找到第一个比基准元素大的元素
	                  arr[right] = arr[left];  //找到这种元素arr[left]后，与arr[right]交换

	            }
	            arr[right] = temp;    //基准元素归位
	            quickSort(arr,_left,left-1);  //对基准元素左边的元素进行递归排序
	            quickSort(arr, right+1,_right);  //对基准元素右边的进行递归排序
	        }        
	    }
	public static void main(String[] args) {
		int [] arr= {44,2,33,6,88,12,66};
		compare2(arr, 0, arr.length-1);
		for (int i : arr) {
			System.out.print(i+"--");
		}
		//System.out.println(arr);
	}
}
