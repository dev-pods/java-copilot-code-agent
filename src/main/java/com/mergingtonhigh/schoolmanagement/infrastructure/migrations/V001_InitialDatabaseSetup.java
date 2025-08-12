package com.mergingtonhigh.schoolmanagement.infrastructure.migrations;

import java.time.LocalTime;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.entities.Teacher;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ScheduleDetails;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

/**
 * Initial database setup: seeds all activities and teachers with proper
 * password handling.
 * Uses environment variables for sensitive data like passwords.
 */
@ChangeUnit(id = "initial-database-setup", order = "001", author = "Andre Fontoura")
public class V001_InitialDatabaseSetup {

    private final MongoTemplate mongoTemplate;
    private final PasswordEncoder passwordEncoder;
    private final Environment environment;

    public V001_InitialDatabaseSetup(MongoTemplate mongoTemplate, PasswordEncoder passwordEncoder,
            Environment environment) {
        this.mongoTemplate = mongoTemplate;
        this.passwordEncoder = passwordEncoder;
        this.environment = environment;
    }

    @Execution
    public void migrate() {
        seedActivitiesIfEmpty();
        seedTeachersIfEmpty();
    }

    private void seedActivitiesIfEmpty() {
        // Only seed if no activities exist
        if (mongoTemplate.count(new Query(), Activity.class) == 0) {
            seedActivities();
        }
    }

    private void seedTeachersIfEmpty() {
        // Only seed if no teachers exist
        if (mongoTemplate.count(new Query(), Teacher.class) == 0) {
            seedTeachers();
        }
    }

    private void seedActivities() {
        // Chess Club
        Activity chessClub = new Activity(
                "Chess Club",
                "Learn strategies and compete in chess tournaments",
                "Mondays and Fridays, 3:15 PM - 4:45 PM",
                new ScheduleDetails(List.of("Monday", "Friday"), LocalTime.of(15, 15), LocalTime.of(16, 45)),
                12);
        chessClub.setParticipants(List.of("michael@mergington.edu", "daniel@mergington.edu"));
        mongoTemplate.save(chessClub);

        // Programming Class
        Activity programmingClass = new Activity(
                "Programming Class",
                "Learn programming fundamentals and build software projects",
                "Tuesdays and Thursdays, 7:00 AM - 8:00 AM",
                new ScheduleDetails(List.of("Tuesday", "Thursday"), LocalTime.of(7, 0), LocalTime.of(8, 0)),
                20);
        programmingClass.setParticipants(List.of("emma@mergington.edu", "sophia@mergington.edu"));
        mongoTemplate.save(programmingClass);

        // Morning Fitness
        Activity morningFitness = new Activity(
                "Morning Fitness",
                "Early morning physical training and exercises",
                "Mondays, Wednesdays, Fridays, 6:30 AM - 7:45 AM",
                new ScheduleDetails(List.of("Monday", "Wednesday", "Friday"), LocalTime.of(6, 30), LocalTime.of(7, 45)),
                30);
        morningFitness.setParticipants(List.of("john@mergington.edu", "olivia@mergington.edu"));
        mongoTemplate.save(morningFitness);

        // Soccer Team
        Activity soccerTeam = new Activity(
                "Soccer Team",
                "Join the school soccer team and compete in matches",
                "Tuesdays and Thursdays, 3:30 PM - 5:30 PM",
                new ScheduleDetails(List.of("Tuesday", "Thursday"), LocalTime.of(15, 30), LocalTime.of(17, 30)),
                22);
        soccerTeam.setParticipants(List.of("liam@mergington.edu", "noah@mergington.edu"));
        mongoTemplate.save(soccerTeam);

        // Basketball Team
        Activity basketballTeam = new Activity(
                "Basketball Team",
                "Practice and compete in basketball tournaments",
                "Wednesdays and Fridays, 3:15 PM - 5:00 PM",
                new ScheduleDetails(List.of("Wednesday", "Friday"), LocalTime.of(15, 15), LocalTime.of(17, 0)),
                15);
        basketballTeam.setParticipants(List.of("ava@mergington.edu", "mia@mergington.edu"));
        mongoTemplate.save(basketballTeam);

        // Art Club
        Activity artClub = new Activity(
                "Art Club",
                "Explore various art techniques and create masterpieces",
                "Thursdays, 3:15 PM - 5:00 PM",
                new ScheduleDetails(List.of("Thursday"), LocalTime.of(15, 15), LocalTime.of(17, 0)),
                15);
        artClub.setParticipants(List.of("amelia@mergington.edu", "harper@mergington.edu"));
        mongoTemplate.save(artClub);

        // Drama Club
        Activity dramaClub = new Activity(
                "Drama Club",
                "Act, direct, and produce plays and performances",
                "Mondays and Wednesdays, 3:30 PM - 5:30 PM",
                new ScheduleDetails(List.of("Monday", "Wednesday"), LocalTime.of(15, 30), LocalTime.of(17, 30)),
                20);
        dramaClub.setParticipants(List.of("ella@mergington.edu", "scarlett@mergington.edu"));
        mongoTemplate.save(dramaClub);

        // Math Club
        Activity mathClub = new Activity(
                "Math Club",
                "Solve challenging problems and prepare for math competitions",
                "Tuesdays, 7:15 AM - 8:00 AM",
                new ScheduleDetails(List.of("Tuesday"), LocalTime.of(7, 15), LocalTime.of(8, 0)),
                10);
        mathClub.setParticipants(List.of("james@mergington.edu", "benjamin@mergington.edu"));
        mongoTemplate.save(mathClub);

        // Debate Team
        Activity debateTeam = new Activity(
                "Debate Team",
                "Develop public speaking and argumentation skills",
                "Fridays, 3:30 PM - 5:30 PM",
                new ScheduleDetails(List.of("Friday"), LocalTime.of(15, 30), LocalTime.of(17, 30)),
                12);
        debateTeam.setParticipants(List.of("charlotte@mergington.edu", "amelia@mergington.edu"));
        mongoTemplate.save(debateTeam);

        // Weekend Robotics Workshop
        Activity roboticsWorkshop = new Activity(
                "Weekend Robotics Workshop",
                "Build and program robots in our state-of-the-art workshop",
                "Saturdays, 10:00 AM - 2:00 PM",
                new ScheduleDetails(List.of("Saturday"), LocalTime.of(10, 0), LocalTime.of(14, 0)),
                15);
        roboticsWorkshop.setParticipants(List.of("ethan@mergington.edu", "oliver@mergington.edu"));
        mongoTemplate.save(roboticsWorkshop);

        // Science Olympiad
        Activity scienceOlympiad = new Activity(
                "Science Olympiad",
                "Weekend science competition preparation for regional and state events",
                "Saturdays, 1:00 PM - 4:00 PM",
                new ScheduleDetails(List.of("Saturday"), LocalTime.of(13, 0), LocalTime.of(16, 0)),
                18);
        scienceOlympiad.setParticipants(List.of("isabella@mergington.edu", "lucas@mergington.edu"));
        mongoTemplate.save(scienceOlympiad);

        // Sunday Chess Tournament
        Activity chessTournament = new Activity(
                "Sunday Chess Tournament",
                "Weekly tournament for serious chess players with rankings",
                "Sundays, 2:00 PM - 5:00 PM",
                new ScheduleDetails(List.of("Sunday"), LocalTime.of(14, 0), LocalTime.of(17, 0)),
                16);
        chessTournament.setParticipants(List.of("william@mergington.edu", "jacob@mergington.edu"));
        mongoTemplate.save(chessTournament);
    }

