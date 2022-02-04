import Logo from '../../assets/logoEducatex.png';
import FacebookIcon from '../../assets/facebook-brands.png';
import LinkedinIcon from '../../assets/linkedin-brands.png';
import TwitterIcon from '../../assets/twitter-brands.png';
import InstagramIcon from '../../assets/instagram-brands.png';
import FirstImg from '../../assets/florian-olivo-4hbJ-eymZ1o-unsplash.jpg';
import SecondImg from '../../assets/kobu-agency-ipARHaxETRk-unsplash.jpg';
import ThirdImg from '../../assets/valery-sysoev-p9OkL4yW3C8-unsplash.jpg';
import PlayImg from '../../assets/play.png';

import '../htmlSpace/htmlSpace.css';
import { Route, Routes } from 'react-router';
import { Button } from 'semantic-ui-react';
import Profile from '../profile/profile';
import { NavLink } from 'react-router-dom';
import Subjects from '../subjects/subjects';
import Forum from '../forum/forum';
import MySpace from '../mySpace/mySpace';

function HTMLSpace() {
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
    <div className="main-htmlSpace">
        <div className="container-htmlSpace">
            <div className="top-html">
                <div>
                    <h2>Tutorials</h2>
                </div>
                <div>
                    <div>
                        <ul>
                            <li>
                                <img src={FirstImg}/>
                                <img className="play" src={PlayImg}/>
                            </li>
                            <li>
                                <img src={SecondImg}/>
                                <img className="play" src={PlayImg}/>
                            </li>
                            <li>
                                <img src={ThirdImg}/>
                                <img className="play" src={PlayImg}/>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div className="bottom-html">
                <div className="list-elements">
                    <ul>
                        <li>Elements</li>
                        <li>Body Parts</li>
                            <ul className="inner-list">
                                <li>header</li>
                                <li>main</li>
                                <li>footer</li>
                            </ul>
                        <li>Div</li>
                        <li>Image</li>
                        <li>Link</li>
                    </ul>
                </div>
                <div className="content">
                    <textarea>

                    </textarea>
                </div>
            </div>
        </div>
    </div>
    <div className="footer-html">
            <div className="footer-html-logo">
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

export default HTMLSpace;
