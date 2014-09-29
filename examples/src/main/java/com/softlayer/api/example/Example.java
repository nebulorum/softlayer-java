package com.softlayer.api.example;

import com.softlayer.api.ApiClient;
import com.softlayer.api.RestApiClient;

/** Base class for all examples that parses the command-line arguments */
public abstract class Example {

    public void start(String[] args) throws Exception {
        // Args are username, api key, and (optional) base URL
        if (args.length < 2 || args.length > 3) {
            throw new RuntimeException("Username and api key required. Base URL can optionally be provided");
        }
        String baseUrl = args.length == 3 ? args[2] : RestApiClient.BASE_URL;
        // Add trailing slash if not present
        if (!baseUrl.endsWith("/")) {
            baseUrl += '/';
        }

        run(new RestApiClient(baseUrl).withCredentials(args[0], args[1]).withLoggingEnabled());
    }

    /** Run the example with the given client */
    public abstract void run(ApiClient client) throws Exception;
}
