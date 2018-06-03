package pl.coderslab.theultimateapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.theultimateapi.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Long> {

    Group findGroupByName (String name);

}
