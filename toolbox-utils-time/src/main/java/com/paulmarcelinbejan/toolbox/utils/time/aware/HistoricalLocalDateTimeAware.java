package com.paulmarcelinbejan.toolbox.utils.time.aware;

import java.time.LocalDateTime;

public interface HistoricalLocalDateTimeAware {
	
	LocalDateTime startLocalDateTime();
	
	LocalDateTime endLocalDateTime();
	
}
