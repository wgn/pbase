package com.zhuani21.pbase.process.pdm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.zhuani21.pbase.process.pdm.domain.Column;
import com.zhuani21.pbase.process.pdm.domain.Table;
import com.zhuani21.pbase.util.Constant;

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
				bw.write("public class " + table.getName() + "{" + Constant.crlf);

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
					+ ") {" + Constant.crlf);
			bw.write("		this." + column.getCode() + " = " + column.getCode() + ";"
					+ Constant.crlf);
			bw.write("	}" + Constant.crlf);
			bw.write(Constant.crlf);
			// getter
			bw.write("	public " + column.getType() + " get" + nName + "() {" + Constant.crlf);
			bw.write("		return this." + column.getCode() + ";" + Constant.crlf);
			bw.write("	}" + Constant.crlf);
			bw.write(Constant.crlf);
		}
	}

	/**
	 * @param table
	 * @param bw
	 * @throws IOException
	 */
	private static void createFields(Table table, BufferedWriter bw) throws IOException {
		for (Column column : table.getColumns()) {
			bw.write("	private " + column.getType() + " " + column.getCode() + ";"
					+ Constant.crlf);
		}
		bw.write(Constant.crlf);
	}

}
