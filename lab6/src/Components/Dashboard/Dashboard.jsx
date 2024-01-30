import { BrowserRouter,Route, Routes}  from "react-router-dom"
import HeaderComponent from "./HeaderComponent"
import FooterComponent from "./FooterComponent"
import Home from "./Home"
import Posts from "../Posts/Posts"
import NewPost from '../Posts/NewPost'




export default function Dashboard(){


    return(
     <div className="dashboard">
       
           <BrowserRouter>
           <HeaderComponent/>
            <Routes>
                <Route path='/posts' element={
                <Posts/>
               }/>
            </Routes>
            <Routes>
                <Route path='/home' element={
                    <NewPost/>
                }/>
                    
               
            </Routes>
            <FooterComponent/>
           </BrowserRouter>
      
       
         
     </div>

    )
}