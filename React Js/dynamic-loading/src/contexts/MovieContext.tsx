import { createContext, useContext, useState } from "react";
import { MovieContextType, Movie } from "../@types/todo";
import { getMoviesByPage } from "../MoviesAPI";

const movieContext = createContext<MovieContextType | null>(null);

export const MovieState: React.FC<{children: React.ReactNode}> = ({ children }) => {
    const [pageNo, setPageNo] = useState<number>(1)
    const [hasMore, setHasMore] = useState<boolean>(true)
    const [movies, setMovies] = useState<Movie[]>([]);

    const fetchMovies = () => {
        getMoviesByPage(pageNo)
            .then((res) => {
                if(res.data.length > 0) {
                    setMovies(movies.concat(res.data));
                }else {
                    setHasMore(false)
                }
            })
            .catch((error) => { 
                console.log(error);
            });
        setPageNo(pageNo+1)
        console.log(pageNo+1)
    }

    return (
        <movieContext.Provider
            value={{
                hasMore,
                movies,
                fetchMovies
            }}
        >
            { children }
        </movieContext.Provider>
    );
}

export const useMovieContext = (): MovieContextType => {
    return useContext(movieContext) as MovieContextType
}