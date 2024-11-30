package org.lab2.lab2springboot.place.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.annotations.ColumnDefault;
import org.lab2.lab2springboot.category.entity.Category;

import java.security.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "place", schema = "mydatabase")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate = false;


    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private String userId;


    @Column(name = "coordinates", columnDefinition = "geometry not null")
    private Point<G2D> coordinates;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public void setCoordinates(Point<G2D> geo) {
        this.coordinates = geo;
    }

    public Point<G2D> getCoordinates() {
        return coordinates;
    }

    @PrePersist
    public void prePersist() {
        Instant currentTime = Instant.now();
        this.createdAt = currentTime;
        this.updatedAt = currentTime;
    }


    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now();
    }
}