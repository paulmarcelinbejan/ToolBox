package ${PACKAGE}.${ENTITY_LOWERCASE}.controller;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
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

import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.validation.ValidatorUtils;
import com.paulmarcelinbejan.toolbox.web.response.OkResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/${ENTITY_LOWERCASE}")
public class ${ENTITY}RestController {

	private final ${ENTITY}Service ${ENTITY_LOWERCAMELCASE}Service;
	
	private final ${ENTITY}Mapper ${ENTITY_LOWERCAMELCASE}Mapper;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ${ENTITY}Dto findById(@PathVariable ${ID_TYPE} id) throws FunctionalException {
		return ${ENTITY_LOWERCAMELCASE}Mapper.toResponse(${ENTITY_LOWERCAMELCASE}Service.findById(id));
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<${ENTITY}Dto> findAll() {
		return ${ENTITY_LOWERCAMELCASE}Mapper.toResponses(${ENTITY_LOWERCAMELCASE}Service.findAll());
	}

	@PostMapping(value = "/save-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ${ID_TYPE} save(@Valid @RequestBody final ${ENTITY}SaveRequest saveRequest) {
		return ${ENTITY_LOWERCAMELCASE}Service.save(${ENTITY_LOWERCAMELCASE}Mapper.fromSaveRequestToEntity(saveRequest));
	}

	@PostMapping(value = "/save-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<${ID_TYPE}> save(@RequestBody final Collection<${ENTITY}SaveRequest> saveRequests) {
		ValidatorUtils.validateAll(saveRequests);
		return ${ENTITY_LOWERCAMELCASE}Service.save(${ENTITY_LOWERCAMELCASE}Mapper.fromSaveRequestsToEntities(saveRequests));
	}

	@PutMapping(value = "/update-one", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ${ID_TYPE} update(@Valid @RequestBody final ${ENTITY}UpdateRequest updateRequest) throws FunctionalException {
		return ${ENTITY_LOWERCAMELCASE}Service.update(${ENTITY_LOWERCAMELCASE}Mapper.fromUpdateRequestToEntity(updateRequest));
	}

	@PutMapping(value = "/update-many", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<${ID_TYPE}> update(@RequestBody final Collection<${ENTITY}UpdateRequest> updateRequests) throws FunctionalException {
		ValidatorUtils.validateAll(updateRequests);
		return ${ENTITY_LOWERCAMELCASE}Service.update(${ENTITY_LOWERCAMELCASE}Mapper.fromUpdateRequestsToEntities(updateRequests));
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@PathVariable ${ID_TYPE} id) throws FunctionalException {
		${ENTITY_LOWERCAMELCASE}Service.delete(id);
		return new OkResponse();
	}

	@DeleteMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OkResponse delete(@RequestBody Collection<${ID_TYPE}> ids) throws FunctionalException {
		${ENTITY_LOWERCAMELCASE}Service.deleteMany(ids);
		return new OkResponse();
	}

}
