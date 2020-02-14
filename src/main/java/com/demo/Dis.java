package com.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;




import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Dis {
    @JsonProperty("status")
    private Integer status;
    public String disa(String appid,String serailno) throws Exception {


        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet("https://vpp.itunes.apple.com/mdm/manageVPPLicensesByAdamIdSrv?sToken=eyJleHBEYXRlIjoiMjAyMC0wOS0xNVQyMzo1Njo0NC0wNzAwIiwidG9rZW4iOiI5c3RtRTcvbWFuckxJZExqcU1DeXpjaXM2S1BxZ0p3blVha1JMditVN0swODFzZGRkRnlLcFd5NGJicnFjV2pVTG04QkRSVDBFWlJYN254UEVMS05BWXk3WEViS0s3cjFqZFVyb01sL1ppcnlFWlpXS010bndiNzFnYkFXQ00xVzBJZ2Y0YzM1ZzA2V254YWJwalc2SVE9PSIsIm9yZ05hbWUiOiJOb3ZlbGwifQ==&disassociateSerialNumbers="+serailno+"&adamIdStr="+appid+"&pricingParam=STDQ");

            System.out.println("Executing request " + httpget.getRequestLine());



            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);

            ObjectMapper mapper = new ObjectMapper();
            A a = mapper.readValue(responseBody,A.class);
            String prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a);
            System.out.println(prettyStaff);

            JsonParser parser;
            JsonFactory factory = new JsonFactory();
            parser  = factory.createParser(prettyStaff);

            String bo = null;
            while(!parser.isClosed()){
                JsonToken jsonToken = parser.nextToken();

                if(JsonToken.FIELD_NAME.equals(jsonToken)){
                    String fieldName = parser.getCurrentName();


                    jsonToken = parser.nextToken();


                    if("status".equals(fieldName)){
                        bo = parser.getValueAsString();
                    }
                }
            }
            DBD dbd = new DBD();
            if (bo.equals("0")){
                dbd.connect(appid,serailno,bo);
                return "License is disassociated";
            }else{
                return "No license to disassociate";
            }

        } finally {
            httpclient.close();
        }

    }






}

