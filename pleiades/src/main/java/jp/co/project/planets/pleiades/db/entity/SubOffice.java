package jp.co.project.planets.pleiades.db.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;

/**
 * 分室
 */
@Entity(listener = SubOfficeListener.class, metamodel = @Metamodel)
@Table(name = "sub_office")
public class SubOffice extends AbstractSubOffice implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** id */
    @Id
    @Column(name = "id")
    String id;

    /** 名前 */
    @Column(name = "name")
    String name;

    /** オフィス */
    @Column(name = "office_id")
    String officeId;

    /** 部門コード */
    @Column(name = "department_code")
    String departmentCode;

    /** 所属コード */
    @Column(name = "belong_code")
    String belongCode;

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
     * Returns the departmentCode.
     * 
     * @return the departmentCode
     */
    public String getDepartmentCode() {
        return departmentCode;
    }

    /** 
     * Sets the departmentCode.
     * 
     * @param departmentCode the departmentCode
     */
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    /** 
     * Returns the belongCode.
     * 
     * @return the belongCode
     */
    public String getBelongCode() {
        return belongCode;
    }

    /** 
     * Sets the belongCode.
     * 
     * @param belongCode the belongCode
     */
    public void setBelongCode(String belongCode) {
        this.belongCode = belongCode;
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
