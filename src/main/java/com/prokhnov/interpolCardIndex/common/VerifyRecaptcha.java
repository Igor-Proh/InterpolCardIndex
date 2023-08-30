package com.prokhnov.interpolCardIndex.common;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

@Component
public class VerifyRecaptcha {

    private static final Logger LOGGER = Logger.getLogger(VerifyRecaptcha.class.getName());
    public static final String url = "https://www.google.com/recaptcha/api/siteverify";
    @Value("${captcha.secretKey}")
    private String secret;

    public boolean verify(String gRecaptchaResponse) {
        if (gRecaptchaResponse == null || gRecaptchaResponse.isEmpty()) {
            return false;
        }

        try {

            BufferedReader in = getIn(gRecaptchaResponse);
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }


            in.close();

            JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            return jsonObject.getBoolean("success");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            return false;
        }
    }

    private BufferedReader getIn(String gRecaptchaResponse) throws IOException {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String postParams = "secret=" + secret + "&response="
                + gRecaptchaResponse;

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();

        return new BufferedReader(new InputStreamReader(
                con.getInputStream()));
    }
}
