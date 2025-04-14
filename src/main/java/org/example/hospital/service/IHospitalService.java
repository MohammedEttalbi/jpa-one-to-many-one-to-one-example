package org.example.hospital.service;

import org.example.hospital.entities.Consultation;
import org.example.hospital.entities.Medecin;
import org.example.hospital.entities.Patient;
import org.example.hospital.entities.RendezVous;

public interface IHospitalService {
     Patient savePatient(Patient patient);
     Medecin saveMedecin(Medecin medecin);
     RendezVous saveRDV(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);


}
