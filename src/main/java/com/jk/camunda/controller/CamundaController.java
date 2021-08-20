package com.jk.camunda.controller;


import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workflow")
public class CamundaController {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @GetMapping("/start")
    public ResponseEntity startWorkflow() {
        ProcessInstance processInstance =  runtimeService.startProcessInstanceByKey("Hello");
        return ResponseEntity.ok(processInstance.getProcessInstanceId());
    }

    @GetMapping("/complete/{taskId}")
    public ResponseEntity completeTask(@PathVariable("taskId") String taskId) {
        taskService.complete(taskId);
        return ResponseEntity.ok("Success");
    }


}
