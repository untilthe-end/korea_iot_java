package org.example.z_project.phr_solution.service.impl;

import org.example.z_project.phr_solution.dto.health_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.health_record.response.RecordListResponseDto;
import org.example.z_project.phr_solution.entity.HealthRecord;
import org.example.z_project.phr_solution.entity.Patient;
import org.example.z_project.phr_solution.repository.HealthRecordRepository;
import org.example.z_project.phr_solution.repository.PatientRepository;
import org.example.z_project.phr_solution.service.HealthRecordService;
import org.example.z_project.phr_solution.util.DateValidator;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HealthRecordServiceImpl implements HealthRecordService {
    private final HealthRecordRepository recordRepository;
    private final PatientRepository patientRepository;

    private static long currentId = 1;

    public HealthRecordServiceImpl() {
        this.recordRepository = HealthRecordRepository.getInstance();
        this.patientRepository = PatientRepository.getInstance();
    }

    private Long generatedRecordId() {
        return currentId++;
    }

    // 환자 고유 ID 유효성 입증
    private void validatePatientId(Long patientId) {
        // 환자 존재 여부 확인
        Optional<Patient> foundPatient = patientRepository.findById(patientId);

        if (foundPatient.isEmpty()) {
            throw new IllegalArgumentException("해당 Id의 환자를 찾을 수 없습니다. " + patientId);
        }
    }

    @Override
    public void createRecord(RecordCreateRequestDto dto) {
        try {
            validatePatientId(dto.getPatientId());

            // 날짜 형식 유효성 검사
            DateValidator.validateOrThrow(dto.getDateOfVisit());

            HealthRecord record = new HealthRecord(generatedRecordId(), dto.getPatientId(),
                    dto.getDateOfVisit(), dto.getDiagnosis(), dto.getTreatment());

            recordRepository.save(record);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<RecordListResponseDto> getAllRecords() {
        List<RecordListResponseDto> dtos = null;

        try {
            List<HealthRecord> records = recordRepository.findAll();

            dtos = records.stream()
                    .map(record -> new RecordListResponseDto(
                            record.getId(), record.getPatientId(), record.getDateOfVisit(),
                            record.getDiagnosis(), record.getTreatment(), new Date()
                    ))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dtos;
    }

    @Override
    public List<RecordListResponseDto> filterRecordsByDiagnosis(String diagnosis) {
        List<RecordListResponseDto> dtos = null;

        try {
            List<HealthRecord> records = recordRepository.findAll();

            dtos = records.stream()
                    .filter(record -> record.getDiagnosis().contains(diagnosis))
                    .map(record -> new RecordListResponseDto(
                        record.getId(), record.getPatientId(), record.getDateOfVisit(), record.getDiagnosis(),
                            record.getTreatment(), new Date()
                    ))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public void deleteRecord(Long id) {
        try {
            HealthRecord record = recordRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 ID의 건강 기록이 존재하지 않습니다."));

            recordRepository.delete(record);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



















}
