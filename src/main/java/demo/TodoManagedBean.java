package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Scope("session")
public class TodoManagedBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(TodoManagedBean.class);
    List<Todo> todos;
    Todo todo = new Todo();

    @Inject
    TodoService todoService;

    @PostConstruct
    void init() {
        log.info("init");
        findAll();
    }

    public void findAll() {
        this.todos = todoService.findAll();
    }

    public void create() {
        log.info("create {}", this.todo);
        todoService.create(this.todo);
        findAll();
        this.todo = new Todo();
    }

    public void delete(String id) {
        log.info("delete {}", id);
        todoService.delete(id);
        findAll();
    }

    public void update(Todo todo) {
        log.info("update {}", todo);
        todoService.update(todo);
    }

    public Todo getTodo() {
        return todo;
    }

    public List<Todo> getTodos() {
        return todos;
    }
}
