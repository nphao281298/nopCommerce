package jsonData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class PaymentInforJSO {
    public static PaymentInforJSO getPaymentInfor() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.RESOURCE_PATH + "userData.json"), PaymentInforJSO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("visa")
    private String visa;

    @JsonProperty("date")
    private String date;

    public String getVisa() {
        return visa;
    }

    public String getDate() {
        return date;
    }

    public String getCvc() {
        return cvc;
    }

    @JsonProperty("cvc")
    private String cvc;

    static class Checkout{
        @JsonProperty("discount")
        String discount;
    }
    @JsonProperty("checkout")
    checkout checkout;

    static class checkout{
        @JsonProperty("discount")
        String discount;
    }
    public String getDiscount(){
        return checkout.discount;
    }

}
