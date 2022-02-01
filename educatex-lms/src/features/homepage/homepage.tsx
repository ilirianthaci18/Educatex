import Logo from '../../assets/logoEducatex.png';
import LoginImage from '../../assets/login.png';
import { NavLink, Route, Routes } from 'react-router-dom';
import { Button } from 'semantic-ui-react';
import '../homepage/homepage.css';

function Homepage() {
  return (
    <div className="Homepage">
      <div className="homepage-main">
          <div className="image">
              <img className="login-logo" src={Logo}/>
              <img className="login-image" src={LoginImage}/>
          </div>
          <div className="form">
              <form>
                  <label id="login">Sign In</label>
                  <input id="email" name='email' type="text" placeholder="Email"/>
                  <input id="pass" name='password' type="password" placeholder="Password"/>
                  <div className="remember-and-forgot">
                      <div className="remember">
                          <input type="checkbox" name="Remember me"/>
                          <span>Remember me</span>
                      </div>
                      <div>
                          <span>Forgot Password</span>
                      </div>
                  </div>
                  <Button as={NavLink} to={'/profile'} id='loginB' name='login-btn' className="submit" type="submit">Log In</Button>
              </form>
          </div>
      </div>
  </div>
  );
}

export default Homepage;
