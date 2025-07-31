package dio.web.api.handler;

import java.util.Objects;

public class BusinessException extends RuntimeException{
    public BusinessException(String mensagem){
        super(mensagem);
    }
    public BusinessException(String mensagem, Objects ... params){
        super(String.format(mensagem, (Object) params));
    }
}
