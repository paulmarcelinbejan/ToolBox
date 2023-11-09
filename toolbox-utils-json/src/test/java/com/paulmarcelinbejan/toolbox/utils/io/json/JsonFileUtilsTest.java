package com.paulmarcelinbejan.toolbox.utils.io.json;

import static com.paulmarcelinbejan.toolbox.utils.io.config.FileType.JSON;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import com.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;
import com.paulmarcelinbejan.toolbox.utils.io.enums.DirectoryPath;
import com.paulmarcelinbejan.toolbox.utils.io.json.dummy.Employee;
import com.paulmarcelinbejan.toolbox.utils.json.JsonFileUtils;

class JsonFileUtilsTest {

	@Test
	void testReadOne() throws IOException {
		JsonFileUtils<Employee> json = new JsonFileUtils<>(Employee.class);
		FileInfo fileInfo = new FileInfo(DirectoryPath.SRC_TEST_RESOURCES.value, "employee");
		Employee employee = json.read(fileInfo);
		assertNotNull(employee);
	}
	
	@Test
	void testReadMany() throws IOException {
		JsonFileUtils<Employee> json = new JsonFileUtils<>(Employee.class);
		FileInfo fileInfo = new FileInfo(DirectoryPath.SRC_TEST_RESOURCES.value, "employees");
		List<Employee> employees = json.readList(fileInfo);
		assertNotNull(employees);
		assertEquals(3, employees.size());
	}
	
	@Test
	void testWriteOne() {
		Employee employee = new Employee("Paul", "P");
		JsonFileUtils<Employee> json = new JsonFileUtils<>(Employee.class);
		FileInfo fileInfo = new FileInfo(DirectoryPath.SRC_TEST_RESOURCES.value, "employeeWrittenByJava");
		try {
			json.write(fileInfo, employee);
		} catch (IOException e) {
			fail();
		}
		assertDoesNotThrow(() -> FileUtils.createFileReader(fileInfo, JSON));
	}
	
	@Test
	void testWriteMany() throws IOException {
		List<Employee> employees = List.of(new Employee("a", "a"), new Employee("b", "b"), new Employee("c", "c"), new Employee("d", "d"));
		JsonFileUtils<Employee> json = new JsonFileUtils<>(Employee.class);
		FileInfo fileInfo = new FileInfo(DirectoryPath.SRC_TEST_RESOURCES.value, "employeesWrittenByJava");
		try {
			json.writeList(fileInfo, employees);
		} catch (IOException e) {
			fail();
		}
		assertDoesNotThrow(() -> FileUtils.createFileReader(fileInfo, JSON));
	}
	
}
