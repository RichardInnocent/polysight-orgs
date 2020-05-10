package org.richardinnocent.polysight.orgs.persistence.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.richardinnocent.polysight.orgs.models.UserOrganisationAssignment;
import org.springframework.data.jpa.domain.Specification;

public class UserOrganisationAssignmentDaoTest {

  private final UserOrganisationAssignmentRepository repo =
      mock(UserOrganisationAssignmentRepository.class);
  private final UserOrganisationAssignmentDao dao = new UserOrganisationAssignmentDao(repo);

  @Test
  @SuppressWarnings("unchecked")
  public void testFindAssignmentsForUserId() {
    List<UserOrganisationAssignment> assignments = Arrays.asList(
        mock(UserOrganisationAssignment.class),
        mock(UserOrganisationAssignment.class),
        mock(UserOrganisationAssignment.class)
    );
    when(repo.findAll(any(Specification.class))).thenReturn(assignments);

    assertEquals(assignments, dao.findAssignmentsForUserId(1L));
  }

}