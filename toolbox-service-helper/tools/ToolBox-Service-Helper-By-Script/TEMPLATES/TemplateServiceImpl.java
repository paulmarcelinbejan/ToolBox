package ${PACKAGE}.${ENTITY_LOWERCASE}.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${PACKAGE}.${ENTITY_LOWERCASE}.entity.${ENTITY};
import ${PACKAGE}.${ENTITY_LOWERCASE}.mapper.${ENTITY}Mapper;
import ${PACKAGE}.${ENTITY_LOWERCASE}.repository.${ENTITY}Repository;
import ${PACKAGE}.${ENTITY_LOWERCASE}.service.${ENTITY}Service;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.UpdateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

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
	public List<${ENTITY}> findManyById(List<${ID_TYPE}> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<${ENTITY}> findManyByIdIfPresent(List<${ID_TYPE}> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<${ENTITY}> findAll() {
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
	public List<${ID_TYPE}> save(List<${ENTITY}> entities) throws FunctionalException {
		return createService.save(entities);
	}

	@Override
	public List<${ENTITY}> saveAndReturn(List<${ENTITY}> entities) throws FunctionalException {
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
	public List<${ID_TYPE}> update(List<${ENTITY}> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public List<${ENTITY}> updateAndReturn(List<${ENTITY}> entities) throws FunctionalException {
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
	public void deleteMany(List<${ID_TYPE}> ids) throws FunctionalException {
		deleteService.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(List<${ID_TYPE}> ids) {
		deleteService.deleteManyIfPresent(ids);
	}
	
}
