package com.jacobsprojects.ppmtool.repositories;

import com.jacobsprojects.ppmtool.domain.Project;
import io.vavr.control.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    Option<Project> findAllById(Iterable<Long> iterable);

    Project findByProjectIdentifier(String projectId);
}
