package com.example.ToDoList.Controller;

import com.example.ToDoList.TaskConfigurationProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final DataSourceProperties _dProperties;
    private final TaskConfigurationProperties _tProperties;

    public InfoController(DataSourceProperties properties, TaskConfigurationProperties tProperties) {
        _dProperties = properties;
        _tProperties = tProperties;
    }

    @GetMapping("info/url")
    public String url() {
        return _dProperties.getUrl();
    }

    @GetMapping("myProp")
    public boolean myProp() {
        return _tProperties.getTemplate().isAllowMultipleTasks();
    }
}
