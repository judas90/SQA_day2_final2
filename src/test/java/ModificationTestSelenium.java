import org.testng.annotations.Test;

public class ModificationTestSelenium extends TestBase {
    @Test
    public void modificationTestSelenium() {
        login("student", "luxoft");
        searchProject();
        reportIssue();
        blockEnterReportDetails();
        blockFillIN("Mobile", "Android", "9.0");
        blockFullDescription("Block", "описание дефекта", "Взять и починить.");
     //   blockAdditionalInformation();
        blockAdditionalInformation("дополнительная информация");
        buttonSubmitReport();

    }

}
