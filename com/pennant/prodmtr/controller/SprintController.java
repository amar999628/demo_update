package com.pennant.prodmtr.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pennant.prodmtr.model.Dto.FunctionalTask;
import com.pennant.prodmtr.model.Dto.FunctionalUnitdto;
import com.pennant.prodmtr.model.Dto.ModuleDTO;
import com.pennant.prodmtr.model.Dto.ProjectDto;
import com.pennant.prodmtr.model.Entity.FunctionalUnit;
import com.pennant.prodmtr.model.Entity.Sprint;
import com.pennant.prodmtr.model.Entity.SprintTasks;
import com.pennant.prodmtr.model.Entity.Task;
import com.pennant.prodmtr.model.Input.SprintInput;
import com.pennant.prodmtr.model.Input.TaskInput;
import com.pennant.prodmtr.service.Interface.ModuleService;
import com.pennant.prodmtr.service.Interface.ProjectService;
import com.pennant.prodmtr.service.Interface.SprintService;

@Controller
public class SprintController {

	SprintService sd;
	ProjectService pd;
	ModuleService md;

	@Autowired
	public SprintController(SprintService sprintService, ProjectService projectService, ModuleService ModuleService) {
		super();
		this.sd = sprintService;
		this.pd = projectService;
		this.md = ModuleService;

	}

	@RequestMapping(value = "/ShowFunctionalUnits", method = RequestMethod.POST)
	public String createTask(@Validated SprintInput sprintInput, Model model) throws ParseException {
		sd.storeSprint(sprintInput.toEntity());
		System.out.println("Create Tasks Requested" + sprintInput);
		System.out.println("Got this data" + sprintInput.getSprintId());

		List<FunctionalUnit> flist = sd.getFunctionalUnitsByModId(sprintInput.getModuleId());
		List<FunctionalUnitdto> funlistDto = new ArrayList<>();

		for (FunctionalUnit functionalUnit : flist) {
			FunctionalUnitdto funUnitDto = FunctionalUnitdto.fromEntity(functionalUnit);
			funlistDto.add(funUnitDto);
		}

		model.addAttribute("funlist", funlistDto);
		model.addAttribute("pro_id", sprintInput.getProjectId());
		return "ShowFunctionalUnits";
	}

	@RequestMapping(value = "/sprint", method = RequestMethod.GET)
	public String sprint(Model model) {
		System.out.println("project called");
		List<Sprint> allSprints = sd.getAllSprints();
		model.addAttribute("allSprints", allSprints);
		System.out.println(allSprints);
		return "sprint_home";
	}

	@RequestMapping(value = "/sprint_details", method = RequestMethod.GET)
	public String getSprintDetails(Model model, @RequestParam Integer sprintId) {
		// System.out.println("Sprint Details JSP Requested");
		Sprint sprint = sd.getSprintDetails(sprintId);
		// Retrieve the selected sprint details from the database and add them to the model
		model.addAttribute("sprint", sprint);

		List<SprintTasks> tasksByIdSprints = sd.getAllTasksBySprintId(sprintId);
		model.addAttribute("tasksByIdSprints", tasksByIdSprints);
		return "sprint_details";
	}

	// @RequestMapping(value = "/projectDetails", method = RequestMethod.GET)
	// public String getProjectDetails(Model model) {
	// // System.out.println("Sprint Details JSP Requested");
	//
	// // Retrieve the selected sprint details from the database and add them to the model
	//
	// return "projectDetails";
	// }

	@RequestMapping(value = "/add_sprint", method = RequestMethod.GET)
	public String addSprint(Model model) {
		List<ProjectDto> pl = pd.getAllProjects();
		model.addAttribute("projects", pl);
		return "add_sprint";
	}

	@RequestMapping(value = "/FunctionalUnit", method = RequestMethod.GET)
	public String addSprint() {
		// System.out.println("functional unit jsp");

		// Add any necessary data to the model for rendering the add sprint page

		return "FunctionalUnit";
	}

	@RequestMapping(value = "/SubTaskdetails", method = RequestMethod.GET)
	public String SubtaskDetails() {
		// System.out.println("Subtask Details requested");
		return "SubtaskDetails";
	}

	@RequestMapping(value = "/CreateSubTask", method = RequestMethod.GET)
	public String CreateSubtask() {

		return "CreateSubtask";
	}

	@RequestMapping(value = "/backlog", method = RequestMethod.GET)
	public String pastdue(Model model) {
		ArrayList<Sprint> SprintList = (ArrayList<Sprint>) sd.getBacklogs();
		System.out.println("pasteeeeeeeeeeeeeeeeeeeeeeeeeedue" + SprintList);
		System.out.println("fffffffffffff");
		model.addAttribute("sprintList", SprintList);
		return "backlog";
	}

	@RequestMapping(value = "/BacklogTasks", method = RequestMethod.GET)
	public String getBacklogTasks(Model model, @RequestParam("sprnModlId") int sprnModlId,
			@RequestParam("sprnId") int sprnId) {

		Sprint sprint = sd.getSprintDetails(sprnId);
		List<Task> taskList = sd.getTasks(sprnModlId);
		model.addAttribute("sprint", sprint);
		model.addAttribute("taskList", taskList);
		return "BacklogTasks";
	}

	@ResponseBody
	@RequestMapping(value = "/getModuleById", method = RequestMethod.POST, produces = "application/json")
	public String getModuleById(@RequestParam("projectId") int projectId) {
		System.out.println("Inside");
		List<ModuleDTO> moduleList = sd.getSprintModulesByProjectId(projectId);
		System.out.println("moduleList" + moduleList.get(0));
		Gson gson = new Gson();
		String json = gson.toJson(moduleList);
		return json;
	}

	@RequestMapping(value = "/Task", method = RequestMethod.POST)
	public String createTask(@ModelAttribute FunctionalTask ft, Model model) {
		System.out.println("Create Task");
		model.addAttribute("funtask", ft);
		System.out.println("tasksare" + ft);
		return "Task";
	}

	@RequestMapping(value = "/TaskAdded", method = RequestMethod.POST)
	public String TaskAdded(@ModelAttribute TaskInput taskInput, Model model) {
		System.out.println("task" + taskInput);
		sd.storeTask(taskInput.toEntity());
		return "TaskAdded";
	}
}
