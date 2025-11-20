import com.example.chapter4.global.apiPayload.exception.GeneralException; // GeneralException 임포트
import com.example.chapter4.global.apiPayload.code.BaseErrorCode; // BaseErrorCode 임포트



public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }
}