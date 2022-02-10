import Logo from '../../assets/logoEducatex.png';
import FacebookIcon from '../../assets/facebook-brands.png';
import LinkedinIcon from '../../assets/linkedin-brands.png';
import TwitterIcon from '../../assets/twitter-brands.png';
import InstagramIcon from '../../assets/instagram-brands.png';
import AddComment from '../../assets/add-comment.png';
import CommentImage from '../../assets/comment.png';
import UserLogo from '../../assets/user.png';
import '../forum/forum.css';
import { Button } from 'semantic-ui-react';
import Profile from '../profile/profile';
import MySpace from '../mySpace/mySpace';
import Subjects from '../subjects/subjects';
import { NavLink, Route, Routes } from 'react-router-dom';
import HTMLSpace from '../htmlSpace/htmlSpace';
import React from 'react';

class Forum extends React.Component{
    constructor(props) {
        super(props);
   
        this.state = {
            items: [],
            DataisLoaded: false
        };
    }

    componentDidMount() {
        fetch(
"http://localhost:8080/api/forum/replies", {headers: {"Authorization":'BearereyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaHJpcyIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJzdHVkZW50OnJlYWQifSx7ImF1dGhvcml0eSI6IlJPTEVfUFJPRkVTU09SIn0seyJhdXRob3JpdHkiOiJjcGlyc2U6cmVhZCJ9LHsiYXV0aG9yaXR5IjoiY291cnNlOndyaXRlIn1dLCJpYXQiOjE2NDQyNjU3OTAsImV4cCI6MTY0NTM5ODAwMH0.-h94oWIVHXVBHfdJYbX2mQHPNp6wNEBwZG9tAfhdl1E'}})
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
            <h1> Pleses wait some time.... </h1> </div> ;

  return (
    <div className="Forum">
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
    <div className="main-forum">
       <div className="container-forum">
           <div className="intro">
               <h2>Learn from each other</h2>
               <h3>Join a discussion</h3>
           </div>
           <div className="discussions">
               <div className="header-d">
                   <div className="left">
                     <img src={AddComment}/><p>Add a comment</p>
                   </div>
                   <input type="text" placeholder="Search"/>
               </div>
               <div className="main-d">
                   <ul>
                       <li>
                           <p>What is the most important chapter in the book that our teacher gave us in Biology?</p>
                           <span>1</span>
                           <img className="comment" src={CommentImage}/>
                        </li>
                        <li>
                            <p>What is math anxiety?</p>
                            <span>2</span>
                            <img className="comment" src={CommentImage}/>
                         </li>
                         <li>
                            <p>How to disable docker desktop from auto updating on windows?</p>
                            <span>1</span>
                            <img className="comment"  src={CommentImage}/>
                         </li>
                         <li>
                            <p>How to redirect a wrong url with the same pattern that a user messed up in django, without javascript?</p>
                            <span>0</span>
                            <img className="comment"  src={CommentImage}/>
                         </li>
                   </ul>
               </div>
               <div className="footer-d">
                   <div className="top">
                        <h3>NEW</h3>
                   </div>
                   <div className="bottom">
                        <ul>
                        {items.map((item) => (
                            <li key={item.id}>
                                <img className="user-profile"  src={UserLogo}/>
                                <p>{ item.description }</p>
                                <br/>
                                <span>2</span>
                                <img className="comment" src={CommentImage}/>
                            </li>
                        ))}
                        </ul>
                   </div>
               </div>
           </div>
       </div>   
   </div>
    <div className="footer-forum">
          <div className="footer-forum-logo">
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
export default Forum;
