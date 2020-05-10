package org.richardinnocent.polysight.orgs.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.richardinnocent.polysight.orgs.models.Organisation;
import org.richardinnocent.polysight.orgs.models.UserOrganisationAssignment;
import org.richardinnocent.polysight.orgs.persistence.dao.UserOrganisationAssignmentDao;

public class OrganisationServiceTest {

  private final UserOrganisationAssignmentDao dao = mock(UserOrganisationAssignmentDao.class);
  private final OrganisationService service = new OrganisationService(dao);

  @Test
  public void testGetAllOrganisationsForUserWithIdReturnsEmptySetWhenDaoReturnsNull() {
    when(dao.findAssignmentsForUserId(anyLong())).thenReturn(null);
    assertSame(Collections.emptySet(), service.getAllOrganisationsForUserWithId(1L));
  }

  @Test
  public void testGetAllOrganisationsForUserWithIdReturnsEmptySetWhenDaoReturnsEmptySet() {
    long userId = 1L;
    when(dao.findAssignmentsForUserId(userId)).thenReturn(Collections.emptyList());
    assertSame(Collections.emptySet(), service.getAllOrganisationsForUserWithId(userId));
  }

  @Test
  public void testGetAllOrganisationsForUserWithIdReturnsOrganisationWhenOneExists() {
    long userId = 1L;
    Organisation organisation = mock(Organisation.class);
    UserOrganisationAssignment assignment = mock(UserOrganisationAssignment.class);
    when(assignment.getOrganisation()).thenReturn(organisation);
    when(dao.findAssignmentsForUserId(userId)).thenReturn(Collections.singletonList(assignment));

    assertEquals(
        Collections.singleton(organisation), service.getAllOrganisationsForUserWithId(userId));
  }

  @Test
  public void testGetAlOrganisationsForUserWithIdReturnsOrganisationsWhenMultipleExist() {
    long userId = 1L;

    Organisation organisation1 = mock(Organisation.class);
    Organisation organisation2 = mock(Organisation.class);
    Organisation organisation3 = mock(Organisation.class);

    UserOrganisationAssignment assignment1 = mock(UserOrganisationAssignment.class);
    UserOrganisationAssignment assignment2 = mock(UserOrganisationAssignment.class);
    UserOrganisationAssignment assignment3 = mock(UserOrganisationAssignment.class);

    when(assignment1.getOrganisation()).thenReturn(organisation1);
    when(assignment2.getOrganisation()).thenReturn(organisation2);
    when(assignment3.getOrganisation()).thenReturn(organisation3);

    when(dao.findAssignmentsForUserId(userId))
        .thenReturn(Arrays.asList(assignment1, assignment2, assignment3));

    Set<Organisation> expectedOrganisations = new HashSet<>(3);
    expectedOrganisations.add(organisation1);
    expectedOrganisations.add(organisation2);
    expectedOrganisations.add(organisation3);

    assertEquals(expectedOrganisations, service.getAllOrganisationsForUserWithId(userId));
  }

  @Test
  public void testGetAlOrganisationsForUserWithIdReturnsOrganisationsWhenMultipleExistIgnoresNulls() {
    long userId = 1L;

    Organisation organisation1 = mock(Organisation.class);

    UserOrganisationAssignment assignment1 = mock(UserOrganisationAssignment.class);
    UserOrganisationAssignment assignment2 = mock(UserOrganisationAssignment.class);

    when(assignment1.getOrganisation()).thenReturn(organisation1);

    when(dao.findAssignmentsForUserId(userId))
        .thenReturn(Arrays.asList(assignment1, assignment2, null));

    Set<Organisation> expectedOrganisations = new HashSet<>(1);
    expectedOrganisations.add(organisation1);

    assertEquals(expectedOrganisations, service.getAllOrganisationsForUserWithId(userId));
  }

}