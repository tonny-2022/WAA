import { useEffect, useState } from "react";
import{getAllPosts} from '../Api/Api'
import { useNavigate } from "react-router-dom";
 const newArrPosts=[];
 export default function Posts(){
            const navigate=useNavigate();

            const[arrPost,setArrPost]=useState(newArrPosts);

              const fetchPosts=()=>{
                  getAllPosts().then(response=>{
                    setArrPost(response.data);  

                  })
                  
                  .catch(error=>console.log(error))
              }
              useEffect(()=>{
                fetchPosts();

              },[]);

              const showPostDetails=(postId)=>{
                const selectedPost = arrPost.find(post => post.id === postId);
                navigate(`/post-detail/${postId}`,{ state: { post: selectedPost } });

              };

          return (
       
           <div className="container">
                <div  id="posts_div" className='row'>
                     {  

                     arrPost.map(
                        row=>(
                        <div className="card col-sm-4 mx-auto card-posts" onClick={()=>showPostDetails(row.id)}>
                        <div class="card-body">
                            <p class="card-text">Id:{row.id}</p>
                            <p class="card-text">Title:{row.title}</p>
                            <p class="card-text">Author:{row.author}</p> 
                            <p class="card-text">Content:{row.content}</p> 
                        </div>
                        </div>
                        )
                       )
                      }
                
                </div>
                </div>  
            )    
       

    

}

export {newArrPosts};