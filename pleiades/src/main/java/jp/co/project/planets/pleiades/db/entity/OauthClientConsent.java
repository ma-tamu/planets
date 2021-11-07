package jp.co.project.planets.pleiades.db.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;

/**
 * OAuthクライアント承認
 */
@Entity(listener = OauthClientConsentListener.class )
@Table(name = "oauth_client_consent")
public class OauthClientConsent extends AbstractOauthClientConsent implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** id */
    @Id
    @Column(name = "id")
    String id;

    /** OAuthクライアントID */
    @Column(name = "oauth_client_id")
    String oauthClientId;

    /** ユーザーID */
    @Column(name = "user_id")
    String userId;

    /** スコープ */
    @Column(name = "scope")
    String scope;

    /** 作成日 */
    @Column(name = "created_at")
    LocalDateTime createdAt;

    /** 作成者 */
    @Column(name = "created_by")
    String createdBy;

    /** 削除フラグ */
    @Column(name = "is_deleted")
    Boolean isDeleted;

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
     * Returns the oauthClientId.
     * 
     * @return the oauthClientId
     */
    public String getOauthClientId() {
        return oauthClientId;
    }

    /** 
     * Sets the oauthClientId.
     * 
     * @param oauthClientId the oauthClientId
     */
    public void setOauthClientId(String oauthClientId) {
        this.oauthClientId = oauthClientId;
    }

    /** 
     * Returns the userId.
     * 
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /** 
     * Sets the userId.
     * 
     * @param userId the userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** 
     * Returns the scope.
     * 
     * @return the scope
     */
    public String getScope() {
        return scope;
    }

    /** 
     * Sets the scope.
     * 
     * @param scope the scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /** 
     * Returns the createdAt.
     * 
     * @return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /** 
     * Sets the createdAt.
     * 
     * @param createdAt the createdAt
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /** 
     * Returns the createdBy.
     * 
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /** 
     * Sets the createdBy.
     * 
     * @param createdBy the createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /** 
     * Returns the isDeleted.
     * 
     * @return the isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /** 
     * Sets the isDeleted.
     * 
     * @param isDeleted the isDeleted
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
