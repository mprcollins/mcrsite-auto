package jUnit_tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
		
@Suite.SuiteClasses( {
	homePageTests.class,
	homePageSearchTests.class,
	eventsSearch.class,
	councillorSearch.class
})

public class testSuite {

}
