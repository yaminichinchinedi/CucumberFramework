package test.java;

import java.io.IOException;

import org.testng.annotations.Test;

import main.java.nativeFunctions.TestBase;
import main.java.pageObjects.VersionPage;

public class TestBranchVersion extends TestBase{
	
	@Test
	public void testEnvBranchVersion() throws InterruptedException, IOException
	 {
          VersionPage vp=new VersionPage(testConfig);
//          vp.verifyDevAndQABranchVersionIsSame();
          vp.verifyCommitIDfromYesterday();
     }
}  
