package com.pennant.prodmtr.service.Interface;

import java.util.List;

import com.pennant.prodmtr.model.Dto.ResTaskFilter;
import com.pennant.prodmtr.model.Dto.TFilterCriteria;
import com.pennant.prodmtr.model.Dto.TaskDto;
import com.pennant.prodmtr.model.Entity.Task;

public interface TaskService {

	List<TaskDto> filterTasks(ResTaskFilter resTaskFilter);

	List<TaskDto> getTasksByUserId(int userId);

	List<TaskDto> PtfilterTasks(TFilterCriteria filterCriteria);

	List<TaskDto> getAllTasks();

	Task getTaskById(int taskId);

	void saveTask(Task task);

	Boolean updateStatus(int taskId);

	// Other task-related methods...
	int getCompletedTasksByUserId(int userId);

	int getTotalTasksByUserId(int userId);

	double getHoursWorkedByUserId(int userId);

	double calculatePerformanceScore(int completedTasks, int totalTasks);

	List<Task> getTasksByProjectId(Integer projId);

	List<Task> getCompTasksByProjectId(Integer projId);

}