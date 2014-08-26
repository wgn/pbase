package com.zhuani21.pbase.pdm.domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
	List<Column> columns = null;
	private String name = null;

	public String getName() {
		return name;
	}

	public Table() {
		columns = new ArrayList<Column>();
	}

	public boolean addColumn(Column column) {
		return columns.add(column);
	}

	public int getColumnCount() {
		return columns.size();
	}

	public List<Column> getColumns() {
		return this.columns;
	}

	public void setName(String name) {
		this.name = name;

	}
}
