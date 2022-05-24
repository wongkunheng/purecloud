/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.purecloud.urlmanage;

import java.net.URL;
import java.net.URLConnection;
import java.io.*;  
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

//import org.apache.http.HttpHeaders;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.client.methods.RequestBuilder;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.HttpResponse;
//import org.apache.http.Header;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpHeaders;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;




/**
 *
 * @author kh.wong
 */
public class urlmanage  {
     public static void main(String[] args)  {



            // get URL content
try
{
//    URL url=new URL("https://apps.mypurecloud.jp/platform/api/v2/downloads/8f7a88c4f8f4deb8");
     String url = "https://apps.mypurecloud.jp/platform/api/v2/downloads/30c5bf36123e95ee";
     getRedirectUrl6Trial(url);
//     getRedirectUrl5Trial(url);
//     String user = System.getProperty("user.name") ;
//      final String desktop = "C:\\Users\\"+user+"\\Desktop\\abc.txt";
//    String path=desktop;
//    downloadFile(url,path);
    //Get command line arguments
//    String srcUrl = "https://apps.mypurecloud.jp/platform/api/v2/downloads/8f7a88c4f8f4deb8";
   
     //Get the redirect URL
//    Optional<String> redirectUrl = getRedirectUrl4Trial(srcUrl);
    
    
     //Output redirect URL
//    redirectUrl.ifPresent(url -> System.out.println(url));

    
    
//    String url = "https://apps.mypurecloud.jp/platform/api/v2/downloads/8f7a88c4f8f4deb8";
////  String url = "https://apps.mypurecloud.jp/";
//
////    Get the redirect URL
//    Map<String, List<String>> redirectUrl = getRedirectUrl(url);
//    
//    //Output redirect URL
//    if (redirectUrl != null) {
//      System.out.println(redirectUrl);
//    }


}catch(Exception ex)
{
    System.out.println(ex.toString());
    System.out.println("check the error");
}
            

    }
       //Get the redirect URL
  public static Map<String, List<String>> getRedirectUrl(String srcUrl) throws IOException {
    //Note that 4xx and 5xx do not raise an exception
    HttpURLConnection con = (HttpURLConnection) new URL(srcUrl).openConnection();
    con.setRequestMethod("GET");
    con.setInstanceFollowRedirects(true); //Setting not to redirect automatically
    con.connect();
    con.disconnect();    
//Get Location header from HTTP response
//   String location=  con.getHeaderFields();
//    String location = con.getHeaderField(0);
//    System.out.println(con.getHeaderField(0));
//    System.out.println(con.getHeaderField(1));
//    System.out.println(con.getHeaderField(2));
//    System.out.println(con.getHeaderField(3));
//    System.out.println(con.getHeaderField(4));
//    System.out.println(con.getHeaderField(5));
//    System.out.println(con.getHeaderField(6));
//    System.out.println(con.getHeaderField(7));
//    System.out.println(con.getHeaderField(8));
//    System.out.println(con.getHeaderField(9));
    
    
//    return location;
return con.getHeaderFields();
  }
  
  private static void getRedirectUrl2Trial(String srcUrl) throws IOException {
    //Note that 4xx and 5xx do not raise an exception
  URLConnection con = new URL(srcUrl).openConnection();
    System.out.println( "orignal url: " + con.getURL() );
    con.connect();
    System.out.println( "connected url: " + con.getURL() );
    InputStream is = con.getInputStream();
    System.out.println( "redirected url: " + con.getURL());
    is.close();
    //Get command line arguments
  }
  private static void  getRedirectUrl3Trial(String srcUrl) throws IOException {
   URL url = new URL("https://login.mypurecloud.jp/oauth/authorize?client_id=86e507ca-b330-416a-b3c2-6073ba118a9d&response_type=code&redirect_uri=http://localhost/");
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
connection.setRequestMethod("GET");
connection.connect();

int code = connection.getResponseCode();
System.out.println(code);
  }
  
