package demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
public class TodoService {
    @Inject
    TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public Todo findOne(String id) {
        return todoRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(String id) {
        todoRepository.delete(id);
    }
}
