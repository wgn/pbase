package com.zhuani21.pbase.process.pdm.util;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class PDMParser {
	public static List<Node> getTables(File file) {

		Document d = getDocument(file);
		List<Node> oTables = findTables(d);
		return oTables;
	}

	private static Document getDocument(File file) {
		Document d = null;
		try {
			d = parse(file);
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}

		return d;
	}

	public static Document parse(File file) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		return document;
	}

	public static List<Node> findTables(Document document) {
		List<Node> tables = document.selectNodes("//c:Tables/o:Table");
		if (null == tables || tables.size() == 0) {
			return Collections.emptyList();
		}
		return tables;
	}

}