package ${PACKAGE}.${ENTITY_LOWERCASE}.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${PACKAGE}.${ENTITY_LOWERCASE}.dto.${ENTITY}Dto;
import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.mapper.${ENTITY}Mapper;
import ${PACKAGE}.${ENTITY_LOWERCASE}.repository.${ENTITY}Repository;
import ${PACKAGE}.${ENTITY_LOWERCASE}.service.${ENTITY}Service;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.DeleteServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.UpdateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class ${ENTITY}ServiceImpl implements ${ENTITY}Service {

	public ${ENTITY}ServiceImpl(${ENTITY}Mapper ${ENTITY_LOWERCAMELCASE}Mapper, ${ENTITY}Repository ${ENTITY_LOWERCAMELCASE}Repository) {
		createService = new CreateServiceImpl<>(${ENTITY_LOWERCAMELCASE}Mapper, ${ENTITY_LOWERCAMELCASE}Repository, ${ENTITY}::getId);
		readService = new ReadServiceImpl<>(${ENTITY_LOWERCAMELCASE}Mapper, ${ENTITY_LOWERCAMELCASE}Repository, ServiceUtils.buildErrorMessageIfEntityNotFound(${ENTITY}.class));
		updateService = new UpdateServiceImpl<>(
				${ENTITY_LOWERCAMELCASE}Mapper,
				${ENTITY_LOWERCAMELCASE}Repository,
				readService,
				${ENTITY}::getId,
				${ENTITY}Dto::getId);
		deleteService = new DeleteServiceImpl<>(${ENTITY_LOWERCAMELCASE}Repository, readService);
	}

	private final CreateService<${ID_TYPE}, ${ENTITY}Dto> createService;
	private final ReadService<${ID_TYPE}, ${ENTITY}, ${ENTITY}Dto> readService;
	private final UpdateService<${ID_TYPE}, ${ENTITY}Dto> updateService;
	private final DeleteService<${ID_TYPE}> deleteService;

	@Override
	@Transactional(readOnly = true)
	public ${ENTITY} findById(${ID_TYPE} id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ${ENTITY}Dto findByIdToDto(${ID_TYPE} id) throws FunctionalException {
		return readService.findByIdToDto(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<${ENTITY}> findManyById(Collection<${ID_TYPE}> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<${ENTITY}> findManyByIdIfPresent(Collection<${ID_TYPE}> ids) {
		return readService.findManyByIdIfPresent(ids);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<${ENTITY}Dto> findManyByIdToDto(Collection<${ID_TYPE}> ids) throws FunctionalException {
		return readService.findManyByIdToDto(ids);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<${ENTITY}Dto> findManyByIdToDtoIfPresent(Collection<${ID_TYPE}> ids) {
		return readService.findManyByIdToDtoIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<${ENTITY}> findAll() {
		return readService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<${ENTITY}Dto> findAllToDto() {
		return readService.findAllToDto();
	}

	@Override
	public ${ID_TYPE} save(${ENTITY}Dto dto) throws TechnicalException {
		return createService.save(dto);
	}

	@Override
	public Collection<${ID_TYPE}> save(Collection<${ENTITY}Dto> dtos) throws TechnicalException {
		return createService.save(dtos);
	}

	@Override
	public ${ID_TYPE} update(${ENTITY}Dto dto) throws FunctionalException, TechnicalException {
		return updateService.update(dto);
	}

	@Override
	public ${ENTITY}Dto updateAndReturn(${ENTITY}Dto dto) throws FunctionalException, TechnicalException {
		return updateService.updateAndReturn(dto);
	}
	
	@Override
	public Collection<${ID_TYPE}> update(Collection<${ENTITY}Dto> dtos) throws FunctionalException, TechnicalException {
		return updateService.update(dtos);
	}
	
	@Override
	public Collection<${ENTITY}Dto> updateAndReturn(Collection<${ENTITY}Dto> dtos) throws FunctionalException, TechnicalException {
		return updateService.updateAndReturn(dtos);
	}

	@Override
	public void delete(${ID_TYPE} id) throws FunctionalException {
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(${ID_TYPE} id) throws FunctionalException {
		deleteService.deleteIfPresent(id);
	}

	@Override
	public void delete(Collection<${ID_TYPE}> ids) throws FunctionalException {
		deleteService.delete(ids);
	}

	@Override
	public void deleteIfPresent(Collection<${ID_TYPE}> ids) {
		deleteService.deleteIfPresent(ids);
	}
	
}
