import { Movie } from "../@types/todo"
import './MovieCard.css'

const MovieCard = ({ Poster_Link, Series_Title, Released_Year, Certificate, Runtime, Genre, IMDB_Rating, Overview, Meta_score, Director, Star1, Star2, Star3, Star4, No_of_Votes, Gross}: Movie) => {
  return (
    <div className="col-xxl-2 col-xl-2 col-lg-3 col-md-4 col-sm-6 col-xs-6 mb-2">
      <div className="card rounded-4 movie-card">
        <div>
            <img src={Poster_Link} className="card-img-top rounded-top-4" style={{minHeight: 246}} />
            <span className="position-absolute badge rounded-pill bg-dark" style={{top: 10, right: 10}}>
                {Runtime}
            </span>
            <span className="position-absolute badge rounded-pill bg-danger" style={{top: 10, left: 10}}>
                {Certificate}
            </span>
        </div>
        <div className="card-body">
            <h5 className="two">{Series_Title}</h5>
            <p>
                <img
                    width={20}
                    height={20}
                    className="rounded me-2"
                    src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAABpUlEQVQoz41SPWsUYRiceXdvN3t38VAs/AhcCg9BiI1FRJTY2ATyCxQ7GxsRf4KdpUUwhSgEC1OmE5PCThTxm0QRFESFQEyOrN7u+z7P+1hcYZkdpphmmIEZbq4fLbopDPuDGJWSZnnancwt7u+gowakEhC8WYME0iQgVYEGNDNABU4EMdKRZkzIqEhIgAmZkDCa0ZEiGDO1yI+bfnVt79L5zur63vUrB+892j13pnj1vhK1udl21uLLt9Wta4dGlUmAM8WPX7K4vPPlm3+wMnzy7M/9x7sbn/3i8k5Zxss3fn745O8sbd+8vfVuo6bRicAiAMAI4O7D38UEx6WnpzIAwdvMyfzFm9Hz1yOLcBpMFQAk2Pxcd2tbT53IowJAFACICkcWOR0oAakIJBiA2tv08RaAQT+vawPw9bsHECPKvxGA96ZiydWFXlBmLc4MJtq56x/Lzp4uOm135HCLxPyFyUE/Sxw7hVu4eCBLwKdLU71enjhoBAnH/wKAATEicQChiuGwTjXA19Z0uPHSEtAQKkhVqMKG31BhWpZBBE06kayq8A/tluDm21lpHwAAAABJRU5ErkJggg=="
                /> {IMDB_Rating}/10, ({No_of_Votes})</p>
            <p><b>Released Year:</b> {Released_Year}</p>
            <p className="two"><b>Genre:</b> {Genre}</p>
            <p className="three"><b>Overview:</b> {Overview}</p>
            <p className="two"><b>Director:</b> {Director}</p>
            <p className="three"><b>Casts:</b> {Star1}, {Star2}, {Star3}, {Star4}</p>
        </div>
      </div>
    </div>
  )
}

export default MovieCard
