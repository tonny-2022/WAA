import { useState } from "react";
import { useNavigate } from "react-router-dom";
import PostDetails from "./PostDetail";
  const arrPost = [
  { id: 1, title: 'The Great Gatsby', author: 'F. Scott Fitzgerald' },
  { id: 2, title: 'To Kill a Mockingbird', author: 'Harper Lee' },
  { id: 3, title: '1984', author: 'George Orwell' },
];
 export default function Posts1(){
    const navigate=useNavigate();

              const [arrPosts, setArrPosts] = useState(arrPost);
              const [newTitle, setNewTitle] = useState('');
              const[selectedPost,setSelectedPost]=useState('');

              const updatePostTitle = () => {
                const newArrPosts = [...arrPosts];
                newArrPosts[0].title=newTitle;
                setArrPosts(newArrPosts);
               
              };

              const viewPostDetails = (postId) => {
               // navigate(`/post-details/${postId}`);
               const post= arrPosts.find((post)=>post.id===postId);
               setSelectedPost(post);
              };

              const closePostDetails = () => {
                // Reset the selected post when closing the details
                setSelectedPost(null);
              };
            

          return (
       
           <div className="container">
                <div  id="posts_div" className='row'>
                     {  

                     arrPosts.map(
                        row=>(
                        <div className="card col-sm-3 mx-auto card-posts" onClick={()=>viewPostDetails(row.id)} key={row.id} >
                        <div class="card-body">
                            <p className="card-text">Id:{row.id}</p>
                            <p className="card-text">Title:{row.title}</p>
                            <p className="card-text">Author:{row.author}</p> 
                        </div>
                        </div>
                        )
                       )
                      }
                     <div className="row div-comment-details">
                     {selectedPost &&  <PostDetails post={selectedPost} onClose={closePostDetails}/>}

                     </div>


                    <div className="form-group row" style={{margin: '30px'}}>
                    
                         <label for="title" class="ciol-sm-4 form-label">Title</label>
                        <div className="col-sm-4">
                            <input type="text" id="title" className="form-control col-sm-12" name="txtTitle" 
                            value={newTitle} onChange={(evt) => setNewTitle(evt.target.value)}/>
                        </div>

                        <div className='col-sm-4'>
                        <button type="submit" className="btn btn-primary btn-flat" onClick={updatePostTitle}>Update title</button>
                        </div>
                     </div>

                </div>
                </div>  
            )    
       

    

}

export {arrPost};