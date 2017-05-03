package org.launchcode.models.data;

import org.launchcode.models.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jeannie on 5/2/17.
 */
public interface TaskDao extends CrudRepository<Task, Integer> {
}
