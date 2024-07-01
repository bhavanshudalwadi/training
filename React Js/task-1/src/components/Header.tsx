import { useEffect } from "react"
import { Link } from "react-router-dom"


const links = [
    {
        'title': 'Home',
        'url': '/',
        'theme': 'bg-warning-subtle'
    },
    {
        'title': 'About',
        'url': '/about',
        'theme': 'bg-success-subtle'
    },
    {
        'title': 'Contact Us',
        'url': '/contact-us',
        'theme': 'bg-primary-subtle'
    }
]

const Header = ({ title, setTitle, theme, setTheme }: any) => {

    useEffect(() => {
        setTitle("Bhavanshu Dalwadi")
    }, [])

    return (
        <nav className={`navbar fixed-top ${theme}`}>
            <div className="container justify-content-start">
                <button className="navbar-toggler box-shadow shadow-sm" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <Link className="navbar-brand ms-3 text-danger-emphasis" to="/" onClick={() => setTheme("bg-warning-subtle")}>{title}</Link>
                <div className="offcanvas offcanvas-start" tabIndex={-1} id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                    <div className="offcanvas-header">
                        <h5 className="offcanvas-title" id="offcanvasNavbarLabel">{title}</h5>
                        <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div className="offcanvas-body">
                        <ul className="navbar-nav justify-content-end flex-grow-1 pe-3">
                            {links.map((link, index) => 
                                <li className="nav-item" key={index} data-bs-dismiss="offcanvas" aria-label="Close">
                                    <Link className={`nav-link px-2 py-3 text-danger-emphasis rounded-3 mb-2 ${theme}`} aria-current="page" to={link.url} onClick={() => setTheme(link.theme)}>{link.title}</Link>
                                </li>
                            )}
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
    )
}

export default Header
