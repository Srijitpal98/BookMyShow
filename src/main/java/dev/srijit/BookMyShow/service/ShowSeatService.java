package dev.srijit.BookMyShow.service;

import dev.srijit.BookMyShow.model.ShowSeat;
import dev.srijit.BookMyShow.model.constant.ShowSeatStatus;
import dev.srijit.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeat(int showSeatId) {
        return showSeatRepository.findById(showSeatId).get();
    }

    public ShowSeat saveShowSeat(ShowSeat seat) {
        return showSeatRepository.save(seat); // save() -> upsert, means insert and update both
    }
}
