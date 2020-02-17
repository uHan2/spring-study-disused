package kr.co.first.gotoeat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Review
{
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    String name;

    @Min(0)
    @Max(5)
    int score;

    @NotEmpty
    private String description;

}
