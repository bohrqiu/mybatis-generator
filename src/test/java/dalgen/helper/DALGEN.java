package dalgen.helper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;

/**
 * 数据库生成类
 *         
 * @Filename DALGEN.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author bohr.qiu
 *
 * @Email qzhanbo@yiji.com
 *       
 * @History
 *<li>Author: bohr.qiu</li>
 *<li>Date: 2013-4-22</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class DALGEN {
	
	private static final Logger	logger						= LoggerFactory.getLogger(DALGEN.class
																.getName());
	String						propertiesLocation			= "/dalgen/mybatis-generatorConfig.xml";
	String						tablesToGen					= null;
	Set<String>					fullyQualifiedTableNames	= Sets.newHashSet();
	Configuration				config						= null;
	List<String>				warnings					= new ArrayList<String>();
	Scanner						s							= new Scanner(System.in);
	
	private void input() {
		logger.info("欢迎使用mybatis代码生成工具");
		
		logger.info("是否使用默认配置(Y/N)");
		String line = s.nextLine();
		if ("Y".equalsIgnoreCase(line)) {
			logger.info("配置文件为:{}", propertiesLocation);
		} else {
			logger.info("请输入配置文件地址(回车使用默认地址:{}):", propertiesLocation);
			line = s.nextLine();
			if (!StringUtils.isEmpty(line)) {
				propertiesLocation = line.trim();
			}
			logger.info("请输入要生成代码的表(表名为schema.tablename 请以逗号隔开，回车生成配置文件中所有的表):");
			line = s.nextLine();
			if (!StringUtils.isEmpty(line)) {
				tablesToGen = line.trim();
			}
			
		}
	}
	
	private void confirm() throws IOException, XMLParserException {
		logger.info("使用配置文件:{}", propertiesLocation);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		config = cp.parseConfiguration(DALGEN.class.getResourceAsStream(
			propertiesLocation));
		List<Context> contexts = config.getContexts();
		if (contexts == null) {
			throw new RuntimeException("请配置Context节点");
		}
		if (contexts.size() != 1) {
			throw new RuntimeException("配置了多个Context节点，建议一个配置文件只设置对一个数据库的操作");
		}
		if (tablesToGen != null) {
			String[] tables = tablesToGen.split(",");
			for (String table : tables) {
				fullyQualifiedTableNames.add(table.trim());
			}
		}
		
		if (fullyQualifiedTableNames.size() == 0) {
			logger.info("任务将会处理配置文件中所有的表");
		} else {
			for (String table : fullyQualifiedTableNames) {
				logger.info("任务将会处理表：{}", table);
			}
		}
		
		logger.info("是否使用以上配置生成代码?(Y/N)");
		String line = s.nextLine();
		if (!"Y".equalsIgnoreCase(line)) {
			System.exit(0);
		}
		
	}
	
	private void gen() throws Exception {
		DefaultShellCallback callback = new DefaultShellCallback(false);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(new LogProgressCallback(), null, fullyQualifiedTableNames);
		if (warnings.size() != 0) {
			logger.info("请注意下面的警告信息");
		}
		for (String warning : warnings) {
			logger.info(warning);
		}
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		DALGEN dalgen = new DALGEN();
		dalgen.input();
		dalgen.confirm();
		dalgen.gen();
	}
	
	private static class LogProgressCallback implements ProgressCallback {
		@Override
		public void introspectionStarted(int totalTasks) {
		}
		
		@Override
		public void generationStarted(int totalTasks) {
		}
		
		@Override
		public void saveStarted(int totalTasks) {
		}
		
		@Override
		public void startTask(String taskName) {
			logger.info("saveStarted {}", taskName);
		}
		
		@Override
		public void done() {
			logger.info("done.");
		}
		
		@Override
		public void checkCancel() throws InterruptedException {
		}
	}
}
