package jp.co.project.planets.pleiades.db.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;

/**
 * 作業時間
 */
@Entity(listener = WorkTimeListener.class, metamodel = @Metamodel)
@Table(name = "work_time")
public class WorkTime extends AbstractWorkTime implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** id */
    @Id
    @Column(name = "id")
    String id;

    /** 年月日 */
    @Column(name = "work_date")
    LocalDate workDate;

    /** 始業時間 */
    @Column(name = "start_time")
    LocalTime startTime;

    /** 終業時間 */
    @Column(name = "end_time")
    LocalTime endTime;

    /** 所定内通常勤務 */
    @Column(name = "official_working_time")
    LocalTime officialWorkingTime;

    /** 所定内深夜勤務 */
    @Column(name = "official_midnight_working_time")
    LocalTime officialMidnightWorkingTime;

    /** 所定内休憩勤務 */
    @Column(name = "official_break_time")
    LocalTime officialBreakTime;

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
     * Returns the workDate.
     * 
     * @return the workDate
     */
    public LocalDate getWorkDate() {
        return workDate;
    }

    /** 
     * Sets the workDate.
     * 
     * @param workDate the workDate
     */
    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    /** 
     * Returns the startTime.
     * 
     * @return the startTime
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /** 
     * Sets the startTime.
     * 
     * @param startTime the startTime
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /** 
     * Returns the endTime.
     * 
     * @return the endTime
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /** 
     * Sets the endTime.
     * 
     * @param endTime the endTime
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /** 
     * Returns the officialWorkingTime.
     * 
     * @return the officialWorkingTime
     */
    public LocalTime getOfficialWorkingTime() {
        return officialWorkingTime;
    }

    /** 
     * Sets the officialWorkingTime.
     * 
     * @param officialWorkingTime the officialWorkingTime
     */
    public void setOfficialWorkingTime(LocalTime officialWorkingTime) {
        this.officialWorkingTime = officialWorkingTime;
    }

    /** 
     * Returns the officialMidnightWorkingTime.
     * 
     * @return the officialMidnightWorkingTime
     */
    public LocalTime getOfficialMidnightWorkingTime() {
        return officialMidnightWorkingTime;
    }

    /** 
     * Sets the officialMidnightWorkingTime.
     * 
     * @param officialMidnightWorkingTime the officialMidnightWorkingTime
     */
    public void setOfficialMidnightWorkingTime(LocalTime officialMidnightWorkingTime) {
        this.officialMidnightWorkingTime = officialMidnightWorkingTime;
    }

    /** 
     * Returns the officialBreakTime.
     * 
     * @return the officialBreakTime
     */
    public LocalTime getOfficialBreakTime() {
        return officialBreakTime;
    }

    /** 
     * Sets the officialBreakTime.
     * 
     * @param officialBreakTime the officialBreakTime
     */
    public void setOfficialBreakTime(LocalTime officialBreakTime) {
        this.officialBreakTime = officialBreakTime;
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
