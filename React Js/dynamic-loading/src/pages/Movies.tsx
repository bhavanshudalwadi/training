import { useEffect } from "react";
import InfiniteScroll from "react-infinite-scroll-component";
import Loader from "../components/Loader";
import { useMovieContext } from "../contexts/MovieContext";
import MovieCard from "../components/MovieCard";

const Movies = () => {
  const { movies, fetchMovies, hasMore } = useMovieContext();

  useEffect(() => {
    fetchMovies();
  }, []);

  return (
    <div className="container" style={{marginTop: 90}}>
        <InfiniteScroll
            style={{overflowX: 'hidden'}}
            className="d-flex flex-column align-items-center"
            dataLength={movies.length}
            next={fetchMovies}
            hasMore={hasMore}
            loader={<Loader />}
            endMessage={<h2>Yay! You have seen it all</h2>}
        >
        <div className="row">
            {movies != undefined && movies.length > 0 && movies.map((movie, index) => (
                <MovieCard key={index} {...movie} />
            ))}
        </div>
        </InfiniteScroll>
    </div>
  )
}

export default Movies
