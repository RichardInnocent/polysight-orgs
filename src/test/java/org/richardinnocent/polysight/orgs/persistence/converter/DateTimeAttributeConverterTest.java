package org.richardinnocent.polysight.orgs.persistence.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Timestamp;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class DateTimeAttributeConverterTest {

  private final DateTimeAttributeConverter converter = new DateTimeAttributeConverter();

  @Test
  public void testConvertToDatabaseColumnWhenNotNull() {
    DateTime dateTime = new DateTime("2019-10-15T20:13:03.000Z").withZone(DateTimeZone.UTC);
    Timestamp result = converter.convertToDatabaseColumn(dateTime);
    assertEquals(dateTime.getMillis(), result.getTime());
  }

  @Test
  public void testConvertToDatabaseColumnWhenNull() {
    assertNull(converter.convertToDatabaseColumn(null));
  }

  @Test
  public void testConvertToEntityAttributeWhenNotNull() {
    DateTime dateTime = new DateTime("2019-10-15T20:16:05.000").withZone(DateTimeZone.UTC);
    Timestamp timestamp = new Timestamp(dateTime.getMillis());
    assertEquals(dateTime, converter.convertToEntityAttribute(timestamp));
  }

  @Test
  public void testConvertToEntityAttributeWhenNull() {
    assertNull(converter.convertToEntityAttribute(null));
  }

}