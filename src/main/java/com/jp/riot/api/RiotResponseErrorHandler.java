package com.jp.riot.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

/**
 * Created by JP on 9/3/2017.
 */
@Component
public class RiotResponseErrorHandler extends DefaultResponseErrorHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        logger.error("{} : {}", response.getStatusCode(), response.getStatusText());
    }
}
