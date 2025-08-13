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
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ActivityType;
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
                // Clube de Xadrez
                Activity chessClub = new Activity(
                                "Clube de Xadrez",
                                "Aprenda estratégias e participe de torneios de xadrez",
                                "Segundas e sextas-feiras, 15:15 - 16:45",
                                new ScheduleDetails(List.of("Monday", "Friday"), LocalTime.of(15, 15),
                                                LocalTime.of(16, 45)),
                                12,
                                ActivityType.ACADEMIC);
                chessClub.setParticipants(List.of("michael@mergington.edu", "daniel@mergington.edu"));
                mongoTemplate.save(chessClub);

                // Aula de Programação
                Activity programmingClass = new Activity(
                                "Aula de Programação",
                                "Aprenda fundamentos de programação e desenvolva projetos de software",
                                "Terças e quintas-feiras, 07:00 - 08:00",
                                new ScheduleDetails(List.of("Tuesday", "Thursday"), LocalTime.of(7, 0),
                                                LocalTime.of(8, 0)),
                                20,
                                ActivityType.TECHNOLOGY);
                programmingClass.setParticipants(List.of("emma@mergington.edu", "sophia@mergington.edu"));
                mongoTemplate.save(programmingClass);

                // Fitness Matinal
                Activity morningFitness = new Activity(
                                "Fitness Matinal",
                                "Treinamento físico e exercícios matinais",
                                "Segundas, quartas e sextas-feiras, 06:30 - 07:45",
                                new ScheduleDetails(List.of("Monday", "Wednesday", "Friday"), LocalTime.of(6, 30),
                                                LocalTime.of(7, 45)),
                                30,
                                ActivityType.SPORTS);
                morningFitness.setParticipants(List.of("john@mergington.edu", "olivia@mergington.edu"));
                mongoTemplate.save(morningFitness);

                // Time de Futebol
                Activity soccerTeam = new Activity(
                                "Time de Futebol",
                                "Junte-se ao time de futebol da escola e participe de competições",
                                "Terças e quintas-feiras, 15:30 - 17:30",
                                new ScheduleDetails(List.of("Tuesday", "Thursday"), LocalTime.of(15, 30),
                                                LocalTime.of(17, 30)),
                                22,
                                ActivityType.SPORTS);
                soccerTeam.setParticipants(List.of("liam@mergington.edu", "noah@mergington.edu"));
                mongoTemplate.save(soccerTeam);

                // Time de Basquete
                Activity basketballTeam = new Activity(
                                "Time de Basquete",
                                "Pratique e participe de torneios de basquete",
                                "Quartas e sextas-feiras, 15:15 - 17:00",
                                new ScheduleDetails(List.of("Wednesday", "Friday"), LocalTime.of(15, 15),
                                                LocalTime.of(17, 0)),
                                15,
                                ActivityType.SPORTS);
                basketballTeam.setParticipants(List.of("ava@mergington.edu", "mia@mergington.edu"));
                mongoTemplate.save(basketballTeam);

                // Clube de Arte
                Activity artClub = new Activity(
                                "Clube de Arte",
                                "Explore diversas técnicas artísticas e crie obras-primas",
                                "Quintas-feiras, 15:15 - 17:00",
                                new ScheduleDetails(List.of("Thursday"), LocalTime.of(15, 15), LocalTime.of(17, 0)),
                                15,
                                ActivityType.ARTS);
                artClub.setParticipants(List.of("amelia@mergington.edu", "harper@mergington.edu"));
                mongoTemplate.save(artClub);

                // Clube de Teatro
                Activity dramaClub = new Activity(
                                "Clube de Teatro",
                                "Atue, dirija e produza peças e apresentações teatrais",
                                "Segundas e quartas-feiras, 15:30 - 17:30",
                                new ScheduleDetails(List.of("Monday", "Wednesday"), LocalTime.of(15, 30),
                                                LocalTime.of(17, 30)),
                                20,
                                ActivityType.ARTS);
                dramaClub.setParticipants(List.of("ella@mergington.edu", "scarlett@mergington.edu"));
                mongoTemplate.save(dramaClub);

                // Clube de Matemática
                Activity mathClub = new Activity(
                                "Clube de Matemática",
                                "Resolva problemas desafiadores e prepare-se para competições de matemática",
                                "Terças-feiras, 07:15 - 08:00",
                                new ScheduleDetails(List.of("Tuesday"), LocalTime.of(7, 15), LocalTime.of(8, 0)),
                                10,
                                ActivityType.ACADEMIC);
                mathClub.setParticipants(List.of("james@mergington.edu", "benjamin@mergington.edu"));
                mongoTemplate.save(mathClub);

                // Equipe de Debates
                Activity debateTeam = new Activity(
                                "Equipe de Debates",
                                "Desenvolva habilidades de oratória e argumentação",
                                "Sextas-feiras, 15:30 - 17:30",
                                new ScheduleDetails(List.of("Friday"), LocalTime.of(15, 30), LocalTime.of(17, 30)),
                                12,
                                ActivityType.ACADEMIC);
                debateTeam.setParticipants(List.of("charlotte@mergington.edu", "amelia@mergington.edu"));
                mongoTemplate.save(debateTeam);

                // Oficina de Robótica
                Activity roboticsWorkshop = new Activity(
                                "Oficina de Robótica",
                                "Construa e programe robôs em nossa oficina de última geração",
                                "Sábados, 10:00 - 14:00",
                                new ScheduleDetails(List.of("Saturday"), LocalTime.of(10, 0), LocalTime.of(14, 0)),
                                15,
                                ActivityType.TECHNOLOGY);
                roboticsWorkshop.setParticipants(List.of("ethan@mergington.edu", "oliver@mergington.edu"));
                mongoTemplate.save(roboticsWorkshop);

                // Olimpíada de Ciências
                Activity scienceOlympiad = new Activity(
                                "Olimpíada de Ciências",
                                "Preparação para competições científicas regionais e estaduais aos fins de semana",
                                "Sábados, 13:00 - 16:00",
                                new ScheduleDetails(List.of("Saturday"), LocalTime.of(13, 0), LocalTime.of(16, 0)),
                                18,
                                ActivityType.ACADEMIC);
                scienceOlympiad.setParticipants(List.of("isabella@mergington.edu", "lucas@mergington.edu"));
                mongoTemplate.save(scienceOlympiad);

                // Torneio de Xadrez
                Activity chessTournament = new Activity(
                                "Torneio de Xadrez",
                                "Torneio semanal para jogadores sérios de xadrez com classificações",
                                "Domingos, 14:00 - 17:00",
                                new ScheduleDetails(List.of("Sunday"), LocalTime.of(14, 0), LocalTime.of(17, 0)),
                                16,
                                ActivityType.ACADEMIC);
                chessTournament.setParticipants(List.of("william@mergington.edu", "jacob@mergington.edu"));
                mongoTemplate.save(chessTournament);

                // Serviço Comunitário
                Activity communityService = new Activity(
                                "Serviço Comunitário",
                                "Seja voluntário em projetos da comunidade local e ajude quem precisa",
                                "Sábados, 09:00 - 12:00",
                                new ScheduleDetails(List.of("Saturday"), LocalTime.of(9, 0), LocalTime.of(12, 0)),
                                25,
                                ActivityType.COMMUNITY);
                communityService.setParticipants(List.of("grace@mergington.edu", "aiden@mergington.edu"));
                mongoTemplate.save(communityService);
        }

        private void seedTeachers() {
                // Get passwords from environment variables or use secure defaults
                String rodriguezPassword = environment.getProperty("TEACHER_RODRIGUEZ_PASSWORD", "art123");
                String chenPassword = environment.getProperty("TEACHER_CHEN_PASSWORD", "chess123");
                String principalPassword = environment.getProperty("PRINCIPAL_PASSWORD", "admin123");

                // Create Rodriguez teacher
                Teacher rodriguez = new Teacher(
                                "mrodriguez",
                                "Sr. Rodriguez",
                                passwordEncoder.encode(rodriguezPassword),
                                Teacher.Role.TEACHER);
                mongoTemplate.save(rodriguez);

                // Create Chen teacher
                Teacher chen = new Teacher(
                                "mchen",
                                "Sra. Chen",
                                passwordEncoder.encode(chenPassword),
                                Teacher.Role.TEACHER);
                mongoTemplate.save(chen);

                // Create Principal
                Teacher principal = new Teacher(
                                "principal",
                                "Diretor Martinez",
                                passwordEncoder.encode(principalPassword),
                                Teacher.Role.ADMIN);
                mongoTemplate.save(principal);
        }

        @RollbackExecution
        public void rollback() {
                // Remove all seeded activities
                mongoTemplate.remove(new Query(Criteria.where("name").in(
                                "Clube de Xadrez", "Aula de Programação", "Fitness Matinal", "Time de Futebol",
                                "Time de Basquete", "Clube de Arte", "Clube de Teatro", "Clube de Matemática",
                                "Equipe de Debates", "Oficina de Robótica", "Olimpíada de Ciências",
                                "Torneio de Xadrez", "Serviço Comunitário")), Activity.class);

                // Remove all seeded teachers
                mongoTemplate.remove(new Query(Criteria.where("_id").in("admin", "mrodriguez", "mchen", "principal")),
                                Teacher.class);
        }
}
