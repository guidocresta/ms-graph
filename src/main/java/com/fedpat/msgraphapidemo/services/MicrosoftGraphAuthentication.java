package com.fedpat.msgraphapidemo.services;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.requests.GraphServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MicrosoftGraphAuthentication {

    @Value("${azure.graph.api.clientId}")
    String clientId;
    @Value("${azure.graph.api.tenantId}")
    String tenantId;
    @Value("${azure.graph.api.clientSecret}")
    String clientSecret;
    @Value("${azure.graph.api.host}")
    String host;

    public GraphServiceClient getGraphClient() {

        ClientSecretCredential credential = new ClientSecretCredentialBuilder()
                .clientId(clientId)
                .tenantId(tenantId)
                .clientSecret(clientSecret)
                .build();

        TokenCredentialAuthProvider authProvider = new TokenCredentialAuthProvider(
                Collections.singletonList(host), credential);


        return GraphServiceClient.builder()
                .authenticationProvider(authProvider).buildClient();
    }

}
