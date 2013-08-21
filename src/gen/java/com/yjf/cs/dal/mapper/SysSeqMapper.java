/**
 *
 * Dont modify any generated method! 
 * If you want to add a new method , plesae dont add  mbggenerated annotation marked comment.
 *
 * @Filename SysSeqMapper.java
 *
 * @Description
 *
 * @Author bohr.qiu
 *
 * @Email bohr.qiu@gmail.com
 *
 */
package com.yjf.cs.dal.mapper;

import com.yjf.cs.dal.dto.SysSeqDO;
import com.yjf.cs.dal.dto.SysSeqDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSeqMapper {
    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    int countByExample(SysSeqDOExample example);

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    int deleteByExample(SysSeqDOExample example);

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    int insert(SysSeqDO record);

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    int insertSelective(SysSeqDO record);

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    List<SysSeqDO> selectByExample(SysSeqDOExample example);

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    SysSeqDO selectByPrimaryKey(Long id);

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysSeqDO record, @Param("example") SysSeqDOExample example);

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysSeqDO record, @Param("example") SysSeqDOExample example);

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysSeqDO record);

    /**
     * corresponds to the database table sys_seq
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysSeqDO record);
}