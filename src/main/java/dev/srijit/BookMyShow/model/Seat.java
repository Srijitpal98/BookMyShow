package dev.srijit.BookMyShow.model;

import dev.srijit.BookMyShow.model.constant.SeatStatus;
import dev.srijit.BookMyShow.model.constant.SeatType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    @Column(name = "seatrow")
    private int row;
    @Column(name = "seatcol")
    private int col;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;
}

/*
    SELECT * FROM SEAT WHERE ROW = ? AND COL = ? AND SEATNUMBER IS NOT ?

    findSeatByRowAndColNotSeatNumber(int row, int col, String seatNumber);
 */
