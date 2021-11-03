package jp.co.project.planets.pleiades.db.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;

/**
 * ロールに紐づくパーミッション
 */
@Entity(listener = RolePermissionListener.class, metamodel = @Metamodel)
@Table(name = "role_permission")
public class RolePermission extends AbstractRolePermission {

    /** id */
    @Id
    @Column(name = "id")
    String id;

    /** id */
    @Column(name = "role_id")
    String roleId;

    /** id */
    @Column(name = "permission_id")
    String permissionId;

    /** 作成日 */
    @Column(name = "created_at")
    LocalDateTime createdAt;

    /** 作成者 */
    @Column(name = "created_by")
    String createdBy;

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
     * Returns the roleId.
     * 
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /** 
     * Sets the roleId.
     * 
     * @param roleId the roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /** 
     * Returns the permissionId.
     * 
     * @return the permissionId
     */
    public String getPermissionId() {
        return permissionId;
    }

    /** 
     * Sets the permissionId.
     * 
     * @param permissionId the permissionId
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
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
}
