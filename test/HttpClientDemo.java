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
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��16�� ����11:41:46
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��16�� ����11:41:46 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class HttpClientDemo {

    public static void test() {
	
	// ����HttpClientʵ��
	HttpClient httpclient = new DefaultHttpClient();
	// ����Get����ʵ��
	URI uri;
	HttpGet httpget;
	// HttpResponse response;
	// #################������#################
	// HttpGet httpget = new HttpGet("http://www.baidu.com/");
	
	try {
	    
	    // HttpClient���ṩ��һЩʵ�õķ������򻯴������޸ĵ�����URI
	    // URI������װ���
	    /**
	    uri = URIUtils.createURI("http", "www.google.cn", -1, "/search",
		    "q=lenovosec&btnG=Google+Search&aq=f&oq=", null);
	    httpget = new HttpGet(uri);
	    System.out.println(httpget.getURI());
	    **/
	    
	    // ��ѯ�ַ���Ҳ�ɸ�ʽ����װ��List�Ĳ�����ʽ
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
	    
	    // #################������Ӧ#################
	    /**
	    // �������󣬵õ���Ӧ
	    response = httpclient.execute(httpget);
	    // ����Ӧ�л�ȡ��Ϣʵ��
	    HttpEntity entity = response.getEntity();
	    // ������Ӧ����Ϣʵ�壬�����
	    if (entity != null) {
		StringBuffer sb = HttpClientUtil.processEntity(entity);
		System.out.println(sb);
	    }
	    **/
	    
	    // HTTP��Ӧ��Ϣ���ɷ��������ظ��ͻ��˵Ľ��պͽ��͵�������Ϣ��
	    // ����Ϣ�ĵ�һ�а���һ������״̬���뼰������ı�����ѭ��Э��汾��
	    /**
	    HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, 
		    HttpStatus.SC_OK, "OK");
	    System.out.println(response.getProtocolVersion());
	    System.out.println(response.getStatusLine().getStatusCode());
	    System.out.println(response.getStatusLine().getReasonPhrase());
	    System.out.println(response.getStatusLine().toString());
	    **/
	    
	    // HTTP��Ӧ�ɰ�����Ϣ���������������ݳ��ȡ��������ͼ���Ϣͷ��Ŀ 
	    // HttpClient�ṩ�˴����������ӡ�ɾ����ö����Ϣͷ�ȵķ���
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
	    
	    // ����Ч�ķ�����ʹ��HeaderIterator�ӿڻ�ȡ�������͵�����ͷ��Ϣ
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
	    
	    // ʹ�ü�㷽������Ϊ������HTTP��ϢͷԪ��
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
	    // ������
	    c1 = a
	    path=/
            domain=localhost
            c2 = b
            path=/
            c3 = c
            domain=localhost
	    **/
	    
	    // #################��Ϣʵ��#################
	    // HTTP��Ϣ������Ϣʵ�����ʽ�����������Ӧ
	    // ��Ϣʵ����ҵ����������������󲢽���Ӧ��װ���ظ��ͻ���
	    // HTTPЭ��淶������������װʵ��ķ�����POST��PUT
	    // ͨ������Ӧ������ʵ��������ﷵ��
	    // ��������һЩ���⣺������Ϣͷ��204��ʾû�����ݡ�304δ�޸ġ�205��������
	    // ####################
	    // HttpClient��ʵ���Ϊ�������ͣ�ȡ���������ݵ���Դ
	    // Streamed. �����ǽ��ܵ�������������ʱ����.����ʵ��һ�㲻���ظ�
	    // Self-contained. ������Ҫ�Ǵ����ݻ�����ʵ���л�ȡ�����ظ�����Ҫ���ڽ�HTTP������з�װ
	    // Wrapping. �����Ǵ�����ʵ���еõ�
	    // ��������ʵ�����ͣ����鿼��ʹ�÷�Streamed�Ŀ��ظ���ʵ�����ͣ�����ʵ�ʿ���
	    
	    // ʹ��HTTPʵ�壬��ȡʵ�������Ϣ
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
	    // ������
	    	Content-Type: text/plain; charset=UTF-8
		17
		UTF-8
		important message
		17
	    **/
	    
	    // ȷ����Դ�ͷ�
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
	    
	    // ����ʵ������
	    // ������ʹ��HttpEntity���������԰�ȫ�ҳ�����֪
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
	    
	    // ����ʵ�����ݣ������ı��ļ���FileEntity�����Ч��װ�ļ�
	    /**
	    File file = new File("somefile.txt");
	    FileEntity entity = new FileEntity(file, "text/plain; charset=\"UTF-8\"");
	    HttpPost httppost = new HttpPost("http://www.google.com/action.do");
	    httppost.setEntity(entity);
	    **/
	    
	    // ��̬����ʵ��
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
	    
	    // HTML����HttpClient���ṩ�����ʵ����UrlEncodedFormEntity���д����
	    /**
	    List<NameValuePair> formparams = new ArrayList<NameValuePair>();
	    formparams.add(new BasicNameValuePair("param1", "value1"));
	    formparams.add(new BasicNameValuePair("param2", "value2"));
	    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
	    HttpPost httppost = new HttpPost("http://localhost/handler.do");
	    httppost.setEntity(entity);
	    // ������� param1=value1&param2=value2
	    **/
	    
	    // ���ݿ����
	    /**
	    StringEntity entity = new StringEntity("important message", 
		    "text/plain; charset=\"UTF-8\"");
	    entity.setChunked(true);
	    HttpPost httppost = new HttpPost("http://localhost/acrtion.do");
	    httppost.setEntity(entity);
	    **/
	    
	    // #################������Ӧ#################
	    
	    // ����ķ�ʽ��ʹ��ResponseHandler�ӿڴ���.
	    // HttpClientʹ��ResponseHandler���Զ��������ӵ��ͷţ�����˶����ӵ��ͷŹ���
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
	    
	    // HttpClientִ��HTTP������
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
	    
	    // �쳣�Զ��ָ�����
	    /**
	    // ʹ��HttpRequestRetryHandler�ӿڵ�ʵ���쳣�ָ�
	    DefaultHttpClient hc = new DefaultHttpClient();
	    HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
	        public boolean retryRequest(
	                IOException exception, 
	                int executionCount,
	                HttpContext context) {
	            if (executionCount >= 5) {
	                // ��������������Ҫ����
	                return false;
	            }
	            if (exception instanceof NoHttpResponseException) {
	                // ����ͣ�������³�������
	                return true;
	            }
	            if (exception instanceof SSLHandshakeException) {
	                // SSL�쳣����Ҫ����
	                return false;
	            }
	            HttpRequest request = (HttpRequest) context.getAttribute(
	                    ExecutionContext.HTTP_REQUEST);
	            boolean idempotent = !(request instanceof HttpEntityEnclosingRequest); 
	            if (idempotent) {
	                // ����������ͬ������ 
	                return true;
	            }
	            return false;
	        }
	    };
	    hc.setHttpRequestRetryHandler(myRetryHandler);
	    **/
	    
	    // HTTPЭ��������
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
	    
	    // HTTP������һ��д���ζ�ȡʹ�ã������ò��������ȼ�
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
	    
	    // ��Bean��ʽ�������
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

	    // ִ��HTTP���������Ӱ�쵽ִ��������̵Ĳ�����Э��汾���ַ������
	    // ......
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    
    
    // ###############����###############
    public static void main(String[] args) {
	
	test();
	
    }

}
