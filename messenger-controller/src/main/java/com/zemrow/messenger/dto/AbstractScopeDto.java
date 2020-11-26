package com.zemrow.messenger.dto;

import com.zemrow.messenger.enums.OperationIdEnum;
import com.zemrow.messenger.enums.ResponseScopeEnum;

/**
 * DTO (Data Transfer Object) объект для передачи данных
 *
 * @author Alexandr Polyakov on 2020.10.23
 */
public abstract class AbstractScopeDto extends AbstractDto {
    //TODO
    private OperationIdEnum operationId;
    //TODO
    private String requestId;
    /**
     * Уровень рассылки ответа.
     */
    private ResponseScopeEnum scope;
    /**
     * Идентификатор объекта к которому привязан ответ (идентификатор пользователя || идентификатор чата).
     */
    private Long to;

//================================ AUTO GENERATE ==============================


    public AbstractScopeDto() {
    }

    public OperationIdEnum getOperationId() {
        return operationId;
    }

    public void setOperationId(OperationIdEnum operationId) {
        this.operationId = operationId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public ResponseScopeEnum getScope() {
        return scope;
    }

    public void setScope(ResponseScopeEnum scope) {
        this.scope = scope;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}
