import { memo, useEffect } from "react";
import { useGlobalContext } from "../contexts/GlobalContext"

const Navbar = ({ title, onChangeTitle } : any) => {

    const { themeColor, setThemeColor } = useGlobalContext()

    console.log("Navbar Rended")

    useEffect(() => {
        onChangeTitle("New Title")
    }, [])

    return (
        <nav className={`navbar navbar-expand-lg bg-${themeColor}`}>
            <div className="container-fluid">
                <a className="navbar-brand" href="#">{title}</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <button className="nav-link" onClick={() => setThemeColor("primary-subtle")}><span className="badge rounded-pill bg-primary">Primary Subtle</span></button>
                        </li>
                        <li className="nav-item">
                            <button className="nav-link" onClick={() => setThemeColor("success-subtle")}><span className="badge rounded-pill bg-success">Success Subtle</span></button>
                        </li>
                        <li className="nav-item">
                            <button className="nav-link" onClick={() => setThemeColor("danger-subtle")}><span className="badge rounded-pill bg-danger">Danger Subtle</span></button>
                        </li>
                        <li className="nav-item">
                            <button className="nav-link" onClick={() => setThemeColor("warning-subtle")}><span className="badge rounded-pill bg-warning">Warning Subtle</span></button>
                        </li>
                        <li className="nav-item">
                            <button className="nav-link" onClick={() => setThemeColor("info-subtle")}><span className="badge rounded-pill bg-info">Info Subtle</span></button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}

export default memo(Navbar)