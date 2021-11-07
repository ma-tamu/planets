package jp.co.project.planets.pleiades.db.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;

/**
 * OAuthクライアントリダイレクトURL
 */
@Entity(listener = OauthClientRedirectUrlListener.class )
@Table(name = "oauth_client_redirect_url")
public class OauthClientRedirectUrl extends AbstractOauthClientRedirectUrl implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** id */
    @Id
    @Column(name = "id")
    String id;

    /** OAuthクライアントid */
    @Column(name = "oauth_client_id")
    String oauthClientId;

    /** リダイレクトURL */
    @Column(name = "redirect_url")
    String redirectUrl;

    /** 作成日 */
    @Column(name = "created_at")
    LocalDateTime createdAt;

    /** 作成者 */
    @Column(name = "created_by")
    String createdBy;

    /** 更新日 */
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    /** 更新者 */
    @Column(name = "update_by")
    String updateBy;

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
     * Returns the redirectUrl.
     * 
     * @return the redirectUrl
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /** 
     * Sets the redirectUrl.
     * 
     * @param redirectUrl the redirectUrl
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
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
     * Returns the updatedAt.
     * 
     * @return the updatedAt
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /** 
     * Sets the updatedAt.
     * 
     * @param updatedAt the updatedAt
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /** 
     * Returns the updateBy.
     * 
     * @return the updateBy
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /** 
     * Sets the updateBy.
     * 
     * @param updateBy the updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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
