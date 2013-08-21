package com.yjf.cs.dal;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yjf.common.log.Logger;
import com.yjf.common.log.LoggerFactory;
import com.yjf.cs.dal.dto.SysSeqDO;
import com.yjf.cs.dal.dto.SysSeqDOExample;
import com.yjf.cs.dal.mapper.SysSeqMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/spring/dal.xml" })
public class DAOTest {
	
	private static final Logger	logger	= LoggerFactory.getLogger(DAOTest.class.getName());
	@Inject
	private SysSeqMapper		sysSeqMapper;
	
	@Test
	public void testDAO() {
		//insert
		SysSeqDO record = new SysSeqDO();
		record.setName("a");
		sysSeqMapper.insert(record);
		logger.info("id:{}\n\n", record.getId());
		//count
		SysSeqDOExample example = new SysSeqDOExample();
		example.createCriteria().andNameEqualTo("a");
		int count = sysSeqMapper.countByExample(example);
		logger.info("count:{}\n\n", count);
		
		//update
		SysSeqDO record1 = new SysSeqDO();
		record1.setId((long) 1);
		record1.setName("b");
		count = sysSeqMapper.updateByPrimaryKey(record1);
		logger.info("update count:{}\n\n", count);
		
		//update name 列
		SysSeqDO record2 = new SysSeqDO();
		record2.setName("c");
		SysSeqDOExample example1 = new SysSeqDOExample();
		example1.createCriteria().andNameEqualTo("b");
		count = sysSeqMapper.updateByExampleSelective(record2, example1);
		logger.info("update count:{}\n\n", count);
		//delete
		SysSeqDOExample example2 = new SysSeqDOExample();
		example2.createCriteria().andNameEqualTo("a");
		count = sysSeqMapper.deleteByExample(example2);
		logger.info("delete count:{}\n\n", count);
	}
}
