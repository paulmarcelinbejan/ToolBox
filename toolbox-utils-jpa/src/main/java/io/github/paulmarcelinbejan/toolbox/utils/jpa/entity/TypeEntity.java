package io.github.paulmarcelinbejan.toolbox.utils.jpa.entity;

import jakarta.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
public abstract class TypeEntity extends CategorizationEntity {

	protected TypeEntity(Integer id, String code, String description) {
		super(id, code, description);
	}

}
