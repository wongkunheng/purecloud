package com.mypurecloud.sdk.v2.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.mypurecloud.sdk.v2.ApiException;
import com.mypurecloud.sdk.v2.ApiClient;
import com.mypurecloud.sdk.v2.ApiRequest;
import com.mypurecloud.sdk.v2.ApiRequestBuilder;
import com.mypurecloud.sdk.v2.ApiResponse;
import com.mypurecloud.sdk.v2.Configuration;
import com.mypurecloud.sdk.v2.model.*;
import com.mypurecloud.sdk.v2.Pair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.mypurecloud.sdk.v2.model.Empty;
import com.mypurecloud.sdk.v2.model.ErrorBody;
import com.mypurecloud.sdk.v2.model.OAuthProviderEntityListing;
import com.mypurecloud.sdk.v2.model.ADFS;
import com.mypurecloud.sdk.v2.model.CustomerInteractionCenter;
import com.mypurecloud.sdk.v2.model.GenericSAML;
import com.mypurecloud.sdk.v2.model.GSuite;
import com.mypurecloud.sdk.v2.model.IdentityNow;
import com.mypurecloud.sdk.v2.model.Okta;
import com.mypurecloud.sdk.v2.model.OneLogin;
import com.mypurecloud.sdk.v2.model.PingIdentity;
import com.mypurecloud.sdk.v2.model.PureCloud;
import com.mypurecloud.sdk.v2.model.PureEngage;
import com.mypurecloud.sdk.v2.model.Salesforce;
import com.mypurecloud.sdk.v2.model.OAuthProvider;

public class PutIdentityprovidersGsuiteRequest {
    
	private GSuite body;
	public GSuite getBody() {
		return this.body;
	}

	public void setBody(GSuite body) {
		this.body = body;
	}

	public PutIdentityprovidersGsuiteRequest withBody(GSuite body) {
	    this.setBody(body);
	    return this;
	} 
	
	private final Map<String, String> customHeaders = new HashMap<>();
    public Map<String, String> getCustomHeaders() {
        return this.customHeaders;
    }

    public void setCustomHeaders(Map<String, String> customHeaders) {
        this.customHeaders.clear();
        this.customHeaders.putAll(customHeaders);
    }

    public void addCustomHeader(String name, String value) {
        this.customHeaders.put(name, value);
    }

    public PutIdentityprovidersGsuiteRequest withCustomHeader(String name, String value) {
        this.addCustomHeader(name, value);
        return this;
    }

    public ApiRequest<GSuite> withHttpInfo() {
        
        // verify the required parameter 'body' is set
        if (this.body == null) {
            throw new IllegalStateException("Missing the required parameter 'body' when building request for PutIdentityprovidersGsuiteRequest.");
        }
        

        return ApiRequestBuilder.create("PUT", "/api/v2/identityproviders/gsuite")
                .withBody(body)
        
                .withCustomHeaders(customHeaders)
                .withContentTypes("application/json")
                .withAccepts("application/json")
                .withAuthNames("PureCloud OAuth")
                .build();
    }

	public static Builder builder() {
		return new Builder();
	}

	
	public static Builder builder(GSuite body) {
	    return new Builder()
	            .withRequiredParams(body);
	}
	

	public static class Builder {
		private final PutIdentityprovidersGsuiteRequest request;

		private Builder() {
			request = new PutIdentityprovidersGsuiteRequest();
		}

		
		public Builder withBody(GSuite body) {
			request.setBody(body);
			return this;
		}
		

		
		public Builder withRequiredParams(GSuite body) {
			request.setBody(body);
			
			return this;
		}
		

		public PutIdentityprovidersGsuiteRequest build() {
            
            // verify the required parameter 'body' is set
            if (request.body == null) {
                throw new IllegalStateException("Missing the required parameter 'body' when building request for PutIdentityprovidersGsuiteRequest.");
            }
            
			return request;
		}
	}
}