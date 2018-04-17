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
public class DateHandler implements RequestHandler<Object, Object> {

    public Object handleRequest(final Object input, final Context context) {
        
        Instant instant = Instant.now();
        Date myDate = Date.from(instant);
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        String formattedDate = formatter.format(myDate);

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return new GatewayResponse(new JSONObject().put("Output", "The Current date is: " + formattedDate).toString(), headers, 200);
    }
}
