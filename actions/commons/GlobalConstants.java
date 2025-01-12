package commons;

import java.nio.file.FileSystems;

public class GlobalConstants {
    // System Information
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = FileSystems.getDefault().getSeparator();

    // App Information for User
    public static final String DEV_USER_URL = "http://dev.techpanda.org/";
    public static final String STAGING_USER_URL = "http://staging.techpanda.org/";
    public static final String LIVE_USER_URL = "http://live.techpanda.org/";

    // App Information for Admin
    public static final String DEV_ADMIN_URL = "http://dev.techpanda.org/index.php/backendlogin";
    public static final String STAGING_ADMIN_URL = "http://staging.techpanda.org/index.php/backendlogin";
    public static final String LIVE_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";

    public static final String ADMIN_USERNAME = "user01";
    public static final String ADMIN_PASSWORD = "guru99com";

    // Wait Information
    public static final long SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;

    // Download/Upload File Paths
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles"+ SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles"+ SEPARATOR;

    // Retry Case Failed
    public static final int RETRY_NUMBER = 3;

    // Browser Logs/Extensions
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;

    // HTML Report Folder Paths
    public static final String REPORTNG_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG"+ SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    // Data Test/Environment Paths
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "dataTest" + SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "environmentConfig" + SEPARATOR;

}
