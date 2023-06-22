package com.pennant.prodmtr.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pennant.prodmtr.Dao.Interface.ProjectTaskdao;
import com.pennant.prodmtr.model.Dto.PTFilterCriteria;
import com.pennant.prodmtr.model.Dto.ProjectDto;
import com.pennant.prodmtr.model.Dto.ProjectTaskDTO;
import com.pennant.prodmtr.model.Entity.ProjectTask;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.service.Interface.ProjectTaskService;
import com.pennant.prodmtr.service.Interface.TaskService;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {
	private final ProjectTaskdao projectTaskdao;
	private final ProjectTaskService projectTaskService;
	private final TaskService taskService;

	@Autowired
	public ProjectTaskServiceImpl(TaskService taskService, ProjectTaskdao projectTaskdao,
			ProjectTaskService projectTaskService) {
		this.projectTaskdao = projectTaskdao;
		this.projectTaskService = projectTaskService;
		this.taskService = taskService;
	}

	public ProjectTask createProjectTask(ProjectTask projectTask) {
		// Additional business logic, if needed
		return projectTaskdao.save(projectTask);
	}

	// public List<ProjectTask> getAllProjectTasks() {
	// return projectTaskdao.getProjectTaskDTOList();
	// }

	public List<ProjectTaskDTO> getProjectTaskDTOList() {
		// TODO Auto-generated method stub
		return projectTaskdao.getProjectTaskDTOList();
	}

	public ProjectTaskDTO getProjectTaskById(int taskId) {
		// TODO Auto-generated method stub
		return projectTaskdao.getProjectTaskById(taskId);
	}

	public List<ProjectTaskDTO> filterTasks(PTFilterCriteria filterCriteria) {

		return projectTaskdao.filterTasks(filterCriteria);
	}

	public void setTasksToProjDto(int projectId, ProjectDto projectDto) {

		List<Task> tasks = taskService.getTasksByProjectId(projectId);
		List<Task> compTasks = taskService.getCompTasksByProjectId(projectId);

		List<ProjectTask> projectTasks = projectTaskService.getTasksByProjectId(projectId);
		List<ProjectTask> compProjectTasks = projectTaskService.getCompTasksByProjectId(projectId);

		projectDto.setTotalTasks(tasks.size());
		projectDto.setCompletedTasks(compTasks.size());

		projectDto.setTotalIndvTasks(projectTasks.size());
		projectDto.setCompletedIndvTasks(compProjectTasks.size());
	}

	public List<ProjectTask> getTasksByProjectId(Integer projId) {
		// TODO Auto-generated method stub
		return projectTaskdao.getTasksByProjectId(projId);
	}

	public List<ProjectTask> getCompTasksByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return projectTaskdao.getCompTasksByProjectId(projectId);
	}

	// Other service methods for updating, deleting project tasks
}