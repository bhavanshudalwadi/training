import loaderImg from "../assets/loading.gif";
// import { useGlobalContext } from "../contexts/GlobalContext";

const Loader = () => {
    // const { loading, setLoading } = useGlobalContext();

    return (
        <img
            width="100"
            height="100"
            src={loaderImg}
            alt="Loading..."
            style={{color: "#fff", zIndex: 1400}}
        />
    );
};

export default Loader;