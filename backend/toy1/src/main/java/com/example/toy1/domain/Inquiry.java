package com.example.toy1.domain;

import com.example.toy1.domain.enums.InquiryTag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Inquiries")
public class Inquiry {
    @Id
    @GeneratedValue
    @Column(name = "uid")
    private Long uid;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "reg_date")
    @CreatedDate
    private LocalDateTime regDate;

    @Column(name = "up_date")
    @CreatedDate
    private LocalDateTime upDate;

    @Column(name = "tag")
    private InquiryTag tag;

    @ManyToOne(targetEntity = User.class ,fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;

}
