import Logo from '../../assets/logoEducatex.png';
import FacebookIcon from '../../assets/facebook-brands.png';
import LinkedinIcon from '../../assets/linkedin-brands.png';
import TwitterIcon from '../../assets/twitter-brands.png';
import InstagramIcon from '../../assets/instagram-brands.png';
import Quizz1 from '../../assets/robina-weermeijer-Tmkwl7EjVtE-unsplash.jpg';

import './quizzes.css';
import { Button } from 'semantic-ui-react';
import Profile from '../profile/profile';
import { NavLink, Route, Routes } from 'react-router-dom';
import MySpace from '../mySpace/mySpace';
import Subjects from '../subjects/subjects';
import Forum from '../forum/forum';

function Quizzes() {
  return (
    <div className="Profile">
      <div className="header">
        <div className="header-logo">
            <img src={Logo}/>
        </div>
        <div className="header-list">
            <ul>
                <li><Button as={NavLink} to={'profile'}>Profile</Button></li>
                <li><Button as={NavLink} to={'my-space'}>My Space</Button></li>
                <li><Button as={NavLink} to={'subjects'}>Subjects</Button></li>
                <li><Button as={NavLink} to={'quizzes'}>Quizzes</Button></li>
                <li><Button as={NavLink} to={'forum'}>Forum</Button></li>
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
                <li><a href="#">Biology</a></li>
                <li><a href="#">Chemistry</a></li>
                <li><a href="#">Physics</a></li>
                <li><a href="#">PE</a></li>
                <li><a href="#">History</a></li>
                <li><a href="#">Math</a></li>
                <li><a href="#">Technology</a></li>
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
    <div className="footer-quizzes">
          <div className="footer-quizzes-logo">
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
      <Routes>
          <Route path="profile" element={<Profile/>}/>
          <Route path="my-space" element={<MySpace/>}/>
          <Route path="subjects" element={<Subjects/>}/>
          <Route path="quizzes" element={<Quizzes/>}/>
          <Route path="forum" element={<Forum/>}/>
      </Routes>
    </div>
  );
}

export default Quizzes;
