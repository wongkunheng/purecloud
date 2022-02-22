package com.example.purecloud;

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
import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  

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
    
     String clientId = "5f34a9ec-17a4-49b5-9987-7ed90acf299f";
     String clientSecret = "h5dKm5vzpS6S3I_N65HM8vxSw6F-RfXE51Oh29hXtsc";
     
     //Start of logging to log file
     ApiClient.LoggingConfiguration loggingConfiguration = new ApiClient.LoggingConfiguration();
    loggingConfiguration.setLogLevel("trace");
    loggingConfiguration.setLogFormat("json");
    loggingConfiguration.setLogRequestBody(true);
    loggingConfiguration.setLogResponseBody(true);
    loggingConfiguration.setLogToConsole(true);
    loggingConfiguration.setLogFilePath("C:/Users/kh.wong/Desktop/javaRevision/GenesysTesting/javaTesting/purecloud/javasdkLog/javasdk.log");
     //end of logging to log file
     
     try
     {
     //Set Region
     PureCloudRegionHosts region = PureCloudRegionHosts.ap_northeast_1;
     
     //Attempts set off timer configuration
     ApiClient.RetryConfiguration retryConfiguration = new ApiClient.RetryConfiguration();
     retryConfiguration.setMaxRetryTimeSec(30);
     retryConfiguration.setRetryMax(5);

     ApiClient apiClient = ApiClient.Builder.standard()
             .withLoggingConfiguration(loggingConfiguration)
             .withBasePath(region)
             .withRetryConfiguration(retryConfiguration)
             .withProperty(ApiClientConnectorProperty.CONNECTOR_PROVIDER, new OkHttpClientConnectorProvider())
             .build();
            // .withRetryConfiguration(retryConfiguration)
            
     
     ApiResponse<AuthResponse> authResponse = apiClient.authorizeClientCredentials(clientId, clientSecret);
     String refreshToken = authResponse.getBody().getRefresh_token();
     // Don't actually do this, this logs your auth token to the console!
     System.out.println("hello \n" + authResponse.getBody().toString()); 
     int expiresIn = authResponse.getBody().getExpires_in();
     System.out.println("Authentication successful. Access token expires in " + authResponse.getBody().getExpires_in() + " seconds");
     
    // Use the ApiClient instance
     Configuration.setDefaultApiClient(apiClient);
      

      try {
      UsersApi apiInstance = new UsersApi();
      ArrayList list=new ArrayList();
      String user1="986398c2-74e7-40b6-a8f6-2504de65baaf";
      list.add(user1);
      UserEntityListing response = apiInstance.getUsers(null, null, list, null, null, null, null,null);
        System.out.println(response.getEntities().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
       
     }catch(Exception ex)
     {
          logger.info(ex);
     }
    }
}
