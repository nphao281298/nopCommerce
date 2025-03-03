package jsonData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class UserInforJson {
    public static UserInforJson getUserInfor() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.RESOURCE_PATH + "userData.json"), UserInforJson.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("dob")
    private String DOB;

    @JsonProperty("email")
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    private String password;
}
