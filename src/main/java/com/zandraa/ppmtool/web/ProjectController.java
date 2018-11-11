package com.zandraa.ppmtool.web;

import com.zandraa.ppmtool.domain.Project;
import com.zandraa.ppmtool.services.MapValidationService;
import com.zandraa.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private ProjectService projectService;
    private MapValidationService mapValidationService;

    @Autowired
    public ProjectController(ProjectService projectService, MapValidationService mapValidationService) {
        this.projectService = projectService;
        this.mapValidationService = mapValidationService;
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationService.validateBindingResult(result);
        if(errorMap != null) return errorMap;

        Project saved = projectService.savveOrUpdate(project);
        return new ResponseEntity<Project>(saved, HttpStatus.CREATED);
    }
}
