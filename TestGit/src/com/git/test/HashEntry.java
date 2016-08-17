package com.jrk.ds.hashtable.oa.linearprobing;

public class HashEntry {
	private int key;
	private int value;

	HashEntry(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[k=" + key + ", v=" + value + "]";
	}
}