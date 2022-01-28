import Logo from '../../assets/logoEducatex.png';
import FacebookIcon from '../../assets/facebook-brands.png';
import LinkedinIcon from '../../assets/linkedin-brands.png';
import TwitterIcon from '../../assets/twitter-brands.png';
import InstagramIcon from '../../assets/instagram-brands.png';
import Quizz1 from '../../assets/robina-weermeijer-Tmkwl7EjVtE-unsplash.jpg';

import './quizzes.css';

function Quizzes() {
  return (
    <div className="Profile">
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
            <ul className="subjects">
                <li><a href="quizzes.html">Biology</a></li>
                <li><a href="quizzes.html">Chemistry</a></li>
                <li><a href="quizzes.html">Physics</a></li>
                <li><a href="quizzes.html">PE</a></li>
                <li><a href="quizzes.html">History</a></li>
                <li><a href="quizzes.html">Math</a></li>
                <li><a href="quizzes.html">Technology</a></li>
            </ul>
            <ul className="quizzes">
                    <ul>
                        <li className="box"><img src={Quizz1}/></li>
                        <li className="box"><img src={Quizz1}/></li>
                        <li className="box"><img src={Quizz1}/></li>
                    </ul>
                    <ul>
                        <li className="box"><img src={Quizz1}/></li>
                        <li className="box"><img src={Quizz1}/></li>
                        <li className="box"><img src={Quizz1}/></li>
                    </ul>
                    <ul>
                        <li className="box"><img src={Quizz1}/></li>
                        <li className="box"><img src={Quizz1}/></li>
                    </ul>
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

export default Quizzes;
