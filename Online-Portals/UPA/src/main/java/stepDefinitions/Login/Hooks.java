package main.java.stepDefinitions.Login;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import main.java.nativeFunctions.*;

public class Hooks {
	TestBase obj_TB = new TestBase();
	
	@Before
	public void Beforetest()
	{
		System.out.print("**Before hooks----->");
		obj_TB.tearUp();
	}

	@After
	public void Aftertest()
	{
		System.out.print("**After hooks----->");
		obj_TB.tearDown();
	}
}
