
import './Logo.css';
import Pic from "../../assets/taskr-logo-small.png";

function Logo({ asideIsShown }) {
    return (
        <div className="aside__logo">
            {asideIsShown && <p className="logo-container__text">ByeBug</p>}
        </div>
    )
}

export default Logo;