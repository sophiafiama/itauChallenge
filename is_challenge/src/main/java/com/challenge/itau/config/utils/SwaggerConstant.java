package com.challenge.itau.config.utils;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConstant {
    public static final String SECURITY_REFERENCE = "JWT";
    public static final String AUTHORIZATION_DESCRIPTION = "accessEverything";
    public static final String AUTHORIZATION_SCOPE = "global";
    public static final String CONTACT_EMAIL = "email@gmail.com";
    public static final String CONTACT_URL = "https://www.movies.com";
    public static final String CONTACT_NAME = "Movies API Support";
    public static final String API_TITLE = "Movies API";
    public static final String API_DESCRIPTION = "API for movie ratings";
    public static final String TERM_OF_SERVICE = "Your term of service will go here";
    public static final String API_VERSION = "1.1";
    public static final String LICENSE = "Apache License 2.1.0";
    public static final String LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";
    public static final String SECURE_PATH = "/*/.*";
    public static final String API_TAG = "ApiStreaming";
}
