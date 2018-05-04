package main.java.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public  class  CopyDir{
       
       
       public static void main(String args []) {
             
             File source = new File("C:\\jenkins\\workspace\\testingAutomation\\Online-Portals\\UPA\target\\surefire-reports\\html");
           File dest = new File("\\\\nas00912pn\\Apps\\Work\\Priyanka\\p1058");
           
              try {
                           copyFolder(source,dest);
                           System.out.println("############Report copied to Shared Folder");
                    } 
              
              catch (Exception e) {
                           
                           e.printStackTrace();
                    }
             
             
       }

       

public static void copyFolder(File source, File destination) throws InterruptedException
{
    if (source.isDirectory())
    {
    	
        if (!destination.exists())
        {
            System.out.println("Destination not exists, creating directories");
        	destination.mkdirs();
        }

        String files[] = source.list();
       
        System.out.println("files are" + files);

        for (String file : files)
        {
            File srcFile = new File(source, file);
            File destFile = new File(destination, file);
            
            copyFolder(srcFile, destFile);
            
            
        }
    }
    else
    {
        InputStream in = null;
        OutputStream out = null;
        
        System.out.println("file copying");
        try
        {
            in = new FileInputStream(source);
            out = new FileOutputStream(destination);

            byte[] buffer = new byte[10249];

            int length;
            while ((length = in.read(buffer)) > 0)
            {
                out.write(buffer, 0, length);
            }
        }
        catch (Exception e)
        {
            try
            {
                in.close();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }

            try
            {
                out.close();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
    }
}



}
