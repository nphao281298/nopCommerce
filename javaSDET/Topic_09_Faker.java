import com.github.javafaker.Faker;

import java.util.Locale;

public class Topic_09_Faker {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("vi"));

        System.out.println(faker.leagueOfLegends().rank());
        System.out.println(faker.address().city());
    }
}
