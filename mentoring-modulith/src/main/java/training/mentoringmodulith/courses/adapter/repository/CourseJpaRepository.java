package training.mentoringmodulith.courses.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training.mentoringmodulith.courses.application.inboundport.CourseDto;

import java.util.List;

public interface CourseJpaRepository extends JpaRepository<CourseJpaEntity, String> {
    @Query("""
            select new training.mentoringmodulith.courses.application.inboundport.CourseDto(
                    c.code,
                    c.title) from CourseJpaEntity c order by c.code
        """)
    List<CourseDto> findAllDto();
}
