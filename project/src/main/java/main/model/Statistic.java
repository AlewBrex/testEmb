package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "statistics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistic
{
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Column(name = "count_car", nullable = false, columnDefinition = "INTEGER")
    private Integer countCar;

    @Column(name = "first_add", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime firstAdd;

    @Column(name = "second_add", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime secondAdd;
}