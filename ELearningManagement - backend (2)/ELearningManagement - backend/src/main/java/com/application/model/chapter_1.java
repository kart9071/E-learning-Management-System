package com.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class chapter_1 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String coursename;
	public String chapter1name;
	@Lob
    private byte[] chapter1id;
	
	private String chapter2name;
	@Lob
    private byte[] chapter2id;
	
	private String chapter3name;
	@Lob
    private byte[] chapter3id;
	
	private String chapter4name;
	@Lob
    private byte[] chapter4id;
	
	private String chapter5name;
	@Lob
    private byte[] chapter5id;
	
	private String chapter6name;
	@Lob
    private byte[] chapter6id;
	
	private String chapter7name;
	@Lob
    private byte[] chapter7id;
	
	private String chapter8name;
	@Lob
    private byte[] chapter8id;
	
	public chapter_1()  
	{
		super();
	}

	public chapter_1 (int id, String coursename, String chapter1name, byte[] chapter1id, String chapter2name,
			byte[] chapter2id, String chapter3name, byte[] chapter3id, String chapter4name, byte[] chapter4id,
			String chapter5name, byte[] chapter5id, String chapter6name, byte[] chapter6id, String chapter7name,
			byte[] chapter7id, String chapter8name, byte[] chapter8id) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.chapter1name = chapter1name;
		this.chapter1id = chapter1id;
		this.chapter2name = chapter2name;
		this.chapter2id = chapter2id;
		this.chapter3name = chapter3name;
		this.chapter3id = chapter3id;
		this.chapter4name = chapter4name;
		this.chapter4id = chapter4id;
		this.chapter5name = chapter5name;
		this.chapter5id = chapter5id;
		this.chapter6name = chapter6name;
		this.chapter6id = chapter6id;
		this.chapter7name = chapter7name;
		this.chapter7id = chapter7id;
		this.chapter8name = chapter8name;
		this.chapter8id = chapter8id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getChapter1name() {
		return chapter1name;
	}

	public void setChapter1name(String chapter1name) {
		this.chapter1name = chapter1name;
	}

	public byte[] getChapter1id() {
		return chapter1id;
	}

	public void setChapter1id(byte[] chapter1id) {
		this.chapter1id = chapter1id;
	}

	public String getChapter2name() {
		return chapter2name;
	}

	public void setChapter2name(String chapter2name) {
		this.chapter2name = chapter2name;
	}

	public byte[] getChapter2id() {
		return chapter2id;
	}

	public void setChapter2id(byte[] chapter2id) {
		this.chapter2id = chapter2id;
	}

	public String getChapter3name() {
		return chapter3name;
	}

	public void setChapter3name(String chapter3name) {
		this.chapter3name = chapter3name;
	}

	public byte[] getChapter3id() {
		return chapter3id;
	}

	public void setChapter3id(byte[] chapter3id) {
		this.chapter3id = chapter3id;
	}

	public String getChapter4name() {
		return chapter4name;
	}

	public void setChapter4name(String chapter4name) {
		this.chapter4name = chapter4name;
	}

	public byte[] getChapter4id() {
		return chapter4id;
	}

	public void setChapter4id(byte[] chapter4id) {
		this.chapter4id = chapter4id;
	}

	public String getChapter5name() {
		return chapter5name;
	}

	public void setChapter5name(String chapter5name) {
		this.chapter5name = chapter5name;
	}

	public byte[] getChapter5id() {
		return chapter5id;
	}

	public void setChapter5id(byte[] chapter5id) {
		this.chapter5id = chapter5id;
	}

	public String getChapter6name() {
		return chapter6name;
	}

	public void setChapter6name(String chapter6name) {
		this.chapter6name = chapter6name;
	}

	public byte[] getChapter6id() {
		return chapter6id;
	}

	public void setChapter6id(byte[] chapter6id) {
		this.chapter6id = chapter6id;
	}

	public String getChapter7name() {
		return chapter7name;
	}

	public void setChapter7name(String chapter7name) {
		this.chapter7name = chapter7name;
	}

	public byte[] getChapter7id() {
		return chapter7id;
	}

	public void setChapter7id(byte[] chapter7id) {
		this.chapter7id = chapter7id;
	}

	public String getChapter8name() {
		return chapter8name;
	}

	public void setChapter8name(String chapter8name) {
		this.chapter8name = chapter8name;
	}

	public byte[] getChapter8id() {
		return chapter8id;
	}

	public void setChapter8id(byte[] chapter8id) {
		this.chapter8id = chapter8id;
	}

	public void setData(byte[] bytes) {
		
		
	}

	

	public void setFilePath(String filePath) {
		// TODO Auto-generated method stub
		
	}
		
	
}