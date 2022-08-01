package jjfactory.pay.biz.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseTimeEntity {
    @CreatedDate
    LocalDateTime createDate;
    @LastModifiedDate
    LocalDateTime modifyDate;
    LocalDateTime deleteDate;

    @Enumerated(EnumType.STRING)
    private DeleteStatus deleteStatus = DeleteStatus.N;

    public void delete() {
        this.deleteStatus = DeleteStatus.Y;
        this.deleteDate = LocalDateTime.now();
    }
}
