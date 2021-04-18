package enset.sping.tp2;

import enset.sping.tp2.entites.Patient;
import enset.sping.tp2.entites.User;
import enset.sping.tp2.repository.PatientRepository;
import enset.sping.tp2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public Tp2Application(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    private PatientRepository patientRep;
    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRep.save(new Patient(null,"amine maslah ",new Date(),2300,true));
        patientRep.save(new Patient(null,"ayoub",new Date(),2500,false));
        patientRep.save(new Patient(null,"yassine",new Date(),1000,true));
        patientRep.save(new Patient(null,"omayma",new Date(),2300,false));
        patientRep.save(new Patient(null,"hamza",new Date(),1000,true));
        patientRep.save(new Patient(null,"zohra",new Date(),2300,false));
        patientRep.save(new Patient(null,"sofiane",new Date(),2500,false));
        patientRep.save(new Patient(null,"zakaria",new Date(),1000,true));
        patientRep.save(new Patient(null,"ilham",new Date(),2500,false));


        patientRep.findAll().forEach(p->{
            System.out.println(p.toString());
        });



        this.userRepository.deleteAll();


        User user1 = new User("user1",passwordEncoder.encode("12345"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("12345"),"ADMIN,USER","");
        User user2 = new User("user2",passwordEncoder.encode("12345"),"USER","");

        List<User> users = Arrays.asList(user1,admin,user2);


        this.userRepository.saveAll(users);

    }
}
