package com.nautical99diary.nautical99diary.controller;


import com.nautical99diary.nautical99diary.domain.Todo;
import com.nautical99diary.nautical99diary.dto.*;
import com.nautical99diary.nautical99diary.service.TodoService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo/{goalDay}")
    public List<Todo> getTodo(@PathVariable String goalDay,@RequestHeader(value = "Authorization", defaultValue = "token") String token) {
        return todoService.getTodo(goalDay, token);
    }

    @PostMapping("/todo/{goalDay}")
    public Todo createTodo(@PathVariable String goalDay, @RequestBody TodoRequestDto todoRequestDto,@RequestHeader(value = "Authorization", defaultValue = "token") String token) {
        return todoService.createTodo(goalDay, todoRequestDto, token);

    }

    /**
     * updateTodo: todo 내용 업데이트
     *
     * @param id
     * @param todoUpdate
     * @return UpdateDto.TodoUpdate
     */
    @PostMapping("/todo/{goalDay}/{id}")
    public UpdateDto.TodoUpdate updateTodo
    (@PathVariable Long id, @RequestBody UpdateDto.TodoUpdate todoUpdate,@RequestHeader(value = "Authorization", defaultValue = "token") String token) {
        todoUpdate.setId(id);
        return todoService.updateTodo(id,todoUpdate,token);
    }

    /**
     * updateComplete: 완료 여부 업데이트
     *
     * @param id
     * @param completionUpdate
     * @return UpdateDto.CompletionUpdate
     */
    @PutMapping("/todo/{goalDay}/{id}")
    public UpdateDto.CompletionUpdate updateComplete
    (@PathVariable Long id, @RequestBody UpdateDto.CompletionUpdate completionUpdate,@RequestHeader(value = "Authorization", defaultValue = "token") String token) {
        completionUpdate.setId(id);
        return todoService.updateComplete(id,completionUpdate,token);
    }

    @DeleteMapping("/todo/{goalDay}/{id}")
    public void deleteTodo(@PathVariable Long id,@RequestHeader(value = "Authorization", defaultValue = "token") String token) {
        todoService.deleteTodo(id,token);
    }

//    @GetMapping("/test/{uuid}/{username}")
//    public Map<String, String> test(
//                                    HttpSession httpSession,
//                                    @PathVariable String uuid,
//                                    @PathVariable String username,
//                                    HttpServletResponse response) {
//        httpSession.setAttribute(uuid, username);
//        System.out.println(httpSession.getAttribute(uuid));
//        Map<String, String> map = new HashMap<>();
//        map.put(AUTH_HEADER, uuid);
//        return map;
//    }

//    @PostMapping("/test2")
//    public String test2(HttpSession httpSession, @RequestParam("test") String test) {
//        return httpSession.getAttribute(test);
//    }


    @PostMapping("/test2")
    public String test2(@RequestHeader(value = "Authorization", defaultValue = "token") String token) {
        return todoService.test(token);
    }
}
