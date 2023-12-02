package io.github.paulmarcelinbejan.toolbox.utils.time.aware;

import java.time.LocalTime;

public interface HistoricalLocalTimeAware {
	
	LocalTime startLocalTime();
	
	LocalTime endLocalTime();
	
}
