package test;
/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  test
 * @Package:      test.QuickSort.java
 * @ClassName:    QuickSort
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年3月21日 下午5:04:50
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年3月21日 下午5:04:50 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class QuickSort {
	
	public static void sort(int arr[],int low,int high){
		int i;
		int j;
		int temp;
		int t;
	    if(low>high) 
	        return; 
	                                 
	     temp=arr[low]; //temp中存的就是基准数 
	     i=low; 
	     j=high; 
	     while(i!=j) 
	     { 
	                    //顺序很重要，要先从右边开始找 
	                    while(arr[j]>=temp && i<j) 
	                             j--; 
	                    //再找右边的 
	                    while(arr[i]<=temp && i<j) 
	                             i++; 
	                    //交换两个数在数组中的位置 
	                    if(i<j) 
	                    { 
	                             t=arr[i]; 
	                             arr[i]=arr[j]; 
	                             arr[j]=t; 
//	                    	     System.out.println("===========");
	                    } 
	     } 
	     //最终将基准数归位 
	     arr[low]=arr[i]; 
	     arr[i]=temp; 
//			System.out.print("这里的数组是：");
//			for(int o=0;o<arr.length;o++){
//				System.out.print(arr[o]+" ");
//			}
//			System.out.println();
			
	     sort(arr,low,i-1);//继续处理左边的，这里是一个递归的过程 
	     sort(arr,i+1,high);//继续处理右边的 ，这里是一个递归的过程 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={12,11,45,6,8,43,40,57,3,20,12,43,2,32,11,2,12,23};
		System.out.print("原数组是：");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
		sort(array,0,array.length-1);
		
		System.out.print("排序后 的数组是：");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
	}

}
