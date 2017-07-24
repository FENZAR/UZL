package service;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RequestUZL {
    private static String FILE_NAME = "src/test/resources/input";
    private static String VIO_DEV = "http://10.0.2.37:9181/vio-emulator/#/send/requestUvedZl";
    private static String VIO_QA = "http://10.0.2.38:9080/vio-emulator/#/send/requestUvedZl";
    private static String VIO_PFR = "http://172.22.116.68:9080/vio-emulator/#/send/requestUvedZl";

    @Before
    public void start() {
        WebDriverRunner.setWebDriver(new ChromeDriver());
        open(VIO_DEV);
    }

    @Test
    public void requestUZL() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
        for (String line:lines) {
            $("#regNumber").setValue(line).pressEnter();
            $(".btn.btn-default").click();
        }
    }
}
