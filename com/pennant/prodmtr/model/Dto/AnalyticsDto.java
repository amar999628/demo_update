package com.pennant.prodmtr.model.Dto;

import java.util.List;

import com.pennant.prodmtr.model.ModuleSummary;
import com.pennant.prodmtr.model.Past30CompletionSummary;
import com.pennant.prodmtr.model.ProjectSummary;
import com.pennant.prodmtr.model.SubtaskSummary;
import com.pennant.prodmtr.model.TaskSummary;

public class AnalyticsDto {
	private List<ProjectSummary> projectSummaries;
	private List<ModuleSummary> moduleSummaries;
	private List<TaskSummary> taskSummaries;
	private List<SubtaskSummary> subtaskSummaries;
	private List<Past30CompletionSummary> past30CompletionSummary;

	public List<Past30CompletionSummary> getPast30CompletionSummary() {
		return past30CompletionSummary;
	}

	public void setPast30CompletionSummary(List<Past30CompletionSummary> past30CompletionSummary) {
		this.past30CompletionSummary = past30CompletionSummary;
	}

	public List<ProjectSummary> getProjectSummaries() {
		return projectSummaries;
	}

	public void setProjectSummaries(List<ProjectSummary> projectSummaries) {
		this.projectSummaries = projectSummaries;
	}

	public List<ModuleSummary> getModuleSummaries() {
		return moduleSummaries;
	}

	public void setModuleSummaries(List<ModuleSummary> moduleSummaries) {
		this.moduleSummaries = moduleSummaries;
	}

	public List<TaskSummary> getTaskSummaries() {
		return taskSummaries;
	}

	public void setTaskSummaries(List<TaskSummary> taskSummaries) {
		this.taskSummaries = taskSummaries;
	}

	public List<SubtaskSummary> getSubtaskSummaries() {
		return subtaskSummaries;
	}

	public void setSubtaskSummaries(List<SubtaskSummary> subtaskSummaries) {
		this.subtaskSummaries = subtaskSummaries;
	}

}
