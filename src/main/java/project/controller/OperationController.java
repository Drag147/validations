package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project.model.Change;
import project.model.operation.Operation;
import project.model.query.SearchParams;
import project.service.OperationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("operation")
public class OperationController {

    @Autowired
    private OperationService service;

    @Autowired
    @Qualifier("operationValidator")
    private Validator validator;

    @InitBinder("operation")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @RequestMapping(value = "query", method = RequestMethod.POST)
    public List<Operation> find(@RequestBody SearchParams searchParams) {
        return service.find(searchParams);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Operation load(@PathVariable String id){
        return service.load(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody @Valid Operation operation) {
        service.create(operation);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void update(@RequestBody @Valid Operation operation) {
        service.update(operation);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void remove(@RequestBody @Valid Operation operation) {
        service.remove(operation);
    }

    @RequestMapping(value = "{id}/change", method = RequestMethod.GET)
    public List<Change> getChanges(@PathVariable String id) {
        return service.getChanges(id);
    }

    @RequestMapping(value = "{id}/change/{versionId}", method = RequestMethod.GET)
    public Operation loadVersion(@PathVariable int versionId) {
        return service.loadVersion(versionId);
    }

}
