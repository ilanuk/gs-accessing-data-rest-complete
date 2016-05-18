package hello;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
@Component
@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId>, JpaSpecificationExecutor<Employee> {
	
//    @Query("SELECT t.id.idEmployee,t.id.branchName FROM Employee t where t.id.idEmployee = :id") 
//    EmployeeId findEmployeeCustomQuery(@Param("id") int id);	

}
