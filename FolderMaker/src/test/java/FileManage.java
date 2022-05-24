/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.purecloud.foldermaker;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 *
 * @author kh.wong
 */
public class FileManage  implements FilenameFilter  {
    String initials;
    
    public  FileManage(String initials)
    {
        this.initials=initials;
    }
    
    
    @Override
    public boolean accept(File file, String name) {
        return name.endsWith(initials);
    }
   public static void main(String args[]) {
      final String filename1="Agent Performance Summary_Date";
      final String filename2="Agent Status Summary_Date";
      final String filename3="Flow Performance Summary_Date";
      final String filename4="Interactions View_Date";
      final String filename5="Queue performance Summary_Date";
      final String filename6="Scheduled Callbacks_Date";
      final String filename7="Wrap-up Performance_Date";
      final String filename8="Queue 30 mins_Date";
      
      //testing
      String filterName="_2022-05-03.txt";
      String user = System.getProperty("user.name") ;
      final String bigDataFilePath = "C:\\Users\\"+user+"\\Desktop\\UmobileBigData";
      final String bigDataFileArchivePath = "C:\\Users\\"+user+"\\Desktop\\UmobileBigDataArchive";
      final String DownloadsFilePath = "C:\\Users\\"+user+"\\Downloads\\";
      String UmobileFolderName="UmobileBigData";
      String UmobileZipFileName="GenesysCloud_mypureCloud.jp.zip";
      String UmobileMD5FileName="GenesysCloud_mypureCloud.jp.md5";
      String DesktopFilePath="C:\\Users\\"+user+"\\Desktop\\";
      String DefaultFodlerPath=DesktopFilePath+UmobileFolderName+"\\";
      String CopySourceZipFilePath=DesktopFilePath+UmobileZipFileName;
      String CopyDestZipPath=DesktopFilePath+UmobileFolderName+"\\"+UmobileZipFileName;
      String CopyDestMD5Path=DesktopFilePath+UmobileFolderName+"\\"+UmobileMD5FileName;
      File defaultFolder = new File(DefaultFodlerPath); 
      File f1 = new File(DesktopFilePath); 
     // fileSearching(f1,filterName);
//      fileCompress(fileSearching(f1),DesktopFilePath);
//      createDirectory();
      moveFile(DownloadsFilePath,DefaultFodlerPath,filterName);
     // fileCopying(defaultFolder,CopySourceZipFilePath,CopyDestZipPath);
     // fileCopying(defaultFolder,CopySourceZipFilePath,CopyDestMD5Path);
   } 
   
   
   private static void createDirectory(String FilePath){
       
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
       LocalDateTime now = LocalDateTime.now();  
       System.out.println(dtf.format(now));  
       String user = System.getProperty("user.name") ;
       final String localfilePath = "C:\\Users\\"+user+"\\Desktop\\UmobileBigData";
       final String directoryName="UmobileBigData";
     

         System.out.println(localfilePath);
         File folder = new File(localfilePath); 
          
         try
         {
             if(!folder.exists())
             {
                folder.mkdirs();  
                System.out.println("Folder "+directoryName+" is created successfully"); 
            
             }else
             {
                  System.out.println("The "+directoryName+ " folder is exist: "+localfilePath);  
                 
             }
         }catch(Exception e) {
            System.out.println(e );
         } 
   }
   
   private static void moveFile(String DownloadsFilePath,String DestFilePath,String filterName)
   {
       
       
        File downloadsFolder = new File(DownloadsFilePath); 
       
        
        if(downloadsFolder.exists())
       {
           
           String[] fileList=fileSearching(downloadsFolder,filterName);
          if(fileList!=null)
          {
              for (int i = 0; i < fileList.length; i++) {
                  try
                  {
                  Path fileMovingRename=Files.move(Paths.get(DownloadsFilePath+fileList[i].toString()),Paths.get(DestFilePath+fileList[i].toString()));
                  System.out.println("Files move successfully");
                  }catch(Exception ex)
                  {
                    System.out.println(ex);
                  }
                          
              }
          } else
          {
                System.out.println("Failed to move the file");
          }
       }
       else
       {
              System.out.println("Directory not found");
       }
       
   }
   private static String[] fileSearching(File Folderdirectory,String filterName)
   {
       String user = System.getProperty("user.name") ;
       FileManage  filter =new FileManage(filterName);
       String[] fileList =Folderdirectory.list(filter);
       if (fileList.length == 0) {
        System.out.println(filterName+ " naming does not match in " +Folderdirectory+ ".");
       }else
       {
            // Print all files with same name in directory
            // as provided in object of FileManage
            // class
           for (int i = 0; i < fileList.length; i++) {
               
                System.out.println(Folderdirectory.toString()+ "\\"+fileList[i]+" found");
            }
       }
       return fileList;
   }
   
   private static boolean fileCopying(File fodlerPath,String source,String destination)
   {
       try
       {
        File copySourceFile=new File(source);
        File copyDestFile=new File(destination);
        Path copySourcePath=copySourceFile.toPath();
        Path copyDestPath=copyDestFile.toPath();
       if (! fodlerPath.exists()) {
        System.out.println("Folder does not exists. Please create it");
       }else
       {
           Files.copy(copySourcePath, copyDestPath);
           System.out.println(destination+" copy successful");
       }
       } catch(Exception ex)
       {
           
           System.out.println(destination+" already exists");
           return false;
       }
       
       return true;
   }
   private static boolean fileCompress(String[] srcFiles,String DestPath)
   {
    String zipFile = DestPath+"GenesysCloud_mypureCloud.jp.zip";

        try {
             // create byte buffer
            byte[] buffer = new byte[1024];
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            
              for (int i=0; i < srcFiles.length; i++) {
              File srcFile = new File(srcFiles[i]);
              FileInputStream fis = new FileInputStream(srcFile);
              
               // begin writing a new ZIP entry, positions the stream to the start of the entry data
                zos.putNextEntry(new ZipEntry(srcFile.getName()));
                
                int length;
 
                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }
 
                zos.closeEntry();
 
                // close the InputStream
                fis.close();
                
              }
              
                // close the ZipOutputStream
                zos.close();
        }
        catch (IOException ioe) {
            System.out.println("Error creating zip file: " + ioe);
        }
         return true;
            
    
   }
}
