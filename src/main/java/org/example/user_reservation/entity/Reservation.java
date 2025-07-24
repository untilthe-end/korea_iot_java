package org.example.user_reservation.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

// final 또는 @NonNull인 필드만 생성자의 매개변수로 작성
@RequiredArgsConstructor
@Getter
public class Reservation {
    private final Long reservationId; // 각 예약의 고유값
    private final String userId; // 예약자 정보
    private final Date reservationTime;

    // 활성화 유무를 저장
    // : 해당 예약의 활성화 상태를 저장
    // - true: 예약 완료 (중)
    // - false: 예약 취소
    private boolean isActive = true;

    // 예약 취소 메서드
    public void cancel() {
        isActive = false;
    }

    @Override
    public String toString() {
        String isActiveMessage = isActive ? "예약중" : "예약취소";
        return "[예약 Id: " + reservationId + ", 예약자 Id: " + userId +", 예약 일자: " +
                reservationTime + ", 예약 상태: " + isActiveMessage;
    }
}
