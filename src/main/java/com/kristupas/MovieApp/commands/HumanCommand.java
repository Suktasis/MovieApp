package com.kristupas.MovieApp.commands;

import com.kristupas.MovieApp.models.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class HumanCommand {
    private String name;
    private Long id;
    private Date dateOfBirth;
    private Country country;
    private Byte[] preview;
}
