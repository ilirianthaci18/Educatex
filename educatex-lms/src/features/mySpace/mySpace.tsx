import Logo from '../../assets/logoEducatex.png';
import FacebookIcon from '../../assets/facebook-brands.png';
import LinkedinIcon from '../../assets/linkedin-brands.png';
import TwitterIcon from '../../assets/twitter-brands.png';
import InstagramIcon from '../../assets/instagram-brands.png';
import ProjectIdeasCourse from '../../assets/junior-ferreira-7esRPTt38nI-unsplash.jpg';
import NotesCourse from '../../assets/kelly-sikkema--1_RZL8BGBM-unsplash.jpg';
import NoImage from '../../assets/no-image.jpg';
import HtmlCourse from '../../assets/html-course.jpg';
import CybersecurityCourse from '../../assets/cybersecurity-course.jpg';

import '../mySpace/mySpace.css';

function MySpace() {
  return (
      <div className='MySpace'>
        <div className="header">
            <div className="header-logo">
                <img src={Logo}/>
            </div>
            <div className="header-list">
                <ul>
                    <li><a href="profile.html">Profile</a></li>
                    <li><a href="mySpace.html">My Space</a></li>
                    <li><a href="subjects.html">Subjects</a></li>
                    <li><a href="quizzes.html">Quizzes</a></li>
                    <li><a href="forum.html">Forum</a></li>
                </ul>
            </div>
            <div className="header-socials">
                <ul>
                    <li><img src={FacebookIcon}/></li>
                    <li><img src={LinkedinIcon}/></li>
                    <li><img src={TwitterIcon}/></li>
                    <li><img src={InstagramIcon}/></li>
                </ul>
            </div>
        </div>
    <div className="main">
        <div className="container">
                <button className="bn54">
                    <span className="bn54span">Add Space</span>
                </button>
            <ul>
                <li className="box"><img src={CybersecurityCourse}/><p>What is Cybersecurity?</p></li>
                <li className="box"><a href="htmlSpace.html"><img src={HtmlCourse}/><p>Learn HTML Basics</p></a></li>
                <li className="box"><img src={NoImage}/><p>Studying for the Biology Exam</p></li>
                <li className="box"><img src={NoImage}/><p>Notes on Math Homeworks</p></li>
            </ul>
            <ul>
                    <li className="box"><img src={NoImage}/><p>To do for Database Project</p></li>
                    <li className="box"><img src={CybersecurityCourse}/><p>What is Cybersecurity?</p></li>
                    <li className="box"><img src={HtmlCourse}/><p>Learn HTML Basics</p></li>
                    <li className="box"><img src={NotesCourse}/>Daily Notes on Important Remarks</li>
                </ul>
                <ul>
                    <li className="box"><img src={ProjectIdeasCourse}/>Project Ideas!</li>
                </ul>
        </div>
    </div>
    <div className="footer">
            <div className="footer-logo">
                <img src={Logo}/>
            </div>
            <div className="footer-quick-navigation">
                <ul>
                    <li>QUICK NAVIAGTION</li>
                    <li>Dashboard</li>
                    <li>My space</li>
                    <li>Subjects</li>
                    <li>Quizzes</li>
                    <li>Forum</li>
                </ul>
            </div>
            <div className="footer-stay-connected">
                <ul>
                    <li>STAY CONNECTED</li>
                    <li>Facebook</li>
                    <li>Linkedin</li>
                    <li>Instagram</li>
                    <li>Twitter</li>
                </ul>
            </div>
            <div className="footer-get-in-touch">
                <ul>
                    <li>GET IN TOUCH</li>
                    <li>Prishtinë, Kosovo</li>
                    <li>Tel: *** - *** - ***</li>
                    <li>info@educatex.com</li>
                </ul>
            </div>
        </div> 
    </div>
  );
}

export default MySpace;
