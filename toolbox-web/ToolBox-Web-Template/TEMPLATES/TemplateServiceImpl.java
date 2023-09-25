package ${PACKAGE}.${ENTITY_LOWERCASE}.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		createService = new CreateServiceImpl<>(${ENTITY_LOWERCAMELCASE}Repository, ${ENTITY}::getId);
		readService = new ReadServiceImpl<>(${ENTITY_LOWERCAMELCASE}Repository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(${ENTITY}.class));
		updateService = new UpdateServiceImpl<>(
				${ENTITY_LOWERCAMELCASE}Repository,
				${ENTITY_LOWERCAMELCASE}Mapper,
				readService,
				${ENTITY}::getId);
		deleteService = new DeleteServiceImpl<>(${ENTITY_LOWERCAMELCASE}Repository, readService);
	}

	private final CreateService<${ID_TYPE}, ${ENTITY}> createService;
	private final ReadService<${ID_TYPE}, ${ENTITY}> readService;
	private final UpdateService<${ID_TYPE}, ${ENTITY}> updateService;
	private final DeleteService<${ID_TYPE}> deleteService;

	@Override
	@Transactional(readOnly = true)
	public ${ENTITY} getReferenceById(${ID_TYPE} id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ${ENTITY} findById(${ID_TYPE} id) throws FunctionalException {
		return readService.findById(id);
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
	public Collection<${ENTITY}> findAll() {
		return readService.findAll();
	}

	@Override
	public ${ID_TYPE} save(${ENTITY} entity) throws FunctionalException {
		return createService.save(entity);
	}

	@Override
	public ${ENTITY} saveAndReturn(${ENTITY} entity) throws FunctionalException {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<${ID_TYPE}> save(Collection<${ENTITY}> entities) throws FunctionalException {
		return createService.save(entities);
	}

	@Override
	public Collection<${ENTITY}> saveAndReturn(Collection<${ENTITY}> entities) throws FunctionalException {
		return createService.saveAndReturn(entities);
	}

	@Override
	public ${ID_TYPE} update(${ENTITY} entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public ${ENTITY} updateAndReturn(${ENTITY} entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<${ID_TYPE}> update(Collection<${ENTITY}> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<${ENTITY}> updateAndReturn(Collection<${ENTITY}> entities) throws FunctionalException {
		return updateService.updateAndReturn(entities);
	}

	@Override
	public void delete(${ID_TYPE} id) throws FunctionalException {
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(${ID_TYPE} id) {
		deleteService.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<${ID_TYPE}> ids) throws FunctionalException {
		deleteService.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<${ID_TYPE}> ids) {
		deleteService.deleteManyIfPresent(ids);
	}
	
}
