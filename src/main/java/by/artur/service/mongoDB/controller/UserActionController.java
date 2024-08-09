package by.artur.service.mongoDB.controller;

import by.artur.service.mongoDB.entity.UserAction;
import by.artur.service.mongoDB.service.UserActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/action")
@RequiredArgsConstructor
public class UserActionController {

    private final UserActionService userActionService;

    @GetMapping("/{userId}")
    public UserAction getUserAction(@PathVariable("userId") String userId) {
        return userActionService.getUserAction(userId);
    }

    @GetMapping
    public List<UserAction> getAllActions() {
        return userActionService.getAllActions();
    }

}