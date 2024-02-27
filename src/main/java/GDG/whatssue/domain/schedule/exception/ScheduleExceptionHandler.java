package GDG.whatssue.domain.schedule.exception;

import GDG.whatssue.domain.schedule.controller.ScheduleController;
import GDG.whatssue.global.error.ErrorResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {ScheduleController.class})
public class ScheduleExceptionHandler {

    @ExceptionHandler(NoScheduleException.class)
    public ResponseEntity<ErrorResult> noScheduleExHandle(NoScheduleException e, HttpServletRequest request) {
        ScheduleErrorCode errorCode = (ScheduleErrorCode) e.getErrorCode();
        ErrorResult errorResult = new ErrorResult(errorCode.name(), errorCode.getMessage(e.getScheduleId()), request.getRequestURI());

        return new ResponseEntity<>(errorResult, errorCode.getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResult> scheduleDateTimePatternExHandle(HttpMessageNotReadableException e, HttpServletRequest request) {
        ScheduleErrorCode errorCode = ScheduleErrorCode.SCHEDULE_DATETIME_PATTERN_ERROR;
        ErrorResult errorResult = new ErrorResult(errorCode.name(), errorCode.getMessage(), request.getRequestURI());

        return new ResponseEntity<>(errorResult, errorCode.getHttpStatus());
    }
}
