package exploringApprovalTests;

import org.approvaltests.Approvals;
import org.junit.Test;

import org.approvaltests.core.ApprovalFailureReporter;
import org.approvaltests.reporters.ClipboardReporter;
import org.approvaltests.reporters.DiffReporter;

public class testApprovalTests {

	//documentation: https://approvaltests.com
	//documentation: https://github.com/approvals/ApprovalTests.Java
	
	public ApprovalFailureReporter UseReporter = DiffReporter.INSTANCE;
		
	@Test
	public void test() {
		Approvals.verify("");
	}
	
	@Test
	  public void testJson()
	  {
	    Person hero = new Person("Tina", "Toucan", true, 2);
	    Approvals.verifyAsJson(hero);
	  }

	@Test
    public void testArray() {
        // create a String Array and set values in the indexes
        String[] s = new String[2];
        s[0] = "Approval";
        s[1] = "Tests";

        // Verify the array
        Approvals.verifyAll("Text", s);
    }
	
	
	
}
