package io.github.wilcywilson.crud.dto;

public record StudentDto(int studentId, String studentName, String studentFaculty) {

	@Override
	public String toString() {
		return studentId + "\t" + studentName + "\t"
				+ studentFaculty;
	}

}
