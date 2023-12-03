package ${PACKAGE}.${ENTITY_LOWERCASE}.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Response;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}SaveRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}UpdateRequest;
import ${PACKAGE}.${ENTITY_LOWERCASE}.mapper.${ENTITY}Mapper;
import ${PACKAGE}.${ENTITY_LOWERCASE}.service.${ENTITY}Service;
import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import io.github.paulmarcelinbejan.toolbox.web.response.OkResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/${ENTITY_LOWERCASE}")
public class ${ENTITY}RestController {

	private final ${ENTITY}Service ${ENTITY_LOWERCAMELCASE}Service;
	
	private final ${ENTITY}Mapper ${ENTITY_LOWERCAMELCASE}Mapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ${ENTITY}Response findById(@PathVariable ${ID_TYPE} id) throws FunctionalException {
		return ${ENTITY_LOWERCAMELCASE}Mapper.toResponse(${ENTITY_LOWERCAMELCASE}Service.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<${ENTITY}Response> findAll() {
		return ${ENTITY_LOWERCAMELCASE}Mapper.toResponses(${ENTITY_LOWERCAMELCASE}Service.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ${ID_TYPE} save(@Valid @RequestBody final ${ENTITY}SaveRequest saveRequest) throws FunctionalException {
		return ${ENTITY_LOWERCAMELCASE}Service.save(${ENTITY_LOWERCAMELCASE}Mapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<${ID_TYPE}> save(@RequestBody final List<${ENTITY}SaveRequest> saveRequests) throws FunctionalException {
		ValidatorUtils.validateAll(saveRequests);
		return ${ENTITY_LOWERCAMELCASE}Service.save(${ENTITY_LOWERCAMELCASE}Mapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ${ID_TYPE} update(@Valid @RequestBody final ${ENTITY}UpdateRequest updateRequest) throws FunctionalException {
		return ${ENTITY_LOWERCAMELCASE}Service.update(${ENTITY_LOWERCAMELCASE}Mapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<${ID_TYPE}> update(@RequestBody final List<${ENTITY}UpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return ${ENTITY_LOWERCAMELCASE}Service.update(${ENTITY_LOWERCAMELCASE}Mapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable ${ID_TYPE} id) throws FunctionalException {
		${ENTITY_LOWERCAMELCASE}Service.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody List<${ID_TYPE}> ids) throws FunctionalException {
		${ENTITY_LOWERCAMELCASE}Service.deleteMany(ids);
		return new OkResponse();
	}

}
