package dalgen.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * model后面加DO，同时也修改example,还有mapper
 *                       
 * @Filename RenameClassPlugin.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author bohr
 *
 * @Email qzhanbo@yiji.com
 *       
 * @History
 *<li>Author: bohr.qiu</li>
 *<li>Date: 2013-4-19</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class RenameClassPlugin extends PluginAdapter {
	
	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	@Override
	public void initialized(IntrospectedTable introspectedTable) {
		String oldType = introspectedTable.getBaseRecordType();
		String newType = oldType + "DO";
		introspectedTable.setBaseRecordType(newType);
		introspectedTable.setExampleType(newType + "Example");
//		String oldMapper = introspectedTable.getMyBatis3JavaMapperType();
//		String newMapper = oldMapper.replaceAll("Mapper$", "DAO");
//		introspectedTable.setMyBatis3JavaMapperType(newMapper);
	}
}
