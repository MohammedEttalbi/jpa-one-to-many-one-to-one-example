package org.example.hospital;

import org.example.hospital.entities.*;
import org.example.hospital.repositories.ConsultationRepository;
import org.example.hospital.repositories.MedecinRepository;
import org.example.hospital.repositories.PatientRepository;
import org.example.hospital.repositories.RendezVousRepository;
import org.example.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean //inteface qui contient la methode run
    CommandLineRunner satrt(IHospitalService hospitalService , PatientRepository patientRepository, MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository/*injection de depandaces par spring*/){
        return args -> {
            //un code qui s'execute au demmarage
            //patientRepository.save(new Patient(null,"Mohammed",new Date(),false,null));
            Stream.of("Mohammed","Hassan","Ali")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("MedMohammed","MedHassan","MedAli")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@mail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohammed");

            Medecin medecin = medecinRepository.findByNom("MedMohammed");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setMedecin(medecin);
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            RendezVous saveRDV = hospitalService.saveRDV(rendezVous);
            System.out.println(saveRDV.getId());


            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation ...");
            hospitalService.saveConsultation(consultation);



        };
    }

}
