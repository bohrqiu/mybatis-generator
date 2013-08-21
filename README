###项目结构介绍
通过mybatis-generator(简称MG)来生成mybatis mapper

- gen目录为MG生成代码存放目录，通过maven配置加入到classpath
- main为runtime目录，存放我们编写的代码和配置文件
- test为MG runtime目录和测试目录。

目录详细结构如下：

    ├─src
	│  ├─gen (生成代码目录)
	│  │  ├─java (java代码目录)
	│  │  │  │─com.yjf.cs.dal.dto (DO目录，应该是do，但是do是java关键字，所以...)
	│  │  │  └─com.yjf.cs.dal.mapper (mapper目录，在mybatis里DTO改名为mapper)
	│  │  └─resources (资源目录)
	│  │      ├─com.yjf.cs.dal.mapper (mapper配置文件目录，mapper文件类似于sqlMap)
	│  │      └─dal (放MapperConfig.xml配置文件，类似于sqlMapConfig.xml)
	│  ├─main 
	│  │  ├─java
	│  │  │  └─com.yjf.mybatis.type (类型转换类目录)
	│  │  └─resources
	│  │      ├─dal (runtime数据库配置文件目录)
	│  │      └─spring (runtime spring配置目录)
	│  └─test
	│      ├─java
	│      │  ├─com.yjf.cs.dal (数据库测试目录)
	│      │  └─dalgen (dao生成工具目录)
	│      │     ├─generator.plugins (MG runtime 插件目录)
	│      │     └─helper   (MG 帮助类目录)
	│      └─resources
	│          └─dalgen  (MG runtime 配置文件目录)
	└─target


###插件执行流程
1. 执行dalgen.helper.DALGEN
2. 读取src/test/resources/dalgen/mybatis-generatorConfig.xml
3. MG读取jdbc文件和插件配置，表配置
4. 生成代码到src/gen目录

###mybatis运行流程
1. spring加载/src/main/resources/dal.xml配置文件
2. 创建数据源、构建SqlSessionFactory、扫描mapper并放入IOC容器
3. ok，其他地方可以Inject了

###如何使用
参考/src/test/java/com.yjf.cs.dal.DAOTest