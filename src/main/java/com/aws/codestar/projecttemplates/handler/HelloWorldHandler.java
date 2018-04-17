package com.aws.codestar.projecttemplates.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.aws.codestar.projecttemplates.GatewayResponse;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.time.Instant;

/**
 * Handler for requests to Lambda function.
 */
public class HelloWorldHandler implements RequestHandler<Object, Object> {

    public Object handleRequest(final Object input, final Context context) {
        
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return new GatewayResponse(new JSONObject().put("Output", "The Current time is: " + timeStampMillis).toString(), headers, 200);
    }
    
    public Object handleRequestES(final Object input, final Context context) {
        
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return new GatewayResponse(new JSONObject().put("Output", "La hora actual es: " + timeStampMillis).toString(), headers, 200);
    }
}
