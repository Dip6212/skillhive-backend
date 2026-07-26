package com.edtech.modules.hero.entity;

import com.edtech.modules.media.entity.Media;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "heroes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String subtitle;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "primary_button_text")
    private String primaryButtonText;

    @Column(name = "primary_button_link")
    private String primaryButtonLink;

    @Column(name = "secondary_button_text")
    private String secondaryButtonText;

    @Column(name = "secondary_button_link")
    private String secondaryButtonLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hero_image_media_id")
    private Media heroImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "background_image_media_id")
    private Media backgroundImage;

    @Column(name = "is_active")
    @Builder.Default
    private Boolean isActive = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}