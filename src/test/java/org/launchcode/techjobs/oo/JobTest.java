package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    public void tearDown() {

    };

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() instanceof String);
        assertEquals("Product tester", testJob.getName());

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob.getEmployer().getValue());

        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency("Persistence"));

        Job jobTwo = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency("Persistence"));

        assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job testJob = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency("Persistence"));

        assertTrue(testJob.toString().startsWith(System.lineSeparator()) && testJob.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency("Persistence"));

        assertEquals(System.lineSeparator() +
                "ID: 4\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" + System.lineSeparator(), testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency(""));

        assertEquals(System.lineSeparator() +
                "ID: 3\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Data not available" + System.lineSeparator(), testJob.toString());
    }
}
