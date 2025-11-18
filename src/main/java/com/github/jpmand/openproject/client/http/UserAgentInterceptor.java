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
                lastPart.append(" ").append(each.getKey()).append("/").append(each.getValue()).append(";");
            }
        }
        this.userAgent = USER_AGENT_PREFIX + library + "; " + jvm + "; " + os + ";" + lastPart;
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
