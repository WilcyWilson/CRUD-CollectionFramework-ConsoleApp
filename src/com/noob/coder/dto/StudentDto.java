package com.noob.coder.dto;

public class StudentDto {
	private int studentId;
	private String studentName;
	private String studentFaculty;

	public StudentDto(int studentId, String studentName, String studentFaculty) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentFaculty = studentFaculty;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentFaculty() {
		return studentFaculty;
	}

	public void setStudentFaculty(String studentFaculty) {
		this.studentFaculty = studentFaculty;
	}

	@Override
	public String toString() {
		return studentId + "\t" + studentName + "\t"
				+ studentFaculty;
	}

}
