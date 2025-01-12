import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.PageBaseUI;

import java.io.File;
import java.nio.file.FileSystems;

public class SystemInformation {
    public static void main(String[] args) {
//        String osName = System.getProperty("os.name");
//        System.out.println(osName);
//
//        String projectPath = System.getProperty("user.dir");
//        System.out.println(projectPath);
//
//        String danangImagePath = projectPath + "/uploadFiles/" + "DaNang.jpg";
//        String danangImagePath1 = projectPath + File.separator + "uploadFiles" + File.separator + "DaNang.jpg";
//        System.out.println(danangImagePath);
//        System.out.println(danangImagePath1);
//
//        String SEPARATOR = FileSystems.getDefault().getSeparator();
//        System.out.println(SEPARATOR);
//
//        String filePath = GlobalConstants.UPLOAD_PATH;
//        System.out.println("filePath="+filePath);
        // /Users/phonghaonguyen/AutomationFCMakeByMe/nopCommerce/javaSDET/SystemInformation.java

        uploadMultipleFiles("HaNoi.jpg", "HoChiMinh.jpg", "DaNang.jpg");
    }

    public static void uploadMultipleFiles(String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
//        StringBuilder fullFileName = new StringBuilder();
        String fullFileName = "";
        for (String file : fileNames) {
//            fullFileName.append(filePath).append(file).append("\n");
            fullFileName += filePath + file + "\n";
        }
        String finalFileName = fullFileName.trim();
        System.out.println(finalFileName);
    }
}