    private void seedTeachers() {
        // Get passwords from environment variables or use secure defaults
        String rodriguezPassword = environment.getProperty("TEACHER_RODRIGUEZ_PASSWORD", "art123");
        String chenPassword = environment.getProperty("TEACHER_CHEN_PASSWORD", "chess123");
        String principalPassword = environment.getProperty("PRINCIPAL_PASSWORD", "admin123");

        // Create Rodriguez teacher
        Teacher rodriguez = new Teacher(
                "mrodriguez",
                "Ms. Rodriguez",
                passwordEncoder.encode(rodriguezPassword),
                Teacher.Role.TEACHER);
        mongoTemplate.save(rodriguez);

        // Create Chen teacher
        Teacher chen = new Teacher(
                "mchen",
                "Mr. Chen",
                passwordEncoder.encode(chenPassword),
                Teacher.Role.TEACHER);
        mongoTemplate.save(chen);

        // Create Principal
        Teacher principal = new Teacher(
                "principal",
                "Principal Martinez",
                passwordEncoder.encode(principalPassword),
                Teacher.Role.ADMIN);
        mongoTemplate.save(principal);
    }

    @RollbackExecution
    public void rollback() {
        // Remove all seeded activities
        mongoTemplate.remove(new Query(Criteria.where("name").in(
                "Chess Club", "Programming Class", "Morning Fitness", "Soccer Team",
                "Basketball Team", "Art Club", "Drama Club", "Math Club",
                "Debate Team", "Weekend Robotics Workshop", "Science Olympiad",
                "Sunday Chess Tournament")), Activity.class);

        // Remove all seeded teachers
        mongoTemplate.remove(new Query(Criteria.where("_id").in("admin", "mrodriguez", "mchen", "principal")),
                Teacher.class);
    }
}
