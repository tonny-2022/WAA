

import { Link } from "react-router-dom";

export default function HeaderComponent(){


  

    return (
      
      <header className="header"> 
         <div className="container">
          
         <nav className="navbar navbar-expand-lg navbar-light bg-light" style={{backgroundColor: "black"}}>
          <Link className="navbar-brand" to="/mainpage">LAB6</Link>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarText">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item active">
                
                 <Link className="nav-link" to="/home">Home</Link>
              </li>
  
              <li className="nav-item">
                <Link className="nav-link" to="/posts">Posts</Link>
               
              </li>
            </ul>
        </div>
        
        <div>
          <ul className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link className="nav-link" to="/logout" >Logout</Link>
              </li>
              
              <li className="nav-item">
                <Link className="nav-link" to="/login">Login</Link>
              </li>
           </ul>
         </div>
  
        </nav>
        </div>    
      </header>
      )
   }