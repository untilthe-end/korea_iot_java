/*
    // == 학생 관리 시스템 == //

    model
        1. 필드
            - 학생에 저장되는 변수 필드
            - studentId, name, age, studentNumber, createdAt
        2. 생성자
        3. 메서드
            - Getter(정보를 보여줄 변수 get)
            - Setter(추후에 수정할 변수 set)
            - toString() 오버라이드 | 화면에 뿌려줄 포맷팅
    dto
        1. StudentRequestDto
            - 요청받은 값 변수명 | name, age, studentNumber
            - 생성자
            - 각 필드의 Getter

        2. StudentResponseDto
            - 응답할 때 필요한 변수명 | name, age, studentNumber, createdAt
            - 생성자
            - 응답할 때 화면에 뿌려줄 toString() 포맷팅

    controller
        1. 필드
            - Student 객체 담을 List<Student> studentList 선언
            - int nextId 선언

        3. 생성자
            - nextId = studentList.size() +1 ;

        4. 메서드
            // 실제 비즈니스 로직 = 일처리하는 곳
            - 추가    : public void addStudent(StudentRequestDto dto) {};
            - 전체 조회: public List<StudentResponseDto> getAllStudent() {};
            - 단건 조회: public StudentResponseDto getStudentByNumber(String studentNumber) {};
            - 학생 수정: public boolean updateStudent(StudentRequestDto dto) {};
            - 학생 삭제: public boolean removeStudent(String studentNumber) {};

    view
        1. 필드
            - Scanner | Controller 가져와서 선언

        2. 생성자
        3. 메서드 (지금은 초보 단계여서 반환값이 없는데 심플하게 한것 뿐, 나중에는 있을것 )
            // 화면에 보여주기위해 처리하는 곳
            - public void showMenu() {}
            - 추가    : private void addStudentView() {};
            - 전체 조회: private void showAllStudentsView() {};
            - 단건 조회: private void showStudentByStudentNumber() {};
            - 학생 수정: private void updateStudentView() {};
            - 학생 삭제: private void deleteStudentView() {};
 */