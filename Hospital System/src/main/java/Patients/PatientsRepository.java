package Patients;

import org.springframework.data.jpa.repository.JpaRepository;


interface PatientsRepository extends JpaRepository<Patient, Integer> {

}

