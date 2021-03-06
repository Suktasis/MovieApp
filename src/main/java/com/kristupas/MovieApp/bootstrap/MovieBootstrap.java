package com.kristupas.MovieApp.bootstrap;

import com.kristupas.MovieApp.models.*;
import com.kristupas.MovieApp.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

/**H2 does not persist data by default, so all entities are gone ones program is finished
  BootsTrap Class creates necessary objects each time program runs
  Spring automatically manages class as bean via @Component annotation  **/

@Component
public class MovieBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CountryRepository countryRepository;
    private HumanRepository humanRepository;
    private MovieRepository movieRepository;

    public MovieBootstrap(CountryRepository countryRepository,
                          HumanRepository humanRepository,
                          MovieRepository movieRepository) {
        this.countryRepository = countryRepository;
        this.humanRepository = humanRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        movieRepository.saveAll(getMovies());
    }

    private List<Movie> getMovies(){


        List<Movie> movies = new ArrayList<>();


        Optional<Country> country1Optional = countryRepository.findByName("UK");
        Optional<Country> country2Optional = countryRepository.findByName("USA");

        if(!country1Optional.isPresent() || !country2Optional.isPresent())
            throw new RuntimeException("NO such entity");

        Country country1 = country1Optional.get();
        Country country2 = country2Optional.get();


        Person actor1 = new Person();
        actor1.setName("Joseph");
        actor1.setDateOfBirth(new Date());

        Person actor2 = new Person();
        actor2.setName("Alfred");
        actor2.setDateOfBirth(new Date());

        Person actor3 = new Person();
        actor3.setName("Kelly");
        actor3.setDateOfBirth(new Date());

        Description description1 = new Description();
        description1.setSlogan("Your mind is crime place");
        description1.setSynopsis("Inception is a 2010 science fiction action film[3] written, co-produced, and directed by Christopher Nolan, and co-produced by Emma Thomas. The film stars Leonardo DiCaprio as a professional thief who steals information by infiltrating the subconscious, and is offered a chance to have his criminal history erased as payment for the implantation of another person's idea into a target's subconscious.[4] The ensemble cast additionally includes Ken Watanabe, Joseph Gordon-Levitt, Marion Cotillard, Ellen Page, Tom Hardy, Dileep Rao, Cillian Murphy, Tom Berenger, and Michael Caine.\n" +
                "\n" +
                "After the 2002 completion of Insomnia, Nolan presented to Warner Bros. a written 80-page treatment about a horror film envisioning \"dream stealers\" based on lucid dreaming.[5] Deciding he needed more experience before tackling a production of this magnitude and complexity, Nolan retired the project and instead worked on 2005's Batman Begins, 2006's The Prestige, and The Dark Knight in 2008.[6] The treatment was revised over 6 months and was purchased by Warner in February 2009.[7] Inception was filmed in six countries, beginning in Tokyo on June 19 and ending in Canada on November 22.[8] Its official budget was US$160 million, split between Warner Bros and Legendary.[9] Nolan's reputation and success with The Dark Knight helped secure the film's US$100 million in advertising expenditure.\n" +
                "\n" +
                "Inception's première was held in London on July 8, 2010; it was released in both conventional and IMAX theaters beginning on July 16, 2010.[10][11] Inception grossed over US$828 million worldwide, becoming the fourth highest-grossing film of 2010.[3] The home video market also had strong results, with US$68 million in DVD and Blu-ray sales. Inception opened to acclaim from critics, who praised its screenplay, visual effects, score, and ensemble cast.[12] It won four Academy Awards for Best Cinematography, Best Sound Editing, Best Sound Mixing, and Best Visual Effects, and was nominated for four more: Best Picture, Best Original Screenplay, Best Art Direction, and Best Original Score. ");

        Description description2 = new Description();
        description2.setSlogan("The most frightening thing about Jacob Singer's nightmare is that he isn't dreaming");
        description2.setSynopsis("Jacob's Ladder is a 1990 American psychological horror film directed by Adrian Lyne, produced by Alan Marshall, written by Bruce Joel Rubin and starring Tim Robbins, Elizabeth Peña, and Danny Aiello. The film's protagonist, Jacob, is a Vietnam veteran whose experiences prior to and during the war result in strange, fragmentary visions and bizarre hallucinations that continue to haunt him. As his ordeal worsens, Jacob desperately attempts to figure out the truth.\n" +
                "\n" +
                "Jacob's Ladder was made by Carolco Pictures ten years after being written by Rubin. It drew from several inspirations for its story and effects, including the short film An Occurrence at Owl Creek Bridge and the paintings of Francis Bacon. Though only moderately successful upon release, the film garnered a cult following and its plot and special effects became a source of influence for various other works such as the horror video game franchise Silent Hill. A remake, also titled Jacob's Ladder, is currently in production for a planned 2019 release. ");


        Movie movie1 = new Movie();
        Movie movie2 = new Movie();



        movie1.setAge(Age.PG);
        movie1.setLength(148);
        movie1.setRelease(new Date());
        movie1.setName("Inception");
        movie1.setDescription(description1);
        movie1.setRating(8.6);
        movie1.setUrl("http://www.kinopoisk.ru/film/447301/");
        movie1.addCountry(country1);

        movie2.setAge(Age.R);
        movie2.setLength(113);
        movie2.setRelease(new Date());
        movie2.setName("Jacobs Ladder");
        movie2.setDescription(description2);
        movie2.setRating(7.5);
        movie2.setUrl("http://www.kinopoisk.ru/film/7355/");
        movie2.addCountry(country2);

        movie1.addHuman(actor1);
        movie1.addHuman(actor2);
        movie2.addHuman(actor3);

        movies.add(movie1);
        movies.add(movie2);


        return movies;
    }
}
