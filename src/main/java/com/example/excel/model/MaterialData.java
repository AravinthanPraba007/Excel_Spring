package com.example.excel.model;

public class MaterialData {
	
	Long materialId;
	String className;
	String character;
	String value;
	public Long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public MaterialData(Long materialId, String className, String character, String value) {
		super();
		this.materialId = materialId;
		this.className = className;
		this.character = character;
		this.value = value;
	}
	public MaterialData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MaterialData [materialId=" + materialId + ", className=" + className + ", character=" + character
				+ ", value=" + value + "]";
	}
	
	

}
