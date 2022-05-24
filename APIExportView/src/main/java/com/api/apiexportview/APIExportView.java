/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.apiexportview;
import com.api.FolderManager.FileManage;
import com.api.DateManager.DateTimeManage;
import com.api.reportTemplate.reportTemplate;
import com.mypurecloud.sdk.v2.model.SelectedColumns;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
/**
 *
 * @author kh.wong
 */
public class APIExportView {
   
      private static final String TODAY_DATE= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      private final String SYSTEM_USER = System.getProperty("user.name") ;
      private final String BIG_DATA_FILE_PATH = "C:\\UmobileBigData\\";
      private final String bigDataFileArchivePath = "C:\\UmobileBigDataArchive\\";
      private final String DownloadsFilePath = "C:\\Users\\"+SYSTEM_USER+"\\Downloads\\";
      private final String UmobileFolderName="UmobileBigData_"+TODAY_DATE;
      private final String UmobileZipFileName="GenesysCloud_mypureCloud.jp.zip";
      private final String UmobileMD5FileName="GenesysCloud_mypureCloud.jp.md5";
      private final String DesktopFilePath="C:\\Users\\"+SYSTEM_USER+"\\Desktop\\";
      private final String DefaultFodlerPath=BIG_DATA_FILE_PATH+UmobileFolderName+"\\";
      private final String DestZipFilePath=DefaultFodlerPath+UmobileZipFileName;
      private final String DestMD5FilePath=DefaultFodlerPath+UmobileMD5FileName;
      private final File defaultFolder = new File(DefaultFodlerPath); 
      private final File bigDataFolder = new File(BIG_DATA_FILE_PATH);
      private final File bigDataFileArchiveFolder = new File(BIG_DATA_FILE_PATH);
      private final File downloadFolder= new File(DownloadsFilePath);
    
    public APIExportView(){
        
    }

    public static void main(String args[]) {
            APIExportView apiObj=new APIExportView();
            String filterName= "_"+TODAY_DATE+".csv";
            apiObj.fileProcess(filterName);
            
//            reportTemplate rt=new reportTemplate(1);
//           // Map<Integer,String> selectColumnList=rt.getReportTemplate();
//            List<SelectedColumns> ss=rt.getColumnList();
//            ss.forEach(item -> {
//                System.out.println(item.getColumnName() + "/" + item.getColumnOrder());
//          });
    }
    
    private void fileProcess(String filterName){

            FileManage fileManage =new FileManage(filterName);
            if(!(bigDataFolder.exists() && bigDataFileArchiveFolder.exists()))
            {
             fileManage.createDirectory(BIG_DATA_FILE_PATH);
             fileManage.createDirectory(bigDataFileArchivePath);
            }
            if(!defaultFolder.exists())
            {
             fileManage.createDirectory(DefaultFodlerPath);
            }
            //FileManage.fileSearching(downloadFolder,filterName);
//            fileManage.moveFile(DownloadsFilePath,DefaultFodlerPath,filterName);
//            fileManage.fileCompress(FileManage.fileSearching(defaultFolder,filterName),DefaultFodlerPath,DestZipFilePath);
//            fileManage.fileCopying(DestZipFilePath,DestMD5FilePath); 
    }
  
}
