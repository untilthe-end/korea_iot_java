package org.example.user_reservation.service;

import org.example.user_reservation.dto.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    // 예약 등록
    void createReservation(String userId);

    // 조회
    List<ReservationResponseDto> getReservationByUserId(String userId);

    // 취소
    void cancelReservation(Long reservationId);
}
