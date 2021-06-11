package com.vti.entity;

public class Position {
	private int posId;
	private String posName;
	public Position(int posId, String posName) {
		super();
		this.posId = posId;
		this.posName = posName;
	}
	@Override
	public String toString() {
		return "Position [posId=" + posId + ", posName=" + posName + "]";
	}
	public int getPosId() {
		return posId;
	}
	public void setPosId(int posId) {
		this.posId = posId;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
}
