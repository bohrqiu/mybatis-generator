/**
 *
 * A data object class directly models database table
 * Dont modify any generated method! 
 * If you want to add a new method , plesae dont add  mbggenerated annotation marked comment.
 *
 * @Filename SysSeqDO.java
 *
 * @Description
 *
 * @Author bohr.qiu
 *
 * @Email bohr.qiu@gmail.com
 *
 */
package com.yjf.cs.dal.dto;

import java.io.Serializable;
import java.util.Date;

public class SysSeqDO implements Serializable {
    /**
     *  sys_seq.id    自增字段
     *
     * @mbggenerated
     */
    private Long id;

    /**
     *  sys_seq.name    seq名字，为日后清理和统计用
     *
     * @mbggenerated
     */
    private String name;

    /**
     *  sys_seq.raw_add_time    创建时间
     *
     * @mbggenerated
     */
    private Date rawAddTime;

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * return the value of the database column sys_seq.id
     *
     * @return the value of sys_seq.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * set the value of the database column sys_seq.id
     *
     * @param id the value for sys_seq.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * return the value of the database column sys_seq.name
     *
     * @return the value of sys_seq.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * set the value of the database column sys_seq.name
     *
     * @param name the value for sys_seq.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * return the value of the database column sys_seq.raw_add_time
     *
     * @return the value of sys_seq.raw_add_time
     *
     * @mbggenerated
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * set the value of the database column sys_seq.raw_add_time
     *
     * @param rawAddTime the value for sys_seq.raw_add_time
     *
     * @mbggenerated
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysSeqDO other = (SysSeqDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()));
    }

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        return result;
    }
}