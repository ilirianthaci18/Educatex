import Logo from '../../assets/logoEducatex.png';
import FacebookIcon from '../../assets/facebook-brands.png';
import LinkedinIcon from '../../assets/linkedin-brands.png';
import TwitterIcon from '../../assets/twitter-brands.png';
import InstagramIcon from '../../assets/instagram-brands.png';

import './subjects.css';

function Subjects() {
  return (
    <div className="Subjects">
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
            <div className="left">
                    <div className="search">
                        <input type="text" placeholder="Search.."/>
                    </div>
                    <div className="list">
                        <ul>
                            <li className="card">
                                <h4>Biology</h4>
                                <p>Professor: Saranda Balaj</p>
                            </li><li className="card">
                                <h4>Technology</h4>
                                <p>Professor: Valmir Gashi</p>
                            </li>
                            <li className="card">
                                <h4>PE</h4>
                                <p>Professor: Afrim Shala</p>
                            </li>
                            <li className="card">
                                <h4>PE</h4>
                                <p>Professor: Megime Potoku</p>
                            </li>
                            <li className="card">
                                <h4>Intro to Programming</h4>
                                <p>Professor: Lavdim Recica</p>
                            </li>
                        </ul>
                    </div>
            </div>
            <div className="right">
                    <p>Filter Subjects</p>
                    <hr/>
                    <div className="filtering">
                        <input type="checkbox"/>
                        <span>Filter by className</span>
                    </div>
                    <div className="filtering">
                        <input type="checkbox"/>
                        <span>Filter by type</span>
                    </div>
                    <div className="filtering">
                        <input type="checkbox"/>
                        <span>Filter by layout</span>
                    </div>
                    <div className="filtering">
                        <input type="checkbox"/>
                        <span>Filter by theme</span>
                    </div>
                    <div className="filtering">
                        <input type="checkbox"/>
                        <span>Filter by professor</span>
                    </div>
            </div>
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

export default Subjects;
