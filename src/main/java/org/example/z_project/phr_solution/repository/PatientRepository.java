package org.example.z_project.phr_solution.repository;

import org.example.z_project.phr_solution.entity.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientRepository {

    List<Patient> patients = new ArrayList<>();
    private static final PatientRepository INSTANCE = new PatientRepository();

    private PatientRepository() {}

    public static PatientRepository getInstance() {
        return INSTANCE;
    }

    public void save(Patient patient) {
        // 생성(Create), 수정(Update)가 같은 save 메서드를 사용
        // springboot는 pk 값 찾는데, 지금 없으니 하드코딩
        Optional<Patient> existing = findById(patient.getId());
        existing.ifPresent(value->this.delete(value));
        //existing.ifPresent(this::delete); // 전달받은 환자의 id가 이미 존재하는 경우 삭제
        patients.add(patient); // 새로운 데이터 추가
    }

    public List<Patient> findAll() {
        return new ArrayList<>(patients); // 방어적 복사 // 읽기 전용
    }

    public Optional<Patient> findById(Long id) {
        return patients.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }

    public void delete(Patient patient) {
        patients.remove(patient); // id는 service 에서 이미 검증해놨음.
    }
}
