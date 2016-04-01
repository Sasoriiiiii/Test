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
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年3月7日 上午9:21:23
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年3月7日 上午9:21:23 
 * @UpdateRemark: 说明本次修改内容  
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
