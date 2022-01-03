package jp.co.project.planets.pleiades.db.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = Oauth2RegisteredClientListener.class )
@Table(name = "oauth2_registered_client")
public class Oauth2RegisteredClient extends AbstractOauth2RegisteredClient implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**  */
    @Id
    @Column(name = "id")
    String id;

    /**  */
    @Column(name = "client_id")
    String clientId;

    /**  */
    @Column(name = "client_id_issued_at")
    LocalDateTime clientIdIssuedAt;

    /**  */
    @Column(name = "client_secret")
    String clientSecret;

    /**  */
    @Column(name = "client_secret_expires_at")
    LocalDateTime clientSecretExpiresAt;

    /**  */
    @Column(name = "client_name")
    String clientName;

    /**  */
    @Column(name = "client_authentication_methods")
    String clientAuthenticationMethods;

    /**  */
    @Column(name = "authorization_grant_types")
    String authorizationGrantTypes;

    /**  */
    @Column(name = "redirect_uris")
    String redirectUris;

    /**  */
    @Column(name = "scopes")
    String scopes;

    /**  */
    @Column(name = "client_settings")
    String clientSettings;

    /**  */
    @Column(name = "token_settings")
    String tokenSettings;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public String getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /** 
     * Returns the clientId.
     * 
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /** 
     * Sets the clientId.
     * 
     * @param clientId the clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /** 
     * Returns the clientIdIssuedAt.
     * 
     * @return the clientIdIssuedAt
     */
    public LocalDateTime getClientIdIssuedAt() {
        return clientIdIssuedAt;
    }

    /** 
     * Sets the clientIdIssuedAt.
     * 
     * @param clientIdIssuedAt the clientIdIssuedAt
     */
    public void setClientIdIssuedAt(LocalDateTime clientIdIssuedAt) {
        this.clientIdIssuedAt = clientIdIssuedAt;
    }

    /** 
     * Returns the clientSecret.
     * 
     * @return the clientSecret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /** 
     * Sets the clientSecret.
     * 
     * @param clientSecret the clientSecret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /** 
     * Returns the clientSecretExpiresAt.
     * 
     * @return the clientSecretExpiresAt
     */
    public LocalDateTime getClientSecretExpiresAt() {
        return clientSecretExpiresAt;
    }

    /** 
     * Sets the clientSecretExpiresAt.
     * 
     * @param clientSecretExpiresAt the clientSecretExpiresAt
     */
    public void setClientSecretExpiresAt(LocalDateTime clientSecretExpiresAt) {
        this.clientSecretExpiresAt = clientSecretExpiresAt;
    }

    /** 
     * Returns the clientName.
     * 
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /** 
     * Sets the clientName.
     * 
     * @param clientName the clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /** 
     * Returns the clientAuthenticationMethods.
     * 
     * @return the clientAuthenticationMethods
     */
    public String getClientAuthenticationMethods() {
        return clientAuthenticationMethods;
    }

    /** 
     * Sets the clientAuthenticationMethods.
     * 
     * @param clientAuthenticationMethods the clientAuthenticationMethods
     */
    public void setClientAuthenticationMethods(String clientAuthenticationMethods) {
        this.clientAuthenticationMethods = clientAuthenticationMethods;
    }

    /** 
     * Returns the authorizationGrantTypes.
     * 
     * @return the authorizationGrantTypes
     */
    public String getAuthorizationGrantTypes() {
        return authorizationGrantTypes;
    }

    /** 
     * Sets the authorizationGrantTypes.
     * 
     * @param authorizationGrantTypes the authorizationGrantTypes
     */
    public void setAuthorizationGrantTypes(String authorizationGrantTypes) {
        this.authorizationGrantTypes = authorizationGrantTypes;
    }

    /** 
     * Returns the redirectUris.
     * 
     * @return the redirectUris
     */
    public String getRedirectUris() {
        return redirectUris;
    }

    /** 
     * Sets the redirectUris.
     * 
     * @param redirectUris the redirectUris
     */
    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    /** 
     * Returns the scopes.
     * 
     * @return the scopes
     */
    public String getScopes() {
        return scopes;
    }

    /** 
     * Sets the scopes.
     * 
     * @param scopes the scopes
     */
    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    /** 
     * Returns the clientSettings.
     * 
     * @return the clientSettings
     */
    public String getClientSettings() {
        return clientSettings;
    }

    /** 
     * Sets the clientSettings.
     * 
     * @param clientSettings the clientSettings
     */
    public void setClientSettings(String clientSettings) {
        this.clientSettings = clientSettings;
    }

    /** 
     * Returns the tokenSettings.
     * 
     * @return the tokenSettings
     */
    public String getTokenSettings() {
        return tokenSettings;
    }

    /** 
     * Sets the tokenSettings.
     * 
     * @param tokenSettings the tokenSettings
     */
    public void setTokenSettings(String tokenSettings) {
        this.tokenSettings = tokenSettings;
    }
}
