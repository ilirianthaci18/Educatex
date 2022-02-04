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
import { Route, Routes } from 'react-router';
import { Button } from 'semantic-ui-react';
import Profile from '../profile/profile';
import { NavLink } from 'react-router-dom';
import Subjects from '../subjects/subjects';
import Forum from '../forum/forum';
import HTMLSpace from '../htmlSpace/htmlSpace';
import { Nav } from 'react-bootstrap';

function MySpace() {
  return (
      <div className='MySpace'>
        <div className="header">
            <div className="header-logo">
                <img src={Logo}/>
            </div>
            <div className="header-list">
                <ul>
                    <li><Button as={NavLink} to={'/profile'}>Profile</Button></li>
                    <li><Button as={NavLink} to={'/my-space'}>My Space</Button></li>
                    <li><Button as={NavLink} to={'/subjects'}>Subjects</Button></li>
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
    <div className="main-mySpace">
        <div className="container-mySpace">
                <button className="bn54">
                    <span className="bn54span">Add Space</span>
                </button>
            <ul>
                <li className="box-mySpace"><img src={CybersecurityCourse}/><p>What is Cybersecurity?</p></li>
                <li className="box-mySpace"><Button as={NavLink} to={'/html-space'}><img src={HtmlCourse}/><p>Learn HTML Basics</p></Button></li>
                <li className="box-mySpace"><img src={NoImage}/><p>Studying for the Biology Exam</p></li>
                <li className="box-mySpace"><img src={NoImage}/><p>Notes on Math Homeworks</p></li>
            </ul>
            <ul>
                    <li className="box-mySpace"><img src={NoImage}/><p>To do for Database Project</p></li>
                    <li className="box-mySpace"><img src={CybersecurityCourse}/><p>What is Cybersecurity?</p></li>
                    <li className="box-mySpace"><img src={HtmlCourse}/><p>Learn HTML Basics</p></li>
                    <li className="box-mySpace"><img src={NotesCourse}/>Daily Notes on Important Remarks</li>
                </ul>
                <ul>
                    <li className="box-mySpace"><img src={ProjectIdeasCourse}/>Project Ideas!</li>
                </ul>
        </div>
    </div>
    <div className="footer-mySpace">
            <div className="footer-mySpace-logo">
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
          <Route path="forum" element={<Forum/>}/>
          <Route path="html-space" element={<HTMLSpace/>}/>
      </Routes> 
    </div>
  );
}

export default MySpace;
