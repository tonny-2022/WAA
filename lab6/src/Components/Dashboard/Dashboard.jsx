import { BrowserRouter,Route, Routes}  from "react-router-dom"
import HeaderComponent from "./HeaderComponent"
import FooterComponent from "./FooterComponent"
import Posts from "../Posts/Posts"
import NewPost from '../Posts/NewPost'
import PostDetails from "../Posts/PostDetails"
import Posts1 from "../Posts/Posts1"
import PostDetail from '../Posts/PostDetail'





export default function Dashboard(){


    return(
     <div className="dashboard">
       
           <BrowserRouter>
           <HeaderComponent/>
            <Routes>
                <Route path='/posts-lab7' element={
                <Posts/>
               }/>
            </Routes>
            <Routes>
                <Route path='/posts-lab6' element={
                    <Posts1/>
                }/>
                    
            </Routes>

            <Routes>
                <Route path="/post-details/:postId"element={
                    <PostDetails  />
                }/>    
            </Routes>

            <Routes>
                <Route path="/post-detail/:postId"element={
                    <PostDetail/>
                }/>    
            </Routes>
            <Routes>
                <Route path="/new-post"element={
                    <NewPost/>
                }/>    
            </Routes>
            <FooterComponent/>
           </BrowserRouter>
      
       
         
     </div>

    )
}