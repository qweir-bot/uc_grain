package com.example.demo.sso.service.impl;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service("clientDetailsServiceImpl")
public class ClientDetailsServiceImpl implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        return null;
    }
}
