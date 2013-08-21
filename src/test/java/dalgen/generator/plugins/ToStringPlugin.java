package dalgen.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * 生成tostring方法
 *                       
 * @Filename ToStringPlugin.java
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
 *<li>Date: 2013-4-20</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ToStringPlugin extends PluginAdapter {
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
													IntrospectedTable introspectedTable) {
		generateToString(introspectedTable, topLevelClass);
		return true;
	}
	
	@Override
	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass,
														IntrospectedTable introspectedTable) {
		generateToString(introspectedTable, topLevelClass);
		return true;
	}
	
	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
													IntrospectedTable introspectedTable) {
		generateToString(introspectedTable, topLevelClass);
		return true;
	}
	
	private void generateToString(IntrospectedTable introspectedTable, TopLevelClass topLevelClass) {
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getStringInstance());
		method.setName("toString");
		if (introspectedTable.isJava5Targeted()) {
			method.addAnnotation("@Override");
		}
		
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		
		method.addBodyLine("StringBuilder sb = new StringBuilder();");
		method.addBodyLine("sb.append(getClass().getSimpleName());");
		method.addBodyLine("sb.append(\" [\");");
		StringBuilder sb = new StringBuilder();
		for (Field field : topLevelClass.getFields()) {
			String property = field.getName();
			sb.setLength(0);
			sb.append("sb.append(\"").append(", ").append(property).append("=\")")
				.append(".append(").append(property).append(");");
			method.addBodyLine(sb.toString());
		}
		
		method.addBodyLine("sb.append(\"]\");");
		method.addBodyLine("return sb.toString();");
		
		topLevelClass.addMethod(method);
	}
}
