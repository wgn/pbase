package com.zhuani21.pbase.process.pdm;

import java.io.File;
import java.util.List;

import org.dom4j.Node;

import com.zhuani21.pbase.process.pdm.domain.Table;
import com.zhuani21.pbase.process.pdm.util.JavaBeanFileCreator;
import com.zhuani21.pbase.process.pdm.util.PDMParser;
import com.zhuani21.pbase.process.pdm.util.TableFormatter;

public class PdmProcess {

	public static void main(String[] args) {
		//1 file
		File file = new File("C:\\Users\\vuclip111\\Desktop\\PhysicalDataModel_1.pdm");
		//2 xml parser
		List<Node> pdmTables = PDMParser.getTables(file);
		//3 transform table obj
		List<Table> nTables = TableFormatter.transformTables(pdmTables);
		//4 path of create file 
		String path = file.getParent();
		//5 create file (javabean)
		JavaBeanFileCreator.create(path, nTables);
	}

}
