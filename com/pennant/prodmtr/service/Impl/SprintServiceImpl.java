package com.pennant.prodmtr.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pennant.prodmtr.Dao.Interface.SprintDAO;
import com.pennant.prodmtr.model.Dto.ModuleDTO;
import com.pennant.prodmtr.model.Dto.SprintDto;
import com.pennant.prodmtr.model.Entity.FunctionalUnit;
import com.pennant.prodmtr.model.Entity.Sprint;
import com.pennant.prodmtr.model.Entity.SprintTasks;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.service.Interface.SprintService;

@Component
@Transactional
public class SprintServiceImpl implements SprintService {

	@Autowired
	private SprintDAO sprintDAO;

	//
	// public List<Sprint> getAllSprints() {
	// return sprintDAO.getAllSprints();
	// }
	//
	// public void createSprint(Sprint sprint) {
	// sprintDAO.createSprint(sprint);
	// }

	// public void updateSprint(Sprint sprint) {
	// sprintDAO.updateSprint(sprint);
	// }

	// public void deleteSprint(int sprintId) {
	// sprintDAO.deleteSprint(sprintId);
	// }
	//
	// public List<SprintDto> getSprintbyprojectId(Integer projectId) {
	// return sprintDAO.getSprintbyprojectId(projectId);
	// }

	// @Autowired
	// public SprintService(SprintDAO sprintDAO) {
	// this.sprintDAO = sprintDAO;
	// }

	@Override
	public List<Sprint> getBacklogs() {
		return sprintDAO.getBaskLogs();
	}

	@Override
	public Sprint getSprintDetails(int sprintId) {
		return sprintDAO.getSprintDetails(sprintId);
	}

	@Override
	public List<Task> getTasks(int modlId) {
		return sprintDAO.getTasks(modlId);
	}

	@Override
	public List<SprintTasks> getAllTasksBySprintId(Integer sprintId) {
		return sprintDAO.allTaskBySprintId(sprintId);
	}

	@Override
	public void storeSprint(Sprint sprint) {
		sprintDAO.storeSprint(sprint);
	}

	@Override
	public List<ModuleDTO> getSprintModulesByProjectId(int projectId) {
		return sprintDAO.getSprintModulesByProjectId(projectId);
	}

	@Override
	public List<FunctionalUnit> getFunctionalUnitsByModId(int modlId) {
		return sprintDAO.getFunctionalUnitsByModId(modlId);
	}

	@Override
	public void storeTask(Task task) {
		// TODO Auto-generated method stub

	}

	@Override
	public Sprint getSprintById(int sprintId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sprint> getAllSprints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createSprint(Sprint sprint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSprint(Sprint sprint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSprint(int sprintId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SprintDto> getSprintbyprojectId(Integer projectId) {
		// TODO Auto-generated method stub
		return null;
	}
}
