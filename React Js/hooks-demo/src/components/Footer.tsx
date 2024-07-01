import { memo } from "react";
import { useGlobalContext } from "../contexts/GlobalContext";

const Footer = () => {
    const { themeColor } = useGlobalContext();

    return (
        <div className={`bg-${themeColor}`}>
            <div className="container">
                <footer className="d-flex flex-wrap justify-content-between align-items-center py-3 my-4">
                    <div className="col-md-4 d-flex align-items-center">
                        <a href="/" className="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
                            <i className="bi bi-twitter-x"></i>
                        </a>
                        <span className="mb-3 mb-md-0 text-muted">© 2024 Bootstrap, Inc</span>
                    </div>
                    <ul className="nav col-md-4 justify-content-end list-unstyled d-flex">
                        <li className="ms-3"><a className="text-muted" href="#"><i className="bi bi-twitter-x"></i></a></li>
                        <li className="ms-3"><a className="text-muted" href="#"><i className="bi bi-instagram"></i></a></li>
                        <li className="ms-3"><a className="text-muted" href="#"><i className="bi bi-facebook"></i></a></li>
                    </ul>
                </footer>
            </div>
        </div>
    )
}

export default memo(Footer)
