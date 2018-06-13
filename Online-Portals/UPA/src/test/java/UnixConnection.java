package test.java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;


public class UnixConnection {
	private static String USERNAME ="ppsstg"; // username for remote host
	private static String PASSWORD ="nXM11K3y"; // password of the remote host
	//private static String host = "apsrs3514.uhc.com"; // remote host address
	
	private static String host = "apsrs3511.uhc.com"; // remote host address
	private static int port=22;


	public static void main(String[] args) throws JSchException, IOException {
	
		JSch js = new JSch();
		Session session = js.getSession(USERNAME, host, port);
		session.setPassword(PASSWORD);
		session.setConfig("StrictHostKeyChecking", "no");
		session.connect();
		System.out.println("connected");
		
		com.jcraft.jsch.Channel channel=session.openChannel("exec");
        ((ChannelExec)channel).setCommand("cd stg/logs/" + "&&" + "tail -500 CSR_apsrs3512_error.log  ");
        channel.setInputStream(null);
        ((ChannelExec)channel).setErrStream(System.err);
        
        InputStream in=channel.getInputStream();
        channel.connect();
        byte[] tmp=new byte[1024];
        while(true)
        {
	          while(in.available()>0)
	          {
	            int i=in.read(tmp, 0, 1024);
	            if(i<0)break;
	            System.out.print(new String(tmp, 0, i));
	          }
	          if(channel.isClosed()){
	            System.out.println("exit-status: "+channel.getExitStatus());
	            break;
	          }
	          try{Thread.sleep(1000);}
	          catch(Exception ee){}
	       }
	        channel.disconnect();
	        session.disconnect();
	        System.out.println("DONE");
	    }
	
	   

		

	}


