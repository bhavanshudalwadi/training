const movies = [
    { id: 1, name: "Movie 1", availableSeats: 100 },
    { id: 2, name: "Movie 2", availableSeats: 50 },
    { id: 3, name: "Movie 3", availableSeats: 75 }
];

const bookings = [];

function bookTicket(movieId, seats) {
    const movie = movies.find(movie => movie.id === movieId);
    if (!movie) {
        console.log("Invalid movie ID.");
        return;
    }

    if (seats > movie.availableSeats) {
        console.log("Not enough seats available.");
        return;
    }

    movie.availableSeats -= seats;
    bookings.push({ movieId, seats });

    console.log(`Successfully booked ${seats} seat(s) for ${movie.name}.`);
}

function cancelBooking(bookingIndex) {
    if (bookingIndex < 0 || bookingIndex >= bookings.length) {
        console.log("Invalid booking index.");
        return;
    }

    const booking = bookings[bookingIndex];
    const movie = movies.find(movie => movie.id === booking.movieId);
    movie.availableSeats += booking.seats;

    bookings.splice(bookingIndex, 1);

    console.log("Successfully cancelled the booking.");
}

bookTicket(2, 2);
console.log(movies);
console.log(bookings);

cancelBooking(0);
console.log(movies);
console.log(bookings);
