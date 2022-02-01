import React from 'react';
import ReactDOM from 'react-dom';
import Profile from '../src/features/profile/profile';
import Forum from '../src/features/forum/forum';
import MySpace from './features/mySpace/mySpace';
import Quizzes from './features/quizzes/quizzes';
import reportWebVitals from './reportWebVitals';
import Homepage from './features/homepage/homepage';
import Subjects from './features/subjects/subjects';
import { store, StoreContext } from './app/stores/store';
import { createBrowserHistory } from 'history';
import { BrowserRouter } from 'react-router-dom';
import App from './app/layout/App';

export const history = createBrowserHistory();

ReactDOM.render(
  <StoreContext.Provider value={store}>
      <App/>
  </StoreContext.Provider>,
  document.getElementById('root')
);

// If you want to start measuring performane                                                                                                                                                                                                                                                     e in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();


