package com.api.APIManager;

import com.api.DateManager.DateTimeManage;
import com.api.reportTemplate.reportTemplate;
import java.util.*;
import com.mypurecloud.sdk.v2.ApiClient;
import com.mypurecloud.sdk.v2.ApiException;
import com.mypurecloud.sdk.v2.ApiResponse;
import com.mypurecloud.sdk.v2.Configuration;
import com.mypurecloud.sdk.v2.api.UsersApi;
import com.mypurecloud.sdk.v2.model.UserEntityListing;
import com.mypurecloud.sdk.v2.PureCloudRegionHosts;
import com.mypurecloud.sdk.v2.extensions.AuthResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.mypurecloud.sdk.v2.api.AnalyticsApi;
import com.mypurecloud.sdk.v2.model.ReportingExportJobListing;
import com.mypurecloud.sdk.v2.model.ViewFilter.MediaTypesEnum;
import com.mypurecloud.sdk.v2.model.ReportingExportJobRequest;
import com.mypurecloud.sdk.v2.model.ReportingExportJobResponse;
import com.mypurecloud.sdk.v2.model.SelectedColumns;
import com.mypurecloud.sdk.v2.model.ViewFilter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class ApiManage {

    private static final Logger logger = LogManager.getLogger(ApiManage.class);
    private String reportId = "";
    private String strDateTime;
    String clientId = "";
    String clientSecret = "";
    String accessToken = "";
//    private static final Logger logger = Logger.getLogger(ThisClass.class.getName());

    public ApiManage() {
        clientId = "86e507ca-b330-416a-b3c2-6073ba118a9d";
        clientSecret = "jrBXkrEpy4ETbhP4GYO4zcnRkGZb26s5EjHOHXC87BY";
        //Start of logging to log file
        ApiClient.LoggingConfiguration loggingConfiguration = new ApiClient.LoggingConfiguration();
        loggingConfiguration.setLogLevel("trace");
        loggingConfiguration.setLogFormat("json");
        loggingConfiguration.setLogRequestBody(true);
        loggingConfiguration.setLogResponseBody(true);
        loggingConfiguration.setLogToConsole(true);
        loggingConfiguration.setLogFilePath("C:/Users/kh.wong/Desktop/javaRevision/GenesysTesting/javaTesting/purecloud/javasdkLog/javasdk.log");
        //end of logging to log file

        //Set Region
        PureCloudRegionHosts region = PureCloudRegionHosts.ap_northeast_1;

        //Attempts set off timer configuration
        ApiClient.RetryConfiguration retryConfiguration = new ApiClient.RetryConfiguration();
        retryConfiguration.setMaxRetryTimeSec(30);
        retryConfiguration.setRetryMax(5);

        ApiClient apiClient = ApiClient.Builder.standard()
                .withBasePath(region)
                .build();
        try {
            // When token expires
            ApiResponse<AuthResponse> authResponse = apiClient.authorizeClientCredentials(clientId, clientSecret);

            //Get access token
            accessToken = authResponse.getBody().getAccess_token();

            // Use the ApiClient instance, a watcher
            Configuration.setDefaultApiClient(apiClient);

            //     analyticsGetAllExportView();
            //     analyticsAgentPerformanceSummary();
        } catch (Exception ex) {
            logger.info("System error with the authentication code" + ex);
        }
    }

    /**@
     * Generate/export agent performance summary view Consist report format and
     * @param date the date time interval of export view
     * @return agent performance summary export view ID.
     */
    private void analyticsAgentPerformanceSummary(String strDate) throws ApiException {

        try {
            DateTimeManage dtM=new DateTimeManage(strDate);
            String dtInterval = dtM.getIntervalDateTime();
//            String dtInterval = "2022-03-22T00:00:00/2022-03-23T00:00:00";
            String MYtimezone = "Asia/Kuala_Lumpur";
            String FileName = "Agent Performance Summary_2022-03-22";
            reportTemplate rt = new reportTemplate(1);
            List<SelectedColumns> columnList = rt.getColumnList();
            List<MediaTypesEnum> ListMediaType = new ArrayList();
            ListMediaType.add(MediaTypesEnum.CHAT);
            ViewFilter mediaTypefilter = new ViewFilter();
            mediaTypefilter.mediaTypes(ListMediaType);
            ReportingExportJobRequest body = new ReportingExportJobRequest();
            body.interval(dtInterval)
                    .name(FileName)
                    .timeZone(MYtimezone)
                    .period("P1D")
                    .viewType(ReportingExportJobRequest.ViewTypeEnum.AGENT_PERFORMANCE_SUMMARY_VIEW)
                    .locale("en-us")
                    .exportFormat(ReportingExportJobRequest.ExportFormatEnum.CSV)
                    .filter(mediaTypefilter)
                    .read(true)
                    .hasFormatDurations(true)
                    .selectedColumns(columnList);
            AnalyticsApi apiInstance = new AnalyticsApi();
            ReportingExportJobResponse response = apiInstance.postAnalyticsReportingExports(body);
            if (response.toString() != null || response.toString() != "") {
                setResponseId(response.getId());
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

    // Generate agent performance summary
    private void analyticsAgentStatusSummary() throws ApiException {
        Map<Integer, String> map;
        SelectedColumns column = new SelectedColumns();
        column.setColumnName("SelectedColumns");
        column.setColumnOrder(Integer.MIN_VALUE);
        try {
            List<MediaTypesEnum> ListMediaType = new ArrayList();
            ListMediaType.add(MediaTypesEnum.CHAT);
            ViewFilter mediaTypefilter = new ViewFilter();
            mediaTypefilter.mediaTypes(ListMediaType);
            ReportingExportJobRequest body = new ReportingExportJobRequest();
            body.interval("2022-03-22T00:00:00/2022-03-23T00:00:00")
                    .name("Agent Status Summary_2022-03-22")
                    .timeZone("UTC")
                    .period("P1D")
                    .viewType(ReportingExportJobRequest.ViewTypeEnum.AGENT_STATUS_SUMMARY_VIEW)
                    .locale("en-us")
                    .exportFormat(ReportingExportJobRequest.ExportFormatEnum.CSV)
                    .filter(mediaTypefilter)
                    .read(true)
                    .hasFormatDurations(true);

            AnalyticsApi apiInstance = new AnalyticsApi();
            ReportingExportJobResponse response = apiInstance.postAnalyticsReportingExports(body);
            if (response.toString() != null || response.toString() != "") {
                setResponseId(response.getId());
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

    // Get all view export requests for a user
    private void analyticsGetAllExportView() throws ApiException {
        try {
            AnalyticsApi apiInstance = new AnalyticsApi();
            ReportingExportJobListing response = apiInstance.getAnalyticsReportingExports(1, 25);

            System.out.println(response.getEntities());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

    public void setResponseId(String reportId) {
        this.reportId = reportId;
    }

    public String getResponseId(String reportId) {
        return this.reportId;
    }

    public void setInterval(LocalDateTime d) {

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-DDThh:mm:ss"); 
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        this.strDateTime = dtf.format(d);
    }

    public String getInterval() {
        return strDateTime;
    }

}
