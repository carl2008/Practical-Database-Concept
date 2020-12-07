package com.rmit.Practical_Database_Concept.timetable.entity;

import javax.persistence.*;

@Entity
@Table(name = "timetable")
public class Timetable {
    // Properties of Timetable entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time_slot")
    private int timeslot;

    @Column
    private int seat_available;

//    @Column
//    private int movie_id;

    public Timetable(int id, int timeslot, int seat_available) {
        this.id = id;
        this.timeslot = timeslot;
        this.seat_available = seat_available;
    }

    public int getId() {
        return id;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public int getSeat_available() {
        return seat_available;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

    public void setSeat_available(int seat_available) {
        this.seat_available = seat_available;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", timeslot=" + timeslot +
                ", seat_available=" + seat_available +
                '}';
    }
}
