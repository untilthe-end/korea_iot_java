package org.example.z_project.phr_solution.repository;

import org.example.z_project.phr_solution.entity.HealthRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HealthRecordRepository {

    // 저장 공간
    List<HealthRecord> records = new ArrayList<>();

    // 싱글톤 생성
    private static final HealthRecordRepository instance = new HealthRecordRepository();

    // 외부에서 생성 못하게
    private HealthRecordRepository() {
    }

    public static HealthRecordRepository getInstance() {
        return instance;
    }

    public void save(HealthRecord record) {
        records.add(record);
    }

    public List<HealthRecord> findAll() {
        return new ArrayList<>(records);
    }

    public Optional<HealthRecord> findById(Long id) {
        return records.stream().filter(record -> record.getId().equals(id))
                .findFirst();
    }

    public void delete(HealthRecord record) {
        records.remove(record);
    }
}
