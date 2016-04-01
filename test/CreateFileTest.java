package test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  test
 * @Package:      test.CreateFileTest.java
 * @ClassName:    CreateFileTest
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年3月29日 下午1:39:02
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年3月29日 下午1:39:02 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class CreateFileTest {
	
	private String workpath="E:/Users/Administrator/workspace/APITestTool/src/";
	private String filepath;
	private String filename;
	private String date;
	public CreateFileTest(String name){
		date=new SimpleDateFormat("MM-dd").format(new Date());
		filepath=workpath+"testcase"+date+"/";
		filename=name+".java";
	}
	public void createFile(){
		File f=new File(filepath);
		if(!f.exists()){
			f.mkdirs();
			} 
		File file=new File(f,filename);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateFileTest aa=new CreateFileTest("hhh");
		aa.createFile();
	}

}
