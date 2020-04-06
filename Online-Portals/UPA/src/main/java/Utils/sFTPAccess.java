package main.java.Utils;


import java.util.Vector;

import com.jcraft.jsch.Channel;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import main.java.nativeFunctions.TestBase;
import main.java.reporting.Log;

public class sFTPAccess extends TestBase{
	
	private TestBase testConfig = TestBase.getInstance();	
	String SFTPHOST = testConfig.runtimeProperties.getProperty("SFTPHOST");
    int SFTPPORT = Integer.parseInt(testConfig.runtimeProperties.getProperty("SFTPPORT"));
    String SFTPUSER = testConfig.runtimeProperties.getProperty("SFTPUSER");
    String SFTPPASS = testConfig.runtimeProperties.getProperty("SFTPPASS");
    Session session = null;
    Channel channel = null;
    ChannelSftp channelSftp = null;
    
    /**
	 *connect
	 * The method connects to sFTP server
	 *
	 * 
	 * @return null
	 * @author pchaud19
	 */
    public void connect() throws JSchException
    {    	
    	JSch jsch = new JSch();
 	    session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT); 		
        session.setPassword(SFTPPASS);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
    }
  
    /**
	 *GenerateDateUsingParsedPath
	 * The method search whether required file exist at designated location
	 *
	 * @param Path
	 *            : Location in sFTP/NAS drive
	 *
	 * @param FileName
	 *            -Name of the file to search
	 * 
	 * @return boolean
	 * @author pchaud19
	 */
	public boolean IsFileAvailable(String path, String FileName) throws JSchException, SftpException	
	{
		
		boolean fileexist = false;
		System.out.println("preparing the host information for NAS Drive.");	    
        System.out.println("Host connected.");
        channel = session.openChannel("sftp");
        channel.connect();
        System.out.println("sftp channel opened and connected.");
        channelSftp = (ChannelSftp) channel;  
		channelSftp.cd(path);    
		
		 Vector filelist = channelSftp.ls(path);
         for(int i=0; i<filelist.size();i++){
        	 
             LsEntry entry = (LsEntry) filelist.get(i);
             System.out.println("*NAS drive file Name:" +entry.getFilename());
             System.out.println(FileName);
             if(FileName.trim().equalsIgnoreCase(entry.getFilename().trim()))
             {
                 System.out.println(entry.getFilename());
            	 fileexist =  true;
            	 break;
             }
         }              
       
		return fileexist;	
	}
	
	//Uploading of file
	public void fileUpload(String Source, String Destination, String FileName) throws SftpException
	{
		channelSftp.put(Source, Destination + FileName);		  
	}
	
	//Downloading of file
	public void fileDownload(String Source, String Destination, String FileName) throws SftpException
	{
		channelSftp.get(Source, Destination + FileName);		  
	}
	
	//Deletion of a file
	public void DeleteFile(String path, String FileName) throws SftpException
	{
		System.out.println("sftp Channel exited------>"+FileName.trim());
		channelSftp.rm(FileName.trim());		  
	}
	
	
	//Deletion of a file, with file name appended in string
	public void DeleteFile_FileNameAppended(String FileName) throws SftpException
	{
			System.out.println("sftp Channel exited------>"+FileName);
			channelSftp.rm(FileName);		  
	}
	//Closing a connection
	public void Closeconnection()
	{
		 channelSftp.exit();
	     System.out.println("sftp Channel exited.");
	     channel.disconnect();
	     System.out.println("Channel disconnected.");
	     session.disconnect();
	     System.out.println("Host Session disconnected.");
	}
	

}
