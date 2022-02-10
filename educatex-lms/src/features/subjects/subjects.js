import React from 'react';
import './subjects.css';
import Logo from '../../assets/logoEducatex.png';
import FacebookIcon from '../../assets/facebook-brands.png';
import LinkedinIcon from '../../assets/linkedin-brands.png';
import TwitterIcon from '../../assets/twitter-brands.png';
import InstagramIcon from '../../assets/instagram-brands.png';

import './subjects.css';
import { Route, Routes } from 'react-router';
import { Button } from 'semantic-ui-react';
import Profile from '../profile/profile';
import MySpace from '../mySpace/mySpace';
import Forum from '../forum/forum';
import { NavLink } from 'react-router-dom';
import HTMLSpace from '../htmlSpace/htmlSpace';

class Subjects extends React.Component {
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
        "http://localhost:8080/api/course", {headers: {"Authorization":'BearereyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkZW56ZWwiLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5Ijoic3R1ZGVudDp3cml0ZSJ9LHsiYXV0aG9yaXR5Ijoic3R1ZGVudDpyZWFkIn0seyJhdXRob3JpdHkiOiJhZG1pbjpyZWFkIn0seyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn0seyJhdXRob3JpdHkiOiJhZG1pbjp3cml0ZSJ9LHsiYXV0aG9yaXR5IjoiY291cnNlOndyaXRlIn0seyJhdXRob3JpdHkiOiJjcGlyc2U6cmVhZCJ9XSwiaWF0IjoxNjQ0MzQyMzAwLCJleHAiOjE2NDU0ODQ0MDB9.mJ26NIPQgRozMsVN0aj6jXNHYbeNC22TIktoYMrpoJo'}})
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
<div className="Subjects">
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
        <div className="main-subjects">
        <div className="container-subjects">
            <div className="left-subjects">
                    <div className="search">
                        <input type="text" placeholder="Search.."/>
                    </div>
                    <div className="list">
                        <ul>
                            {items.map((item) => (
                            <li key={ item.id } className="card">
                                <h2> { item.courseName } </h2>
                                <p>ECTS: { item.ects }</p>
                            </li>
                              ))
                            }
                        </ul>
                    </div>
            </div> 
            <div className="right-subjects">
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
        <div className="footer-subjects">
            <div className="footer-subjects-logo">
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
   
export default Subjects;