package com.github.jpmand.openproject.client.http;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Map;

public final class UserAgentInterceptor implements Interceptor {

    private static final String USER_AGENT_PREFIX = "Openproject-Java-Client;";

    private final String userAgent;

    public UserAgentInterceptor(@Nullable Map<String, String> userAgentInformation) {
        String library = "Openproject-Java-Client/1.0";
        String jvm = System.getProperty("java.vm.name") + "/" + System.getProperty("java.version");
        String os = System.getProperty("os.name") + "/" + System.getProperty("os.version");
        StringBuilder lastPart = new StringBuilder();
        if(userAgentInformation != null){
            for (Map.Entry<String, String> each : userAgentInformation.entrySet()) {
                String key = sanitizeToken(each.getKey());
                String value = sanitizeToken(each.getValue());
                if (!key.isEmpty() && !value.isEmpty()) {
                    lastPart.append(" ").append(key).append("/").append(value).append(";");
                }
            }
        }
        this.userAgent = USER_AGENT_PREFIX + library + "; " + jvm + "; " + os + ";" + lastPart;
    }

    /**
     * Sanitize a token for safe inclusion in HTTP headers by removing control characters.
     *
     * This strips all ASCII control characters (0x00-0x1F) and DEL (0x7F),
     * which includes CR and LF, to prevent header injection.
     *
     * @param input the original token, may be {@code null}
     * @return a sanitized token with control characters removed, never {@code null}
     */
    private static String sanitizeToken(@Nullable String input) {
        if (input == null) {
            return "";
        }
        StringBuilder sanitized = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 0x20 && c != 0x7F) {
                sanitized.append(c);
            }
        }
        return sanitized.toString();
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .header("User-Agent", userAgent)
                .build();
        return chain.proceed(request);
    }
}
