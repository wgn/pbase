package com.zhuani21.pbase.process.pdm.util;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Node;

import com.zhuani21.pbase.process.pdm.domain.Column;
import com.zhuani21.pbase.process.pdm.domain.Table;

public class TableFormatter {
	public static List<Table> transformTables(List<Node> oTables) {
		List<Table> tables = new ArrayList<Table>();
		for (Object table : oTables) {
			Table nTable = new Table();
			Node t = (Node) table;
			Node name = t.selectSingleNode("a:Code");
			nTable.setName(name.getText());
			List<Node> columns = t.selectNodes("c:Columns/o:Column");

			for (Node column : columns) {
				Column ncolumn = new Column();

				String cCode = column.selectSingleNode("a:Code").getText();
				String cType = column.selectSingleNode("a:DataType").getText();
				String cLength = column.selectSingleNode("a:Length").getText();

				String nType = null;
				if (cType.indexOf("numeric") != -1) {
					nType = "Long";
				} else if (cType.indexOf("varchar") != -1) {
					nType = "String";
				}

				ncolumn.setCode(cCode);
				ncolumn.setType(nType);
				ncolumn.setLength(Integer.parseInt(cLength));
				nTable.addColumn(ncolumn);
			}
			if (nTable.getColumnCount() > 0) {
				tables.add(nTable);
			}
		}
		return tables;
	}
}
