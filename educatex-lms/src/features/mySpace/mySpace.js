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
import React from 'react';
import '../mySpace/mySpace.css';
import { Route, Routes } from 'react-router';
import { Button } from 'semantic-ui-react';
import Profile from '../profile/profile';
import { NavLink } from 'react-router-dom';
import Subjects from '../subjects/subjects';
import Forum from '../forum/forum';
import HTMLSpace from '../htmlSpace/htmlSpace';

class MySpace extends React.Component {
    constructor(props) {
        super(props);
   
        this.state = {
            items: [],
            DataisLoaded: false
        };
    }
   
    // ComponentDidMount is used to 
    // execute the code 
    componentDidMount() {
        fetch(
        "http://localhost:8080/api/elibrary/trainings", {headers: {"Authorization":'BearereyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaHJpcyIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJzdHVkZW50OnJlYWQifSx7ImF1dGhvcml0eSI6IlJPTEVfUFJPRkVTU09SIn0seyJhdXRob3JpdHkiOiJjb3Vyc2U6d3JpdGUifSx7ImF1dGhvcml0eSI6ImNwaXJzZTpyZWFkIn1dLCJpYXQiOjE2NDQzNDM3MDksImV4cCI6MTY0NTQ4NDQwMH0.UD_FKPB2iq8PCac53ySARP0DWam2QK5Vh6kU2aLHF0A'}})
            .then((res) => 
            res.json())
            .then((json) => {
                this.setState({
                    items: json,
                    DataisLoaded: true
                });
            })
    }
    render() {
        const { DataisLoaded, items } = this.state;
        if (!DataisLoaded) return <div>
            <h1> Please wait some time.... </h1> </div> ;
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
                    <li><Button as={NavLink} to={'/elibrary'}>E - Library</Button></li>
                    <li><Button as={NavLink} to={'/subjects'}>Subjects</Button></li>
                    <li><Button as={NavLink} to={'/forum'}>Forum</Button></li>
                    <li><Button as={NavLink} to={'/'}>Logout</Button></li>
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
                    {items.map((item) => (
                    <li key={ item.id } className="box-mySpace-header">
                        <h5> { item.title } </h5>
                        <br/>
                        <p> Category: { item.category }</p>
                    </li>
                        ))
                    }
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
}

export default MySpace;
