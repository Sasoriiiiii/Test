package test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.net.ssl.SSLHandshakeException;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParamBean;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  test
 * @Package:      test.HttpClientDemo.java
 * @ClassName:    HttpClientDemo
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月16日 上午11:41:46
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月16日 上午11:41:46 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class HttpClientDemo {

    public static void test() {
	
	// 创建HttpClient实例
	HttpClient httpclient = new DefaultHttpClient();
	// 创建Get方法实例
	URI uri;
	HttpGet httpget;
	// HttpResponse response;
	// #################请求处理#################
	// HttpGet httpget = new HttpGet("http://www.baidu.com/");
	
	try {
	    
	    // HttpClient的提供了一些实用的方法来简化创建和修改的请求URI
	    // URI可以组装编程
	    /**
	    uri = URIUtils.createURI("http", "www.google.cn", -1, "/search",
		    "q=lenovosec&btnG=Google+Search&aq=f&oq=", null);
	    httpget = new HttpGet(uri);
	    System.out.println(httpget.getURI());
	    **/
	    
	    // 查询字符串也可格式化组装成List的参数形式
	    /**
	    List<NameValuePair> qparams = new ArrayList<NameValuePair>();
	    qparams.add(new BasicNameValuePair("q", "lenovosec"));
	    qparams.add(new BasicNameValuePair("btnG", "Google Search"));
	    qparams.add(new BasicNameValuePair("aq", "f"));
	    qparams.add(new BasicNameValuePair("oq", null));
	    uri = URIUtils.createURI("http", "www.google.cn", -1, "/search", 
	        URLEncodedUtils.format(qparams, "UTF-8"), null);
	    httpget = new HttpGet(uri);
	    System.out.println(httpget.getURI());
	    **/
	    
	    // #################处理响应#################
	    /**
	    // 发送请求，得到响应
	    response = httpclient.execute(httpget);
	    // 从响应中获取消息实体
	    HttpEntity entity = response.getEntity();
	    // 处理响应的消息实体，如果有
	    if (entity != null) {
		StringBuffer sb = HttpClientUtil.processEntity(entity);
		System.out.println(sb);
	    }
	    **/
	    
	    // HTTP响应消息是由服务器返回给客户端的接收和解释的请求消息。
	    // 该消息的第一行包含一个数字状态代码及其相关文本所遵循的协议版本。
	    /**
	    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, 
		    HttpStatus.SC_OK, "OK");
	    System.out.println(response.getProtocolVersion());
	    System.out.println(response.getStatusLine().getStatusCode());
	    System.out.println(response.getStatusLine().getReasonPhrase());
	    System.out.println(response.getStatusLine().toString());
	    **/
	    
	    // HTTP响应可包含消息的描述，例如内容长度、内容类型及消息头数目 
	    // HttpClient提供了处理检索、添加、删除和枚举消息头等的方法
	    /**
	    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, 
		    HttpStatus.SC_OK, "OK");
	    response.addHeader("Set-Cookie", 
		    "c1=a; path=/; domain=localhost");
	    response.addHeader("Set-Cookie", 
		    "c2=b; path=\"/\", c3=c; domain=\"localhost\"");
	    Header h1 = response.getFirstHeader("Set-Cookie");
	    System.out.println(h1);
	    Header h2 = response.getLastHeader("Set-Cookie");
	    System.out.println(h2);
	    Header[] hs = response.getHeaders("Set-Cookie");
	    System.out.println(hs.length);
	    **/
	    
	    // 最有效的方法是使用HeaderIterator接口获取给定类型的所有头消息
	    /**
	    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, 
		    HttpStatus.SC_OK, "OK");
	    response.addHeader("Set-Cookie", 
	    	"c1=a; path=/; domain=localhost");
	    response.addHeader("Set-Cookie", 
		"c2=b; path=\"/\", c3=c; domain=\"localhost\"");

	    HeaderIterator it = response.headerIterator("Set-Cookie");
	    while (it.hasNext()) {
		System.out.println(it.next());
	    }
	    **/
	    
	    // 使用简便方法解析为单个的HTTP消息头元素
	    /**
	    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, 
		    HttpStatus.SC_OK, "OK");
	    response.addHeader("Set-Cookie", 
	    	"c1=a; path=/; domain=localhost");
	    response.addHeader("Set-Cookie", 
	    	"c2=b; path=\"/\", c3=c; domain=\"localhost\"");

	    HeaderElementIterator it = new BasicHeaderElementIterator(
		    response.headerIterator("Set-Cookie"));

	    while (it.hasNext()) {
		HeaderElement elem = it.nextElement(); 
		System.out.println(elem.getName() + " = " + elem.getValue());
		NameValuePair[] params = elem.getParameters();
		for (int i = 0; i < params.length; i++) {
		    System.out.println(" " + params[i]);
		}
	    }
	    **/
	    /**
	    // 输出结果
	    c1 = a
	    path=/
            domain=localhost
            c2 = b
            path=/
            c3 = c
            domain=localhost
	    **/
	    
	    // #################消息实体#################
	    // HTTP消息可以消息实体的形式进行请求或响应
	    // 消息实体可找到服务器的请求需求并将响应封装返回给客户端
	    // HTTP协议规范定义了两个封装实体的方法：POST和PUT
	    // 通常将响应附加在实体的内容里返回
	    // 规则定义了一些例外：返回消息头，204表示没有内容、304未修改、205重置内容
	    // ####################
	    // HttpClient的实体分为三种类型，取决于其内容的来源
	    // Streamed. 内容是接受到的流，或者适时生成.这类实体一般不会重复
	    // Self-contained. 内容主要是从内容获其他实体中获取，可重复，主要用于将HTTP请求进行封装
	    // Wrapping. 内容是从其他实体中得到
	    // 以上三种实体类型，建议考虑使用非Streamed的可重复的实体类型，便于实际控制
	    
	    // 使用HTTP实体，获取实体相关信息
	    /**
	    StringEntity myEntity = new StringEntity("important message", 
		    "UTF-8");
	    System.out.println(myEntity.getContentType());
	    System.out.println(myEntity.getContentLength());
	    System.out.println(EntityUtils.getContentCharSet(myEntity));
	    System.out.println(EntityUtils.toString(myEntity));
	    System.out.println(EntityUtils.toByteArray(myEntity).length);
	    **/
	    /**
	    // 输出结果
	    	Content-Type: text/plain; charset=UTF-8
		17
		UTF-8
		important message
		17
	    **/
	    
	    // 确保资源释放
	    /**
	    HttpGet httpgets = new HttpGet("http://www.google.com/");
	    HttpResponse response = httpclient.execute(httpgets);
	    HttpEntity entity = response.getEntity();
	    if (entity != null) {
	        InputStream instreams = entity.getContent();
	        int byteOne = instreams.read();
	        int byteTwo = instreams.read();
	        System.out.println("Do something");
	        // Do not need the rest
	        httpgets.abort();
	    }
	    **/
	    
	    // 销毁实体内容
	    // 不建议使用HttpEntity，除非来自安全且长度已知
	    /**
	    HttpGet httpgets = new HttpGet("http://www.google.com/");
	    HttpResponse response = httpclient.execute(httpgets);
	    HttpEntity entity = response.getEntity();
	    if (entity != null) {
		
	        //long len = entity.getContentLength();
	        //if (len != -1 && len < 2048) {
	            System.out.println(EntityUtils.toString(entity));
	        //} else {
	        //    // Stream content out
	        //}
	        
	        entity = new BufferedHttpEntity(entity);
	        System.out.println(EntityUtils.toString(entity));
	    }
	    **/
	    
	    // 构建实体内容，发送文本文件，FileEntity类可有效封装文件
	    /**
	    File file = new File("somefile.txt");
	    FileEntity entity = new FileEntity(file, "text/plain; charset=\"UTF-8\"");
	    HttpPost httppost = new HttpPost("http://www.google.com/action.do");
	    httppost.setEntity(entity);
	    **/
	    
	    // 动态内容实体
	    /**
	    ContentProducer cp = new ContentProducer() {
		
		public void writeTo(OutputStream outstream) throws IOException {
		    Writer writer = new OutputStreamWriter(outstream, "UTF-8");
		    writer.write("<response>");
		    writer.write("  <content>");
		    writer.write("    important stuff");
		    writer.write("  </content>");
		    writer.write("</response>");
		    writer.flush();
		}
	    };
	    HttpEntity entity = new EntityTemplate(cp);
	    HttpPost httppost = new HttpPost("http://localhost/action.do");
	    httppost.setEntity(entity);
	    **/
	    
	    // HTML表单，HttpClient的提供特殊的实体类UrlEncodedFormEntity进行处理表单
	    /**
	    List<NameValuePair> formparams = new ArrayList<NameValuePair>();
	    formparams.add(new BasicNameValuePair("param1", "value1"));
	    formparams.add(new BasicNameValuePair("param2", "value2"));
	    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
	    HttpPost httppost = new HttpPost("http://localhost/handler.do");
	    httppost.setEntity(entity);
	    // 编码参数 param1=value1&param2=value2
	    **/
	    
	    // 内容块编码
	    /**
	    StringEntity entity = new StringEntity("important message", 
		    "text/plain; charset=\"UTF-8\"");
	    entity.setChunked(true);
	    HttpPost httppost = new HttpPost("http://localhost/acrtion.do");
	    httppost.setEntity(entity);
	    **/
	    
	    // #################操作响应#################
	    
	    // 最简便的方式是使用ResponseHandler接口处理.
	    // HttpClient使用ResponseHandler会自动管理连接的释放，解决了对连接的释放管理
	    /**
	    HttpClient hc = new DefaultHttpClient();
	    HttpGet hg = new HttpGet("http://localhost/");

	    ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>() {
	        public byte[] handleResponse(
	                HttpResponse response) throws ClientProtocolException, IOException {
	            HttpEntity entity = response.getEntity();
	            if (entity != null) {
	                return EntityUtils.toByteArray(entity);
	            } else {
	                return null;
	            }
	        }
	    };
	    byte[] response = httpclient.execute(hg, handler);
   	    **/
	    
	    // HttpClient执行HTTP上下文
	    /**
	    DefaultHttpClient hc = new DefaultHttpClient();
	    HttpContext localContext = new BasicHttpContext();
	    HttpGet hg = new HttpGet("http://www.google.com/");

	    HttpResponse response = hc.execute(hg, localContext);

	    HttpHost target = (HttpHost) localContext.getAttribute(
		    ExecutionContext.HTTP_TARGET_HOST);

	    System.out.println("Final target: " + target);

	    HttpEntity entity = response.getEntity();
	    if (entity != null) {
		entity.consumeContent();
	    }
	    **/
	    
	    // 异常自动恢复处理
	    /**
	    // 使用HttpRequestRetryHandler接口的实现异常恢复
	    DefaultHttpClient hc = new DefaultHttpClient();
	    HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
	        public boolean retryRequest(
	                IOException exception, 
	                int executionCount,
	                HttpContext context) {
	            if (executionCount >= 5) {
	                // 超过最大次数则不需要重试
	                return false;
	            }
	            if (exception instanceof NoHttpResponseException) {
	                // 服务停掉则重新尝试连接
	                return true;
	            }
	            if (exception instanceof SSLHandshakeException) {
	                // SSL异常不需要重试
	                return false;
	            }
	            HttpRequest request = (HttpRequest) context.getAttribute(
	                    ExecutionContext.HTTP_REQUEST);
	            boolean idempotent = !(request instanceof HttpEntityEnclosingRequest); 
	            if (idempotent) {
	                // 请求内容相同则重试 
	                return true;
	            }
	            return false;
	        }
	    };
	    hc.setHttpRequestRetryHandler(myRetryHandler);
	    **/
	    
	    // HTTP协议拦截器
	    /**
	    DefaultHttpClient hc = new DefaultHttpClient();
	    HttpContext localContext = new BasicHttpContext();
	    AtomicInteger count = new AtomicInteger(1);
	    localContext.setAttribute("count", count);
	    hc.addRequestInterceptor(new HttpRequestInterceptor() {
	        public void process(
	                final HttpRequest request, 
	                final HttpContext context) throws HttpException, IOException {
	            AtomicInteger count = (AtomicInteger) context.getAttribute("count");
	            request.addHeader("Count", Integer.toString(count.getAndIncrement()));
	        }
	    });
	    HttpGet hg = new HttpGet("http://localhost/");
	    for (int i = 0; i < 10; i++) {
	        HttpResponse response = httpclient.execute(hg, localContext);
	        HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            entity.consumeContent();
	        }
	    }
	    **/
	    
	    // HTTP参数，一次写入多次夺取使用，可设置参数的优先级
	    /**
	    DefaultHttpClient hc = new DefaultHttpClient();
	    hc.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, 
	        HttpVersion.HTTP_1_0);
	    hc.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, 
	        "UTF-8");
	    HttpGet hg = new HttpGet("http://www.google.com/");
	    hg.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, 
	        HttpVersion.HTTP_1_1);
	    hg.getParams().setParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, 
	        Boolean.FALSE);
	    hc.addRequestInterceptor(new HttpRequestInterceptor() {
	        public void process(
	                final HttpRequest request, 
	                final HttpContext context) throws HttpException, IOException {
	            System.out.println(request.getParams().getParameter(
	                    CoreProtocolPNames.PROTOCOL_VERSION));
	            System.out.println(request.getParams().getParameter(
	                    CoreProtocolPNames.HTTP_CONTENT_CHARSET));
	            System.out.println(request.getParams().getParameter(
	                    CoreProtocolPNames.USE_EXPECT_CONTINUE));
	            System.out.println(request.getParams().getParameter(
	                    CoreProtocolPNames.STRICT_TRANSFER_ENCODING));
	        }
	    });
	    **/
	    
	    // 以Bean方式处理参数
	    HttpParams params = new BasicHttpParams();
	    HttpProtocolParamBean paramsBean = new HttpProtocolParamBean(params);
	    paramsBean.setVersion(HttpVersion.HTTP_1_1);
	    paramsBean.setContentCharset("UTF-8");
	    paramsBean.setUseExpectContinue(true);
	    System.out.println(params.getParameter(
	        CoreProtocolPNames.PROTOCOL_VERSION));
	    System.out.println(params.getParameter(
	        CoreProtocolPNames.HTTP_CONTENT_CHARSET));
	    System.out.println(params.getParameter(
	        CoreProtocolPNames.USE_EXPECT_CONTINUE));
	    System.out.println(params.getParameter(
	        CoreProtocolPNames.USER_AGENT));

	    // 执行HTTP请求参数，影响到执行请求过程的参数有协议版本、字符编码等
	    // ......
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    
    
    // ###############测试###############
    public static void main(String[] args) {
	
	test();
	
    }

}
