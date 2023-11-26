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
		createServiceHelper = new CreateServiceHelperImpl<>(${ENTITY_LOWERCAMELCASE}Repository, ${ENTITY}::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(${ENTITY_LOWERCAMELCASE}Repository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(${ENTITY}.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				${ENTITY_LOWERCAMELCASE}Repository,
				${ENTITY_LOWERCAMELCASE}Mapper,
				readServiceHelper,
				${ENTITY}::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(${ENTITY_LOWERCAMELCASE}Repository, readServiceHelper);
	}

	private final CreateServiceHelper<${ID_TYPE}, ${ENTITY}> createServiceHelper;
	private final ReadServiceHelper<${ID_TYPE}, ${ENTITY}> readServiceHelper;
	private final UpdateServiceHelper<${ID_TYPE}, ${ENTITY}> updateServiceHelper;
	private final DeleteServiceHelper<${ID_TYPE}> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public ${ENTITY} getReferenceById(${ID_TYPE} id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ${ENTITY} findById(${ID_TYPE} id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<${ENTITY}> findManyById(List<${ID_TYPE}> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<${ENTITY}> findManyByIdIfPresent(List<${ID_TYPE}> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<${ENTITY}> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public ${ID_TYPE} save(${ENTITY} entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}

	@Override
	public ${ENTITY} saveAndReturn(${ENTITY} entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<${ID_TYPE}> save(List<${ENTITY}> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}

	@Override
	public List<${ENTITY}> saveAndReturn(List<${ENTITY}> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public ${ID_TYPE} update(${ENTITY} entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public ${ENTITY} updateAndReturn(${ENTITY} entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<${ID_TYPE}> update(List<${ENTITY}> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<${ENTITY}> updateAndReturn(List<${ENTITY}> entities) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entities);
	}

	@Override
	public void delete(${ID_TYPE} id) throws FunctionalException {
		deleteServiceHelper.delete(id);
	}
	
	@Override
	public void deleteIfPresent(${ID_TYPE} id) {
		deleteServiceHelper.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(List<${ID_TYPE}> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(List<${ID_TYPE}> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
	}
	
}
