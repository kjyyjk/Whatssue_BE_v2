package GDG.whatssue.domain.attendance.Error;

import GDG.whatssue.global.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum AttendanceErrorCode  implements  ErrorCode {

    ATTENDANCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Attendance Not Found","404"),
    ATTENDANCE_ALREADY_ONGOING(HttpStatus.BAD_REQUEST,"The Attendance is Already Ongoing","404"),
    ATTENDANCE_ALREADY_COMPLETED(HttpStatus.BAD_REQUEST,"The Attendance is Already Completed","404"),
    ATTENDANCE_IS_NOT_ONGOING(HttpStatus.BAD_REQUEST,"The Attendance is Not Ongoing","404"),
    NONE_ATTENDANCE_NUM_ERROR(HttpStatus.BAD_REQUEST, "There are no attendance numbers","404");

    private final HttpStatus httpStatus;
    private final String message;
    private final String code;
}
