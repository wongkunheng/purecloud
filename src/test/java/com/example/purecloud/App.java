package com.example.purecloud;

import com.example.purecloud.*;
import com.mypurecloud.sdk.v2.ApiClient;
import com.mypurecloud.sdk.v2.ApiException;
import com.mypurecloud.sdk.v2.ApiResponse;
import com.mypurecloud.sdk.v2.Configuration;
import com.mypurecloud.sdk.v2.api.UsersApi;
import com.mypurecloud.sdk.v2.model.User;
import com.mypurecloud.sdk.v2.model.UserMe;
import com.mypurecloud.sdk.v2.model.UserEntityListing;
import com.mypurecloud.sdk.v2.PureCloudRegionHosts;
import com.mypurecloud.sdk.v2.api.ConversationsApi;
import com.mypurecloud.sdk.v2.connector.ApiClientConnectorProperty;
import com.mypurecloud.sdk.v2.connector.okhttp.OkHttpClientConnectorProvider;
import com.mypurecloud.sdk.v2.extensions.AuthResponse;
import com.mypurecloud.sdk.v2.model.SendAgentlessOutboundMessageRequest;
import com.mypurecloud.sdk.v2.model.SendAgentlessOutboundMessageResponse;
import java.util.*;
import javax.xml.bind.DatatypeConverter;
import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  

import com.mypurecloud.sdk.v2.api.AnalyticsApi;
import com.mypurecloud.sdk.v2.model.ReportingExportJobListing;
import com.mypurecloud.sdk.v2.model.ViewFilter.MediaTypesEnum;
import com.mypurecloud.sdk.v2.model.ReportingExportJobRequest;
import com.mypurecloud.sdk.v2.model.ReportingExportJobResponse;
import com.mypurecloud.sdk.v2.model.ViewFilter;
import java.io.IOException;
/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LogManager.getLogger(App.class);
      
//    private static final Logger logger = Logger.getLogger(ThisClass.class.getName());
    public static void main( String[] args )
    {
      BasicConfigurator.configure();  
 
     logger.trace("We've just greeted the user!");
     logger.debug("We've just greeted the user!");
     logger.info("Hello world");  
     logger.info("we are in logger info mode");  
     logger.warn("We've just greeted the user!");
     logger.error("We've just greeted the user!");
     logger.fatal("We've just greeted the user!");
    
     String clientId = "86e507ca-b330-416a-b3c2-6073ba118a9d";
     String clientSecret = "jrBXkrEpy4ETbhP4GYO4zcnRkGZb26s5EjHOHXC87BY";
     String accessToken="";

   
     
//      logger.fatal(authorizationHeaderString);    
     //Start of logging to log file
     ApiClient.LoggingConfiguration loggingConfiguration = new ApiClient.LoggingConfiguration();
    loggingConfiguration.setLogLevel("trace");
    loggingConfiguration.setLogFormat("json");
    loggingConfiguration.setLogRequestBody(true);
    loggingConfiguration.setLogResponseBody(true);
    loggingConfiguration.setLogToConsole(true);
    loggingConfiguration.setLogFilePath("C:/Users/kh.wong/Desktop/javaRevision/GenesysTesting/javaTesting/purecloud/javasdkLog/javasdk.log");
//     end of logging to log file
     
     try
     {
     //Set Region
     PureCloudRegionHosts region = PureCloudRegionHosts.ap_northeast_1;
     
     //Attempts set off timer configuration
     ApiClient.RetryConfiguration retryConfiguration = new ApiClient.RetryConfiguration();
     retryConfiguration.setMaxRetryTimeSec(30);
     retryConfiguration.setRetryMax(5);

//      .withRetryConfiguration(retryConfiguration)
//             .withProperty(ApiClientConnectorProperty.CONNECTOR_PROVIDER, new OkHttpClientConnectorProvider())
//                  
     ApiClient apiClient = ApiClient.Builder.standard()
             .withBasePath(region)
//             .withLoggingConfiguration(loggingConfiguration)
            // .withProperty(ApiClientConnectorProperty.CONNECTOR_PROVIDER, new OkHttpClientConnectorProvider())
//             .withAccessToken(accessToken)
//             .withShouldRefreshAccessToken(false)
             .build();

            // When token expires

  ApiResponse<AuthResponse> authResponse = apiClient.authorizeClientCredentials(clientId, clientSecret);
//     ApiResponse<AuthResponse> authResponse = apiClient.authorizeCodeAuthorization(clientId, clientSecret,authorizationCode,redirectUri);
//ApiResponse<AuthResponse> authResponse = apiClient.authorizeSaml2Bearer(clientId, clientSecret,orgName,encodedSamlAssertion);
     //    When Token Expired
//     String refreshToken = authResponse.getBody().getRefresh_token();
//     int expiresIn = authResponse.getBody().getExpires_in();
//     authResponse = apiClient.refreshCodeAuthorization(clientId,clientSecret,refreshToken);
//     refreshToken = authResponse.getBody().getRefresh_token();
//     expiresIn = authResponse.getBody().getExpires_in();
      
//        ApiResponse<AuthResponse> authResponse = apiClient.authorizeClientCredentials(clientId, clientSecret);
//     ApiResponse<AuthResponse> authResponse = apiClient.refreshCodeAuthorization(clientId, clientSecret,accessToken);
    
     // Don't actually do this, this logs your auth token to the console!
     accessToken=authResponse.getBody().getAccess_token();
     
    

     System.out.println("Authentication successful. Access token expires in " + authResponse.getBody().getExpires_in() + " seconds");
     System.out.println(authResponse.getHeader("access_token"));
    // Use the ApiClient instance
     Configuration.setDefaultApiClient(apiClient);
     
//        analytics();
     System.out.println("Ended");
       
     }catch(Exception ex)
     {
          logger.info("System error with the authentication code" + ex);
     }
    }
    private static void getUser(){
         try {
      UsersApi apiInstance = new UsersApi();
      ArrayList list=new ArrayList();
      String user1="bad2eba2-6eb3-40c5-acca-36bdd22eea60";
      list.add(user1);
      UserEntityListing response = apiInstance.getUsers(null, null, list, null, null, null, null,null);
        System.out.println(response.getEntities().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void analytics() throws ApiException
    {
        
        try
        {
            List<MediaTypesEnum> ListMediaType=new ArrayList();
            ListMediaType.add(MediaTypesEnum.CHAT);
            ViewFilter mediaTypefilter= new ViewFilter();
            mediaTypefilter.mediaTypes(ListMediaType);
            ReportingExportJobRequest body=new ReportingExportJobRequest();
            body.interval("2022-03-22T00:00:00/2022-03-23T00:00:00")
            .name("AgentPerformance Summary_2022-03-22")
            .timeZone("UTC")
            .period("P1D")
            .viewType(ReportingExportJobRequest.ViewTypeEnum.AGENT_PERFORMANCE_SUMMARY_VIEW)
            .locale("en-us")
            .exportFormat(ReportingExportJobRequest.ExportFormatEnum.CSV)
            .filter(mediaTypefilter)
            .read(true)
            .hasFormatDurations(true);
       AnalyticsApi apiInstance= new AnalyticsApi();
     //  apiInstance.postAnalyticsReportingExports(body);
//       ReportingExportJobResponse response = apiInstance.postAnalyticsReportingExports(body); 
        ReportingExportJobListing response = apiInstance.getAnalyticsReportingExports(1,25);
//        ApiResponse<ReportingExportJobListing> response = apiInstance.getAnalyticsReportingExportsWithHttpInfo(1,25);
       System.out.println(response.getEntities()) ;
        }catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
      
        
    }
}
