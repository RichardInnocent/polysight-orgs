package org.richardinnocent.polysight.orgs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.joda.time.DateTime;
import org.richardinnocent.polysight.orgs.models.Organisation.Meta;

/**
 * Represents an organisation.
 */
@Entity
@Table(
    name = Meta.TABLE_NAME,
    uniqueConstraints = {
        @UniqueConstraint(
            name = Meta.UNIQUE_NAME_CONSTRAINT_NAME,
            columnNames = Meta.NAME_COLUMN_NAME
        )
    }
)
public class Organisation {

  @Id
  @Column(name = Meta.ID_COLUMN_NAME, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(
      name = Meta.NAME_COLUMN_NAME,
      nullable = false,
      unique = true,
      length = Meta.NAME_COLUMN_LENGTH
  )
  private String name;

  @Column(name = Meta.DATE_CREATED_COLUMN_NAME, nullable = false)
  private DateTime dateCreated;

  @Column(name = Meta.STATUS_COLUMN_NAME, nullable = false)
  private OrganisationStatus status;

  /**
   * Gets the ID of the organisation.
   * @return The ID of the organisation.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the ID of the organisation.
   * @param id The ID of the organisation.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the name of the organisation. Note that the name of the organisation is unique.
   * @return The name of the organisation.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the organisation. Note that name of the organisation is unique.
   * @param name The name of the organisation.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the date and time at which the organisation was created.
   * @return The date and time at which the organisation was created.
   */
  public DateTime getDateCreated() {
    return dateCreated;
  }

  /**
   * Sets the date and time at which the organisation was created.
   * @param dateCreated The date and time at which the organisation was created.
   */
  public void setDateCreated(DateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  /**
   * Gets the current status of the organisation.
   * @return The current status of the organisation.
   */
  public OrganisationStatus getStatus() {
    return status;
  }

  /**
   * Sets the current status of the organisation.
   * @param status The current status of the organisation.
   */
  public void setStatus(OrganisationStatus status) {
    this.status = status;
  }

  public static class Meta {

    public static final String TABLE_NAME = "organisation";

    public static final String ID_COLUMN_NAME = "organisation_id";

    public static final String NAME_COLUMN_NAME = "name";
    public static final int NAME_COLUMN_LENGTH = 64;

    public static final String DATE_CREATED_COLUMN_NAME = "date_created";

    public static final String STATUS_COLUMN_NAME = "status";

    public static final String UNIQUE_NAME_CONSTRAINT_NAME = "unique_name";

    private Meta() {}
  }

}
