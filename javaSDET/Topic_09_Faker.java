import com.github.javafaker.Faker;
import utilities.ExcelConfig;

import java.util.Locale;

public class Topic_09_Faker {
    public static void main(String[] args) {
//        Faker faker = new Faker(new Locale("vi"));
//
//        System.out.println(faker.leagueOfLegends().rank());
//        System.out.println(faker.address().city());

        ExcelConfig excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("userData");
        System.out.println(excelConfig.getCellData("FirstName",1));

    }
}
