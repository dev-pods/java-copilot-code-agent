package com.mergingtonhigh.schoolmanagement.infrastructure.config;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.entities.Teacher;
import com.mergingtonhigh.schoolmanagement.domain.repositories.ActivityRepository;
import com.mergingtonhigh.schoolmanagement.domain.repositories.TeacherRepository;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ScheduleDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalTime;
import java.util.List;

/**
 * Database initialization configuration.
 */
@Configuration
public class DatabaseInitConfig {
    
    @Bean
    public CommandLineRunner initDatabase(ActivityRepository activityRepository, 
                                        TeacherRepository teacherRepository,
                                        PasswordEncoder passwordEncoder) {
        return args -> {
            // Skip database initialization if MongoDB is not available
            try {
                // Initialize activities if empty
                if (activityRepository.findAll().isEmpty()) {
                    initializeActivities(activityRepository);
                }
                
                // Initialize teachers if empty
                if (teacherRepository.findAll().isEmpty()) {
                    initializeTeachers(teacherRepository, passwordEncoder);
                }
            } catch (Exception e) {
                System.out.println("Database initialization skipped - MongoDB not available: " + e.getMessage());
            }
        };
    }
    
    private void initializeActivities(ActivityRepository activityRepository) {
        // Chess Club
        Activity chessClub = new Activity(
            "Chess Club",
            "Learn strategies and compete in chess tournaments",
            "Mondays and Fridays, 3:15 PM - 4:45 PM",
            new ScheduleDetails(List.of("Monday", "Friday"), LocalTime.of(15, 15), LocalTime.of(16, 45)),
            12
        );
        chessClub.setParticipants(List.of("michael@mergington.edu", "daniel@mergington.edu"));
        activityRepository.save(chessClub);
        
        // Programming Class
        Activity programmingClass = new Activity(
            "Programming Class",
            "Learn programming fundamentals and build software projects",
            "Tuesdays and Thursdays, 7:00 AM - 8:00 AM",
            new ScheduleDetails(List.of("Tuesday", "Thursday"), LocalTime.of(7, 0), LocalTime.of(8, 0)),
            20
        );
        programmingClass.setParticipants(List.of("emma@mergington.edu", "sophia@mergington.edu"));
        activityRepository.save(programmingClass);
        
        // Morning Fitness
        Activity morningFitness = new Activity(
            "Morning Fitness",
            "Early morning physical training and exercises",
            "Mondays, Wednesdays, Fridays, 6:30 AM - 7:45 AM",
            new ScheduleDetails(List.of("Monday", "Wednesday", "Friday"), LocalTime.of(6, 30), LocalTime.of(7, 45)),
            30
        );
        morningFitness.setParticipants(List.of("john@mergington.edu", "olivia@mergington.edu"));
        activityRepository.save(morningFitness);
        
        // Soccer Team
        Activity soccerTeam = new Activity(
            "Soccer Team",
            "Join the school soccer team and compete in matches",
            "Tuesdays and Thursdays, 3:30 PM - 5:30 PM",
            new ScheduleDetails(List.of("Tuesday", "Thursday"), LocalTime.of(15, 30), LocalTime.of(17, 30)),
            22
        );
        soccerTeam.setParticipants(List.of("liam@mergington.edu", "noah@mergington.edu"));
        activityRepository.save(soccerTeam);
        
        // Basketball Team
        Activity basketballTeam = new Activity(
            "Basketball Team",
            "Practice and compete in basketball tournaments",
            "Wednesdays and Fridays, 3:15 PM - 5:00 PM",
            new ScheduleDetails(List.of("Wednesday", "Friday"), LocalTime.of(15, 15), LocalTime.of(17, 0)),
            15
        );
        basketballTeam.setParticipants(List.of("ava@mergington.edu", "mia@mergington.edu"));
        activityRepository.save(basketballTeam);
        
        // Art Club
        Activity artClub = new Activity(
            "Art Club",
            "Explore various art techniques and create masterpieces",
            "Thursdays, 3:15 PM - 5:00 PM",
            new ScheduleDetails(List.of("Thursday"), LocalTime.of(15, 15), LocalTime.of(17, 0)),
            15
        );
        artClub.setParticipants(List.of("amelia@mergington.edu", "harper@mergington.edu"));
        activityRepository.save(artClub);
        
        // Drama Club
        Activity dramaClub = new Activity(
            "Drama Club",
            "Act, direct, and produce plays and performances",
            "Mondays and Wednesdays, 3:30 PM - 5:30 PM",
            new ScheduleDetails(List.of("Monday", "Wednesday"), LocalTime.of(15, 30), LocalTime.of(17, 30)),
            20
        );
        dramaClub.setParticipants(List.of("ella@mergington.edu", "scarlett@mergington.edu"));
        activityRepository.save(dramaClub);
        
        // Math Club
        Activity mathClub = new Activity(
            "Math Club",
            "Solve challenging problems and prepare for math competitions",
            "Tuesdays, 7:15 AM - 8:00 AM",
            new ScheduleDetails(List.of("Tuesday"), LocalTime.of(7, 15), LocalTime.of(8, 0)),
            10
        );
        mathClub.setParticipants(List.of("james@mergington.edu", "benjamin@mergington.edu"));
        activityRepository.save(mathClub);
        
        // Debate Team
        Activity debateTeam = new Activity(
            "Debate Team",
            "Develop public speaking and argumentation skills",
            "Fridays, 3:30 PM - 5:30 PM",
            new ScheduleDetails(List.of("Friday"), LocalTime.of(15, 30), LocalTime.of(17, 30)),
            12
        );
        debateTeam.setParticipants(List.of("charlotte@mergington.edu", "amelia@mergington.edu"));
        activityRepository.save(debateTeam);
        
        // Weekend Robotics Workshop
        Activity roboticsWorkshop = new Activity(
            "Weekend Robotics Workshop",
            "Build and program robots in our state-of-the-art workshop",
            "Saturdays, 10:00 AM - 2:00 PM",
            new ScheduleDetails(List.of("Saturday"), LocalTime.of(10, 0), LocalTime.of(14, 0)),
            15
        );
        roboticsWorkshop.setParticipants(List.of("ethan@mergington.edu", "oliver@mergington.edu"));
        activityRepository.save(roboticsWorkshop);
        
        // Science Olympiad
        Activity scienceOlympiad = new Activity(
            "Science Olympiad",
            "Weekend science competition preparation for regional and state events",
            "Saturdays, 1:00 PM - 4:00 PM",
            new ScheduleDetails(List.of("Saturday"), LocalTime.of(13, 0), LocalTime.of(16, 0)),
            18
        );
        scienceOlympiad.setParticipants(List.of("isabella@mergington.edu", "lucas@mergington.edu"));
        activityRepository.save(scienceOlympiad);
        
        // Sunday Chess Tournament
        Activity chessTournament = new Activity(
            "Sunday Chess Tournament",
            "Weekly tournament for serious chess players with rankings",
            "Sundays, 2:00 PM - 5:00 PM",
            new ScheduleDetails(List.of("Sunday"), LocalTime.of(14, 0), LocalTime.of(17, 0)),
            16
        );
        chessTournament.setParticipants(List.of("william@mergington.edu", "jacob@mergington.edu"));
        activityRepository.save(chessTournament);
    }
    
    private void initializeTeachers(TeacherRepository teacherRepository, PasswordEncoder passwordEncoder) {
        Teacher rodriguez = new Teacher(
            "mrodriguez",
            "Ms. Rodriguez",
            passwordEncoder.encode("art123"),
            Teacher.Role.TEACHER
        );
        teacherRepository.save(rodriguez);
        
        Teacher chen = new Teacher(
            "mchen",
            "Mr. Chen",
            passwordEncoder.encode("chess456"),
            Teacher.Role.TEACHER
        );
        teacherRepository.save(chen);
        
        Teacher principal = new Teacher(
            "principal",
            "Principal Martinez",
            passwordEncoder.encode("admin789"),
            Teacher.Role.ADMIN
        );
        teacherRepository.save(principal);
    }
}