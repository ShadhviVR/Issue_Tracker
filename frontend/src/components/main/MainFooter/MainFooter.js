
import './MainFooter.css';

function MainFooter({ getYear }) {
    return (
        <footer className="footer">
            <p className="footer__text"> Copyright &copy; {getYear()}. All rights reserved.</p>
        </footer>
    )
}

export default MainFooter;