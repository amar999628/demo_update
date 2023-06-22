package com.pennant.prodmtr.service.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Past30CompletionSummary;
import com.pennant.prodmtr.model.Dto.AnalyticsDto;

public interface AnalyticService {
	public AnalyticsDto getSummariesByUserId(int userId);

	public List<Past30CompletionSummary> getPast30CompletionSummary();

}