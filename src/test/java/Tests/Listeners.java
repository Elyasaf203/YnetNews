package Tests;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public  class Listeners extends MainTest implements ITestListener
{
    public void onFinish(ITestContext argITestContext)
    {
        System.out.println("finish");
    }

    public void onStart(ITestContext argITestContext)
    {
        System.out.println("--------------Srarting Execution---------------" + " " +argITestContext.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult argITestResult)
    {
        // TODO Auto-generated method stub
    }

    public void onTestFailure(ITestResult test)
    {
        System.out.println("--------------Failde Execution" +  " " +test.getName()+"---------------" + test.getName());
    }

    public void onTestSkipped(ITestResult argITestResult)
    {
        System.out.println("--------------Srarting Skipped" + " " +argITestResult.getName());
        // TODO Auto-generated method stub
    }

    public void onTestStart(ITestResult test)
    {
        System.out.println("--------------Srarting Test" + " " + test.getName() +"----------");
    }

    public void onTestSuccess(ITestResult argITestResult)
    {
        // TODO Auto-generated method stub
    }
}
