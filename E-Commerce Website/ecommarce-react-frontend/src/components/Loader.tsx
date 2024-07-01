import { useGlobalContext } from "../contexts/GlobalProvider"
import LoaderImg from '../assets/loading.gif';

const Loader = () => {
    const { loading } = useGlobalContext()

    return (
        <div className='loader-container' style={loading?{display:'flex', position:'absolute'}:{display: 'none'}}>
            <img src={LoaderImg} style={{width: 150, height: 150}} />
        </div>
    )
}

export default Loader