 //Get the redirect URL
//  public static Optional<String> getRedirectUrl4Trial(String srcUrl) throws URISyntaxException, IOException, InterruptedException {
//
//    
//      
//      
////    //Build HTTP request information
//    HttpRequest req = HttpRequest.newBuilder(new URI(srcUrl))
//            .GET()
//            .setHeader("Authorization", "Bearer mwgnXAiuG8pN1bBJ0HUx-H-axoMLvy-mETdXpZsGvaOaKmcZfighT9BSr2Iu39c9dkEikMwYynEwQ97Q8_YWpg")
////            .setHeader("Host", "apps.mypurecloud.jp")
//            .build();
// 
//    //HTTP request
//    //Note that HttpClient does not raise an exception even with 4xx or 5xx
//    HttpClient client = HttpClient.newBuilder()
//      .version(HttpClient.Version.HTTP_1_1)
//      .followRedirects(HttpClient.Redirect.ALWAYS) //Setting not to redirect automatically
//      .build();
//    HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
//
//    //Get Location header from HTTP response
//    return req.headers().firstValue("Referer");
////    return res.headers().toString();
////return null;
//  }
  
  
    public static void downloadFile(URL url, String outputFileName) throws IOException
    {
        try (InputStream in = url.openStream();
            ReadableByteChannel rbc = Channels.newChannel(in);
            FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }
  
   
    
    
//  public  void doGet(HttpServletRequest req,HttpServletResponse response)  throws ServletException,IOException  
//    {  
//    response.setContentType("text/html");  
//    PrintWriter pw=response.getWriter();  
//
//    response.sendRedirect("http://www.google.com");  
//
//    pw.close();  
//    }
    
//     public static void getRedirectUrl5Trial(String URi) throws ClientProtocolException, IOException {
//        try
//        {
//             URL website = new URL("https://apps.mypurecloud.jp/platform/api/v2/downloads/8f7a88c4f8f4deb8");
//         ReadableByteChannel rbc = Channels.newChannel(website.openStream());
//         FileOutputStream fos = new FileOutputStream("C:\\A_work\\information.html");
//          fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//        }catch(Exception ex)
//        {
//            System.out.println(ex.toString());
//        }
        
          
//          CloseableHttpClient client=null;
//           CloseableHttpResponse  response=null;
//        try
//        {
//           client = HttpClients.createDefault();
//            HttpGet httpget = new HttpGet(URi);
//             
////           HttpClient client = HttpClients.custom().build();
//          HttpUriRequest request = RequestBuilder.get().setUri(URi)
//                  .setHeader(HttpHeaders.AUTHORIZATION, "Bearer mwgnXAiuG8pN1bBJ0HUx-H-axoMLvy-mETdXpZsGvaOaKmcZfighT9BSr2Iu39c9dkEikMwYynEwQ97Q8_YWpg")
//
////                  .setHeader(HttpHeaders.HOST,"reporting-export-service-prod-apne1.s3.ap-northeast-1.amazonaws.com")
//                  .setHeader(HttpHeaders.REFERER,"https://apps.mypurecloud.jp/platform/api/v2/downloads/8f7a88c4f8f4deb8")
//                  .build();
//          
//          System.out.println("request header URI value : " + request.getURI());
//          
//             response=  client.execute(request);
//            Header[] reqHeaders=request.getAllHeaders();
//            Header[] headers=response.getAllHeaders();
//            
//           System.out.println("Getting the header info from request");
//            System.out.println("Request header URI value : " + Arrays.toString(response.getHeaders("Request URL"))); 
//           for(Header header:reqHeaders)
//           {
//               System.out.println("reqKey : " + header.getName() 
//		      + " ,Value : " + header.getValue()); 
//           }
////            System.out.println("request header propery name : " + request.getAllHeaders()[0].getName());
////            System.out.println("request header propery value : " + request.getAllHeaders()[0].getValue());
//             
//              for(Header header:headers)
//              {
//                  System.out.println("Key : " + header.getName() 
//		      + " ,Value : " + header.getValue());
//              }
//            System.out.println("Response header URI value : " + Arrays.toString(response.getHeaders("Server"))); 
//            
//            try{
//             Scanner sc = new Scanner(response.getEntity().getContent());
//
//            //Printing the status line
//            System.out.println("Get status:"+response.getStatusLine());
//            while(sc.hasNext()) {
//               System.out.println(sc.nextLine());
//            }
//             }catch(Exception ex)
//             {
//             
//              }finally{
//                    response.close();
//         }
//        }catch(Exception ex)
//        {
//            System.out.println(ex.toString());
//        }
//        finally{
//            client.close();
//        }
          
//     }
    
    
    //Passed
    public static void getRedirectUrl6Trial(String URi)    {
        OkHttpClient client=null;
        Request request =null;
        Response response=null;
        try
        {
        client = new OkHttpClient.Builder()
                                 .build();
        
        request = new Request.Builder()
                            .url(URi)
                            .addHeader("Authorization", "Bearer GuJu8YD16qUMtOgcUi9ZGB9HX4cba9das879aydCvKVPwiGGyvKRPai8gkOtDSu6-VUQDdZSnDEpT9PbeiVgiw")
                            .build(); 
          response = client.newCall(request).execute();
          System.out.println(response.code());
          System.out.println(response.request());
          FileOutputStream fos=new FileOutputStream("C:\\A_work\\agentSumary.csv");
          fos.write(response.body().bytes());
          fos.close();
         
        }catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
        finally{
             response.close();  
        }
      
          
    }
}


