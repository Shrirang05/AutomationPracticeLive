package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "\\src\\test\\resources\\resources\\global.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String URL = prop.getProperty("QAUrl");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String browser = browser_maven != null ? browser_maven : browser_properties;

        if (driver == null) {

            if (browser.equalsIgnoreCase("chrome")) {

                // ✅ Download path will be: C:\Users\Gauri\Downloads
                String downloadPath = System.getProperty("user.home") + "\\Downloads";

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-blink-features=AutomationControlled");

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("autofill.profile_enabled", false);
                prefs.put("autofill.credit_card_enabled", false);

                // ✅ Download Preferences
                prefs.put("download.default_directory", downloadPath);
                prefs.put("download.prompt_for_download", false);
                prefs.put("download.directory_upgrade", true);
                prefs.put("safebrowsing.enabled", true);

                options.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver(options);

            } else if (browser.equalsIgnoreCase("firefox")) {

                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("edge")) {

                driver = new EdgeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(URL);
        }

        return driver;
    }
}