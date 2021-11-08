package Patients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "patients", path = "patients")
public interface PatientsRepository extends PagingAndSortingRepository<Patient, Integer> {
    List<Patient> findByHealthCardNum(@Param("healthCardNum") int healthCardNum);
}


