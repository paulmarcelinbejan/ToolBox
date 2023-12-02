package io.github.paulmarcelinbejan.toolbox.utils.json;

import static io.github.paulmarcelinbejan.toolbox.utils.io.config.FileType.JSON;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.github.paulmarcelinbejan.toolbox.utils.io.FileUtils;
import io.github.paulmarcelinbejan.toolbox.utils.io.config.FileInfo;
import io.github.paulmarcelinbejan.toolbox.utils.io.enums.DirectoryPath;
import io.github.paulmarcelinbejan.toolbox.utils.json.JsonFileUtils;
import io.github.paulmarcelinbejan.toolbox.utils.json.dummy.Employee;

class JsonFileUtilsTest {

	@Test
	void testReadOne() throws IOException {
		JsonFileUtils json = new JsonFileUtils();
		FileInfo fileInfo = new FileInfo(DirectoryPath.SRC_TEST_RESOURCES.value, "employee", JSON);
		Employee employee = json.read(fileInfo, Employee.class);
		assertNotNull(employee);
	}
	
	@Test
	void testReadMany() throws IOException {
		JsonFileUtils json = new JsonFileUtils();
		FileInfo fileInfo = new FileInfo(DirectoryPath.SRC_TEST_RESOURCES.value, "employees", JSON);
		List<Employee> employees = json.readList(fileInfo, Employee.class);
		assertNotNull(employees);
		assertEquals(3, employees.size());
	}
	
	@Test
	void testWriteOne() {
		Employee employee = new Employee("Paul", "P");
		JsonFileUtils json = new JsonFileUtils();
		FileInfo fileInfo = new FileInfo(DirectoryPath.SRC_TEST_RESOURCES.value, "employeeWrittenByJava", JSON);
		try {
			json.write(fileInfo, employee);
		} catch (IOException e) {
			fail();
		}
		assertDoesNotThrow(() -> FileUtils.createFileReader(fileInfo));
	}
	
	@Test
	void testWriteMany() throws IOException {
		List<Employee> employees = List.of(new Employee("a", "a"), new Employee("b", "b"), new Employee("c", "c"), new Employee("d", "d"));
		JsonFileUtils json = new JsonFileUtils();
		FileInfo fileInfo = new FileInfo(DirectoryPath.SRC_TEST_RESOURCES.value, "employeesWrittenByJava", JSON);
		try {
			json.writeList(fileInfo, employees);
		} catch (IOException e) {
			fail();
		}
		assertDoesNotThrow(() -> FileUtils.createFileReader(fileInfo));
	}
	
}
