package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  test
 * @Package:      test.testJsonPath.java
 * @ClassName:    testJsonPath
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��3��7�� ����9:21:23
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��3��7�� ����9:21:23 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class testJsonPath {
	
	
	public static void main(String[] args){
		JSONObject o=JSON.parseObject("{\"clazz\":null,\"data\":{\"total\":3,\"list\":[{\"class\":\"saas.retail.GoodsUnit\",\"id\":8001}]},\"isSuccess\":true,\"message\":null,\"result\":\"SUCCESS\"}");
		String s=JsonPath.read(o, "$.result");

		System.out.println(s);
		System.out.println(JsonPath.read(o, "$"));
		
	}
	
}
