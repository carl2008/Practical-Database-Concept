SELECT * FROM movie m WHERE m.movie_name LIKE '%EXTREME JOB%';
SELECT * FROM movie m WHERE m.category LIKE '%comedy%';
SELECT * FROM movie m WHERE m.rated <= 18;
SELECT * FROM movie m WHERE m.movie_name LIKE '%EXTREME JOB%' AND m.category LIKE '%action%';

SELECT * FROM user u WHERE u.username = 'user' AND u.password = '$2a$10$eYZ4G3LZgsZ2mupJc9KK/.38v1LMNHB263caHBpaoI2rnbG3AGsma' AND u.is_active = 1;

SELECT b.seats as number_of_seat, t.time_slot as timeslot, u.username as userName, m.movie_name as movieName
FROM booking b
INNER JOIN timetable t
    ON t.id = b.timetable_id
INNER JOIN user u
    ON u.id = b.user_id
INNER JOIN movie m
    ON m.id = t.movie_id
WHERE b.user_id = 2;

SELECT t.time_slot as timeslot, t.seat_available as available_seats, m.movie_name
FROM timetable t
    INNER JOIN movie m
        ON m.id = t.movie_id;

/*
  UPDATE QUERY
*/
UPDATE movie
SET movie_name = 'Updated movie name'
WHERE movie.id = 1;

UPDATE booking
SET seats = 4
WHERE booking.user_id = 2 AND booking.id = 1;

UPDATE timetable
SET seat_available = 300
WHERE timetable.movie_id = 1 AND timetable.id = 1;

/*
  DELETE QUERY
*/
DELETE FROM booking b WHERE b.id = 1;

DELETE FROM timetable t WHERE t.id = 2;

DELETE timetable, booking, movie
FROM movie
    INNER JOIN timetable
        ON timetable.movie_id = movie.id
    INNER JOIN booking
        ON booking.timetable_id = timetable.id
WHERE movie.id = 1;

DELETE booking, user
FROM user
    INNER JOIN booking
        ON booking.user_id = user.id
WHERE user.id = 2;


