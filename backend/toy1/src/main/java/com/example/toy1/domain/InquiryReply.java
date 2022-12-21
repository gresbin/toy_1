package com.example.toy1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Inquiry_Replies")
public class InquiryReply {
    @Id
    @GeneratedValue
    @Column(name = "uid")
    private Long uid;

    @Column(name = "content")
    private String content;

    @Column(name = "reg_date")
    @CreatedDate
    private LocalDateTime regDate;

    @Column(name = "up_date")
    @CreatedDate
    private LocalDateTime upDate;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;

}
