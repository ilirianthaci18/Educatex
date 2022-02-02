import Logo from '../../assets/logoEducatex.png';
import FacebookIcon from '../../assets/facebook-brands.png';
import LinkedinIcon from '../../assets/linkedin-brands.png';
import TwitterIcon from '../../assets/twitter-brands.png';
import InstagramIcon from '../../assets/instagram-brands.png';
import ProfileImage from '../../assets/profile-image.jpg';

import './profile.css';
import { NavLink, Route, Routes } from 'react-router-dom';
import { Button } from 'semantic-ui-react';
import MySpace from '../mySpace/mySpace';
import Subjects from '../subjects/subjects';
import Quizzes from '../quizzes/quizzes';
import Forum from '../forum/forum';

function Profile() {
  return (
    <div className="Profile">
      <div className="header">
        <div className="header-logo">
            <img src={Logo}/>
        </div>
        <div className="header-list">
            <ul>
                <li><Button as={NavLink} to={'/profile'}>Profile</Button></li>
                <li><Button as={NavLink} to={'/my-space'}>My Space</Button></li>
                <li><Button as={NavLink} to={'/subjects'}>Subjects</Button></li>
                <li><Button as={NavLink} to={'/quizzes'}>Quizzes</Button></li>
                <li><Button as={NavLink} to={'/forum'}>Forum</Button></li>
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
    <div className="main-profile profile-container">
        <div className="user-image">
              <img src={ProfileImage}/>
        </div>
        <div className="user-data">
              <ul>
                  <li>Emri: Erblin</li>
                  <li>Mbiemri: Shehu</li>
                  <li>Mosha: 20</li>
                  <li>Gjinia: Mashkull</li>
                  <li>Nënshtetësia: Kosovar/e</li>
              </ul>
              <ul>
                  <li>Rruga: Mizair Isma</li>
                  <li>Qyteti: Rahovec</li>
                  <li>Zip Code: 20000 </li>
                  <li>Nr.Tel: 044 - 111 - 222</li>
                  <li>Email: erblin-sh@gmail.com</li>
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

export default Profile;
