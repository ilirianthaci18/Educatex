import React from 'react';
import ReactDOM from 'react-dom';
import reportWebVitals from './reportWebVitals';
import { store, StoreContext } from './app/stores/store';
import { createBrowserHistory } from 'history';
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


