package io.github.paulmarcelinbejan.toolbox.utils.json;

import static io.github.paulmarcelinbejan.toolbox.utils.io.config.FileExtension.JSON;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.github.paulmarcelinbejan.toolbox.utils.io.LocalFileUtils;
import io.github.paulmarcelinbejan.toolbox.utils.io.enums.DirectoryPath;
import io.github.paulmarcelinbejan.toolbox.utils.io.resource.InputFileResource;
import io.github.paulmarcelinbejan.toolbox.utils.io.resource.local.LocalInputFileResource;
import io.github.paulmarcelinbejan.toolbox.utils.io.resource.local.LocalOutputFileResource;
import io.github.paulmarcelinbejan.toolbox.utils.json.dummy.Employee;

class JsonFileUtilsTest {

	@Test
	void testReadOne() throws IOException {
		JsonFileReader json = new JsonFileReader();
		InputFileResource inputFileResource = new LocalInputFileResource(DirectoryPath.SRC_TEST_RESOURCES.value, "employee", JSON);
		Employee employee = json.read(inputFileResource, Employee.class);
		assertNotNull(employee);
	}
	
	@Test
	void testReadMany() throws IOException {
		JsonFileReader json = new JsonFileReader();
		InputFileResource inputFileResource = new LocalInputFileResource(DirectoryPath.SRC_TEST_RESOURCES.value, "employees", JSON);
		List<Employee> employees = json.readList(inputFileResource, Employee.class);
		assertNotNull(employees);
		assertEquals(3, employees.size());
	}
	
	@Test
	void testWriteOne() {
		Employee employee = new Employee("Paul", "P");
		JsonFileWriter json = new JsonFileWriter();
		LocalOutputFileResource localOutputFileResource = new LocalOutputFileResource(DirectoryPath.SRC_TEST_RESOURCES.value, "employeeWrittenByJava", JSON);
		try {
			json.write(localOutputFileResource, employee);
		} catch (IOException e) {
			fail();
		}
		assertDoesNotThrow(() -> LocalFileUtils.createFileReader(localOutputFileResource.getFullPath()));
	}
	
	@Test
	void testWriteMany() throws IOException {
		List<Employee> employees = List.of(new Employee("a", "a"), new Employee("b", "b"), new Employee("c", "c"), new Employee("d", "d"));
		JsonFileWriter json = new JsonFileWriter();
		LocalOutputFileResource localOutputFileResource = new LocalOutputFileResource(DirectoryPath.SRC_TEST_RESOURCES.value, "employeesWrittenByJava", JSON);
		try {
			json.writeList(localOutputFileResource, employees);
		} catch (IOException e) {
			fail();
		}
		assertDoesNotThrow(() -> LocalFileUtils.createFileReader(localOutputFileResource.getFullPath()));
	}
	
}
