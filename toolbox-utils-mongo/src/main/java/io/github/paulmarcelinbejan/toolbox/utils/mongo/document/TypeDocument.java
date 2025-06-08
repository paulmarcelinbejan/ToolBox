package io.github.paulmarcelinbejan.toolbox.utils.mongo.document;

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
public abstract class TypeDocument extends CategorizationDocument {

	protected TypeDocument(Integer id, String code, String description) {
		super(id, code, description);
	}

}
