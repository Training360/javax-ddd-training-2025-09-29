package training.mentoringmodulith.courses.adapter.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import training.mentoringmodulith.courses.application.outboundport.gateway.EmployeesGateway;
import training.mentoringmodulith.courses.domain.enrollments.EmployeeId;
import training.mentoringmodulith.employees.application.inbound.EmployeeApplicationService;

@Service
@RequiredArgsConstructor
public class InMemoryEmployeesGateway implements EmployeesGateway {

    private final EmployeeApplicationService employeeApplicationService;

    @Override
    public boolean existsById(EmployeeId employeeId) {
        return employeeApplicationService.findEmployeeById(employeeId.value()).isPresent();
    }
}
