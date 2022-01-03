package jp.co.project.planets.pleiades.db.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;

/**
 * ユーザー
 */
@Entity(listener = UserListener.class )
@Table(name = "user")
public class User extends AbstractUser implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** id */
    @Id
    @Column(name = "id")
    String id;

    /** ログインID */
    @Column(name = "login_id")
    String loginId;

    /** ユーザー名 */
    @Column(name = "name")
    String name;

    /** 性別 */
    @Column(name = "gender")
    String gender;

    /** メールアドレス */
    @Column(name = "mail")
    String mail;

    /** パスワード */
    @Column(name = "password")
    String password;

    /** ロックアウト */
    @Column(name = "lockout")
    Boolean lockout;

    /** 所属オフィス */
    @Column(name = "office_id")
    String officeId;

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
     * Returns the loginId.
     * 
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /** 
     * Sets the loginId.
     * 
     * @param loginId the loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /** 
     * Returns the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** 
     * Sets the name.
     * 
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Returns the gender.
     * 
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /** 
     * Sets the gender.
     * 
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** 
     * Returns the mail.
     * 
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /** 
     * Sets the mail.
     * 
     * @param mail the mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /** 
     * Returns the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /** 
     * Sets the password.
     * 
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * Returns the lockout.
     * 
     * @return the lockout
     */
    public Boolean getLockout() {
        return lockout;
    }

    /** 
     * Sets the lockout.
     * 
     * @param lockout the lockout
     */
    public void setLockout(Boolean lockout) {
        this.lockout = lockout;
    }

    /** 
     * Returns the officeId.
     * 
     * @return the officeId
     */
    public String getOfficeId() {
        return officeId;
    }

    /** 
     * Sets the officeId.
     * 
     * @param officeId the officeId
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
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
