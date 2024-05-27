package GDG.whatssue.domain.post.exception;

import GDG.whatssue.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostErrorCode implements ErrorCode {

    EX7100("7100", HttpStatus.NOT_FOUND, "존재하지 않는 게시물입니다.");

    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}
