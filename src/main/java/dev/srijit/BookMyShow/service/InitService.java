package dev.srijit.BookMyShow.service;

import dev.srijit.BookMyShow.model.Auditorium;
import dev.srijit.BookMyShow.model.City;
import dev.srijit.BookMyShow.model.Seat;
import dev.srijit.BookMyShow.model.Theatre;
import dev.srijit.BookMyShow.model.constant.AuditoriumFeature;
import dev.srijit.BookMyShow.model.constant.SeatStatus;
import dev.srijit.BookMyShow.model.constant.SeatType;
import dev.srijit.BookMyShow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;

    public boolean initialise(){
        City delhi = new City("Delhi");
        City bangalore = new City("Bangalore");
        City canberra = new City("Canberra");

        cityRepository.save(delhi);
        cityRepository.save(bangalore);
        cityRepository.save(canberra);

        City savedDelhi = cityRepository.findCityByName("Delhi");
        Theatre ashishTheatre = new Theatre("AshishMultiplex", "CP, Delhi");
        Theatre nithinTheatre = new Theatre("NithinIMAX", "Munirka, Delhi");

        theatreRepository.save(ashishTheatre);
        theatreRepository.save(nithinTheatre);

        Theatre savedAshishTheatre = theatreRepository.findTheatreByName("AshishMultiplex");
        Theatre savedNithinTheatre = theatreRepository.findTheatreByName("NithinIMAX");

        List<Theatre> delhiTheatres = new ArrayList<>();
        delhiTheatres.add(savedAshishTheatre);
        delhiTheatres.add(savedNithinTheatre);
        savedDelhi.setTheatres(delhiTheatres);
        cityRepository.save(savedDelhi);

        for(int i=1;i<=5;i++){
            Seat s = new Seat(i,i,i+" "+i,SeatType.GOLD, SeatStatus.AVAILABLE);
            seatRepository.save(s);
        }

        List<Seat> savedSeats = seatRepository.findAll(); //returns all the data of the table, "select * from table"

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi01");
        auditorium.setCapacity(5);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY, AuditoriumFeature.IMAX));
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);

        savedAshishTheatre.setAuditoriums(List.of(auditoriumRepository.findAuditoriumByName("Audi01")));
        theatreRepository.save(savedAshishTheatre);

        return true;
    }
}

/*
    Theatre Audi mapping not present
 */
