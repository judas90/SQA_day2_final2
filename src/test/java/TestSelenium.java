import org.testng.annotations.Test;

public class TestSelenium  extends TestBase{
    @Test
    public void testSelenium() {
        login("student", "luxoft");
        searchProject();
        reportIssue();
        blockEnterReportDetails();
        blockFillIN("Web", "Wind", "x64");
        blockFullDescription("Block", "описание дефекта", "Взять и починить.");
        buttonSubmitReport();

    }

    @Test
    public void testSeleniumEmpty() {
        login("student", "luxoft");
        searchProject();
        reportIssue();
        blockEnterReportDetails();
        blockFillIN("Web", "Wind", "x64");
        blockFullDescription("", "", "");
        buttonSubmitReport();

    }

}
