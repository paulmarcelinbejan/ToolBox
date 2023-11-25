package com.paulmarcelinbejan.toolbox.utils.time.aware;

import java.time.ZonedDateTime;

public interface HistoricalZonedDateTimeAware {
	
	ZonedDateTime startInstant();
	
	ZonedDateTime endInstant();
	
}
