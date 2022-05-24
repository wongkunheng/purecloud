/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.purecloud.sftpmanager;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author kh.wong
 */
public class sftpmanager {
      private String host = "demo.wftpserver.com";
       private int port = 21;
        Session session = null;
        
        
        public sftpmanager(){
            
        }
         public static void main(String args[])  throws IOException, NoSuchAlgorithmException, JSchException, SftpException {
            String source="/readme.txt";
            String destination="C:\\Users\\kh.wong\\Desktop\\Release2";
            String sourceUpload="C:\\Users\\kh.wong\\Desktop\\tryme.txt";
            String destUpload="/upload";
                    
            sftpmanager s1=new sftpmanager();
            s1.connect();
//            s1.download(source, destination);
            s1.upload(sourceUpload, destUpload);
            s1.disconnect();
             
         }
         
        public void connect() throws JSchException {
         JSch jsch = new JSch();
    
         session = jsch.getSession("demo", host, port);
         session.setPassword("demo");
         session.setConfig("StrictHostKeyChecking", "no");
         session.connect();
         System.out.println("ServerConnected!");
        }
        
     public void download(String source, String destination) throws JSchException, SftpException {
      Channel channel = session.openChannel("sftp");
      channel.connect();
      ChannelSftp sftpChannel = (ChannelSftp) channel;
      try
      {
      sftpChannel.get(source, destination);
      System.out.println("FileDownloaded!");
      }catch(Exception ex)
      {
           System.out.println(ex.toString());
      }finally
      {
          sftpChannel.exit(); 
      }
     
       
      
  }
     public void disconnect() {
      if (session != null) {
          session.disconnect();
           System.out.println("Server has disconnected!");
      }
  }
     public void upload(String source,String destination) throws JSchException{
        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp) channel;
         try
        {
            sftpChannel.put(source, destination);
            System.out.println("FileUploaded!");
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }finally
        {
            sftpChannel.exit(); 
        }
     }
}
