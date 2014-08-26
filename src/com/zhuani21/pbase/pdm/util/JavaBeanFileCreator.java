package com.zhuani21.pbase.pdm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.zhuani21.pbase.pdm.domain.Column;
import com.zhuani21.pbase.pdm.domain.Table;

public class JavaBeanFileCreator {
	public static void create(String path, List<Table> nTables) {
		for (Table table : nTables) {
			File javaFile = new File(path + File.separator + table.getName() + ".java");
			if (!javaFile.exists()) {
				try {
					javaFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(javaFile));
				bw.write("public class " + table.getName() + "{\r\n");

				createFields(table, bw);
				createGetterAndSetter(table, bw);

				bw.write("}");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					bw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	/**
	 * @param table
	 * @param bw
	 * @throws IOException
	 */
	private static void createGetterAndSetter(Table table, BufferedWriter bw) throws IOException {
		for (Column column : table.getColumns()) {
			String nName = (column.getCode().substring(0, 1).toUpperCase())
					+ column.getCode().substring(1, column.getCode().length());
			// setter
			bw.write("	public void set" + nName + "(" + column.getType() + " " + column.getCode()
					+ ") {\r\n");
			bw.write("		this." + column.getCode() + " = " + column.getCode() + " ;\r\n");
			bw.write("	}\r\n");
			bw.write("\r\n");
			// getter
			bw.write("	public " + column.getType() + " get" + nName + "() {\r\n");
			bw.write("		return this." + column.getCode() + " ;\r\n");
			bw.write("	}\r\n");
			bw.write("\r\n");
		}
	}

	/**
	 * @param table
	 * @param bw
	 * @throws IOException
	 */
	private static void createFields(Table table, BufferedWriter bw) throws IOException {
		for (Column column : table.getColumns()) {
			bw.write("	private " + column.getType() + " " + column.getCode() + " ; \r\n");
		}
		bw.write("\r\n");
	}

}
