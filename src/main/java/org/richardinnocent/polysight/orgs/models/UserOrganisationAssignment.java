package org.richardinnocent.polysight.orgs.models;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.richardinnocent.polysight.orgs.models.UserOrganisationAssignment.Meta;

@Entity
@Table(
    name = Meta.TABLE_NAME
)
public class UserOrganisationAssignment {

  @Id
  @Column(name = Meta.ID_COLUMN_NAME, nullable = false)
  private long id;

  @Column(name = Meta.USER_ID_COLUMN_NAME, nullable = false)
  private long userId;

  @OneToMany
  @JoinColumn(name = Meta.ORGANISATION_ID_JOIN_NAME, referencedColumnName = Organisation.Meta.ID_COLUMN_NAME)
  private Set<Organisation> organisations;

  public static final class Meta {
    public static final String TABLE_NAME = "user_organisation_assignment";
    public static final String ID_COLUMN_NAME = "user_organisation_assignment_id";
    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String ORGANISATION_ID_JOIN_NAME = "organisation_id";

    private Meta() {}
  }

}
