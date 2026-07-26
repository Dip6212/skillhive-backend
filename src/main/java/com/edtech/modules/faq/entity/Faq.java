package com.edtech.modules.faq.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "faqs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String question;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String answer;

    @Builder.Default
    @Column(name="display_order")
    private Integer displayOrder = 0;

    @Builder.Default
    @Column(name="is_active")
    private Boolean isActive = true;

    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    void onUpdate(){
        updatedAt = LocalDateTime.now();
    }

}