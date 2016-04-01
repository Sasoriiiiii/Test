package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  test
 * @Package:      test.TestHttp.java
 * @ClassName:    TestHttp
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月15日 下午4:49:39
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月15日 下午4:49:39 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class TestHttp {
	
	public static void main(String[] args){
		

        
		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		HttpPost httppost=new HttpPost("http://test.smartpos.top/portal/login/userLogin"); 
 
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("loginName", "61011437"));  
        formparams.add(new BasicNameValuePair("loginPwd", "123456"));  
        UrlEncodedFormEntity uefEntity; 
        
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) { 
                	if(entity.getContentLength()!=-1&&entity.getContentLength()<2048){
                		System.out.println("--------------------------------------");
                		System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                		System.out.println("--------------------------------------"); 
                	}else{
                		System.out.println(entity.getContentLength());
                	}
                }
                    
                    String location = response.getFirstHeader("Location").getValue(); 
                    System.out.println(location);
                    String cookie=response.getLastHeader("Set-Cookie").getValue();
                    System.out.println(cookie);
                    HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator("Set-Cookie"));
                    while(it.hasNext()){
                    	HeaderElement elem=it.nextElement();
                    	if(elem.getName().equals("JSESSIONID")){
                    		System.out.println(elem.getValue());
                    	}
                    } 
                  
			} finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    } 
}
