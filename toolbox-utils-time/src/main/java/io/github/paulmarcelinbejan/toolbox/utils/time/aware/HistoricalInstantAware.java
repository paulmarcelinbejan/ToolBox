package io.github.paulmarcelinbejan.toolbox.utils.time.aware;

import java.time.Instant;

public interface HistoricalInstantAware {
	
	Instant startInstant();
	
	Instant endInstant();
	
}
