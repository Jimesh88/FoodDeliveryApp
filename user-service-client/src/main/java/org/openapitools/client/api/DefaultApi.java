package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.UserDto;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-08-07T10:50:50.869823+05:30[Asia/Kolkata]", comments = "Generator version: 7.14.0")
public class DefaultApi {
    private ApiClient apiClient;

    public DefaultApi() {
        this(new ApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    
    /**
     * Get user by ID
     * 
     * <p><b>200</b> - Successful response
     * @param id The id parameter
     * @return UserDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getUserRequestCreation(@jakarta.annotation.Nonnull Integer id) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new WebClientResponseException("Missing the required parameter 'id' when calling getUser", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<UserDto> localVarReturnType = new ParameterizedTypeReference<UserDto>() {};
        return apiClient.invokeAPI("/v1/users/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get user by ID
     * 
     * <p><b>200</b> - Successful response
     * @param id The id parameter
     * @return UserDto
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<UserDto> getUser(@jakarta.annotation.Nonnull Integer id) throws WebClientResponseException {
        ParameterizedTypeReference<UserDto> localVarReturnType = new ParameterizedTypeReference<UserDto>() {};
        return getUserRequestCreation(id).bodyToMono(localVarReturnType);
    }

    /**
     * Get user by ID
     * 
     * <p><b>200</b> - Successful response
     * @param id The id parameter
     * @return ResponseEntity&lt;UserDto&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<UserDto>> getUserWithHttpInfo(@jakarta.annotation.Nonnull Integer id) throws WebClientResponseException {
        ParameterizedTypeReference<UserDto> localVarReturnType = new ParameterizedTypeReference<UserDto>() {};
        return getUserRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get user by ID
     * 
     * <p><b>200</b> - Successful response
     * @param id The id parameter
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getUserWithResponseSpec(@jakarta.annotation.Nonnull Integer id) throws WebClientResponseException {
        return getUserRequestCreation(id);
    }
}
