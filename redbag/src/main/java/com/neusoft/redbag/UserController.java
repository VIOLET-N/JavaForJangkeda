package com.neusoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping()
    public User save(@RequestBody User user){
        return repository.save(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id")String id){
        Optional<User> optional = repository.findById(id);
        return optional.orElseGet(User::new);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        repository.deleteById(id);
    }

    @PutMapping("/id")
    public User update(@PathVariable("id")String id,@RequestBody User user){
        user.setId(id);
        return repository.save(user);
    }

    @GetMapping("/list")
//    public List<User> listAll(){
//        return repository.findAll();
//    }
    public Page<User> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize);
        return repository.findAll(pageRequest);
    }
}
