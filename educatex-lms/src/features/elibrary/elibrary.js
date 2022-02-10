import Logo from '../../assets/logoEducatex.png';
import FacebookIcon from '../../assets/facebook-brands.png';
import LinkedinIcon from '../../assets/linkedin-brands.png';
import TwitterIcon from '../../assets/twitter-brands.png';
import InstagramIcon from '../../assets/instagram-brands.png';
import React from 'react';
import '../elibrary/elibrary.css';
import { Route, Routes } from 'react-router';
import { Button } from 'semantic-ui-react';
import Profile from '../profile/profile';
import { NavLink } from 'react-router-dom';
import Subjects from '../subjects/subjects';
import Forum from '../forum/forum';
import HTMLSpace from '../htmlSpace/htmlSpace';
import MySpace from '../mySpace/mySpace';
import { number } from 'prop-types';

class ELibrary extends React.Component {
    constructor(props) {
        super(props);
   
        this.state = {
            count: number,
            DataisLoaded: false
        };
    }
   
    // ComponentDidMount is used to 
    // execute the code 
    componentDidMount() {
        fetch(
        "http://localhost:8080/api/elibrary/trainings/count", {headers: {"Authorization":'BearereyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkZW56ZWwiLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5Ijoic3R1ZGVudDp3cml0ZSJ9LHsiYXV0aG9yaXR5Ijoic3R1ZGVudDpyZWFkIn0seyJhdXRob3JpdHkiOiJhZG1pbjpyZWFkIn0seyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn0seyJhdXRob3JpdHkiOiJhZG1pbjp3cml0ZSJ9LHsiYXV0aG9yaXR5IjoiY291cnNlOndyaXRlIn0seyJhdXRob3JpdHkiOiJjcGlyc2U6cmVhZCJ9XSwiaWF0IjoxNjQ0MzM2MDc2LCJleHAiOjE2NDU0ODQ0MDB9.a-0qUUDLNYOsNgU_fmNsinlYMIlIoAvwiUKJr-CuSJQ'}})
            .then((res) => 
            res.json())
            .then((json) => {
                this.setState({
                    count: json,
                    count: json,
                    DataisLoaded: true
                });
            })
    }
    render() {
        const { DataisLoaded, count } = this.state;
        if (!DataisLoaded) return <div>
            <h1> Pleses wait some time.... </h1> </div> ;
   
  return (
      <div className='ELibrary'>
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
            <div className="list-books">
                <ul>
                    <li>
                        <Button as={NavLink} to={'/books'} className="card"> Books</Button>
                        <br/>
                        <p>{count}</p>
                    </li>
                    <li>
                        <Button as={NavLink} to={'/trainings'} className="card"> Trainings</Button>
                        <br/>
                        <p>{count}</p>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div className="footer-elibrary">
            <div className="footer-elibrary-logo">
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

export default ELibrary;
