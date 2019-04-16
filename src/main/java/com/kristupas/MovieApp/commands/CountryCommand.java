package com.kristupas.MovieApp.commands;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryCommand {
    private String name;
    private Byte[] icon;
    private Long id;
}
