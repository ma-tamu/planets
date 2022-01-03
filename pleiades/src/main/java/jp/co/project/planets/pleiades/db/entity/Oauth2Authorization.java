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
@Entity(listener = Oauth2AuthorizationListener.class )
@Table(name = "oauth2_authorization")
public class Oauth2Authorization extends AbstractOauth2Authorization implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**  */
    @Id
    @Column(name = "id")
    String id;

    /**  */
    @Column(name = "registered_client_id")
    String registeredClientId;

    /**  */
    @Column(name = "principal_name")
    String principalName;

    /**  */
    @Column(name = "authorization_grant_type")
    String authorizationGrantType;

    /**  */
    @Column(name = "attributes")
    String attributes;

    /**  */
    @Column(name = "state")
    String state;

    /**  */
    @Column(name = "authorization_code_value")
    String authorizationCodeValue;

    /**  */
    @Column(name = "authorization_code_issued_at")
    LocalDateTime authorizationCodeIssuedAt;

    /**  */
    @Column(name = "authorization_code_expires_at")
    LocalDateTime authorizationCodeExpiresAt;

    /**  */
    @Column(name = "authorization_code_metadata")
    String authorizationCodeMetadata;

    /**  */
    @Column(name = "access_token_value")
    String accessTokenValue;

    /**  */
    @Column(name = "access_token_issued_at")
    LocalDateTime accessTokenIssuedAt;

    /**  */
    @Column(name = "access_token_expires_at")
    LocalDateTime accessTokenExpiresAt;

    /**  */
    @Column(name = "access_token_metadata")
    String accessTokenMetadata;

    /**  */
    @Column(name = "access_token_type")
    String accessTokenType;

    /**  */
    @Column(name = "access_token_scopes")
    String accessTokenScopes;

    /**  */
    @Column(name = "oidc_id_token_value")
    String oidcIdTokenValue;

    /**  */
    @Column(name = "oidc_id_token_issued_at")
    LocalDateTime oidcIdTokenIssuedAt;

    /**  */
    @Column(name = "oidc_id_token_expires_at")
    LocalDateTime oidcIdTokenExpiresAt;

    /**  */
    @Column(name = "oidc_id_token_metadata")
    String oidcIdTokenMetadata;

    /**  */
    @Column(name = "refresh_token_value")
    String refreshTokenValue;

    /**  */
    @Column(name = "refresh_token_issued_at")
    LocalDateTime refreshTokenIssuedAt;

    /**  */
    @Column(name = "refresh_token_expires_at")
    LocalDateTime refreshTokenExpiresAt;

    /**  */
    @Column(name = "refresh_token_metadata")
    String refreshTokenMetadata;

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
     * Returns the registeredClientId.
     * 
     * @return the registeredClientId
     */
    public String getRegisteredClientId() {
        return registeredClientId;
    }

    /** 
     * Sets the registeredClientId.
     * 
     * @param registeredClientId the registeredClientId
     */
    public void setRegisteredClientId(String registeredClientId) {
        this.registeredClientId = registeredClientId;
    }

    /** 
     * Returns the principalName.
     * 
     * @return the principalName
     */
    public String getPrincipalName() {
        return principalName;
    }

    /** 
     * Sets the principalName.
     * 
     * @param principalName the principalName
     */
    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    /** 
     * Returns the authorizationGrantType.
     * 
     * @return the authorizationGrantType
     */
    public String getAuthorizationGrantType() {
        return authorizationGrantType;
    }

    /** 
     * Sets the authorizationGrantType.
     * 
     * @param authorizationGrantType the authorizationGrantType
     */
    public void setAuthorizationGrantType(String authorizationGrantType) {
        this.authorizationGrantType = authorizationGrantType;
    }

    /** 
     * Returns the attributes.
     * 
     * @return the attributes
     */
    public String getAttributes() {
        return attributes;
    }

    /** 
     * Sets the attributes.
     * 
     * @param attributes the attributes
     */
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    /** 
     * Returns the state.
     * 
     * @return the state
     */
    public String getState() {
        return state;
    }

    /** 
     * Sets the state.
     * 
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /** 
     * Returns the authorizationCodeValue.
     * 
     * @return the authorizationCodeValue
     */
    public String getAuthorizationCodeValue() {
        return authorizationCodeValue;
    }

    /** 
     * Sets the authorizationCodeValue.
     * 
     * @param authorizationCodeValue the authorizationCodeValue
     */
    public void setAuthorizationCodeValue(String authorizationCodeValue) {
        this.authorizationCodeValue = authorizationCodeValue;
    }

    /** 
     * Returns the authorizationCodeIssuedAt.
     * 
     * @return the authorizationCodeIssuedAt
     */
    public LocalDateTime getAuthorizationCodeIssuedAt() {
        return authorizationCodeIssuedAt;
    }

    /** 
     * Sets the authorizationCodeIssuedAt.
     * 
     * @param authorizationCodeIssuedAt the authorizationCodeIssuedAt
     */
    public void setAuthorizationCodeIssuedAt(LocalDateTime authorizationCodeIssuedAt) {
        this.authorizationCodeIssuedAt = authorizationCodeIssuedAt;
    }

    /** 
     * Returns the authorizationCodeExpiresAt.
     * 
     * @return the authorizationCodeExpiresAt
     */
    public LocalDateTime getAuthorizationCodeExpiresAt() {
        return authorizationCodeExpiresAt;
    }

    /** 
     * Sets the authorizationCodeExpiresAt.
     * 
     * @param authorizationCodeExpiresAt the authorizationCodeExpiresAt
     */
    public void setAuthorizationCodeExpiresAt(LocalDateTime authorizationCodeExpiresAt) {
        this.authorizationCodeExpiresAt = authorizationCodeExpiresAt;
    }

    /** 
     * Returns the authorizationCodeMetadata.
     * 
     * @return the authorizationCodeMetadata
     */
    public String getAuthorizationCodeMetadata() {
        return authorizationCodeMetadata;
    }

    /** 
     * Sets the authorizationCodeMetadata.
     * 
     * @param authorizationCodeMetadata the authorizationCodeMetadata
     */
    public void setAuthorizationCodeMetadata(String authorizationCodeMetadata) {
        this.authorizationCodeMetadata = authorizationCodeMetadata;
    }

    /** 
     * Returns the accessTokenValue.
     * 
     * @return the accessTokenValue
     */
    public String getAccessTokenValue() {
        return accessTokenValue;
    }

    /** 
     * Sets the accessTokenValue.
     * 
     * @param accessTokenValue the accessTokenValue
     */
    public void setAccessTokenValue(String accessTokenValue) {
        this.accessTokenValue = accessTokenValue;
    }

    /** 
     * Returns the accessTokenIssuedAt.
     * 
     * @return the accessTokenIssuedAt
     */
    public LocalDateTime getAccessTokenIssuedAt() {
        return accessTokenIssuedAt;
    }

    /** 
     * Sets the accessTokenIssuedAt.
     * 
     * @param accessTokenIssuedAt the accessTokenIssuedAt
     */
    public void setAccessTokenIssuedAt(LocalDateTime accessTokenIssuedAt) {
        this.accessTokenIssuedAt = accessTokenIssuedAt;
    }

    /** 
     * Returns the accessTokenExpiresAt.
     * 
     * @return the accessTokenExpiresAt
     */
    public LocalDateTime getAccessTokenExpiresAt() {
        return accessTokenExpiresAt;
    }

    /** 
     * Sets the accessTokenExpiresAt.
     * 
     * @param accessTokenExpiresAt the accessTokenExpiresAt
     */
    public void setAccessTokenExpiresAt(LocalDateTime accessTokenExpiresAt) {
        this.accessTokenExpiresAt = accessTokenExpiresAt;
    }

    /** 
     * Returns the accessTokenMetadata.
     * 
     * @return the accessTokenMetadata
     */
    public String getAccessTokenMetadata() {
        return accessTokenMetadata;
    }

    /** 
     * Sets the accessTokenMetadata.
     * 
     * @param accessTokenMetadata the accessTokenMetadata
     */
    public void setAccessTokenMetadata(String accessTokenMetadata) {
        this.accessTokenMetadata = accessTokenMetadata;
    }

    /** 
     * Returns the accessTokenType.
     * 
     * @return the accessTokenType
     */
    public String getAccessTokenType() {
        return accessTokenType;
    }

    /** 
     * Sets the accessTokenType.
     * 
     * @param accessTokenType the accessTokenType
     */
    public void setAccessTokenType(String accessTokenType) {
        this.accessTokenType = accessTokenType;
    }

    /** 
     * Returns the accessTokenScopes.
     * 
     * @return the accessTokenScopes
     */
    public String getAccessTokenScopes() {
        return accessTokenScopes;
    }

    /** 
     * Sets the accessTokenScopes.
     * 
     * @param accessTokenScopes the accessTokenScopes
     */
    public void setAccessTokenScopes(String accessTokenScopes) {
        this.accessTokenScopes = accessTokenScopes;
    }

    /** 
     * Returns the oidcIdTokenValue.
     * 
     * @return the oidcIdTokenValue
     */
    public String getOidcIdTokenValue() {
        return oidcIdTokenValue;
    }

    /** 
     * Sets the oidcIdTokenValue.
     * 
     * @param oidcIdTokenValue the oidcIdTokenValue
     */
    public void setOidcIdTokenValue(String oidcIdTokenValue) {
        this.oidcIdTokenValue = oidcIdTokenValue;
    }

    /** 
     * Returns the oidcIdTokenIssuedAt.
     * 
     * @return the oidcIdTokenIssuedAt
     */
    public LocalDateTime getOidcIdTokenIssuedAt() {
        return oidcIdTokenIssuedAt;
    }

    /** 
     * Sets the oidcIdTokenIssuedAt.
     * 
     * @param oidcIdTokenIssuedAt the oidcIdTokenIssuedAt
     */
    public void setOidcIdTokenIssuedAt(LocalDateTime oidcIdTokenIssuedAt) {
        this.oidcIdTokenIssuedAt = oidcIdTokenIssuedAt;
    }

    /** 
     * Returns the oidcIdTokenExpiresAt.
     * 
     * @return the oidcIdTokenExpiresAt
     */
    public LocalDateTime getOidcIdTokenExpiresAt() {
        return oidcIdTokenExpiresAt;
    }

    /** 
     * Sets the oidcIdTokenExpiresAt.
     * 
     * @param oidcIdTokenExpiresAt the oidcIdTokenExpiresAt
     */
    public void setOidcIdTokenExpiresAt(LocalDateTime oidcIdTokenExpiresAt) {
        this.oidcIdTokenExpiresAt = oidcIdTokenExpiresAt;
    }

    /** 
     * Returns the oidcIdTokenMetadata.
     * 
     * @return the oidcIdTokenMetadata
     */
    public String getOidcIdTokenMetadata() {
        return oidcIdTokenMetadata;
    }

    /** 
     * Sets the oidcIdTokenMetadata.
     * 
     * @param oidcIdTokenMetadata the oidcIdTokenMetadata
     */
    public void setOidcIdTokenMetadata(String oidcIdTokenMetadata) {
        this.oidcIdTokenMetadata = oidcIdTokenMetadata;
    }

    /** 
     * Returns the refreshTokenValue.
     * 
     * @return the refreshTokenValue
     */
    public String getRefreshTokenValue() {
        return refreshTokenValue;
    }

    /** 
     * Sets the refreshTokenValue.
     * 
     * @param refreshTokenValue the refreshTokenValue
     */
    public void setRefreshTokenValue(String refreshTokenValue) {
        this.refreshTokenValue = refreshTokenValue;
    }

    /** 
     * Returns the refreshTokenIssuedAt.
     * 
     * @return the refreshTokenIssuedAt
     */
    public LocalDateTime getRefreshTokenIssuedAt() {
        return refreshTokenIssuedAt;
    }

    /** 
     * Sets the refreshTokenIssuedAt.
     * 
     * @param refreshTokenIssuedAt the refreshTokenIssuedAt
     */
    public void setRefreshTokenIssuedAt(LocalDateTime refreshTokenIssuedAt) {
        this.refreshTokenIssuedAt = refreshTokenIssuedAt;
    }

    /** 
     * Returns the refreshTokenExpiresAt.
     * 
     * @return the refreshTokenExpiresAt
     */
    public LocalDateTime getRefreshTokenExpiresAt() {
        return refreshTokenExpiresAt;
    }

    /** 
     * Sets the refreshTokenExpiresAt.
     * 
     * @param refreshTokenExpiresAt the refreshTokenExpiresAt
     */
    public void setRefreshTokenExpiresAt(LocalDateTime refreshTokenExpiresAt) {
        this.refreshTokenExpiresAt = refreshTokenExpiresAt;
    }

    /** 
     * Returns the refreshTokenMetadata.
     * 
     * @return the refreshTokenMetadata
     */
    public String getRefreshTokenMetadata() {
        return refreshTokenMetadata;
    }

    /** 
     * Sets the refreshTokenMetadata.
     * 
     * @param refreshTokenMetadata the refreshTokenMetadata
     */
    public void setRefreshTokenMetadata(String refreshTokenMetadata) {
        this.refreshTokenMetadata = refreshTokenMetadata;
    }
}
