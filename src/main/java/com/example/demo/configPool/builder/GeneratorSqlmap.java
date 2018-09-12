package com.example.demo.configPool.builder;

import com.example.demo.configPool.builder.util.FileUtil;
import com.example.demo.configPool.builder.util.XMLAnalysis;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {
	public void generator(String path) throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File(path); 
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
		myBatisGenerator.generate(null);

	}
	public static void main(String[] args) throws Exception {
		FileUtil fileUtil = new FileUtil();
		String config = "";

		config = fileUtil.getResourceFilePathByName("generatorConfig.xml");
        XMLAnalysis.getNodeInfo(config);

		try {
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator(config);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
