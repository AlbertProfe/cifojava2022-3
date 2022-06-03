package io.company.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="Play")
@Table(name="PLAY_TABLE")
public class Play extends  Work{

    @Column(name="TIMES_PLAYED")
    private int timesPlayed;
    @Column(name="RELEASE_THEATRE")
    private String releaseTheatre;

}
