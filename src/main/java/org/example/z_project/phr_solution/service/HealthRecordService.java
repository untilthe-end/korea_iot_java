package org.example.z_project.phr_solution.service;

import org.example.z_project.phr_solution.dto.health_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.health_record.response.RecordListResponseDto;

import java.util.List;

public interface HealthRecordService {
    void createRecord(RecordCreateRequestDto dto);
    List<RecordListResponseDto> getAllRecords();

    List<RecordListResponseDto> filterRecordsByDiagnosis(String diagnosis);

    void deleteRecord(Long id);
}
