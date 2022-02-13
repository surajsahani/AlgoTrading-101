package com.hackerearth.pluang.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Stock {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @JsonProperty("Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yy")
    private LocalDate date;
    @JsonProperty("Open")
    private Double open;
    @JsonProperty("High")
    private Double high;
    @JsonProperty("Low")
    private Double low;
    @JsonProperty("Close")
    private Double close;
    @JsonProperty("Volume")
    private Long volume;

}
