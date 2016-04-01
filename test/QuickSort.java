package test;
/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  test
 * @Package:      test.QuickSort.java
 * @ClassName:    QuickSort
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��3��21�� ����5:04:50
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��3��21�� ����5:04:50 
 * @UpdateRemark: ˵�������޸�����  
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
	                                 
	     temp=arr[low]; //temp�д�ľ��ǻ�׼�� 
	     i=low; 
	     j=high; 
	     while(i!=j) 
	     { 
	                    //˳�����Ҫ��Ҫ�ȴ��ұ߿�ʼ�� 
	                    while(arr[j]>=temp && i<j) 
	                             j--; 
	                    //�����ұߵ� 
	                    while(arr[i]<=temp && i<j) 
	                             i++; 
	                    //�����������������е�λ�� 
	                    if(i<j) 
	                    { 
	                             t=arr[i]; 
	                             arr[i]=arr[j]; 
	                             arr[j]=t; 
//	                    	     System.out.println("===========");
	                    } 
	     } 
	     //���ս���׼����λ 
	     arr[low]=arr[i]; 
	     arr[i]=temp; 
//			System.out.print("����������ǣ�");
//			for(int o=0;o<arr.length;o++){
//				System.out.print(arr[o]+" ");
//			}
//			System.out.println();
			
	     sort(arr,low,i-1);//����������ߵģ�������һ���ݹ�Ĺ��� 
	     sort(arr,i+1,high);//���������ұߵ� ��������һ���ݹ�Ĺ��� 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={12,11,45,6,8,43,40,57,3,20,12,43,2,32,11,2,12,23};
		System.out.print("ԭ�����ǣ�");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
		sort(array,0,array.length-1);
		
		System.out.print("����� �������ǣ�");
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
	}

}
